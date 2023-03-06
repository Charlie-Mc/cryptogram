import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class letterCryptogram extends Cryptogram{


    private char [] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public letterCryptogram() throws IOException {
        super();
        FileReader("phrases.txt");
        String phrase = choosePhrase();
        encryptPhrase(phrase);
        HashMap<Character, Character> LetterEncryptionMap = new HashMap<>();

        for (Map.Entry<Integer, Character> entry : encryptionMap.entrySet()) {
            LetterEncryptionMap.put(alphabet[entry.getKey()], entry.getValue());
        }
        for (Map.Entry<Character, Character> entry : LetterEncryptionMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("done");
    }


}
