package src;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.*;

public class unscramble {
    static ArrayList<String> allWords = new ArrayList<String>();
    public static void main(String[] args) {
        setUpWords();
        Scanner scan = new Scanner(System.in);
        String base = "a"; 
        while (!base.equals("")) {
            System.out.println("Please provide letters (all joint together as a \"word\")");
            base = scan.nextLine().toLowerCase();
            System.out.println("\nHere are your possible answers:");
            for (int i = 0; i < allWords.size(); i++) {
                if (checkWord(allWords.get(i), base)) {
                    System.out.println(allWords.get(i));
                }
            }
            System.out.println();
        }
        scan.close();
    }

    public static boolean checkWord(String str, String givenLetters) {
        int temp = 0;
        if (str.length() != givenLetters.length()) return false; 
        for (int i = 0; i < givenLetters.length(); i++) {
            temp = str.indexOf(givenLetters.charAt(i));
            if (temp == -1) return false;
            else str = str.substring(0, temp) + str.substring(temp+1, str.length());
        }
        return true; 
    }
    public static void setUpWords() {
        File wordBank = new File("./WORDS.txt");; 
        try {
            Scanner wordScan = new Scanner(wordBank);
            while (wordScan.hasNextLine()) {
                allWords.add(wordScan.nextLine().toLowerCase());
            } 
            wordScan.close();
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
    }
}
