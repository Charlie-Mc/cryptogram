import java.io.IOException;


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

}
