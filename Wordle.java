import javax.swing.JFrame;

public class Wordle {
    public static void main(String[] args) {
        // Frame frame = new Frame();


        Brain Brain = new Brain();
        Brain.instructions();
        Brain.play();

    }
}