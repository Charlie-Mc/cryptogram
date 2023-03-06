import java.io.IOException;
import java.util.Scanner;


public class numberCryptogram extends Cryptogram{

    private String phrase;
    public numberCryptogram()throws IOException {
        super();
        FileReader("phrases.txt");
        phrase = choosePhrase();
        encryptPhrase(phrase);
      /*  for (Map.Entry<Integer, Character> entry : encryptionMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        } */
        System.out.println("done");
    }

    public String getPhrase() {
        return phrase;
    }

    public void play() {
        System.out.println("Cryptogram: " + phrase);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < completeEncryption.size(); i++) {
            int number = completeEncryption.get(i);
            char encryptedLetter = encryptionMap.get(number);
            System.out.print("Guess for " + number + ": ");
            char guess = scanner.next().charAt(0);
            encryptionMap.put(number, guess);
        }
        scanner.close();
        System.out.println("Your guess: " + encryptionMap.values());
    }

}
