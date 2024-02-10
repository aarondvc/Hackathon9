import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class HeroQuiz implements ActionListener{
   String [] questions = {
      "What is the for the Hulk?", 
   };
   
   char userAns;
   char correctAns;
   int index;
   int correctUserAns = 0;
   int totalQuestions = questions.length;
   int result;
   
   JFrame frame = new JFrame();
   JTextField textField = new JTextField();
   JTextArea textArea = new JTextArea();
   JButton aBtn = new JButton();
   JButton bBtn = new JButton();
   JButton cBtn = new JButton();
   JButton dBtn = new JButton();
   JLabel aLbl = new JLabel();
   JLabel bLbl = new JLabel();
   JLabel cLbl = new JLabel();
   JLabel dLbl = new JLabel();
   ImageIcon display = new ImageIcon();


   public HeroQuiz() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(650,650);

      

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
