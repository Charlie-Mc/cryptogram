/*
TODO:
    This is for the generate Branch, delete this comment when complete
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cryptogram {
    private List<Character> encryption = Arrays.asList(new Character[26]);
    private String phrase;
    private List<Integer> numLetters = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25));

    public Cryptogram() {
        encryptPhrase();
        System.out.println("done");
    }

    public void encryptPhrase() {
        phrase = "hello world";
        // loop through the phrase
        for (int i = 0; i < phrase.length(); i++) {
            // get the current letter
            char letter = phrase.charAt(i);

            // check if the letter is a space
            if (letter == ' ') {
                continue;
            }
            // check if the letter is already in the encryption
            if (encryption != null) {
                if (encryption.contains(letter)) {
                    continue;
                }
            }


            // checks if all numbers have been used
            if (numLetters.size() == 0) {
                break;
            }
            // generate a random number

            Random rand = new Random();
            int random_int = rand.nextInt(numLetters.size());

            // add the letter and number to the encryption
            encryption.set(numLetters.get(random_int), letter);
            numLetters.remove(random_int);
        }


    }
}
