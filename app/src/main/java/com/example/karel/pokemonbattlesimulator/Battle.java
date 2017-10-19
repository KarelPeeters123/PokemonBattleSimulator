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
        defender.myStats.setHp(defender.myStats.hp - damage);
        if (myMove.statReductionStat.equals("atk")){
            if (myMove.statReductionValue >= 0) {
                defender.myStats.setAtk((myMove.statReductionValue + 2)/2);
            } else {
                defender.myStats.setAtk(2/(myMove.statReductionValue + 2));
            }
        }
        if (myMove.statReductionStat.equals("def")){
            if (myMove.statReductionValue >= 0) {
                defender.myStats.setDef((myMove.statReductionValue + 2)/2);
            } else {
                defender.myStats.setDef(2/(myMove.statReductionValue + 2));
            }
        }
        if (myMove.statReductionStat.equals("spAtk")){
            if (myMove.statReductionValue >= 0) {
                defender.myStats.setSpAtk((myMove.statReductionValue + 2)/2);
            } else {
                defender.myStats.setSpAtk(2/(myMove.statReductionValue + 2));
            }
        }
        if (myMove.statReductionStat.equals("spDef")){
            if (myMove.statReductionValue >= 0) {
                defender.myStats.setSpDef((myMove.statReductionValue + 2)/2);
            } else {
                defender.myStats.setSpDef(2/(myMove.statReductionValue + 2));
            }
        }
        if (myMove.statReductionStat.equals("spd")){
            if (myMove.statReductionValue >= 0) {
                defender.myStats.setSpd((myMove.statReductionValue + 2)/2);
            } else {
                defender.myStats.setSpd(2/(myMove.statReductionValue + 2));
            }
        }
        if (myMove.statReductionStat.equals("acc")){
            if (myMove.statReductionValue >= 0) {
                defender.myStats.setAcc((myMove.statReductionValue + 3)/3);
            } else {
                defender.myStats.setAcc(3/(myMove.statReductionValue + 3));
            }
        }
        if (myMove.statReductionStat.equals("eva")){
            if (myMove.statReductionValue >= 0) {
                defender.myStats.setEva((myMove.statReductionValue + 3)/3);
            } else {
                defender.myStats.setEva(3/(myMove.statReductionValue + 3));
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
