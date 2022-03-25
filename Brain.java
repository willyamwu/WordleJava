import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Brain {

    // Color Constants
    final String YELLOW_COLOR = "\u001B[33m";
    final String GREEN_COLOR = "\u001B[32m";
    final String RED_COLOR = "\u001B[31m";
    final String RESET = "\u001B[0m";

    Scanner sn = new Scanner(System.in);
    Keyboard keyboard = new Keyboard();
    Words Word = new Words();

    public Brain(){
    }

    public void play() {
        ArrayList<String> guesses = new ArrayList<String>();
        String randomWord = Word.chooseWord().toUpperCase();
        keyboard.reset();
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
            // To restart
            else if (input.equals("r")) {
                System.out.println("Restarting....");
                play();
            }
            else if (isValid(input)) {
                guesses.add(input); 
                draw(guesses, randomWord);

                if (guesses.get(attempts).toUpperCase().equals(randomWord)){
                    isGo = false;
                    System.out.println("Congrats you got it right in " + attempts + " tries!");
                    break;
                }
                else if (attempts == 5) {
                    isGo = false;
                    System.out.print("You ran out of tries." +  "The word was " + randomWord + "\n");
                    break;
                }
                attempts++;
            } else {
                System.out.println("Not in the dictionary.");
            }
        }
        sn.close();
    }

    public static String process(Scanner sn) {
        String s1 = sn.nextLine();
        s1 = s1.trim().toLowerCase();
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
                String characterUpper = guesses.get(l).substring(j, j+1).toUpperCase();
                String characterLower = guesses.get(l).substring(j, j+1).toLowerCase();
                int place = braces(randomWord, characterUpper, j);
                switch(place){
                    case 0:
                        keyboard.alphabetAndKey.replace(characterLower, 0);
                        System.out.print("[" + characterUpper + "] ");
                        break;
                    case 1:
                        keyboard.alphabetAndKey.replace(characterLower, 1);
                        System.out.print("[" + YELLOW_COLOR + characterUpper + RESET + "] ");
                        break;
                    case 2:
                        keyboard.alphabetAndKey.replace(characterLower, 2);
                        System.out.print("[" + GREEN_COLOR + characterUpper + RESET + "] ");
                        break;
                    
                }
                count++;
            }
            System.out.print("\n");
        }

        // For displaying 5x6 grid.
        for (int i = guesses.size(); i<6; i++){
            System.out.println("[x] [x] [x] [x] [x]");
        }

        drawAlphabet();
    }

    public void drawAlphabet(){
        System.out.println("\nKeyboard");
        for (int i = 0; i < 26; i++){
            switch(i){
                case 10:
                     System.out.print("");
                case 19:
                    System.out.print("\n");
            }
            switch(keyboard.alphabetAndKey.get(keyboard.alphabet[i].toLowerCase())){
                case 0:
                    System.out.print("[" + RED_COLOR + keyboard.alphabet[i] + RESET + "] ");
                    break;
                case 1:
                    System.out.print("[" + YELLOW_COLOR + keyboard.alphabet[i] + RESET + "] ");
                    break;
                case 2:
                    System.out.print("[" + GREEN_COLOR + keyboard.alphabet[i] + RESET + "] ");
                    break;
                case 3:
                    System.out.print("[" + keyboard.alphabet[i] + "] ");
                    break;
            }
            
        }
        System.out.print("\n");
    }

    public static int braces(String randomWord, String character, int index){
        ArrayList<String> spliced = splice(randomWord);
        if (character.equals(spliced.get(index))){
            return 2;
        }
        for (int i = 0; i < 5; i++) {
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


}
