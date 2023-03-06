import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class letterCryptogram extends Cryptogram {

    private String phrase;
    private HashMap<Character, Character> LetterEncryptionMap = new HashMap<>();
    private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public letterCryptogram() throws IOException {
        super();
        FileReader("phrases.txt");
        phrase = choosePhrase();
        encryptPhrase(phrase);

        for (Map.Entry<Integer, Character> entry : encryptionMap.entrySet()) {
            // checks if the letter is null
            if (entry.getValue() == '\0') {
                LetterEncryptionMap.put(alphabet[entry.getKey()], ' ');
                continue;
            }

            LetterEncryptionMap.put(alphabet[entry.getKey()], entry.getValue());
        }

        System.out.println("done");
    }

    public void play() {
        System.out.println("Cryptogram: " + phrase);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < phrase.length(); i++) {
            char letter = phrase.charAt(i);
            if (letter == ' ') {
                System.out.print(" ");
            } else {
                char encryptedLetter = LetterEncryptionMap.get(letter);
                if (encryptedLetter != ' ') {
                    System.out.print(encryptedLetter);
                    char guess = scanner.next().charAt(0);
                    LetterEncryptionMap.put(letter, guess);
                } else {
                    System.out.print("_");
                }
            }
        }
        scanner.close();
        System.out.println("Your guess: " + LetterEncryptionMap.values());
    }


    public String getPhrase() {
        return phrase;
    }

    public HashMap<Character, Character> getLetterEncryptionMap() {
        return LetterEncryptionMap;
    }

    public int getalphabetInt(char letter) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == letter) {
                return i;
            }
        }
        return -1;
    }

}
