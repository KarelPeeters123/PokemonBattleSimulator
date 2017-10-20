package com.example.karel.pokemonbattlesimulator;

/**
 * Created by Karel on 20/10/2017.
 */

public class StatusEffect {
    Pokemon myPokemon;
    private boolean isParalized;
    private boolean isPoisoned;
    private boolean isBadlyPoisoned;
    private boolean isBurned;
    private boolean isFrozen;

    private boolean isFlinched;
    private boolean isConfused;
    private boolean isInfatuated;
    private boolean isSleeping;
    private boolean isBound;


    private boolean hasNonVolatileEffect;

    private int sleepCounter;
    private int badlyPoisonedCounter;
    private int bindCounter;

    public StatusEffect() {
        isParalized = false;
        isPoisoned = false;
        isBadlyPoisoned = false;
        isBurned = false;
        isFrozen = false;
        isSleeping = false;
        isFlinched = false;
        isConfused = false;
        isInfatuated = false;

        hasNonVolatileEffect = false;

        sleepCounter = 0;
        badlyPoisonedCounter = 0;
        bindCounter =  0;

    }

    public boolean isBound() {
        return isBound;
    }

    public void setBound(boolean bound) {
        isBound = bound;
        bindCounter = (int)(2 + Math.random()*4);
    }

    public int getBindCounter() {
        return bindCounter;
    }

    public void setBindCounter(int bindCounter) {
        this.bindCounter = bindCounter;
        if (this.bindCounter <= 0){
            this.bindCounter = 0;
        }
    }

    public boolean isParalized() {
        return isParalized;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public boolean isBadlyPoisoned() {
        return isBadlyPoisoned;
    }

    public boolean isBurned() {
        return isBurned;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public boolean isFlinched() {
        return isFlinched;
    }

    public boolean isConfused() {
        return isConfused;
    }

    public boolean isInfatuated() {
        return isInfatuated;
    }

    public boolean isSleeping() {
        return isSleeping;
    }


    public boolean isHasNonVolatileEffect() {
        return hasNonVolatileEffect;
    }

    public int getSleepCounter() {
        return sleepCounter;
    }

    public void setSleeping(boolean sleeping) {
        if (!hasNonVolatileEffect) {
            isSleeping = sleeping;
            setSleepCounter(3);
            setNonVolatileEffect(sleeping);
            if (getSleepCounter() <= 0);
        }
        if (sleeping == false){
            isSleeping = sleeping;
        }
    }

    public void setSleepCounter(int sleepCounter) {
        this.sleepCounter = sleepCounter;
        if (this.sleepCounter <= 0){
            this.sleepCounter = 0;
        }
    }

    public void setBadlyPoisonedCounter(int badlyPoisonedCounter) {
        this.badlyPoisonedCounter = badlyPoisonedCounter;
        if (this.badlyPoisonedCounter <= 0){
            this.badlyPoisonedCounter = 0;
        }
    }

    public int getBadlyPoisonedCounter() {
        return badlyPoisonedCounter;
    }

    public void setParalized(boolean paralized) {
        if (!hasNonVolatileEffect) {
            isParalized = paralized;
            setNonVolatileEffect(paralized);
            myPokemon.myStats.setSpd((int)(0.75*myPokemon.myStats.spd));
        }
        if (paralized == false){
            isParalized = paralized;
        }
    }

    public void setPoisoned(boolean poisoned) {
        if (!hasNonVolatileEffect) {
            isPoisoned = poisoned;
            setNonVolatileEffect(poisoned);
        }
        if (poisoned == false){
            isPoisoned = poisoned;
        }
    }

    public void setBadlyPoisoned(boolean badlyPoisoned) {
        if (!hasNonVolatileEffect) {
            isBadlyPoisoned = badlyPoisoned;
            setNonVolatileEffect(badlyPoisoned);
        }
        if (badlyPoisoned == false){
            isBadlyPoisoned = badlyPoisoned;
        }
    }

    public void setBurned(boolean burned) {
        if (!hasNonVolatileEffect) {
            isBurned = burned;
            setNonVolatileEffect(burned);
        }
        if (burned == false){
            isBurned = burned;
        }
    }

    public void setFrozen(boolean frozen) {
        if (!hasNonVolatileEffect) {
            isFrozen = frozen;
            setNonVolatileEffect(frozen);
        }
        if (frozen == false){
            isFrozen = frozen;
        }
    }

    public void setFlinched(boolean flinched) {
        isFlinched = flinched;
    }

    public void setConfused(boolean confused) {
        isConfused = confused;
    }

    public void setInfatuated(boolean infatuated) {
        isInfatuated = infatuated;
    }

    public void setNonVolatileEffect(boolean nonVolatileEffect) {
        hasNonVolatileEffect = nonVolatileEffect;
    }
}
