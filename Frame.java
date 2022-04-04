import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener{

    JButton button;

    Frame(){

        JButton button = new JButton();
        button.setBounds(200, 100, 100, 50);
        button.addActionListener(e -> System.out.println("hi"));

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.gray);
        redPanel.setBounds(10, 10, 72, 72);
        // redPanel.setLayout(new BorderLayout());

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.gray);
        bluePanel.setBounds(92, 10, 72, 72);


        JLabel label = new JLabel();
        label.setText("Wordle");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        loadRowsAndColumns(this);

        this.setBackground(Color.green);
        this.setSize(420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        // redPanel.add(label);
        this.add(redPanel);
        this.add(bluePanel);
        this.add(button);
    }

    public void loadRowsAndColumns(JFrame frame){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("hi");
        }
        // TODO Auto-generated method stub
        
    }

    
}
