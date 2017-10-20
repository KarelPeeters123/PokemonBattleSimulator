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
    int atkMultiplier;
    int defMultiplier;
    int spAtkMultiplier;
    int spDefMultiplier;
    int spdMultiplier;
    int accMultiplier;
    int evaMultiplier;


    public Stats(int level, int baseHp, int baseAtk, int baseDef, int baseSpAtk, int baseSpDef, int baseSpd) {
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpAtk = baseSpAtk;
        this.baseSpDef = baseSpDef;
        this.baseSpd = baseSpd;
        this.atkMultiplier = 0;
        this.defMultiplier = 0;
        this.spAtkMultiplier = 0;
        this.spDefMultiplier = 0;
        this.spdMultiplier = 0;
        this.accMultiplier = 0;
        this.evaMultiplier = 0;
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
    public void setMultiplier(int multiplier, String stat){
        if (stat.equals("atk")) {
            this.atkMultiplier += multiplier;
            if (this.atkMultiplier >= 6){
                this.atkMultiplier = 6;
            } else if (this.atkMultiplier <= -6){
                this.atkMultiplier = -6;
            }
            if (atkMultiplier >= 0) {
                this.setAtk((atkMultiplier + 2) / 2);
            } else {
                this.setAtk(2 / (atkMultiplier + 2));
            }
        } else if (stat.equals("def")) {
            this.defMultiplier += multiplier;
            if (this.defMultiplier >= 6){
                this.defMultiplier = 6;
            } else if (this.defMultiplier <= -6){
                this.defMultiplier = -6;
            }
            if (defMultiplier >= 0) {
                this.setDef((defMultiplier + 2) / 2);
            } else {
                this.setDef(2 / (defMultiplier + 2));
            }
        } else if (stat.equals("spAtk")) {
            this.spAtkMultiplier += multiplier;
            if (this.spAtkMultiplier >= 6){
                this.spAtkMultiplier = 6;
            } else if (this.spAtkMultiplier <= -6){
                this.spAtkMultiplier = -6;
            }
            if (spAtkMultiplier >= 0) {
                this.setSpAtk((spAtkMultiplier + 2) / 2);
            } else {
                this.setSpAtk(2 / (spAtkMultiplier + 2));
            }
        } else if (stat.equals("spDef")) {
            this.spDefMultiplier += multiplier;
            if (this.spDefMultiplier >= 6) {
                this.spDefMultiplier = 6;
            } else if (this.spDefMultiplier <= -6) {
                this.spDefMultiplier = -6;
            }
            if (spDefMultiplier >= 0) {
                this.setSpDef((spDefMultiplier + 2) / 2);
            } else {
                this.setSpDef(2 / (spDefMultiplier + 2));
            }
        } else if (stat.equals("spd")) {
            this.spdMultiplier += multiplier;
            if (this.spdMultiplier >= 6) {
                this.spdMultiplier = 6;
            } else if (this.spdMultiplier <= -6) {
                this.spdMultiplier = -6;
            }
            if (spdMultiplier >= 0) {
                this.setSpd((spdMultiplier + 2) / 2);
            } else {
                this.setSpd(2 / (spdMultiplier + 2));
            }
        } else if (stat.equals("acc")) {
            this.accMultiplier += multiplier;
            if (this.accMultiplier >= 6) {
                this.accMultiplier = 6;
            } else if (this.accMultiplier <= -6) {
                this.accMultiplier = -6;
            }
            if (accMultiplier >= 0) {
                this.setAcc((accMultiplier + 2) / 2);
            } else {
                this.setAcc(2 / (accMultiplier + 2));
            }
        } else if (stat.equals("eva")) {
            this.evaMultiplier += multiplier;
            if (this.evaMultiplier >= 6) {
                this.evaMultiplier = 6;
            } else if (this.evaMultiplier <= -6) {
                this.evaMultiplier = -6;
            }
            if (evaMultiplier >= 0) {
                this.setEva((evaMultiplier + 2) / 2);
            } else {
                this.setEva(2 / (evaMultiplier + 2));
            }
        }
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
