import java.util.Random;
import java.io.*;

public class Words {
    File answerWords = new File("Answer.txt");
    File guessWords = new File("5LetterWords.txt");

    public boolean isWord (String input){
        try (BufferedReader br = new BufferedReader(new FileReader(guessWords))) {
            String line;
            while ((line = br.readLine()) != null) {
               if(input.equals(line)){
                    return true;
               }            
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public String chooseWord(){
        Random rand = new Random();
        int num = rand.nextInt(5757);
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(answerWords))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(i == num){
                     return line;
                }            
                i++;
             }
        } catch (Exception e) {
            return "false";
        }
        return "false";
    }



}