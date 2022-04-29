import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Brain {

    // Color Constants
    private static final String YELLOW_COLOR = "\u001B[33m";
    private static final String GREEN_COLOR = "\u001B[32m";
    private static final String RED_COLOR = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    // Global Variables
    private static Scanner sn = new Scanner(System.in);
    private static Keyboard keyboard = new Keyboard();
    private static Words Word = new Words();

    public static void play() {
        ArrayList<String> guesses = new ArrayList<String>();
        String randomWord = Word.chooseWord().toUpperCase();
        keyboard.reset();
        boolean isGo = true;
        int attempts = 0;

        while (isGo) {
            System.out.println("Enter a five-letter word:");
            String input = process(sn);

            // To exit
            if (input.toLowerCase().equals("e") || input.toLowerCase().equals("exit")) {
                isGo = false;
                restart(sn);
                break;
            }
            else if (isValid(input)) {
                guesses.add(input); 
                draw(guesses, randomWord);

                if (guesses.get(attempts).toUpperCase().equals(randomWord)){
                    isGo = false;
                    switch(attempts){
                        case(0):
                            System.out.println("You got it in " + (attempts + 1) + " attempt!");
                            break;
                        default:
                            System.out.println("You got it in " + (attempts + 1) + " attempts!");
                            break;
                    }
                    restart(sn);
                }
                else if (attempts == 5) {
                    isGo = false;
                    System.out.print("You ran out of tries." +  "The word was " + randomWord + "\n");
                    restart(sn);
                    break;
                }
                attempts++;
            } else {
                System.out.println("Not in the dictionary.");
            }
        }
        sn.close();
    }

    // Uses Scanner to get input from user and clean it.
    public static String process(Scanner sn) {
        String s1 = sn.nextLine();
        s1 = s1.trim().toLowerCase();
        return s1;
    }

    // Checks to see if the word is five letters and if it is a valid English word.
    public static boolean isValid(String input) {
        if (input.length() != 5) {
            System.out.println("The word was not 5 letters!");
            return false;
        }
        return Word.isWord(input);
    }

    // Draws the words and remaining attempts in the terminal using boxes.
    public static void draw(ArrayList<String> guesses, String randomWord){
        // Iterating through the guesses.
        for (int i = 0; i < guesses.size(); i++) {
            // Iterating through the word and finding the characters.
            for (int j = 0; j < 5; j++){
                String characterUpper = guesses.get(i).substring(j, j+1).toUpperCase();
                String characterLower = guesses.get(i).substring(j, j+1).toLowerCase();
                int colorKey = color(randomWord, characterUpper, j);
                switch(colorKey){
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
            }
            System.out.print("\n");
        }

        // Displays the 5x6 grid.
        for (int i = guesses.size(); i<6; i++){
            System.out.println("[x] [x] [x] [x] [x]");
        }

        drawKeyboard();
    }

    // Draws the keyboard in the terminal.
    public static void drawKeyboard(){
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

    // Decides which color to the character will be.
    public static int color(String randomWord, String character, int index){
        if (character.equals(randomWord.substring(index, index+1))){
            return 2;
        }
        else {
            for (int i = 0; i < 5; i++) {
                if (character.equals(randomWord.substring(i, i+1))){
                    return 1;
                }
            }
        }
        return 0;
    }

    // Restarts or quits the game.
    public static void restart(Scanner sn) {
        System.out.println("Do you want to restart? (Y/N)");
        String response = sn.nextLine().trim().toUpperCase();
        switch(response){
            case "Y":
                System.out.println("Restarting...");
                play();
                break;
            case "N":
                System.out.println("Quitting...");
                break;
            default:
                System.out.println("Invalid input.");
                restart(sn);
        }
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
