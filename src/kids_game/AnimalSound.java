package kids_game;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import static java.awt.Component.LEFT_ALIGNMENT;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AnimalSound extends JFrame implements MouseListener {

    int i = 0;
    int a1int = 0;
    int a2int = 0;
    int a3int = 0;
    int scoor = 0;

    boolean c = false;
    int z = 0;

    int random[] = new int[3];
    int idx;

    //-------------------Definitions------------------------------------

    JLabel l6 = new JLabel(new ImageIcon("PICTURES\\home\\AnimalsGameBackground.jpg"));


    String names[] = {
        "Elephant",
        "Dog",
        "Cat",
        "Sheep",
        "Frog",
        "Monkey",
        "Lion",
        "Horse",
        "Cow",
    };

    String animals[] = {
        "PICTURES\\home\\Elephant.png",
        "PICTURES\\home\\Dog.png",
        "PICTURES\\home\\Cat.png",
        "PICTURES\\home\\Sheep.png",
        "PICTURES\\home\\Frog.png",
        "PICTURES\\home\\Monkey.png",
        "PICTURES\\home\\Lion.png",
        "PICTURES\\home\\Horse.png",
        "PICTURES\\home\\Cow.png"
    };
    JLabel lhome = new JLabel(new ImageIcon("PICTURES\\home\\HomeButton.png"));
    JButton a1 = new JButton();
    JButton a2 = new JButton();
    JButton a3 = new JButton();
    JLabel aname = new JLabel();
    JLabel lscoor = new JLabel();
    JLabel star = new JLabel();
    JLabel Error = new JLabel(" ");
    Clip clip;

    public AnimalSound() {
        //-----Frame prop.--------------------------------------------------
        setTitle(" Animals ");
        setVisible(true);
        setSize(800, 800);
        setResizable(false);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

      
        
        star.setIcon(new ImageIcon("PICTURES\\home\\Star.png"));

        lscoor.setFont(new Font("Serif", Font.BOLD, 80));
        lscoor.setForeground(Color.red);
        lscoor.setText("" + scoor);
        setLayout(null);
        l6.setLayout(null);
        l6.setBounds(0, 0, 800, 800);
        //
       // home.setBounds(10, 20, 70, 70);
        a1.setBounds(80, 450, 200, 200);
        a2.setBounds(310, 450, 200, 200);
        a3.setBounds(540, 450, 200, 200);
        lscoor.setBounds(710, 10, 80, 80);
        star.setBounds(605, 0, 100, 100);
        //Title.setBounds(100, 15, 600, 100);
        aname.setBounds(300, 200, 500, 100);
        Error.setBounds(250, 280, 500, 100);
        Error.setFont(new Font("Serif", Font.BOLD, 80));
        add(star);
        lhome.setBounds(5, 5, 70, 70);
        lhome.addMouseListener(this);
        add(lhome);
        // add(home);
        add(lscoor);
       // add(Title);
        add(Error);


        try {
            File file = new File("PICTURES\\home\\AnimalMusic.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            System.err.println(e);
        }

        aname.setFont(new Font("Serif", Font.BOLD, 80));
        aname.setForeground(Color.DARK_GRAY);

        //-------------------------------------------------------------
        for (i = 0; i < 3;) {
            int max = 8;
            int min = 0;
            int x = (int)((Math.random() * ((max - min) + 1)) + min);

            if (x != a1int) {
                if (x != a2int) {
                    if (x != a3int) {
                        switch (i) {
                            case 0:
                                a1int = x;
                                a1.setIcon(new ImageIcon(animals[x]));
                                add(a1);
                                random[0] = a1int;
                                i++;
                                break;

                            case 1:
                                a2int = x;
                                a2.setIcon(new ImageIcon(animals[x]));
                                add(a2);
                                random[1] = a2int;
                                i++;
                                break;

                            case 2:
                                a3int = x;
                                a3.setIcon(new ImageIcon(animals[x]));
                                add(a3);
                                random[2] = a3int;
                                idx = (int)((Math.random() * ((2 - 0) + 1)) + min);
                                i++;
                                break;

                            default:
                                break;

                        }
                    }
                }
            }

            //-----------------------------------------
            aname.setText(names[random[idx]]);

            add(aname);

        }

        //==================================================================================================================
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                z = random[idx];
                if (a1int == z) {
                    scoor = scoor + 5;
                    lscoor.setText("" + scoor);

                    aname.setText(names[random[idx]]);

                    a1.setBackground(Color.GREEN);

                    for (i = 0; i < 3;) {
                        int max = 8;
                        int min = 0;
                        int x = (int)((Math.random() * ((max - min) + 1)) + min);

                        if (x != a1int) {
                            if (x != a2int) {
                                if (x != a3int) {
                                    switch (i) {
                                        case 0:
                                            a1int = x;
                                            a1.setBackground(Color.GRAY);
                                            a1.setIcon(new ImageIcon(animals[x]));
                                            add(a1);
                                            random[0] = a1int;
                                            i++;

                                            break;
                                        case 1:
                                            a2int = x;
                                            a2.setBackground(Color.GRAY);
                                            a2.setIcon(new ImageIcon(animals[x]));
                                            add(a2);
                                            random[1] = a2int;
                                            i++;
                                            break;

                                        case 2:
                                            a3int = x;
                                            a3.setBackground(Color.GRAY);
                                            a3.setIcon(new ImageIcon(animals[x]));
                                            add(a3);
                                            random[2] = a3int;
                                            idx = (int)((Math.random() * ((2 - 0) + 1)) + min);
                                            i++;
                                            break;

                                        default:
                                            break;

                                    }
                                }
                            }
                        }

                        //-----------------------------------------
                        aname.setText(names[random[idx]]);
                        Error.setText("");
                    }
                    c = true;
                } else {
                    Error.setText("Try again");
                    Error.setForeground(Color.RED);
                    a1.setBackground(Color.RED);
                    c = false;
                }
            }
        });

        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int z = random[idx];
                if (a2int == z) {
                    scoor = scoor + 5;
                    lscoor.setText("" + scoor);

                    aname.setText(names[random[idx]]);
                    a2.setBackground(Color.GREEN);

                    for (i = 0; i < 3;) {
                        int max = 8;
                        int min = 0;
                        int x = (int)((Math.random() * ((max - min) + 1)) + min);

                        if (x != a1int) {
                            if (x != a2int) {
                                if (x != a3int) {
                                    switch (i) {
                                        case 0:
                                            a1int = x;
                                            a1.setBackground(Color.GRAY);
                                            a1.setIcon(new ImageIcon(animals[x]));
                                            add(a1);
                                            random[0] = a1int;
                                            i++;

                                            break;
                                        case 1:
                                            a2int = x;
                                            a2.setBackground(Color.GRAY);
                                            a2.setIcon(new ImageIcon(animals[x]));
                                            add(a2);
                                            random[1] = a2int;
                                            i++;
                                            break;

                                        case 2:
                                            a3int = x;
                                            a3.setBackground(Color.GRAY);
                                            a3.setIcon(new ImageIcon(animals[x]));
                                            add(a3);
                                            random[2] = a3int;
                                            idx = (int)((Math.random() * ((2 - 0) + 1)) + min);
                                            i++;
                                            break;

                                        default:
                                            break;

                                    }
                                }
                            }
                        }

                        //-----------------------------------------
                        aname.setText(names[random[idx]]);
                        Error.setText("");
                    }
                } else {
                    Error.setText("Try again");
                    Error.setForeground(Color.RED);
                    a2.setBackground(Color.RED);
                    c = false;
                }
            }
        });

        add(l6);
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                z = random[idx];

                if (a3int == z) {

                    scoor = scoor + 5;
                    lscoor.setText("" + scoor);


                    aname.setText(names[random[idx]]);

                    for (i = 0; i < 3;) {
                        int max = 8;
                        int min = 0;
                        int x = (int)((Math.random() * ((max - min) + 1)) + min);

                        if (x != a1int) {
                            if (x != a2int) {
                                if (x != a3int) {
                                    switch (i) {
                                        case 0:
                                            a1int = x;
                                            a1.setBackground(Color.GRAY);
                                            a1.setIcon(new ImageIcon(animals[x]));
                                            add(a1);
                                            random[0] = a1int;
                                            i++;

                                            break;
                                        case 1:
                                            a2int = x;
                                            a2.setBackground(Color.GRAY);
                                            a2.setIcon(new ImageIcon(animals[x]));
                                            add(a2);
                                            random[1] = a2int;
                                            i++;
                                            break;

                                        case 2:
                                            a3int = x;
                                            a3.setBackground(Color.GRAY);
                                            a3.setIcon(new ImageIcon(animals[x]));
                                            add(a3);
                                            random[2] = a3int;
                                            idx = (int)((Math.random() * ((2 - 0) + 1)) + min);
                                            i++;
                                            break;

                                        default:
                                            break;

                                    }
                                }
                            }
                        }

                        //-----------------------------------------
                        aname.setText(names[random[idx]] + "  random " + random[idx] + a1int + a2int + a3int);
                        aname.setText(names[random[idx]]);
                        Error.setText("");

                    }
                } else {
                    Error.setText("Try again");
                    Error.setForeground(Color.RED);
                    a3.setBackground(Color.RED);
                    c = false;
                }
            }
        });

        //-------------HOME BUTTON------------------------------
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