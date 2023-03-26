import java.io.*;
import java.util.*;


public class Cryptogram implements Serializable {
    static public ArrayList<Integer> completeEncryption = new ArrayList<>();
    public HashMap<Integer, Character> encryptionMap = new HashMap<>();
    private ArrayList<String> phrases = new ArrayList<>();
    private List<Integer> numLetters = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25));

    private String phrase;
    private String BlankPhrase= " ";

    public Cryptogram() throws IOException {
    }

    public HashMap<Integer, Character> getEncryptionMap() {
        return encryptionMap;
    }
    public HashMap<Character, Character> getLetterEncryptionMap() {
        return null;
    }

    public HashMap<Character, Character> getLetterUserMap() {
        return null;
    }
    public HashMap<Integer, Character> getUserMap() {
        return null;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getBlankPhrase(){
        return BlankPhrase;
    }

    public ArrayList<Integer> getCompleteEncryption() {
        return completeEncryption;
    }

    public char getalphabet(int num) {
        return ' ';
    }

    public int getChatAt(char letter) {
        return 0;
    }


    public void encryptPhrase(String phrase) {

        // loop through the phrase
        for (int i = 0; i < phrase.length(); i++) {
            // get the current letter
            char letter = phrase.charAt(i);

            // check if the letter is a space
            if (letter == ' ') {
                continue;
            }
            // check if the letter is already in the encryption
            if (encryptionMap != null) {
                if (encryptionMap.containsValue(letter)) {
                    for (int key : encryptionMap.keySet()) {
                        if (encryptionMap.get(key) == letter) {
                            encryptionMap.put(key, letter);
                            completeEncryption.add(key);
                        }
                    }

                    continue;
                }
            }


            // checks if all numbers have been used
            if (numLetters.size() == 0) {
                break;
            }
            // generate a random number

            Random rand = new Random();
            int random_int = rand.nextInt(numLetters.size());


            encryptionMap.put(numLetters.get(random_int), letter);
            completeEncryption.add(numLetters.get(random_int));
            numLetters.remove(random_int);
        }
    }

    protected void FileReader(String fileName)
            throws IOException
    {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        //checks if the file is empty
        if (br.readLine() == null) {
            System.out.println("File is empty");
            return;
        }
        String line;
        System.out.println(
                "Reading text file");
        while ((line = br.readLine()) != null) {
            // process the line
            phrases.add(line);
            //System.out.println(line);
        }
        br.close();
        fr.close();
    }

    protected String choosePhrase() {
        String phrase;
        Random rand = new Random();
        int random_int = rand.nextInt(phrases.size());
        return phrase = phrases.get(random_int);
    }

    protected String generateBlankPhrase(String phrase) {
        BlankPhrase = "_";
        for (int i = 1; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ' ') {
                BlankPhrase = BlankPhrase + " ";
            } else {
                BlankPhrase = BlankPhrase + "_";
            }
        }

        return BlankPhrase;
    }

    public ArrayList<Integer> getFrequency(){
        ArrayList<Integer> frequency = new ArrayList<>();

        for(int key : encryptionMap.keySet()) {
            int count = 0;
            for (int i = 0; i < completeEncryption.size(); i++) {
                if (completeEncryption.get(i) == key) {
                    count++;

                }
            }
            frequency.add(count);
        }

        return frequency;
    }


    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}

