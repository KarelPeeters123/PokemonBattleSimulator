package com.example.karel.pokemonbattlesimulator;

/**
 * Created by Karel on 11/10/2017.
 */

public class Battle {
    Pokemon pokemon1;
    Pokemon pokemon2;
    String weather;
    double target = 1; //only relevant for multiplayer battles
    double weatherMod = 1;
    double badge = 1; //only relevant
    double critical = 1; //critical attribute should be added to all moves first.
    double random = 1;
    double stab = 1;
    double type = 1;
    double burn = 1;


    public Battle(Pokemon pokemon1, Pokemon pokemon2, String weather) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.weather = weather;
    }
    public void attack(Pokemon attacker, Pokemon defender, Move myMove) {
        weatherMod = getWeatherMod(myMove);
        type = calculateTypeEffectiveness(defender, myMove);
        random = 0.85 + Math.random() * 0.15;
        stab = getStab(myMove, attacker);

        double  modifier = target * weatherMod * badge * critical * random * stab * type * burn;
        double decimalDamage;
        if (myMove.statReductionValue >= 0) {

        }

        if (Math.random() <= myMove.accuracy * attacker.myStats.acc/defender.myStats.eva){
            if (myMove.baseDamage == 0) {
                decimalDamage = 0;
            } else if (myMove.isSpecial){
                decimalDamage = ((((2 * attacker.level)/5 + 2) * myMove.baseDamage * (attacker.myStats.spAtk / defender.myStats.spDef) ) / 50 + 2) * modifier;
            } else {
                decimalDamage = ((((2 * attacker.level) / 5 + 2) * myMove.baseDamage * (attacker.myStats.atk / defender.myStats.def)) / 50 + 2) * modifier;
            }
        } else {
            decimalDamage = 0;
        }
        int damage = (int) decimalDamage;
        for (int i = 0; i < myMove.amountHits; i++) {
            defender.myStats.setHp(defender.myStats.hp - damage);
            attacker.myStats.setHp(attacker.myStats.hp + ((int) (decimalDamage * myMove.healratio)));
        }
        if (Math.random() <= myMove.statReductionAcc) {
            if (myMove.buffTarget.equals("enemy")) {
                defender.myStats.setMultiplier(myMove.statReductionValue, myMove.statReductionStat);
            } else {
                attacker.myStats.setMultiplier(myMove.statReductionValue, myMove.statReductionStat);
            }
        }
    }
    public double calculateTypeEffectiveness(Pokemon defender, Move myMove){
        double typeEffectiveness = 1;
        typeEffectiveness *= defender.type1.typeChart[myMove.type.typeIndex][defender.type1.typeIndex];
        typeEffectiveness *= defender.type1.typeChart[myMove.type.typeIndex][defender.type2.typeIndex];
        return typeEffectiveness;

    }

    public double getWeatherMod(Move myMove){
        boolean isRain = weather.equals("rain");
        boolean isSunlight = weather.equals("harsh sunlight");
        boolean isWater = myMove.type.typeName.equals("water");
        boolean isFire = myMove.type.typeName.equals("water");

        if (isRain) {
            if (isWater) {
                return 1.5;
            } else if (isFire) {
                return 0.5;
            } else {
                return 1;
            }
        } else if (isSunlight) {
            if (isFire) {
                return 1.5;
            } else if (isWater) {
                return 0.5;
            }
        }
        return 1;
    }

    public double getStab(Move myMove, Pokemon attacker){
        if (myMove.type.typeName.equals(attacker.type1.typeName)
                && myMove.type.typeName.equals(attacker.type2.typeName)){
            return 2;
        }
        return 1;
    }
}
