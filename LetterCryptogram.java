import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class LetterCryptogram extends Cryptogram {

    private String phrase;
    private String blankPhrase;
    private HashMap<Character,Character> UsersInput = new HashMap<>();

    private HashMap<Character, Character> LetterEncryptionMap = new HashMap<>();
    private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public LetterCryptogram() throws IOException {
        super();
        FileReader("phrases.txt");
        phrase = choosePhrase();
        blankPhrase = generateBlankPhrase(phrase);
        encryptPhrase(phrase);

        for (Map.Entry<Integer, Character> entry : encryptionMap.entrySet()) {
            // checks if the letter is null
            if (entry.getValue() == '\0') {
                LetterEncryptionMap.put(alphabet[entry.getKey()], '_');
                continue;
            }

            LetterEncryptionMap.put(alphabet[entry.getKey()], entry.getValue());
            UsersInput.put(alphabet[entry.getKey()], '_');
        }

        System.out.println("done");
    }

    @Override
    public String getPhrase() {
        return phrase;
    }

    @Override
    public HashMap<Character, Character> getLetterUserMap (){
        return UsersInput;
    }

   @Override
    public HashMap<Character, Character> getLetterEncryptionMap() {
        return LetterEncryptionMap;
    }
    @Override
    public String getBlankPhrase(){
        return blankPhrase;
    }

    @Override
    public char getalphabet(int num) {
                return alphabet[num];
    }

    @Override
    public int getChatAt(char letter){
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == letter){
                return i;
            }
        }
        return -1;
    }



}
