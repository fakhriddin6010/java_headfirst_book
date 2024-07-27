import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mygame implements ActionListener {

    JFrame frame;
    JPanel panel;
    JButton button;
    JLabel[] labels;
    int[] randomNumbers;

    public static void main(String[] args) {
        mygame game = new mygame();
        game.go();
    }

    public void go() {
        frame = new JFrame("Slot Machine");
        panel = new JPanel();
        button = new JButton("Spin");
        labels = new JLabel[3];
        randomNumbers = new int[3];

        // UI 디자인
        panel.setLayout(new GridLayout(1, 3));
        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel();
            labels[i].setFont(new Font("Arial", Font.PLAIN, 48));
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            panel.add(labels[i]);
        }

        button.addActionListener(this);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(button, BorderLayout.SOUTH);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ev) {
        // 난수 생성
        for (int i = 0; i < 3; i++) {
            randomNumbers[i] = (int) (Math.random() * 10); // 0부터 9까지의 난수 생성
            labels[i].setText(Integer.toString(randomNumbers[i])); // 난수를 UI에 표시
        }

        // 득점 계산
        if (randomNumbers[0] == randomNumbers[1] && randomNumbers[1] == randomNumbers[2]) {
            JOptionPane.showMessageDialog(frame, "Congratulations! You won!", "Winner",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Better luck next time!", "No match", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}