import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class numberCryptogram extends Cryptogram{

    private int [][] NumberEncryption;

    public numberCryptogram()throws IOException {
        super();
        FileReader("phrases.txt");
        String phrase = choosePhrase();
        encryptPhrase(phrase);
      /*  for (Map.Entry<Integer, Character> entry : encryptionMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        } */
        System.out.println("done");
    }


}
