package com.example.karel.pokemonbattlesimulator;

/**
 * Created by Karel on 16/10/2017.
 */

public class Turn {
    Battle myBattle;
    Move move1;
    Move move2;

    public Turn(Battle myBattle, Move move1, Move move2) {
        this.myBattle = myBattle;
        this.move1 = move1;
        this.move2 = move2;
        int confuseDamage1 = (int)((((2 * myBattle.pokemon1.level) / 5 + 2) * 40 * (myBattle.pokemon1.myStats.atk / myBattle.pokemon1.myStats.def)) / 50 + 2);
        int confuseDamage2 = (int)((((2 * myBattle.pokemon2.level) / 5 + 2) * 40 * (myBattle.pokemon2.myStats.atk / myBattle.pokemon2.myStats.def)) / 50 + 2);
        boolean selfDamage1 = myBattle.pokemon1.myStatus.isConfused() && Math.random()< 0.5;
        boolean selfDamage2 = myBattle.pokemon2.myStatus.isConfused() && Math.random()< 0.5;
        if(myBattle.pokemon1.myStats.spd >= myBattle.pokemon2.myStats.spd) {
            if (!(Math.random() <= 0.25 && myBattle.pokemon1.myStatus.isParalized() || myBattle.pokemon1.myStatus.isSleeping() || selfDamage1 || myBattle.pokemon1.myStatus.isFrozen())) {
                myBattle.attack(myBattle.pokemon1, myBattle.pokemon2, move1);
            }
            if (!(Math.random() <= 0.25 && myBattle.pokemon2.myStatus.isParalized() || myBattle.pokemon2.myStatus.isSleeping() || selfDamage2 || myBattle.pokemon2.myStatus.isFrozen())) {
                myBattle.attack(myBattle.pokemon2, myBattle.pokemon1, move2);
            }

        } else {
            if (!(Math.random() <= 0.25 && myBattle.pokemon1.myStatus.isParalized() || myBattle.pokemon1.myStatus.isSleeping() || selfDamage1 || myBattle.pokemon1.myStatus.isFrozen())) {
                myBattle.attack(myBattle.pokemon2, myBattle.pokemon1, move2);
            }
            if (!(Math.random() <= 0.25 && myBattle.pokemon2.myStatus.isParalized() || myBattle.pokemon2.myStatus.isSleeping() || selfDamage2 || myBattle.pokemon2.myStatus.isFrozen())) {
                myBattle.attack(myBattle.pokemon1, myBattle.pokemon2, move1);
            }
        }
        if (selfDamage1) {
            myBattle.pokemon1.myStats.hp -= confuseDamage1;
        }
        if (selfDamage2) {
            myBattle.pokemon2.myStats.hp -= confuseDamage2;
        }

        if (myBattle.pokemon1.myStatus.isBurned()){
            myBattle.pokemon1.myStats.hp -= myBattle.pokemon1.myStats.hp*0.0625;
            myBattle.pokemon1.myStats.atk = myBattle.pokemon1.myStats.atk/2;
        }
        if (myBattle.pokemon2.myStatus.isBurned()){
            myBattle.pokemon2.myStats.hp -= myBattle.pokemon2.myStats.hp*0.0625;
            myBattle.pokemon2.myStats.atk = myBattle.pokemon2.myStats.atk/2;
        }
        if(myBattle.pokemon1.myStatus.isPoisoned()) {
            myBattle.pokemon1.myStats.hp -= myBattle.pokemon1.myStats.hp*0.125;
        }
        if(myBattle.pokemon2.myStatus.isPoisoned()) {
            myBattle.pokemon2.myStats.hp -= myBattle.pokemon2.myStats.hp*0.125;
        }
        if(myBattle.pokemon1.myStatus.isBadlyPoisoned()) {
            myBattle.pokemon1.myStats.hp -= myBattle.pokemon1.myStats.hp*((1+myBattle.pokemon1.myStatus.getBadlyPoisonedCounter())/16);
            myBattle.pokemon1.myStatus.setBadlyPoisonedCounter(myBattle.pokemon1.myStatus.getBadlyPoisonedCounter()+1);
        }
        if(myBattle.pokemon2.myStatus.isBadlyPoisoned()) {
            myBattle.pokemon2.myStats.hp -= myBattle.pokemon2.myStats.hp*((1+myBattle.pokemon2.myStatus.getBadlyPoisonedCounter())/16);
            myBattle.pokemon2.myStatus.setBadlyPoisonedCounter(myBattle.pokemon2.myStatus.getBadlyPoisonedCounter()+1);
        }
        if(myBattle.pokemon1.myStatus.isBound()) {
            myBattle.pokemon1.myStats.hp -= myBattle.pokemon1.myStats.hp*(1/16);
            myBattle.pokemon1.myStatus.setBindCounter(myBattle.pokemon1.myStatus.getBindCounter() - 1);
        }
        if(myBattle.pokemon2.myStatus.isBound()) {
            myBattle.pokemon2.myStats.hp -= myBattle.pokemon2.myStats.hp*(1/16);
            myBattle.pokemon2.myStatus.setBindCounter(myBattle.pokemon2.myStatus.getBindCounter() - 1);
        }

        myBattle.pokemon1.myStatus.setFlinched(false);
        myBattle.pokemon2.myStatus.setFlinched(false);
        if (Math.random() <= 0.3){
            myBattle.pokemon1.myStatus.setFrozen(false);
        }
        if (Math.random() <= 0.3){
            myBattle.pokemon2.myStatus.setFrozen(false);
        }
        if (Math.random() <= 0.2){
            myBattle.pokemon1.myStatus.setFrozen(false);
        }
        if (Math.random() <= 0.2){
            myBattle.pokemon2.myStatus.setFrozen(false);
        }
        myBattle.pokemon1.myStatus.setSleepCounter(myBattle.pokemon1.myStatus.getSleepCounter() - 1);
        myBattle.pokemon2.myStatus.setSleepCounter(myBattle.pokemon2.myStatus.getSleepCounter() - 1);
        if (myBattle.pokemon1.myStatus.getSleepCounter() == 0){
            myBattle.pokemon1.myStatus.setSleeping(false);
        }
        if (myBattle.pokemon2.myStatus.getSleepCounter() == 0){
            myBattle.pokemon2.myStatus.setSleeping(false);
        }
        //add end of turn effects (i.e. poison, statreduction)
    }
}
