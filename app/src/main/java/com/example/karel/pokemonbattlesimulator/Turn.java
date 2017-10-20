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
        if(myBattle.pokemon1.myStats.spd >= myBattle.pokemon2.myStats.spd) {
            myBattle.attack(myBattle.pokemon1, myBattle.pokemon2, move1);
            myBattle.attack(myBattle.pokemon2, myBattle.pokemon1, move2);
        } else {
            myBattle.attack(myBattle.pokemon2, myBattle.pokemon1, move2);
            myBattle.attack(myBattle.pokemon1, myBattle.pokemon2, move1);
        }
        myBattle.pokemon1.myStatus.setFlinched(false);
        myBattle.pokemon2.myStatus.setFlinched(false);
        myBattle.pokemon1.myStatus.setSleepCounter(myBattle.pokemon1.myStatus.getSleepCounter() - 1);
        myBattle.pokemon1.myStatus.setSleepCounter(myBattle.pokemon2.myStatus.getSleepCounter() - 1);
        //add end of turn effects (i.e. poison, statreduction)
    }
}
