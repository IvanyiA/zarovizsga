package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String textnumbers) {

        if (textnumbers == null || textnumbers.isEmpty()) {
            return 0;
        }
        Set<Character> countOfNumbers = new HashSet<>();
        for (Character c : textnumbers.toCharArray()) {
            if (Character.isDigit(c)) {
                countOfNumbers.add(c);
            }
        }
        return countOfNumbers.size();
    }

}
