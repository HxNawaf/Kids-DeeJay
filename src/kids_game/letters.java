package kids_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.*;
import java.io.*;

public class letters extends JFrame implements ActionListener, MouseListener {

    Clip clip;
    int i = 0;
    int z = 0;
    int x = 0;
    int b1let = 0;
    int b2let = 0;
    int b3let = 0;
    int scoor = 0;
    int idx;
    JLabel lhome = new JLabel(new ImageIcon("PICTURES\\home\\HomeButton.png"));
    int random[] = new int[3];
    boolean c = false;

    JButton bvoi = new JButton();
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();

    JLabel aname = new JLabel();
    JLabel l;
    JLabel lscoor = new JLabel();
    JLabel tit;

   // ImageIcon w;
    ImageIcon n;

    String voice[] = {
        "PICTURES\\home\\Vo\\A.wav",
        "PICTURES\\home\\Vo\\B.wav",
        "PICTURES\\home\\Vo\\C.wav",
        "PICTURES\\home\\Vo\\D.wav",
        "PICTURES\\home\\Vo\\E.wav",
        "PICTURES\\home\\Vo\\F.wav",
        "PICTURES\\home\\Vo\\G.wav",
        "PICTURES\\home\\Vo\\H.wav",
        "PICTURES\\home\\Vo\\I.wav",
        "PICTURES\\home\\Vo\\G.wav",
        "PICTURES\\home\\Vo\\K.wav",
        "PICTURES\\home\\Vo\\L.wav",
        "PICTURES\\home\\Vo\\M.wav",
        "PICTURES\\home\\Vo\\N.wav",
        "PICTURES\\home\\Vo\\O.wav",
        "PICTURES\\home\\Vo\\P.wav",
        "PICTURES\\home\\Vo\\Q.wav",
        "PICTURES\\home\\Vo\\R.wav",
        "PICTURES\\home\\Vo\\S.wav",
        "PICTURES\\home\\Vo\\T.wav",
        "PICTURES\\home\\Vo\\U.wav",
        "PICTURES\\home\\Vo\\V.wav",
        "PICTURES\\home\\Vo\\W.wav",
        "PICTURES\\home\\Vo\\X.wav",
        "PICTURES\\home\\Vo\\Y.wav",
        "PICTURES\\home\\Vo\\Z.wav"
    };
    String letters[] = {
        "PICTURES\\home\\abc\\A.png",
        "PICTURES\\home\\abc\\B.png",
        "PICTURES\\home\\abc\\C.png",
        "PICTURES\\home\\abc\\D.png",
        "PICTURES\\home\\abc\\E.png",
        "PICTURES\\home\\abc\\F.png",
        "PICTURES\\home\\abc\\G.png",
        "PICTURES\\home\\abc\\H.png",
        "PICTURES\\home\\abc\\I.png",
        "PICTURES\\home\\abc\\J.png",
        "PICTURES\\home\\abc\\K.png",
        "PICTURES\\home\\abc\\L.png",
        "PICTURES\\home\\abc\\M.png",
        "PICTURES\\home\\abc\\N.png",
        "PICTURES\\home\\abc\\O.png",
        "PICTURES\\home\\abc\\P.png",
        "PICTURES\\home\\abc\\Q.png",
        "PICTURES\\home\\abc\\R.png",
        "PICTURES\\home\\abc\\S.png",
        "PICTURES\\home\\abc\\T.png",
        "PICTURES\\home\\abc\\U.png",
        "PICTURES\\home\\abc\\V.png",
        "PICTURES\\home\\abc\\W.png",
        "PICTURES\\home\\abc\\X.png",
        "PICTURES\\home\\abc\\Y.png",
        "PICTURES\\home\\abc\\Z.png"
    };
    JLabel l1 = new JLabel(new ImageIcon("PICTURES\\home\\InteractiveBoy.gif"));
    public letters() {

        setTitle("Letters game");
        setVisible(true);
        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        l1.setBounds(320, 50, 250, 250);

        setContentPane(new JLabel(new ImageIcon("PICTURES\\home\\LettersGameBackground.jpg")));
        tit = new JLabel();
        add(tit).setBounds(10, 10, 700, 270);

        b1.setBounds(20, 340, 200, 200);
        b2.setBounds(240, 340, 200, 200);
        b3.setBounds(460, 340, 200, 200);
        b1.setBackground(new java.awt.Color(19, 103, 159));
        b2.setBackground(new java.awt.Color(19, 103, 159));
        b3.setBackground(new java.awt.Color(19, 103, 159));
        lhome.setBounds(5, 5, 70, 70);
        lhome.addMouseListener(this);
        add(lhome);
        add(b1);
        add(b2);
        add(b3);

        add(l1);
     

        add(bvoi).setBounds(115, 135, 125, 125);
        bvoi.setIcon(new ImageIcon("PICTURES\\home\\SoundButton.png"));

        bvoi.setBackground(new java.awt.Color(19, 103, 159));
        bvoi.addActionListener(this);

        /////////////////////////////////////////////////////////////////////////////
        for (i = 0; i < 3;) {
            int max = 25;
            int min = 0;
            x = (int)((Math.random() * ((max - min) + 1)) + min);

            if (x != b1let) {
                if (x != b2let) {
                    if (x != b3let) {
                        switch (i) {
                        case 0:
                            b1let = x;
                            b1.setIcon(new ImageIcon(letters[x]));
                            add(b1);
                            random[0] = b1let;
                            i++;
                            break;

                        case 1:
                            b2let = x;
                            b2.setIcon(new ImageIcon(letters[x]));

                            add(b2);
                            random[1] = b2let;
                            i++;
                            break;

                        case 2:
                            b3let = x;
                            b3.setIcon(new ImageIcon(letters[x]));
                            add(b3);
                            random[2] = b3let;
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
            aname.setText(voice[random[idx]]);

        }
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                z = random[idx];
                if (b1let == z) {
                    scoor = scoor + 5;
                    lscoor.setText("" + scoor);
                    add(lscoor);

                    aname.setText(voice[random[idx]]);
                    add(aname);

                    b1.setBackground(Color.GREEN);

                    for (i = 0; i < 3;) {
                        int max = 25;
                        int min = 0;
                        x = (int)((Math.random() * ((max - min) + 1)) + min);

                        if (x != b1let) {
                            if (x != b2let) {
                                if (x != b3let) {
                                    switch (i) {
                                    case 0:
                                        b1let = x;
                                        b1.setBackground(new java.awt.Color(19, 103, 159));
                                        b1.setIcon(new ImageIcon(letters[x]));
                                        add(b1);
                                        random[0] = b1let;

                                        i++;

                                        break;
                                    case 1:
                                        b2let = x;
                                        b2.setBackground(new java.awt.Color(19, 103, 159));
                                        b2.setIcon(new ImageIcon(letters[x]));
                                        add(b2);
                                        random[1] = b2let;

                                        i++;
                                        break;

                                    case 2:
                                        b3let = x;
                                        b3.setBackground(new java.awt.Color(19, 103, 159));
                                        b3.setIcon(new ImageIcon(letters[x]));
                                        add(b3);
                                        random[2] = b3let;
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
                        aname.setText(voice[random[idx]]);
                        add(aname);

                    }
                    c = true;
                } else {
                    aname.setText("Try again" + random[idx] + z + b1let + idx);
                    b1.setBackground(new java.awt.Color(155, 8, 8));
                    c = false;
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int z = random[idx];
                if (b2let == z) {
                    scoor = scoor + 5;
                    lscoor.setText("" + scoor);
                    add(lscoor);

                    aname.setText(voice[random[idx]]);
                    add(aname);

                    b2.setBackground(Color.GREEN);

                    for (i = 0; i < 3;) {
                        int max = 25;
                        int min = 0;
                        x = (int)((Math.random() * ((max - min) + 1)) + min);

                        if (x != b1let) {
                            if (x != b2let) {
                                if (x != b3let) {
                                    switch (i) {
                                    case 0:
                                        b1let = x;
                                        b1.setBackground(new java.awt.Color(19, 103, 159));
                                        b1.setIcon(new ImageIcon(letters[x]));
                                        add(b1);
                                        random[0] = b1let;

                                        i++;

                                        break;
                                    case 1:
                                        b2let = x;
                                        b2.setBackground(new java.awt.Color(19, 103, 159));
                                        b2.setIcon(new ImageIcon(letters[x]));
                                        add(b2);
                                        random[1] = b2let;

                                        i++;
                                        break;

                                    case 2:
                                        b3let = x;
                                        b3.setBackground(new java.awt.Color(19, 103, 159));
                                        b3.setIcon(new ImageIcon(letters[x]));
                                        add(b3);
                                        random[2] = b3let;
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
                        aname.setText(voice[random[idx]]);
                        add(aname);

                    }
                } else {
                    aname.setText("Try again" + random[idx] + z + b2let + idx);
                    b2.setBackground(new java.awt.Color(155, 8, 8));
                    c = false;
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                z = random[idx];

                if (b3let == z) {

                    scoor = scoor + 5;
                    lscoor.setText("" + scoor);
                    add(lscoor);

                    aname.setText(voice[random[idx]]);
                    add(aname);

                    for (i = 0; i < 3;) {
                        int max = 25;
                        int min = 0;
                        x = (int)((Math.random() * ((max - min) + 1)) + min);

                        if (x != b1let) {
                            if (x != b2let) {
                                if (x != b3let) {
                                    switch (i) {
                                    case 0:
                                        b1let = x;
                                        b1.setBackground(new java.awt.Color(19, 103, 159));
                                        b1.setIcon(new ImageIcon(letters[x]));
                                        add(b1);
                                        random[0] = b1let;

                                        i++;

                                        break;
                                    case 1:
                                        b2let = x;
                                        b2.setBackground(new java.awt.Color(19, 103, 159));
                                        b2.setIcon(new ImageIcon(letters[x]));
                                        add(b2);
                                        random[1] = b2let;

                                        i++;
                                        break;

                                    case 2:
                                        b3let = x;
                                        b3.setBackground(new java.awt.Color(19, 103, 159));
                                        b3.setIcon(new ImageIcon(letters[x]));
                                        add(b3);
                                        random[2] = b3let;
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
                        aname.setText(voice[random[idx]] + "  random " + random[idx] + b1let + b2let + b3let);

                        aname.setText(voice[random[idx]]);
                        add(aname);

                    }
                } else {
                    aname.setText("Try again" + random[idx] + z + b3let + idx);
                    b3.setBackground(new java.awt.Color(155, 8, 8));
                    c = false;

                }
            }
        });

    }

    public void actionPerformed(ActionEvent ae) {
        if (bvoi == ae.getSource()) {
            try {

                File voi = new File(voice[random[idx]]);

                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(voi));

                clip.start();
            } catch (Exception e) {
                System.err.println("");
            }
        } else if (b5 == ae.getSource()) {
            setVisible(false);
            Kids_game f = new Kids_game();

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