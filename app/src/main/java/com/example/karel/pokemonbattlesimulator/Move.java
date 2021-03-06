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
    String buffTarget;
    double statReductionAcc;
    double healratio;
    int amountHits;


    public Move(String moveName, boolean isSpecial, int baseDamage, double accuracy, Type type,
                String statReductionStat, int statReductionValue, String buffTarget,
                double statReductionAcc, double healratio, int amountHits, String statusEffect) {
        this.moveName = moveName; //name
        this.isSpecial = isSpecial; // true if the damage scales with Special attack rather than physical
        this.baseDamage = baseDamage; //base damage
        this.accuracy = accuracy; // chance that the move will hit
        this.type = type; // type of the move
        this.statReductionStat = statReductionStat; // the stat which might be altered because of this move
        this.statReductionValue = statReductionValue; // amount of stages this stat is altered
        this.buffTarget = buffTarget; //the target for the stat altering. either "self" or "enemy"
        this.statReductionAcc = statReductionAcc; //accuracy of the stat altering component to hit
        this.healratio = healratio; // % of the damage that is healed
        this.amountHits = amountHits; // amount of times this moves hits

    }

    public void createMoveDatabase(){

        Type normal = new Type("normal");
        Type fire = new Type("fire");
        Type water = new Type("water");
        Type electric = new Type("electric");
        Type grass = new Type("grass");
        Type ice = new Type("ice");
        Type fighting = new Type("fighting");
        Type poison = new Type("poison");
        Type ground = new Type("ground");
        Type flying = new Type("flying");
        Type psychic = new Type("psychic");
        Type bug = new Type("bug");
        Type rock = new Type("rock");
        Type ghost = new Type("ghost");
        Type dragon = new Type("dragon");
        Type dark = new Type("dark");
        Type steel = new Type("steel");
        Type fairy =  new Type("fairy");
        Type noType = new Type("");

        Move absorb = new Move("Absorb", true, 20, 1, grass, "atk", 0, "self", 1.0, 0.5, 1, "");
        Move acid = new Move("Acid", true, 40, 1, poison, "spDef", -1, "enemy", 0.1, 0, 1, "");
        Move acidArmor =  new Move("Acid Armor", true, 0, 1, poison, "def", 2, "self", 1.0, 0, 1, "");
        Move agility = new Move("Agility", true, 0, 1, psychic, "spd", 2, "self", 1.0, 0, 1, "");
        Move amnesia = new Move("Amnesia", true, 0, 1, psychic, "spDef", 2, "self", 1.0, 0, 1, "");
        Move auroraBeam = new Move("Aurora Beam", true, 65, 1, ice, "atk", -1, "enemy", 0.1, 0, 1, "");
        Move barrage = new Move("Barrage", false, 15, 0.85, normal, "atk", 0, "self", 1.0, 0, 2 + (int)(Math.random()*4), "");
        //TODO verify math.random
        Move barrier = new Move("Barrier", true, 0, 100, psychic, "def", 2, "self", 1.0, 0, 1, "");
        Move bide;
        //TODO to be hardcoded;
        Move bind = new Move("Bind", false, 15, 0.85, normal, "atk", 0, "self", 1.0, 0, 1, "bind");
        Move bite = new Move("Bite", false, 60, 1, dark, "atk", 0, "self", .3, 0, 1, "flinch");
        Move blizzard = new Move("Blizzard", true, 110, 0.70, ice, "atk", 0, "self", .1, 0, 1, "freeze");
        Move bodySlam = new Move("Body Slam", false, 85, 1.0, normal, "atk", 0, "self", .3, 0, 1, "paralize");
        Move boneClub = new Move("Bone Club", false, 65, 0.85, ground, "atk", 0, "self", .1, 0, 1, "flinch");
        Move bonemerang = new Move("Bonemerang", true, 50, 0.9, ground, "atk", 0, "self", 0, 0, 2, "");
        Move bubble =  new Move("Bubble", true, 40, 1.0, water, "spd", -1, "enemy", .1, 0, 1, "");
        Move bubbleBeam = new Move("Bubble Beam", true, 65, 1, water, "spd", -1, "enemy", .1, 0, 1, "");



    }
}