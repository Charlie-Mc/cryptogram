import java.io.IOException;


public class numberCryptogram extends Cryptogram{


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
