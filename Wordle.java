import java.util.Scanner;

import java.util.ArrayList; // Create an ArrayList object

import java.util.ArrayList; // import the ArrayList class

public class Wordle {

    public static void main(String[] args) {
        instructions();
        Words Word = new Words();
        String choosenOne = Word.chooseWord().toUpperCase();
        // System.out.println(choosenOne);
        Scanner sn = new Scanner(System.in);
        boolean con = true;
        int count = 0;
        ArrayList<String> guesses = new ArrayList<String>();

        while (con) {
            System.out.println("Enter a word:");
            String input = process(sn);

            if (input.equals("q")) {
                con = false;
                continue;
            }

            if (test(input) == true) {
                guesses.add(input); 
                draw(guesses, choosenOne);

                if (count == 5) {
                    con = false;
                    System.out.print("You ran out of tries." +  "The word was " + choosenOne + "\n");
                    break;
                }
                if (guesses.get(count).toUpperCase().equals(choosenOne)){
                    con = false;
                    System.out.println("Congrats you got it right!");
                }

                count++;
            } else {
                System.out.println("That was wrong:");
            }

        }

    }

    public static String process(Scanner sn) {
        String s1 = sn.nextLine();
        s1 = s1.trim();
        s1 = s1.toLowerCase();
        return s1;
    }

    public static boolean test(String input) {
        if (input.length() != 5) {
            System.out.println("The word was not 5 letters!");
            return false;
        }
        Words Word = new Words();
        return Word.isWord(input);
    }

    public static void draw(ArrayList<String> guesses, String choosenOne){
        boolean isTrue = true;
        int count = 0;
        for (int l = 0; l < guesses.size(); l++) {
            for (int j = 0; j < 5; j++){
                String character = guesses.get(l).substring(j, j+1).toUpperCase();
                int place = braces(choosenOne, character, j);
                switch(place){
                    case 0:
                        System.out.print("[" + character + "] ");
                        break;
                    case 1:
                        System.out.print("{" + character + "} ");
                        break;
                    case 2:
                        System.out.print("(" + character + ") ");
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

    public static int braces(String choosenOne, String character, int index){
        ArrayList<String> spliced = splice(choosenOne);
        for (int i = 0; i < 5; i++) {
            if (character.equals(spliced.get(i)) && index == i){
                return 1;
            }
            if (character.equals(spliced.get(i))){
                return 2;
            }
        }
        return 0;
    }

    public static ArrayList<String> splice(String choosenOne) {
        ArrayList<String> spliced = new ArrayList<String>();
        for(int i = 0; i < 5; i++){
            spliced.add(choosenOne.substring(i, i+1));
        }
        return spliced;
    }

    public static void instructions(){
        System.out.println("Welcome to Wordle:");
        System.out.println("Guess the five letter word.");
        System.out.println("[A] means that the letter is not in the word.");
        System.out.println("(A) means that the letter is in the word but not in the right spot.");
        System.out.println("{A} means that the letter is in the right spot in the word.");
        System.out.println("Enter in \"q\" to quit.");
    }
}