import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

            writer.write("accuracy = " + getAccuracy() + "\n");
            writer.write("games completed = " + getCryptogramsCompleted() + "\n");
            writer.write("games played = " + getCryptogramsPlayed() + "\n");
            writer.write("total guesses = " + getTotalGuesses() + "\n");
            writer.write("correct guesses = " + getCorrectGuesses() + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }

    }
}
