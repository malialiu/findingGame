import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class game {
    public static void main(String[] args) {
        findingGame(newFrame(), newPanel(), newCorrect());
    }

    static JFrame newFrame(){
        JFrame frame = new JFrame("Find Differences");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        return frame;
    }

    static JPanel newPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10,10,0,0));
        return panel;
    }

    static JFrame newCorrect(){
        JFrame correct = new JFrame("Result");
        correct.setLayout(new FlowLayout(FlowLayout.CENTER));
        correct.setSize(300,300);
        correct.add(new JLabel("Good job! Please try a new one."));
        correct.setVisible(false);
        return correct;
    }

    static void findingGame(JFrame frame, JPanel panel, JFrame correct){
        JFrame wrong = new JFrame("Result");
        wrong.setLayout(new FlowLayout(FlowLayout.CENTER));
        wrong.setSize(300,300);
        wrong.add(new JLabel("Sorry, please try again"));
        wrong.setVisible(false);
        
        correct.setVisible(false);

        long key = Math.round(Math.random()*100);
        while (key > 100 || key < 1){
            key = Math.round(Math.random()*100);
        }
        for (long i = 1; i < 100; i++){
            JButton button = new JButton("D");
            button.setBackground(Color.WHITE);
            panel.add(button);
            button.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    wrong.setVisible(true);
                }
            });
                if(i == key){
                    JButton answer = new JButton("C");
                    answer.setBackground(Color.WHITE);
                    panel.add(answer);
                    answer.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            wrong.dispose();
                            frame.dispose();
                            correct.setVisible(true);
                            findingGame(newFrame(), newPanel(), correct);
                        }
                    });
                }
        }
        frame.add(panel);
        frame.setVisible(true);
    }

}

