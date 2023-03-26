import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

public class showSolutionTest {

    @Test
    public void testShowSolutionLetter() throws IOException {
        Game game = new Game(true);
        Cryptogram Lcrypt = new LetterCryptogram();
        HashMap<Character, Character> LUserMap = Lcrypt.getLetterUserMap();

        game.userInput = 1;
        game.blankPhrase = Lcrypt.getBlankPhrase();
        LUserMap = game.showSolution(Lcrypt,LUserMap);
        Assertions.assertEquals(Lcrypt.getPhrase(), game.blankPhrase);
        Assertions.assertEquals(Lcrypt.getLetterEncryptionMap(),LUserMap);

    }

    @Test
    public void testShowSolutionNumber() throws IOException {
        Game game = new Game(true);
        Cryptogram Ncrypt = new NumberCryptogram();
        HashMap<Integer, Character> NUserMap = Ncrypt.getUserMap();

        game.userInput = 2;
        game.blankPhrase = Ncrypt.getBlankPhrase();
        NUserMap = game.showSolution(Ncrypt, NUserMap);

        Assertions.assertEquals(Ncrypt.getPhrase(), game.blankPhrase);
        Assertions.assertEquals(Ncrypt.getEncryptionMap(), NUserMap);

    }
}
