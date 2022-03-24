import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.*;
import java.io.*;
import javax.xml.transform.Templates;

public class Brain {

    final String YELLOW_COLOR = "\u001B[33m";
    final String GREEN_COLOR = "\u001B[32m";
    final String BLACK_COLOR = "\u001B[0m";
    final String RESET = "\u001B[0m";

    ArrayList<String> guesses = new ArrayList<String>();
    Dictionary<String, Integer> alphabet = new Hashtable<String,Integer>();
    Words Word = new Words();
    Scanner sn = new Scanner(System.in);

    public Brain(){
        play();
    }

    public void play() {
        populateDictionary();
        String randomWord = Word.chooseWord().toUpperCase();
        boolean isGo = true;
        int attempts = 0;

        while (isGo) {
            System.out.println("Enter a five-letter word:");
            String input = process(sn);

            // To quit
            if (input.equals("q")) {
                System.out.println("You quit :(");
                isGo = false;
                break;
            }
            else if (isValid(input)) {
                guesses.add(input); 
                draw(guesses, randomWord);

                if (attempts == 5) {
                    isGo = false;
                    System.out.print("You ran out of tries." +  "The word was " + randomWord + "\n");
                    break;
                }
                else if (guesses.get(attempts).toUpperCase().equals(randomWord)){
                    isGo = false;
                    System.out.println("Congrats you got it right!");
                }

                attempts++;
            } else {
                System.out.println("That was wrong:");
            }
        }
        sn.close();
    }

    public static String process(Scanner sn) {
        String s1 = sn.nextLine();
        s1 = s1.trim();
        s1 = s1.toLowerCase();
        return s1;
    }


    public boolean isValid(String input) {
        if (input.length() != 5) {
            System.out.println("The word was not 5 letters!");
            return false;
        }
        return Word.isWord(input);
    }

    public void draw(ArrayList<String> guesses, String randomWord){
        boolean isTrue = true;
        int count = 0;
        for (int l = 0; l < guesses.size(); l++) {
            for (int j = 0; j < 5; j++){
                String character = guesses.get(l).substring(j, j+1).toUpperCase();
                int place = braces(randomWord, character, j);
                switch(place){
                    case 0:
                        System.out.print("[" + BLACK_COLOR + character + RESET + "] ");
                        break;
                    case 1:
                        System.out.print("[" + YELLOW_COLOR + character + RESET + "] ");
                        break;
                    case 2:
                        System.out.print("[" + GREEN_COLOR + character + RESET + "] ");
                        break;
                    
                }
                count++;

            }
            System.out.print("\n");
        }

        for (int i = guesses.size(); i<6; i++){
            System.out.println("[x] [x] [x] [x] [x]");
        }
    }

    public static void drawAlphabet(ArrayList<String> guesses){

    }

    public static int braces(String randomWord, String character, int index){
        ArrayList<String> spliced = splice(randomWord);
        for (int i = 0; i < 5; i++) {
            if (character.equals(spliced.get(i)) && index == i){
                return 2;
            }
            if (character.equals(spliced.get(i))){
                return 1;
            }
        }
        return 0;
    }

    public static ArrayList<String> splice(String randomWord) {
        ArrayList<String> spliced = new ArrayList<String>();
        for(int i = 0; i < 5; i++){
            spliced.add(randomWord.substring(i, i+1));
        }
        return spliced;
    }

    // Displays the instructions to play the game.
    public static void instructions(){
        File file = new File("Instructions.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
               System.out.println(line);           
            }
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    public void populateDictionary(){
        alphabet.put("a", 0);
        alphabet.put("b", 0);
        alphabet.put("c", 0);
        alphabet.put("d", 0);
        alphabet.put("e", 0);
        alphabet.put("f", 0);
        alphabet.put("g", 0);
        alphabet.put("h", 0);
        alphabet.put("i", 0);
        alphabet.put("j", 0);
        alphabet.put("k", 0);
        alphabet.put("l", 0);
        alphabet.put("m", 0);
        alphabet.put("n", 0);
        alphabet.put("o", 0);
        alphabet.put("p", 0);
        alphabet.put("q", 0);
        alphabet.put("r", 0);
        alphabet.put("s", 0);
        alphabet.put("t", 0);
        alphabet.put("u", 0);
        alphabet.put("v", 0);
        alphabet.put("w", 0);
        alphabet.put("x", 0);
        alphabet.put("y", 0);
        alphabet.put("z", 0);
        alphabet.put("a", 0);
    }
}
