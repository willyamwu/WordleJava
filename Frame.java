import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;

public class Frame extends JFrame{

    Frame(){
        this.setSize(420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        

        ImageIcon image = new ImageIcon("something.png");
        this.setIconImage(image.getImage());

        this.setLayout(new GridLayout(6,5, 5, 5));
        this.add(new JButton());

        this.setBackground(Color.green);

        this.setVisible(true);
    }
    
}
