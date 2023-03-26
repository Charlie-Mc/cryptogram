import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class FrequencyTest {
    @Test
    public void frequencyTest() throws IOException {
        Cryptogram crypt = new Cryptogram();
        crypt.setPhrase("aaabcc za");
        crypt.encryptPhrase(crypt.getPhrase());

        ArrayList<Integer> freq = crypt.getFrequency();
        // test the frequency of each letter
                int i = 0;
               for (int key: crypt.getEncryptionMap().keySet()){
                   if (crypt.getEncryptionMap().get(key) == 'a'){
                       Assertions.assertEquals(freq.get(i), 4);
                   }
                   if (crypt.getEncryptionMap().get(key) == 'b'){
                          Assertions.assertEquals(freq.get(i), 1);
                   }
                   if (crypt.getEncryptionMap().get(key) == 'c'){
                            Assertions.assertEquals(freq.get(i), 2);
                   }
                   if (crypt.getEncryptionMap().get(key) == 'z'){
                               Assertions.assertEquals(freq.get(i), 1);
                   }

                   i++;

               }


        }

    }

