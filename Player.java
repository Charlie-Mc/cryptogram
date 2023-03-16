public class Player {
    String userName;
    Double accuracy;
    int totalGuesses;

    int correctGuesses;
    int cryptogramsPlayed;
    int cryptogramsCompleted;

    /* Empty Constructor Method */
    public Player() {
        this.totalGuesses = 0;
        this.accuracy = 0.00;
        this.cryptogramsCompleted = 0;
        this.totalGuesses = 0;
        this.correctGuesses = 0;
    }

    /* Constructor Method with name input*/
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
