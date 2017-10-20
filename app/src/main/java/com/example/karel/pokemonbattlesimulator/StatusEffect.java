package com.example.karel.pokemonbattlesimulator;

/**
 * Created by Karel on 20/10/2017.
 */

public class StatusEffect {
    private boolean isParalized;
    private boolean isPoisoned;
    private boolean isBadlyPoisoned;
    private boolean isBurned;
    private boolean isFrozen;
    private boolean isFlinched;
    private boolean isConfused;
    private boolean isInfatuated;
    private boolean isSleeping;

    private boolean hasNonVolatileEffect;

    private int sleepCounter;

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
    }

    public void setParalized(boolean paralized) {
        if (!hasNonVolatileEffect) {
            isParalized = paralized;
            setNonVolatileEffect(paralized);
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
