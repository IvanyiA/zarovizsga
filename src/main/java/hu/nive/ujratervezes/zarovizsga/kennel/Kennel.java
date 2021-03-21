package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
//        for (Dog dog : dogs) {
//            dog.feed();
//        }
        dogs.forEach(Dog::feed);       //stream-es megoldás
    }

    public Dog findByName(String name) {
//        for (Dog dog : dogs) {
//            if (name.equals(dog.getName())) {
//                return dog;
//            }
//        throw new IllegalArgumentException("Cannot find a dog with this name");
        return dogs.stream()            //stream-es megoldás
                .filter(dog -> dog.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find a dog with this name" + name));
    }

    public void playWith(String name, int hours) {
//        for (Dog dog : dogs) {
//            if (name.equals(dog.getName())) {
//                dog.play(hours);
//            }
        Dog dog = findByName(name);     //stream-es megoldás
        dog.play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
//        List<String> happyDogNames = new ArrayList<>();
//        for (Dog dog : dogs) {
//            if (dog.getHappiness() > minHappiness) {
//                happyDogNames.add(dog.getName());
//            }
//        }
//        return happyDogNames;
        return dogs.stream()            //stream-es megoldás
                .filter(dog -> dog.getHappiness() > minHappiness)
                .map(dog -> dog.getName())
                .collect(Collectors.toList());
    }
}
