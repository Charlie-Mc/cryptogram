public class Player {
    String userName;
    int userScore;
    int correctGuesses;
    int gamesPlayed;
    public Player() {
        userScore = 0;
        correctGuesses = 0;
        gamesPlayed = 0;
    }
    public Player(String name) {
        userName = name;
        userScore = 0;
        correctGuesses = 0;
        gamesPlayed = 0;
    }

    // ADDERS
    public void addUserScore() {
        userScore += 1;
    }

    public void addGamesPlayed() {
        gamesPlayed += 1;
    }

    public void addCorrectGuesses(int c) {
        correctGuesses += c;
    }

    // GETTERS
    public Integer getCorrectGuesses() {
        return correctGuesses;
    }
    public Integer getUserScore() {
        return userScore;
    }
    public Integer getGamesPlayed() {
        return gamesPlayed;
    }
}
