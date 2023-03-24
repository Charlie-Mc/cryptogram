import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Players extends Player {

    ArrayList<Player> allPlayers = new ArrayList<>();
    ArrayList<String> PlayerFile = new ArrayList<>();

    public Players() {
        super();
    }

    public void addPlayer(Player player) {
        if (!allPlayers.contains(player)) {
            allPlayers.add(player);
        }
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
                file = new File("user_files/playerList.user_file");
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
            File file = new File("user_files/playerList.user_file");
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                if (line != null) {
                    File newFile = new File("user_files/" + line + ".user_file");
                    if (newFile.exists()) {
                        Player p = loadPlayer(line);
                        allPlayers.add(p);
                    } else {
                        PlayerFile.add(line);
                        Player p = new Player(line);
//                      p = fillPlayerDetails(p);
                        allPlayers.add(p);
                    }
                }
            }


        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }

    }


    public void getTop10() {
        ArrayList<Player> top10 = new ArrayList<>(allPlayers);
        // sort the list by cryptogramsCompleted
        Collections.sort(top10, new Comparator<Player>() {
            public int compare(Player p1, Player p2) {
                return p2.cryptogramsCompleted - p1.cryptogramsCompleted;
            }
        });

        // reduce size of list to 10
        if (top10.size() > 10) {
            top10.subList(10, top10.size()).clear();
        }

        System.out.println("\nThe Top Ten Scoreboard:\n");
        for (int i = 0; i < top10.size(); i++) {
            System.out.println((i + 1) + ". " + top10.get(i).getUserName() + " with " + top10.get(i).getCryptogramsCompleted() + " completions.");
        }
        System.out.println("\n===============\n");
    }

}
