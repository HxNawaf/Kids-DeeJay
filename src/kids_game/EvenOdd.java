package kids_game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.sound.sampled.Clip;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EvenOdd extends JFrame implements ActionListener, MouseListener {
    JButton home = new JButton();
    JButton b1 = new JButton(new ImageIcon("PICTURES\\home\\OddButton.jpg"));
    JButton b2 = new JButton(new ImageIcon("PICTURES\\home\\EvenButton.jpg"));
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel("SCORE: ");
    JLabel lhome = new JLabel(new ImageIcon("PICTURES\\home\\HomeButton.png"));
    static int score = 0;
    Random r = new Random();
    int randomNum;
    Clip clip;
    JLabel k1 = new JLabel(new ImageIcon("PICTURES\\home\\EvenOddGameBackground.png"));
    static int count = 0;
    public EvenOdd() {
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        k1.setBounds(0, 0, 600, 500);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(l1);
        add(l2); 

        l2.setFont(new java.awt.Font("Tahoma", 1, 24));
        l2.setForeground(new java.awt.Color(0, 41, 152));
        l1.setFont(new java.awt.Font("Tahoma", 3, 68));
        l1.setForeground(new java.awt.Color(0, 41, 152));
        l3.setFont(new java.awt.Font("Tahoma", 1, 24));
        l3.setForeground(new java.awt.Color(0, 41, 152));
        randomNum = r.nextInt(100);

        b1.setBounds(100, 260, 150, 70);
        b1.setBackground(Color.BLACK);
        b2.setBounds(350, 260, 150, 70);
        l1.setBounds(250, 100, 200, 70);
        l2.setBounds(300, 370, 200, 50);
        l3.setBounds(200, 370, 200, 50);
        lhome.setBounds(5, 5, 70, 70);
        lhome.addMouseListener(this);
        add(lhome);
        add(l3);
        l1.setText(String.valueOf(randomNum));


        add(k1);
        b1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                count = count + 1;
                int num = Integer.parseInt(l1.getText());
                if (count == 10) {
                    if (num % 2 != 0) {
                        score = score + 1;
                        l2.setText(String.valueOf(score));
                        randomNum = r.nextInt(100);
                    } else {

                        randomNum = r.nextInt(100);
                        l1.setText(String.valueOf(randomNum));
                    }
                    JOptionPane.showMessageDialog(null, "Your score is: " + score + "/10");

                    count = 0;
                    score = 0;
                    l2.setText("");
                    randomNum = r.nextInt(100);
                    l1.setText(String.valueOf(randomNum));

                } else {

                    if (num % 2 != 0) {
                        score = score + 1;
                        l2.setText(String.valueOf(score));

                        randomNum = r.nextInt(100);
                        l1.setText(String.valueOf(randomNum));
                    } else {

                        randomNum = r.nextInt(100);
                        l1.setText(String.valueOf(randomNum));

                    }
                }

            }
        });

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Kids_game c = new Kids_game();
                setVisible(false);
                clip.stop();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                count = count + 1;
                int num = Integer.parseInt(l1.getText());
                if (count == 10) {
                    if (num % 2 == 0) {
                        score = score + 1;
                        l2.setText(String.valueOf(score));
                        randomNum = r.nextInt(100);
                    } else {

                        randomNum = r.nextInt(100);
                        l1.setText(String.valueOf(randomNum));
                    }
                    JOptionPane.showMessageDialog(null, "Your score is: " + score + "/10");
                    count = 0;
                    score = 0;
                    l2.setText("");
                    randomNum = r.nextInt(100);
                    l1.setText(String.valueOf(randomNum));

                } else {

                    if (num % 2 == 0) {
                        score = score + 1;
                        l2.setText(String.valueOf(score));

                        randomNum = r.nextInt(100);
                        l1.setText(String.valueOf(randomNum));
                    } else {

                        randomNum = r.nextInt(100);
                        l1.setText(String.valueOf(randomNum));

                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        new EvenOdd();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (lhome == me.getSource()) {
            Kids_game c = new Kids_game();
            setVisible(false);
            try {
                clip.stop();
            } catch (Exception e) {}
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}