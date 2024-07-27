import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtons {

    JFrame frame;
    JLabel label;
    MyDrawPanel drawPanel;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new BorderLayout()); // Set layout manager

        JButton labelButton = new JButton("Change Label.");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle.");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a label.");
        drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("Ouch!");
        }
    }

    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Update the color of the draw panel
            drawPanel.changeColor();
        }
    }

    class MyDrawPanel extends JPanel {
        private Color color = Color.RED;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillOval(70, 70, 100, 100);
        }

        public void changeColor() {
            color = (color == Color.RED) ? Color.BLUE : Color.RED;
            repaint(); // Repaint the panel to reflect the color change
        }
    }
}