package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {

    private String name;
    //    protected int happiness;
    private int happiness;

    public Dog(String name) {
        this.happiness = 0;
        this.name = name;
    }

    protected void increaseHappiness(int diff) {
        happiness += diff;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public abstract void feed();

    public abstract void play(int hours);


}
