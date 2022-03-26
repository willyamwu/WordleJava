import java.util.*;

public class Keyboard {
    Hashtable<String, Integer> alphabetAndKey = new Hashtable<String,Integer>();
    String[] alphabet = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
    "A", "S", "D", "F", "G", "H", "J", "K", "L",
    "Z", "X", "C", "V", "B", "N", "M"};

    public Keyboard() {
        reset();
    }

    public void reset() {
        alphabetAndKey.put("a", 3);
        alphabetAndKey.put("b", 3);
        alphabetAndKey.put("c", 3);
        alphabetAndKey.put("d", 3);
        alphabetAndKey.put("e", 3);
        alphabetAndKey.put("f", 3);
        alphabetAndKey.put("g", 3);
        alphabetAndKey.put("h", 3);
        alphabetAndKey.put("i", 3);
        alphabetAndKey.put("j", 3);
        alphabetAndKey.put("k", 3);
        alphabetAndKey.put("l", 3);
        alphabetAndKey.put("m", 3);
        alphabetAndKey.put("n", 3);
        alphabetAndKey.put("o", 3);
        alphabetAndKey.put("p", 3);
        alphabetAndKey.put("q", 3);
        alphabetAndKey.put("r", 3);
        alphabetAndKey.put("s", 3);
        alphabetAndKey.put("t", 3);
        alphabetAndKey.put("u", 3);
        alphabetAndKey.put("v", 3);
        alphabetAndKey.put("w", 3);
        alphabetAndKey.put("x", 3);
        alphabetAndKey.put("y", 3);
        alphabetAndKey.put("z", 3);
    }
    
}
