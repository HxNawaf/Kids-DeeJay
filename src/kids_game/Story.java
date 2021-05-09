package kids_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Story extends JFrame implements ActionListener, MouseListener {

    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JLabel lhome = new JLabel(new ImageIcon("PICTURES\\home\\HomeButton.png"));
    String data = "11";
    JLabel l6 = new JLabel(new ImageIcon("PICTURES\\home\\storyWall.png"));

    JLabel myStory = new JLabel(" ");
    File story1 = new File("PICTURES\\home\\ElephentStory.text");
    File story2 = new File("PICTURES\\home\\TheAnt.text");
    File story3 = new File("PICTURES\\home\\Lier.text");
    File story4 = new File("PICTURES\\home\\LionStory.text");
    Clip clip;
    JButton home = new JButton();

    public Story() throws FileNotFoundException {

        setTitle("Story");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        home.setBounds(0, 0, 70, 70);
        setLocationRelativeTo(null);
        setLayout(null);
        b1.setBounds(20, 560, 180, 192);
        b2.setBounds(210, 560, 180, 192);
        b3.setBounds(400, 560, 180, 192);
        b4.setBounds(590, 560, 180, 192);
        l6.setBounds(0, 0, 800, 800);
        b1.setIcon(new ImageIcon("PICTURES\\home\\story1.png"));
        b2.setIcon(new ImageIcon("PICTURES\\home\\story2.png"));
        b3.setIcon(new ImageIcon("PICTURES\\home\\story3.png"));
        b4.setIcon(new ImageIcon("PICTURES\\home\\story4.png"));
        b1.addActionListener(this);
        b2.addActionListener(this);
        lhome.setBounds(5, 5, 70, 70);
        lhome.addMouseListener(this);
        add(lhome);

        myStory.setBounds(90, 0, 630, 500);
        myStory.setFont(new Font("Sans Serif", Font.BOLD, 17));

        add(b1);
        add(myStory);

        add(b2);
        add(b3);
        add(b4);
        home.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        add(l6);

        try {
            File file = new File("PICTURES\\home\\StoryMusic.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // button1
        if (b1 == ae.getSource()) {
            try {
                Scanner myReader = new Scanner(story1);
                myStory.setForeground(Color.PINK);
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    myStory.setText(data);
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        // Button2      
        if (b2 == ae.getSource()) {
            try {
                Scanner myReader = new Scanner(story2);
                myStory.setText(" ");
                myStory.setForeground(Color.WHITE);
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    myStory.setText(data);
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        // Button3      
        if (b3 == ae.getSource()) {
            try {
                Scanner myReader = new Scanner(story3);
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    myStory.setForeground(Color.YELLOW);
                    myStory.setText(data);
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        // Button4      
        if (b4 == ae.getSource()) {
            try {
                Scanner myReader = new Scanner(story4);
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    myStory.setForeground(Color.WHITE);
                    myStory.setText(data);
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        // Home Button   
        if (home == ae.getSource()) {
            Kids_game x = new Kids_game();
            setVisible(false);
            clip.stop();
        }

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