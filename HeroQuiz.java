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
   JTextField title = new JTextField();
   JLabel infoLbl = new JLabel();
   JTextArea questionArea = new JTextArea();
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

      title.setBounds(0, 25, 400, 50);
      title.setBackground(null);
      title.setForeground(new Color(186,12,47));
      title.setFont(new Font("Arial",Font.BOLD, 36));
      title.setBorder(BorderFactory.createBevelBorder(5));
      title.setHorizontalAlignment(JTextField.CENTER);
      title.setEditable(false);
      title.setText("SuperHero Quiz");

      questionArea.setBounds(0, 175, 400, 50);
      questionArea.setLineWrap(true);
      questionArea.setWrapStyleWord(true);
      questionArea.setBackground(null);
      questionArea.setForeground(new Color(186,12,47));
      questionArea.setFont(new Font("Arial",Font.BOLD, 20));
      questionArea.setBorder(BorderFactory.createBevelBorder(5));
      questionArea.setEditable(false);
      questionArea.setText("trial");

      displayLbl.setBounds(0, 125, 400, 200);
      displayLbl.setIcon(display);
      displayLbl.setHorizontalAlignment(JLabel.CENTER);

      frame.add(displayLbl);
      frame.add(questionArea);
      frame.add(title);
      frame.add(aBtn);
      frame.add(bBtn);
      frame.add(cBtn);
      frame.add(dBtn);
     
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
