import java.io.IOException;

public class numberCryptogram extends Cryptogram{

    private int [][] NumberEncryption;

    public numberCryptogram(String phrase)throws IOException {
        super();
        encryptPhrase(phrase);
        NumberEncryption = new int[26][2] ;
        numberMap();
        System.out.println("done");
    }

    private void numberMap() {
        for (int i = 0; i < encryption.size(); i++) {
            NumberEncryption[i][0] = i;
            if (encryption.get(i) == null){
                continue;
            }
            NumberEncryption[i][1] = encryption.get(i);
        }
    }
}
