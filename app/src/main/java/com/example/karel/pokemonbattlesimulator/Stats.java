package com.example.karel.pokemonbattlesimulator;

/**
 * Created by Karel on 11/10/2017.
 */

public class Stats {
    int hp;
    int level;
    int baseHp;
    int baseAtk;
    int baseDef;
    int baseSpAtk;
    int baseSpDef;
    int baseSpd;
    int atk;
    int def;
    int spAtk;
    int spDef;
    int maxHp;
    int spd;
    int acc = 1;
    int eva = 1;

    public Stats(int level, int baseHp, int baseAtk, int baseDef, int baseSpAtk, int baseSpDef, int baseSpd) {
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpAtk = baseSpAtk;
        this.baseSpDef = baseSpDef;
        this.baseSpd = baseSpd;
        setLevel(level);
    }

    public int calculateHp(int baseHp) {
        return (((2*baseHp) * this.level)/100) + this.level + 10;
    }

    public int calculateStat(int myBaseStat) {
        return (((2*myBaseStat)*this.level)/100) + 5;

    }
    public void setLevel(int newLevel){
        this.level = newLevel;
        this.hp = calculateHp(baseHp);
        this.maxHp = calculateHp(baseHp);
        this.atk = calculateStat(baseAtk);
        this.def = calculateStat(baseDef);
        this.spAtk = calculateStat(baseSpAtk);
        this.spDef = calculateStat(baseSpDef);
        this.spd = calculateStat(baseSpd);
    }

    public void setAtk(int newAtk) {
        this.atk = newAtk;
    }

    public void setDef(int newDef) {
        this.def = newDef;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public void setAcc(int acc){
        this.acc =  acc;
    }
    public void setEva(int eva){
        this.eva = eva;
    }
}
