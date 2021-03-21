package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
//        happiness += 2;
        increaseHappiness(2);
    }

    @Override
    public void play(int hours) {
//        happiness += hours * 2;
        increaseHappiness(hours * 2);
    }
}
