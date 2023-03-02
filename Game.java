
public class Game {
 //  private List<List<String>> encryption;


    public static void main(String[] args) {
        // Create a new game
        Game game = new Game();
        gui Gui = new gui();



        // Start the game
        Gui.startMenu();
    }

    public Game() {
        Cryptogram crypt = new Cryptogram();
        crypt.encryptPhrase();

    }
    public void playGame() {
        System.out.println("Game Started!");


    }


}




        //TODO: create cryptogram generator, dont forget to update gui when complete




