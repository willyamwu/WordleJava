import javax.swing.*;

public class Frame extends JFrame{

    Frame(){
        this.setSize(420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("something.png");
        this.setIconImage(image.getImage());
    }
    
}
