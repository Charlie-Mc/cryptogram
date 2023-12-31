import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {
    String userName = "player";
    double accuracy;
    int totalGuesses;

    int correctGuesses;
    int cryptogramsPlayed;
    int cryptogramsCompleted;

    /* Empty Constructor Method */
    public Player() {
        this.accuracy = 0.00;
        this.cryptogramsCompleted = 0;
        this.cryptogramsPlayed = 0;
        this.totalGuesses = 0;
        this.correctGuesses = 0;
    }

    /* Constructor Method with name input*/
    public Player(String name) {
        this.userName = name.toLowerCase().replace(' ', '_');
        this.accuracy = 0.00;
        this.cryptogramsCompleted = 0;
        this.cryptogramsPlayed = 0;
        this.totalGuesses = 0;
        this.correctGuesses = 0;
    }

    public Player(String name, double accuracy, int cryptogramsCompleted, int cryptogramsPlayed, int totalGuesses, int correctGuesses){
        this.userName = name.toLowerCase().replace(' ', '_');
        this.accuracy = accuracy;
        this.cryptogramsCompleted = cryptogramsCompleted;
        this.cryptogramsPlayed = cryptogramsPlayed;
        this.totalGuesses = totalGuesses;
        this.correctGuesses = correctGuesses;
    }

    public void setUserName(String userName) {
        this.userName = userName.toLowerCase().replace(' ', '_');
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

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
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

    public void setCorrectGuesses(int correctGuesses) {
        this.correctGuesses = correctGuesses;
    }

    public void setCryptogramsCompleted(int cryptogramsCompleted) {
        this.cryptogramsCompleted = cryptogramsCompleted;
    }

    public void setCryptogramsPlayed(int cryptogramsPlayed) {
        this.cryptogramsPlayed = cryptogramsPlayed;
    }

    public void setTotalGuesses(int totalGuesses) {
        this.totalGuesses = totalGuesses;
    }




    public void saveDetails(int userInput) throws FileNotFoundException {
        try {
            File file;
            File input;
            if (userName.equals("player")) {
                file = new File("user_files/player.user_file");
                input = new File("user_files/player.input");
            } else {
                file = new File("user_files/" + userName + ".user_file");
                input = new File("user_files/" + userName + ".input");
            }

            FileWriter writer = new FileWriter(file);

            writer.write(getAccuracy() + "\n");
            writer.write(getCryptogramsCompleted() + "\n");
            writer.write(getCryptogramsPlayed() + "\n");
            writer.write(getTotalGuesses() + "\n");
            writer.write(getCorrectGuesses() + "\n");
            writer.close();

            FileWriter inWriter = new FileWriter(input);
            inWriter.write(userInput);

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
            File file = new File("user_files/" + userName.toLowerCase().replace(' ', '_') + ".user_file");
            Scanner fileInput = new Scanner(file);

                accuracy = fileInput.nextDouble();
                cryptogramsComplete = fileInput.nextInt();
                cryptogramsPlayed = fileInput.nextInt();
                totalGuess = fileInput.nextInt();
                correctGuess = fileInput.nextInt();

                fileInput.close();
            player = new Player(userName,accuracy,cryptogramsComplete,cryptogramsPlayed, totalGuess, correctGuess);
            return player;
        } catch (FileNotFoundException e) {
            System.out.println("Player <" + userName + "> does not exist...");
        }
        return null;
    }

    public String toString() {
        if (userName == null) {
            return "Player is missing a username";
        }
        return "Player{" +
                "userName= '" + getUserName() + '\'' +
                ", cryptogramsCompleted= " + getCryptogramsCompleted() +
                ", Accuracy= " + getAccuracy() +
                ", cryptogramsPlayed= " + getCryptogramsPlayed() +
                ", totalGuesses= " + getTotalGuesses() +
                ", correctGuesses= " + getCorrectGuesses() +
                '}';
    }
}
