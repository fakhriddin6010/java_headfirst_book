import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class innerButton {
    JFrame frame;
    JButton b;

    public static void main(String[] args){
        innerButton gui = new innerButton();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b = new JButton("A");
        b.addActionListener(new BListener()); // Register BListener as the ActionListener

        frame.getContentPane().add(BorderLayout.SOUTH, b);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    class BListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (b.getText().equals("A")) {
                b.setText("B");
            } else {
                b.setText("A");
            }
        }
    }
}
