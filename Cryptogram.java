/*
TODO:
    This is for the generate Branch, delete this comment when complete
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Cryptogram {
    public List<Character> encryption = Arrays.asList(new Character[26]);

    private ArrayList<String> phrases = new ArrayList<>();
    private List<Integer> numLetters = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25));

    private String phrase;

    public Cryptogram(int userInput) throws IOException {

        FileReader("phrases.txt");
        phrase = chooseCryptogram();

        if (userInput == 1) {
            letterCryptogram LetterCrypt = new letterCryptogram(phrase);
        }
        if (userInput == 2) {
            numberCryptogram NumberCrypt = new numberCryptogram(phrase);
        }
    }

    public Cryptogram(){
       // FileReader("phrases.txt");
       // phrase = chooseCryptogram();

    }

    public void encryptPhrase(String phrase) {

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

    private void FileReader(String fileName)
            throws IOException
    {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        //checks if the file is empty
        if (br.readLine() == null) {
            System.out.println("File is empty");
            return;
        }
        String line;
        System.out.println(
                "Reading text file");
        while ((line = br.readLine()) != null) {
            // process the line
            phrases.add(line);
            //System.out.println(line);
        }
        br.close();
        fr.close();
    }

    private String chooseCryptogram() {
        String phrase;
        Random rand = new Random();
        int random_int = rand.nextInt(phrases.size());

        return phrase= phrases.get(random_int);
    }


}
