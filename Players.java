import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Players extends Player{

    ArrayList<Player> allPlayers = new ArrayList<>();
    ArrayList<String> PlayerFile = new ArrayList<>();

    public Players() {
        super();
    }

    public void addPlayer(Player player) {
        allPlayers.add(player);
    }
    public void removePlayer(Player player) {
        allPlayers.remove(player);
    }
    public ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }
    public Player getPlayer(String name) {
        for (Player player : allPlayers) {
            if (player.getUserName().equals(name.toLowerCase().replace(' ', '_'))) {
                return player;
            }
        }
        return new Player();
    }

    public boolean isPlayer(String name){
        for (String value: PlayerFile){
            if (value.equals(name.toLowerCase().replace(' ', '_'))){
                return true;
            }
        }
        return false;
    }

    public int getAllPlayersCryptogramsCompleted() {
        int total = 0;
        for (Player player : allPlayers) {
            total += player.getCryptogramsCompleted();
        }
        return total;
    }

    public void savePlayersList() {
        try {
            File file;
            if (allPlayers.size() != 0) {
                file = new File("playerList.user_file");
            }else{
                return;
            }
            // overwrite the file
            FileWriter writer = new FileWriter(file, false);
            for (Player player : allPlayers) {
                writer.write(player.getUserName() + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

    public void loadPlayerList(){
        // load in the player list
        try {
            File file = new File("playerList.user_file");
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                PlayerFile.add(line);
            }

        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

    public void getHints(Cryptogram crypt) {
        HashMap<Character, Character> letterUserMap = crypt.getLetterUserMap();
        ArrayList<Character> keySet = new ArrayList<Character>(letterUserMap.keySet());
        Random random = new Random();
        char letterToReplace;
        char hintLetter;

        do {
            letterToReplace = keySet.get(random.nextInt(keySet.size()));
        } while (!letterUserMap.get(letterToReplace).equals('_'));

        hintLetter = crypt.getLetterEncryptionMap().get(letterToReplace);

        letterUserMap.replace(letterToReplace, hintLetter);
        crypt.setLetterUserMap(letterUserMap);

        System.out.println("Hint: Replace the letter '" + letterToReplace + "' with '" + hintLetter + "'");
    }
}
