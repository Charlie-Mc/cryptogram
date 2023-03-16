import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Player_tests {

    /* Test to create an account successfully on all cases*/
    @Test
    public void testCreateAccount() {
        Player a = new Player();
        Player b = new Player("testerb");

        Assertions.assertNull(a.getUserName());
        Assertions.assertEquals(b.getUserName(), "testerb");
    }

    /* Test to set a new UserName on all instances */
    @Test
    public void testUserName() {
        Player a = new Player();
        Player b = new Player("testerb");

        Assertions.assertNull(a.getUserName());
        Assertions.assertEquals(b.getUserName(), "testerb");

        a.setUserName("testera");
        b.setUserName("btester");

        Assertions.assertEquals(a.getUserName(), "testera");
        Assertions.assertEquals(b.getUserName(), "btester");
    }

    /* Test the CryptogramsCompleted variable and its methods */
    @Test
    public void testCryptogramsCompleted() {
        Player a = new Player();

        Assertions.assertEquals(a.getCryptogramsCompleted(), 0);
        a.addCryptogramsCompleted();
        Assertions.assertEquals(a.getCryptogramsCompleted(), 1);
    }

    /* Tests the accuracy variable and it's methods*/
    @Test
    public void testAccuracy() {
        Player a = new Player();

        Assertions.assertEquals(a.getAccuracy(), 0.0);
        a.setAccuracy(25.0);
        Assertions.assertEquals(a.getAccuracy(), 25.0);
    }

    /* Test the CryptogramsCompleted variable and its methods */
    @Test
    public void testCryptogramsPlayed() {
        Player a = new Player();

        Assertions.assertEquals(a.getCryptogramsPlayed(), 0);
        a.addCryptogramsPlayed();
        Assertions.assertEquals(a.getCryptogramsPlayed(), 1);
    }

    /* Test the TotalGuesses variable and its methods */
    @Test
    public void testTotalGuesses() {
        Player a = new Player();

        Assertions.assertEquals(a.getTotalGuesses(), 0);
        a.addTotalGuesses();
        Assertions.assertEquals(a.getTotalGuesses(), 1);
    }

    /* Test the CorrectGuesses variable and its methods */
    @Test
    public void testCorrectGuesses() {
        Player a = new Player();

        Assertions.assertEquals(a.getCorrectGuesses(), 0);
        a.addCorrectGuesses();
        Assertions.assertEquals(a.getCorrectGuesses(), 1);
    }

    /* Test the toString method, adjusting the variables and tests again */
    @Test
    public void testToString() {
        Player a = new Player("tester");

        Assertions.assertEquals(a.toString(), "Player{userName= 'tester', cryptogramsCompleted= 0, " +
                "Accuracy= 0.0, cryptogramsPlayed= 0, totalGuesses= 0, correctGuesses= 0}");

        a.setUserName("tester2");
        a.setAccuracy(100.0);
        a.addCorrectGuesses();
        a.addTotalGuesses();
        a.addCryptogramsPlayed();
        a.addCryptogramsCompleted();

        Assertions.assertEquals(a.toString(), "Player{userName= 'tester2', cryptogramsCompleted= 1, " +
                "Accuracy= 100.0, cryptogramsPlayed= 1, totalGuesses= 1, correctGuesses= 1}");
    }
}