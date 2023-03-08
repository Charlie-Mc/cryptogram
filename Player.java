public class Player {
    String userName;
    Double accuracy;
    int totalGuesses;

    int correctGuesses;
    int cryptogramsPlayed;
    int cryptogramsCompleted;

    public Player() {
        this.totalGuesses = 0;
        this.accuracy = 0.00;
        this.cryptogramsCompleted = 0;
        this.totalGuesses = 0;
        this.correctGuesses = 0;
    }
    public Player(String name) {
        this.userName = name;
        this.totalGuesses = 0;
        this.accuracy = 0.00;
        this.cryptogramsCompleted = 0;
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

    public void addCryptogramsCompleted() {
        cryptogramsCompleted += 1;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public int getCryptogramsPlayed() {
        return cryptogramsPlayed;
    }

    public void addCryptogramsPlayed() {cryptogramsPlayed += 1;}

    public int getTotalGuesses() {
        return totalGuesses;
    }

    public void addTotalGuesses() {
        totalGuesses += 1;
    }

    public int getCorrectGuesses() {
        return correctGuesses;
    }
    public void addCorrectGuesses() {
        correctGuesses += 1;
    }
}
