import java.io.*;
import java.util.*;

public class Game {
    //  private List<List<String>> encryption;
    int userInput;
    int KeyInputNumber = -1;

    String blankPhrase;
    Players players;

    String playerName;
    Player player;

    LetterCryptogram lcrypt;
    NumberCryptogram ncrypt;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Create a new game
        new Game();
    }

    public Game() throws IOException, ClassNotFoundException {

        // Create a new player
        players = new Players();
        players.loadPlayerList();
        System.out.println("Do you want to enter a name to store your stats? y/n");
        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().charAt(0) == 'y') {
            System.out.print("Please enter here:   ");
            playerName = sc.nextLine();
            if (players.isPlayer(playerName)) {
                players.addPlayer(players.loadPlayer(playerName));
            } else {
                players.addPlayer(new Player(playerName));
                players.savePlayersList();
            }
        } else {
            players.loadPlayer("player");
            playerName = "player";
        }

        player = players.getPlayer(playerName);

        // gets the user input for the game version
        if (new File(playerName + ".game_save").exists() && new File(playerName + ".input").exists()) {
            Cryptogram c = loadGame(player);
            userInput = fileInput();
            GameVersion(userInput, c, player);
        } else {
            userInput = getUserInput();
            GameVersion(userInput, null, player);
        }
        // runs that game version;

    }

    public int fileInput() throws FileNotFoundException {
        File file = new File(playerName + ".input");
        return (new Scanner(file).nextByte());
    }

    //checks if the user wants to replace that value
    private boolean inputCheck() throws FileNotFoundException {
        System.out.println("you have already allocated a value to this key, do you want to replace it? (y/n)");
        char replace = ' ';
        do {
            replace = enterLetter();
            replace = Character.toLowerCase(replace);
            if (replace != 'y' && replace != 'n'){
                System.out.println("please enter a valid input");
            }
        } while (replace != 'y' && replace != 'n');

        if (replace == 'y'){
            return true;
        } else{
            return false;
        }
    }



    public void playGame(Cryptogram crypt) throws IOException {

        ArrayList keySet;
        HashMap UserMap = null;
        boolean running = true;
        blankPhrase = crypt.getBlankPhrase();
        System.out.println(crypt.getCompleteEncryption());
        while (running) {

            System.out.println("keys: ");
            // get data depending on game type
            if (userInput == 1) {
                keySet = new ArrayList<Character>();
                for (char key : crypt.getLetterEncryptionMap().keySet()) {
                    keySet.add(key);
                    UserMap = crypt.getLetterUserMap();
                    System.out.print(": " + key);
                }
            } else {
                keySet = new ArrayList<Integer>();
                for (int key : crypt.getEncryptionMap().keySet()) {
                    keySet.add(key);
                    UserMap = crypt.getUserMap();
                    System.out.print(": " + key);
                }
            }


            // start of game
            System.out.println();
            System.out.println("phrase: " + crypt.getPhrase());
            System.out.println("current phrase: " + blankPhrase);
            System.out.println("enter a letter or enter - to remove a mapping");
            char letterInput = enterLetter();
            char keyInputChar = '_';

            // the undo button//
            if (letterInput == '-') {
                if (UserMap.isEmpty()) {
                    System.out.println("you have not allocated a value to this key");
                } else {
                    System.out.println("what key do you want to unmap");
                    UserMap = gameInput(UserMap, keySet, keyInputChar, letterInput, crypt, false);

                    int counter = 0;
                    for (int i = 0; i < blankPhrase.length(); i++) {

                        if (blankPhrase.charAt(i) != ' ') {
                            if (KeyInputNumber == crypt.getCompleteEncryption().get(counter)) {
                                blankPhrase = blankPhrase.substring(0, i) + '_' + blankPhrase.substring(i + 1);
                            }
                            counter++;
                        }
                    }
                }
            } else {

                System.out.println("what key do you want to allocate it to");
                UserMap = gameInput(UserMap, keySet, keyInputChar, letterInput, crypt, true);


                // prints out the keys and what's mapped to them
                int i = 0;
                for (Object values : UserMap.values()) {
                    System.out.print("key: " + keySet.get(i) + "-" + values + "| ");
                    i++;
                }
                // updates the blank phrase for the user
                updateBlankPhrase(UserMap, crypt);


                // checks if the user has won or lost
                if (blankPhrase.equals(crypt.getPhrase())) {
                    System.out.println("\n you have won");
                    player.addCryptogramsCompleted();
                    player.addCryptogramsPlayed();
                    running = false;
                } else if (!blankPhrase.contains("_")) {
                    System.out.println("\n you have lost");
                    player.addCryptogramsPlayed();
                }

            }
        }
            System.out.println();
            player.saveDetails(userInput);
            saveGame(player, crypt);
    }


    private void GameVersion(int userInput, Cryptogram c, Player p) throws IOException {
        if (userInput == 1) {
            if (c != null) {
                lcrypt = (LetterCryptogram) c;
            } else {
                lcrypt = new LetterCryptogram();
            }
            playGame(lcrypt);
        }
        if (userInput == 2) {
            NumberCryptogram crypt;
            if (c != null) {
                ncrypt = (NumberCryptogram) c;
            } else {
                ncrypt = new NumberCryptogram();
            }
            playGame(ncrypt);
        }
    }

    private int getUserInput() throws FileNotFoundException {
        int choice = 0;
        boolean correctInput = false;
        System.out.println("Enter / at any time to quit the game");
        System.out.println("Enter ? at any time to show the answer");
        do {
            System.out.println("Please enter 1 to play a letter cryptogram or 2 to play a number cryptogram");
            Scanner input = new Scanner(System.in);
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                char c = input.nextLine().charAt(0);
                player.saveDetails(userInput);
                System.exit(0);
            }

            input.nextLine();

            if (choice == 1 || choice == 2){
                correctInput = true;
            }
            else {
                System.out.println("Please enter a valid input");
            }
        } while (!correctInput);

        return choice;
    }



    public int enterNumber(ArrayList<Integer> keySet) throws FileNotFoundException{

        try {
            int i = 0;
            do {
                Scanner sc = new Scanner(System.in);
                try {
                    i = sc.nextInt();
                } catch (InputMismatchException e) {
                    char c = sc.nextLine().charAt(0);
                    player.saveDetails(userInput);
                    System.exit(0);
                }


                if (!keySet.contains(i)){
                    System.out.println("key in not in the list, please enter a valid key");
                }
            }while(!keySet.contains(i));
            return i;
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input");
            return enterNumber(keySet);
        }

    }
    public char enterLetter(ArrayList<Character> keySet) throws FileNotFoundException, InputMismatchException{
        // takes in user input
        try {
            char c = ' ';
            do {
                Scanner sc = new Scanner(System.in);
                c = sc.nextLine().charAt(0);

                if (c == '/') {
                    player.saveDetails(userInput);
                    if (lcrypt != null)
                        saveGame(player, lcrypt);
                    else
                        saveGame(player, ncrypt);
                    System.exit(0);
                }

                if (c == '?') {
                    System.out.println("showing solution ...");
                    return c;
                }

                if (!keySet.contains(c)) {
                    System.out.println("key in not in the list, please enter a valid key");
                }
                if (!Character.isLetter(c)) {
                    System.out.println("Please enter a letter");
                }
            } while (!Character.isLetter(c) || !keySet.contains(c));
            return c;
        } catch (IOException e) {
            System.out.println("Please enter a valid input");
            return enterLetter(keySet);
        }
    }

    public char enterLetter() throws FileNotFoundException, InputMismatchException{
        // takes in user input
        try {
            char c = ' ';
            do {
                Scanner sc = new Scanner(System.in);
                c = sc.nextLine().charAt(0);

                if (c == '/') {
                    player.saveDetails(userInput);
                    if (lcrypt != null)
                        saveGame(player, lcrypt);
                    else
                        saveGame(player, ncrypt);
                    System.exit(0);
                }

                if (c == '?') {
                    System.out.println("showing solution ...");
                    return c;
                }

                if (!Character.isLetter(c) && c != '-') {
                    System.out.println("Please enter a letter");
                }
            } while (!Character.isLetter(c) && c != '-');
            return c;
        } catch (IOException e) {
            System.out.println("Please enter a valid input");
            return enterLetter();
        }
    }

    private HashMap gameInput(HashMap UserMap, ArrayList keySet, char keyInputChar, char letterInput, Cryptogram crypt, boolean newInput) throws FileNotFoundException {
        if (userInput == 1) {
            keyInputChar = enterLetter(keySet);
            if (!UserMap.get(keyInputChar).equals('_')) {
                if (inputCheck()) {
                    UserMap.replace(keyInputChar, letterInput);
                }
            } else {
                UserMap.replace(keyInputChar, letterInput);
            }
            if(newInput){
                if (crypt.getLetterEncryptionMap().get(keyInputChar) == letterInput) {
                    player.addTotalGuesses();
                    player.addCorrectGuesses();
                } else {
                    player.addTotalGuesses();
                }
            }
            this.KeyInputNumber = crypt.getChatAt(keyInputChar);
        } else {
            KeyInputNumber = enterNumber(keySet);
            if (!UserMap.get(KeyInputNumber).equals('_')) {
                if (inputCheck()) {
                    UserMap.replace(KeyInputNumber, letterInput);
                }
            } else {
                UserMap.replace(KeyInputNumber, letterInput);
            }

            if (newInput){
                if (crypt.getEncryptionMap().get(KeyInputNumber) == letterInput) {
                    player.addTotalGuesses();
                    player.addCorrectGuesses();
                } else {
                    player.addTotalGuesses();
                }
            }

        }
        return UserMap;
    }

    private void updateBlankPhrase(HashMap UserMap, Cryptogram crypt){
        if (userInput == 1) {
            for (char key : crypt.getLetterEncryptionMap().keySet()) {
                int counter = 0;
                if (!UserMap.get(key).equals('_')) {
                    for (int i = 0; i < blankPhrase.length(); i++) {

                        if (blankPhrase.charAt(i) != ' ') {
                            if (key == crypt.getalphabet(crypt.getCompleteEncryption().get(counter))) {
                                blankPhrase = blankPhrase.substring(0, i) + UserMap.get(key) + blankPhrase.substring(i + 1);
                            }
                            counter++;
                        }
                    }
                }
            }
        } else {
            for (int key : crypt.encryptionMap.keySet()) {
                int counter = 0;
                if (!UserMap.get(key).equals('_')) {
                    for (int i = 0; i < blankPhrase.length(); i++) {

                        if (blankPhrase.charAt(i) != ' ') {
                            if (key == crypt.getCompleteEncryption().get(counter)) {
                                blankPhrase = blankPhrase.substring(0, i) + UserMap.get(key) + blankPhrase.substring(i + 1);
                            }
                            counter++;
                        }
                    }
                }
            }
        }
    }

    public void saveGame(Player p, Cryptogram c) throws IOException {
        String filename = p.getUserName() + ".game_save";
        FileWriter writer = new FileWriter(p.getUserName() + ".input");
        writer.write(userInput + "\n");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(c);
    }


   public Cryptogram loadGame(Player p) throws IOException, ClassNotFoundException {
        String filename = p.getUserName() + ".game_save";
        Scanner scan = new Scanner(p.getUserName() + ".input");
        String input = scan.nextLine();
        userInput = (int) input.charAt(0) - '0' - 50;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        return (Cryptogram) ois.readObject();
   }
}
