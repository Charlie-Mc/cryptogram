

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class generationTest {

    @Test
    public void testLetterCryptogram() throws IOException {
        letterCryptogram Lcryptogram = new letterCryptogram ();
        Assertions.assertNotNull(Lcryptogram);

        Assertions.assertNotNull(Lcryptogram.getLetterEncryptionMap());
        Assertions.assertEquals(Lcryptogram.getPhrase().length(), Lcryptogram.getBlankPhrase().length());

       for (int value: Lcryptogram.getCompleteEncryption()){
           Assertions.assertTrue(Lcryptogram.getLetterEncryptionMap().keySet().contains(Lcryptogram.getalphabet(value)));
           Assertions.assertNotNull(Lcryptogram.getLetterEncryptionMap().get(Lcryptogram.getalphabet(value)));
       }
    }


    @Test
    public void testNumberCryptogram() throws IOException {
        numberCryptogram Ncryptogram = new numberCryptogram ();
        Assertions.assertNotNull(Ncryptogram);

        Assertions.assertNotNull(Ncryptogram.getEncryptionMap());
        Assertions.assertEquals(Ncryptogram.getPhrase().length(), Ncryptogram.getBlankPhrase().length());

        for (int value: Ncryptogram.getCompleteEncryption()){
            Assertions.assertTrue(Ncryptogram.getEncryptionMap().keySet().contains(value));
            Assertions.assertNotNull(Ncryptogram.getEncryptionMap().get(value));
        }
    }
}
