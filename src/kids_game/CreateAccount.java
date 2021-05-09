 package kids_game;

 import java.awt.Color;
 import java.awt.FlowLayout;
 import java.awt.Font;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.MouseEvent;
 import java.awt.event.MouseListener;
 import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.io.OutputStream;
 import static java.lang.ProcessBuilder.Redirect.Type.APPEND;
 import java.nio.file.Files;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javax.sound.sampled.AudioSystem;
 import javax.sound.sampled.Clip;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 import javax.swing.JPasswordField;
 import javax.swing.JTextField;

 public class CreateAccount extends JFrame implements ActionListener, MouseListener {

     FileWriter NameWriter = new FileWriter("PICTURES\\home\\name.txt", true);
     FileWriter EmailWriter = new FileWriter("PICTURES\\home\\email.txt", true);
     FileWriter PassWriter = new FileWriter("PICTURES\\home\\password.txt", true);
     Clip clip;
     //----------------------------
     JLabel l1 = new JLabel("Full name");
     JLabel l2 = new JLabel("Email");
     JLabel l3 = new JLabel("Password");
     JLabel l4 = new JLabel("  ");
     JLabel l5 = new JLabel("I have account");
     JButton b1 = new JButton(new ImageIcon("PICTURES\\home\\CreateButton.png"));
     JTextField tname = new JTextField();
     JTextField tmail = new JTextField();
     JPasswordField tpass = new JPasswordField();

     int x = 0;

     JLabel l6 = new JLabel(new ImageIcon("PICTURES\\home\\CreateAndLoginBackground.jpg"));

     public CreateAccount() throws IOException {
         setTitle("New Account");
         setVisible(true);
         setSize(600, 600);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setResizable(false);
         setLayout(null);

         l1.setBounds(180, 160, 100, 25);
         tname.setBounds(180, 195, 250, 40);
         l1.setFont(new Font("Serif", Font.BOLD, 20));
         l1.setForeground(Color.DARK_GRAY);

         l2.setBounds(180, 250, 100, 25);
         tmail.setBounds(180, 285, 250, 40);
         l2.setFont(new Font("Serif", Font.BOLD, 20));
         l2.setForeground(Color.DARK_GRAY);

         l3.setBounds(180, 340, 100, 25);
         tpass.setBounds(180, 375, 250, 40);
         l3.setFont(new Font("Serif", Font.BOLD, 20));
         l3.setForeground(Color.DARK_GRAY);

         l4.setBounds(177, 470, 500, 25);
         l4.setForeground(Color.RED);
         l4.setFont(new Font("Serif", Font.BOLD, 20));

         l5.setBounds(320, 430, 180, 30);
         add(l5);
         b1.setBounds(180, 430, 130, 30);
         add(b1);
         add(l4);
         add(l1);
         add(l2);
         add(l3);
         add(l5);
         add(tname);
         add(tmail);
         add(tpass);
         add(b1);
         b1.addActionListener(this);
         l6.setBounds(0, 0, 600, 600);
         l5.addMouseListener(this);
         add(l6);

         //=====================================
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
         if (b1 == ae.getSource()) {

             if (tname.getText().matches("[A-Za-z ]{3,}") == false) {
                 l4.setText("Please enter your correct name");

             } else {

                 try {
                     tname.write(NameWriter.append("\n"));
                     NameWriter.close();

                     l4.setText(" ");
                 } catch (IOException ex) {}
                 //-----------------------------

                 if (tmail.getText().matches("[A-Za-z0-9-_]+@[A-Za-z]+[.][A-Za-z]+([.][A-Za-z]+)?") == false) {
                     l4.setText("Please enter your correct E-mail");

                 } else {

                     l4.setText(" ");
                     try {
                         tmail.write(EmailWriter.append("\n"));
                         EmailWriter.close();

                     } catch (IOException ex) {}

                     //+++++++++++++++++++++++++++++

                     if (tpass.getText().matches("[0-9A-Za-z]{6,}") == false) {
                         l4.setText(" Your password should be more than 4 ");

                     } else {

                         try {
                             l4.setText(" ");
                             tpass.write(PassWriter.append("\n"));
                             PassWriter.close();

                             setVisible(false);
                             SignIn x = new SignIn();
                             clip.stop();
                         } catch (IOException ex) {

                         }
                     }
                     //+++++++++++++++++++++++++++++

                     //--------------------------------- 
                 }
             }

         }
     }

     @Override
     public void mouseClicked(MouseEvent me) {
         if (l5 == me.getSource()) {
             setVisible(false);
             SignIn x = new SignIn();
             clip.stop();
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
         l5.setForeground(Color.BLUE);
     }

     @Override
     public void mouseExited(MouseEvent me) {
         l5.setForeground(Color.BLACK);
     }

 }