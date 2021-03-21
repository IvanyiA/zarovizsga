package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {

    public Husky(String name) {
        super(name);
    }

    public void feed() {
//        happiness += 4;
        increaseHappiness(4);
    }

    public void play(int hours) {
//        happiness = hours * 3;
        increaseHappiness(hours * 3);
    }
}
