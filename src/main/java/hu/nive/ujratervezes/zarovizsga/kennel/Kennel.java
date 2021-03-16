package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog : dogs) {
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog dog : dogs) {
            if (name.equals(dog.getName())) {
                return dog;
            }
        }
        throw new IllegalArgumentException("Cannot find a dog with this name");
    }

    public void playWith(String name, int hours) {
        for (Dog dog : dogs) {
            if (name.equals(dog.getName())) {
                dog.play(hours);
            }
        }
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> happyDogs = new ArrayList<>();
        for (Dog dog : dogs) {
            if (dog.getHappiness() > minHappiness) {
                happyDogs.add(dog.getName());
            }
        }
        return happyDogs;
    }
}
