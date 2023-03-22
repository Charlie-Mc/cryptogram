import java.io.*;
import java.util.Scanner;

public class Player {
    String userName = "player";
    double accuracy;
    int totalGuesses;

    int correctGuesses;
    int cryptogramsPlayed;
    int cryptogramsCompleted;

    public Player() {
        this.accuracy = 0.00;
        this.cryptogramsCompleted = 0;
        this.cryptogramsPlayed = 0;
        this.totalGuesses = 0;
        this.correctGuesses = 0;
    }
    public Player(String name) {
        this.userName = name.toLowerCase().replace(' ', '_');
        this.accuracy = 0.00;
        this.cryptogramsCompleted = 0;
        this.cryptogramsPlayed = 0;
        this.totalGuesses = 0;
        this.correctGuesses = 0;
    }

    public Player(String name, double accuracy, int cryptogramsCompleted, int cryptogramsPlayed, int totalGuesses, int correctGuesses){
        this.userName = name;
        this.accuracy = accuracy;
        this.cryptogramsCompleted = cryptogramsCompleted;
        this.cryptogramsPlayed = cryptogramsPlayed;
        this.totalGuesses = totalGuesses;
        this.correctGuesses = correctGuesses;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public int getCryptogramsCompleted() {
        return cryptogramsCompleted;
    }

    public void addCryptogramsCompleted() {this.cryptogramsCompleted += 1;}

    public double getAccuracy() {
        try {
            this.accuracy = correctGuesses / totalGuesses;
        } catch (ArithmeticException ignored){}

        return accuracy;
    }

    public int getCryptogramsPlayed() {
        return cryptogramsPlayed;
    }

    public void addCryptogramsPlayed() {this.cryptogramsPlayed += 1;}

    public int getTotalGuesses() {
        return totalGuesses;
    }

    public void addTotalGuesses() {
        this.totalGuesses += 1;
    }

    public int getCorrectGuesses() {
        return correctGuesses;
    }
    public void addCorrectGuesses() {
        this.correctGuesses += 1;
    }


    public void saveDetails() throws FileNotFoundException {
        try {
            File file;
            if (userName.equals("player")) {
                file = new File("player.user_file");
            } else {
                file = new File(userName + ".user_file");
            }

            FileWriter writer = new FileWriter(file);

            writer.write(getAccuracy() + "\n");
            writer.write(getCryptogramsCompleted() + "\n");
            writer.write(getCryptogramsPlayed() + "\n");
            writer.write(getTotalGuesses() + "\n");
            writer.write(getCorrectGuesses() + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }

    }

    public Player loadPlayer(String userName){
        try {
            double accuracy = 0;
            int cryptogramsComplete = 0;
            int cryptogramsPlayed = 0;
            int totalGuess= 0;
            int correctGuess = 0;
            Player player = null;
            File file = new File(userName.toLowerCase().replace(' ', '_') + ".user_file");
            Scanner fileInput = new Scanner(file);

                accuracy = fileInput.nextDouble();
                cryptogramsComplete = fileInput.nextInt();
                cryptogramsPlayed = fileInput.nextInt();
                totalGuess = fileInput.nextInt();
                correctGuess = fileInput.nextInt();

                fileInput.close();
            player = new Player(userName,accuracy,cryptogramsComplete,cryptogramsPlayed, totalGuess, correctGuess);
            return player;
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
        return null;
    }
}
