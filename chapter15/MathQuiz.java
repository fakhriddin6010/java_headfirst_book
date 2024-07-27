import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MathQuiz extends JFrame implements ActionListener {
    private int num1, num2, answer;
    private JLabel questionLabel, resultLabel;
    private JTextField answerField;
    private JButton newProblemButton;

    public MathQuiz() {
        setTitle("Math Quiz");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // 문제 표시 라벨 생성
        questionLabel = new JLabel();
        add(questionLabel);

        // 답변 입력 필드 생성
        answerField = new JTextField();
        answerField.addActionListener(this);
        add(answerField);

        // 새 문제 생성 버튼 생성
        newProblemButton = new JButton("New Problem");
        newProblemButton.addActionListener(this);
        add(newProblemButton);

        // 결과 표시 라벨 생성
        resultLabel = new JLabel();
        add(resultLabel);

        // 문제 생성 및 초기화
        generateProblem();

        // 화면 출력
        setVisible(true);
    }

    // 수학 문제 생성
    public void generateProblem() {
        num1 = (int) (Math.random() * 9) + 1;
        num2 = (int) (Math.random() * 9) + 1;

        int operator = (int) (Math.random() * 3) + 1;

        switch (operator) {
            case 1:
                questionLabel.setText("What is " + num1 + " + " + num2 + "?");
                answer = num1 + num2;
                break;
            case 2:
                questionLabel.setText("What is " + num1 + " - " + num2 + "?");
                answer = num1 - num2;
                break;
            case 3:
                questionLabel.setText("What is " + num1 + " * " + num2 + "?");
                answer = num1 * num2;
                break;
        }

        answerField.setText("");
        resultLabel.setText("Please enter your answer.");
    }

    // 답변 확인
    public void checkAnswer(int userAnswer) {
        if (userAnswer == answer) {
            resultLabel.setText("Very good!");
        } else {
            resultLabel.setText("Sorry, but no. Try again.");
        }

        answerField.setText("");
    }

    // 버튼 클릭 또는 답변 입력시 발생하는 이벤트 처리
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newProblemButton) {
            generateProblem();
        } else {
            String answerText = answerField.getText();
            if (!answerText.equals("")) {
                int userAnswer = Integer.parseInt(answerText);
                checkAnswer(userAnswer);
            }
        }
    }

    public static void main(String[] args) {
        MathQuiz quiz = new MathQuiz();
    }
}
