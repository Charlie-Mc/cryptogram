import java.io.IOException;

public class letterCryptogram extends Cryptogram{

   private char [][] LetterEncryption;
   private char [] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public letterCryptogram(String phrase) throws IOException {
        super();
        encryptPhrase(phrase);
        LetterEncryption = new char[26][2] ;
        letterMap();
        System.out.println("done");
    }

    private void letterMap() {
        for (int i = 0; i < encryption.size(); i++) {
            LetterEncryption[i][0] = alphabet[i];
            if (encryption.get(i) == null){
                continue;
            }
            LetterEncryption[i][1] = encryption.get(i);
        }
    }

}
