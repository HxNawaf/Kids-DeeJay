package kids_game;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Kids_game extends JFrame implements ActionListener {

    JButton button = new JButton();
    JButton animals = new JButton();
    JButton letters = new JButton();
    JButton EvenOdd = new JButton();
    JButton shapes = new JButton();
    JLabel Title = new JLabel();
    JLabel Title2 = new JLabel();

    JLabel test = new JLabel();

    JLabel l6 = new JLabel(new ImageIcon("C:\\Users\\a7law\\Desktop\\مبادئ\\image.png"));

    Clip clip;

    public Kids_game() {
        setTitle("Kids Game");
        setVisible(true);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);





        animals.setIcon(new ImageIcon("C:\\Users\\a7law\\Desktop\\مبادئ\\AnimalsGIFF.gif"));
        shapes.setIcon(new ImageIcon("C:\\Users\\a7law\\Desktop\\مبادئ\\uu.gif"));
        letters.setIcon(new ImageIcon("C:\\Users\\a7law\\Desktop\\مبادئ\\ei.gif"));
        EvenOdd.setIcon(new ImageIcon("C:\\Users\\a7law\\Desktop\\مبادئ\\rr.gif"));
        Title.setIcon(new ImageIcon("C:\\Users\\a7law\\Desktop\\مبادئ\\do.gif"));
        Title2.setIcon(new ImageIcon("C:\\Users\\a7law\\Desktop\\مبادئ\\ddd1.png"));
        Title.setBounds(620, 0, 600, 120);
        button.setBounds(50, 50, 200, 200);
        animals.setBounds(244, 435, 120, 180);
        shapes.setBounds(447, 535, 120, 180);
        letters.setBounds(433, 133, 120, 180);
        EvenOdd.setBounds(224, 77, 120, 180);
        Title2.setBounds(380, 0, 600, 120);

        add(Title2);
        add(Title);


        add(animals);
        add(shapes);
        add(letters);
        add(EvenOdd);



        l6.setBounds(0, 0, 800, 800);
        add(l6);

        try {
            File file = new File("C:\\Users\\a7law\\Desktop\\مبادئ\\v.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            System.err.println("");
        }

        //========================================
        //========================================

        animals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                AnimalSound a = new AnimalSound();
                setVisible(false);

                clip.stop();
            }
        });




        letters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    letters a = new letters();
                    setVisible(false);
                    clip.stop();
                    InputStream IAudio;
                    try {
                        IAudio = new FileInputStream(new File("C:\\Users\\a7law\\Desktop\\مبادئ\\intro_A.wav"));
                        AudioStream IMusic = new AudioStream(IAudio);
                        AudioPlayer.player.start(IMusic);
                    } catch (IOException ex) {
                        Logger.getLogger(Kids_game.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (Exception e) {}
            }
        });

        EvenOdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                EvenOdd a = new EvenOdd();
                setVisible(false);
                clip.stop();
                InputStream IAudio;
                try {
                    IAudio = new FileInputStream(new File("C:\\Users\\A7law\\Desktop\\مبادئ\\intro_123.wav"));
                    AudioStream IMusic = new AudioStream(IAudio);
                    AudioPlayer.player.start(IMusic);
                } catch (IOException ex) {
                    Logger.getLogger(Kids_game.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        shapes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                try {
                    Story b = new Story();
                    setVisible(false);


                    clip.stop();
                } catch (FileNotFoundException ex) {

                }



            }
        });

    }

    public static void main(String[] args) throws IOException {

        SignIn x = new SignIn();



    }

    @Override
    public void actionPerformed(ActionEvent ae) {


    }


}