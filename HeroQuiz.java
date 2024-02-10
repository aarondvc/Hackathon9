import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class HeroQuiz implements ActionListener{
   String [] questions = {
      "What is the Hulk's strength level?", "What comic was Batman's first appearance?",  
   };
   
   char userAns;
   char correctAns;
   int index;
   int correctUserAns = 0;
   int totalQuestions = questions.length;
   int result;
   
   JFrame frame = new JFrame();
   JTextField textField = new JTextField();
   JLabel infoLbl = new JLabel();
   JTextArea textArea = new JTextArea();
   JButton aBtn = new JButton();
   JButton bBtn = new JButton();
   JButton cBtn = new JButton();
   JButton dBtn = new JButton();
   JLabel aLbl = new JLabel();
   JLabel bLbl = new JLabel();
   JLabel cLbl = new JLabel();
   JLabel dLbl = new JLabel();
   JButton playBtn = new JButton();
   ImageIcon display = new ImageIcon("resources/byte.jpeg");
   JLabel displayLbl = new JLabel();


   public HeroQuiz() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400,650);
      frame.getContentPane().setBackground(new Color(136,206,235));
      frame.setResizable(false);
      frame.setLayout(null);

      textField.setBounds(0, 25, 400, 50);
      textField.setBackground(null);
      textField.setForeground(new Color(186,12,47));
      textField.setFont(new Font("Arial",Font.BOLD, 36));
      textField.setBorder(BorderFactory.createBevelBorder(5));
      textField.setHorizontalAlignment(JTextField.CENTER);
      textField.setEditable(false);
      textField.setText("SuperHero Quiz");

      displayLbl.setBounds(0, 175, 400, 200);
      displayLbl.setIcon(display);
      displayLbl.setHorizontalAlignment(JLabel.CENTER);
      infoLbl.setBounds(0, 75, 400, 50);
      infoLbl.setText("How well do you know your favorite superheroes?");
      infoLbl.setFont(new Font("Arial",Font.BOLD, 28));
   
      frame.add(displayLbl);
      frame.add(textField);
      frame.add(infoLbl);
     
      frame.setVisible(true);
   }

   public void nextQuestion() {

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      
   }

   public void displayAnswer() {

   }

   public void results() {

   }
}
