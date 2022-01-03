package com.company;

public class Polinom {
    private int factor;
    private int power;

    public Polinom(int factor, int power) {
        this.factor = factor;
        this.power = power;
    }

    public Polinom(int factor){
        this.factor = factor;
        this.power = 1;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Polinom{" +
                "factor=" + factor +
                ", power=" + power +
                '}';
    }
}
