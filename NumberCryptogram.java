import java.io.IOException;
import java.util.HashMap;



public class NumberCryptogram extends Cryptogram{

    HashMap <Integer, Character> UsersInput = new HashMap<>();
    private String phrase;
    private String blankPhrase;

    public NumberCryptogram()throws IOException {
        super();
        FileReader("phrases.txt");
        phrase = choosePhrase();
        blankPhrase = generateBlankPhrase(phrase);
        encryptPhrase(phrase);
       for (int key: encryptionMap.keySet()){
           UsersInput.put(key, '_');
       }
        System.out.println("done");
    }
    @Override
    public String getPhrase() {
        return phrase;
    }

    @Override
    public HashMap<Integer, Character> getUserMap (){
        return UsersInput;
    }
    @Override
    public HashMap<Integer, Character> getEncryptionMap() {
        return UsersInput;
    }

    @Override
    public String getBlankPhrase(){
        return blankPhrase;
    }

}
