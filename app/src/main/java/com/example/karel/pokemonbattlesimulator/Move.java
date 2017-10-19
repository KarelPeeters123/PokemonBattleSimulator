package com.example.karel.pokemonbattlesimulator;

/**
 * Created by Karel on 11/10/2017.
 */

public class Move {
    String moveName;
    boolean isSpecial;
    int baseDamage;
    double accuracy;
    Type type;
    String statReductionStat;
    int statReductionValue;

    public Move(String moveName, boolean isSpecial, int baseDamage, double accuracy, Type type,
                String statReductionStat, int statReductionValue, String buffTarget) {
        this.moveName = moveName;
        this.isSpecial = isSpecial;
        this.baseDamage = baseDamage;
        this.accuracy = accuracy;
        this.type = type;
        this.statReductionStat = statReductionStat;
        this.statReductionValue = statReductionValue;
    }
}