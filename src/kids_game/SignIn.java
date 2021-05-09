
package kids_game;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class SignIn extends JFrame implements ActionListener, MouseListener {

    JTextField t1 = new JTextField();

    JPasswordField t2 = new JPasswordField(20);
    JLabel l1 = new JLabel("Email");
    JLabel l2 = new JLabel("Password");
    JLabel l3 = new JLabel("Create new account");
    JLabel l4 = new JLabel(new ImageIcon("PICTURES\\home\\CreateAndLoginBackground.jpg"));
    JButton b1 = new JButton(new ImageIcon("PICTURES\\home\\LoginButton.png"));
    JLabel l5 = new JLabel(" ");

    File userName = new File("PICTURES\\home\\name.txt");
    File Email = new File("PICTURES\\home\\email.txt");
    File Password = new File("PICTURES\\home\\password.txt");

    String data = " ";
    ArrayList emailArr = new ArrayList();

    int i = 0;
    int k = 0;
    ArrayList passArr = new ArrayList();
    Clip clip;

    public SignIn() {
        setTitle("Login");
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        t1.setBounds(130, 20, 180, 30);
        t2.setBounds(130, 70, 180, 30);

        l2.setBounds(180, 270, 100, 25);
        t2.setBounds(180, 310, 250, 40);
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        l2.setForeground(Color.DARK_GRAY);

        l1.setBounds(180, 170, 100, 25);
        t1.setBounds(180, 210, 250, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setForeground(Color.DARK_GRAY);

        l3.setBounds(315, 375, 150, 30);

        l5.setBounds(185, 420, 300, 25);
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Serif", Font.BOLD, 20));

        l4.setBounds(0, 0, 600, 600);
        b1.setBounds(180, 375, 125, 28);
        b1.addActionListener(this);

        add(t1);
        add(t2);
        add(l1);
        add(l2);
        add(b1);
        add(l3);
        add(l5);
        add(l4);

        l3.addMouseListener(this);

        try {
            File file = new File("PICTURES\\home\\login.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            System.err.println("");
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (b1 == ae.getSource());

        {
            //================name========= 
            try {
                Scanner myReader = new Scanner(Email);

                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    if (i != 0) {
                        emailArr.add(data);
                    }
                    i++;
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            //================Password========= 
            try {
                Scanner myReader = new Scanner(Password);

                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    if (k != 0) {
                        passArr.add(data);
                    }
                    k++;
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            //======================== 
            int index = emailArr.indexOf(t1.getText());

            if (index != -1) {
                if (t2.getText().equals(passArr.get(index))) {
                    setVisible(false);
                    Kids_game x = new Kids_game();
                    clip.stop();
                } else {

                    l5.setText("Incorrect Password");

                }
            } else {
                l5.setText("Incorrect Email");
            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (l3 == me.getSource()) {
            setVisible(false);
            clip.stop();
            try {
                CreateAccount x = new CreateAccount();
            } catch (IOException ex) {
                Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        l3.setForeground(Color.BLUE);

    }

    @Override
    public void mouseExited(MouseEvent me) {
        l3.setForeground(Color.BLACK);
    }
}