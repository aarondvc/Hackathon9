import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class HeroQuiz implements ActionListener {
   String[] questions = {
         "Which superhero is known as the 'Man of Steel'?",
         "What year was Scarlet Witch introduced?",
         "What is the name of Spider-Man's alter-ego?",
         "Which king is known to break the sound barrier with a whisper",
         "Who is the king of Wakanda and also known as the Black Panther?",
         "What is the real name of the superhero known as Wonder Woman?",
         "Which entity was killed in order to defeat the Black Winter?",
         "What is the civilian name of the superhero known as Captain America?",
         "Which superhero is known for wielding a magical hammer called Mjolnir?",
         "What comic was Batman's first appearance?"
   };

   String[][] choices = {
         { "Thor", "Superman", "Iron Man", "Wolverine" },
         { "1999", "1971", "2003", "1964" },
         { "Barry Allen", "Steve Rodgers", "Peter Parker", "Bruce Banner" },
         { "Namor", "Black Bolt", "Doctor Doom", "Zeus" },
         { "T'Challa", "Bruce Wayne", "Tony Stark", "Clark Kent" },
         { "Diana Prince", "Natasha Romanoff", "Jessica Jones", "Carol Danvers" },
         { "Eternity", "Living Tribunal", "Galactus", "The Beyonder" },
         { "Tony Stark", "Bruce Wayne", "Clark Kent", "Steve Rogers" },
         { "Hulk", "Thor", "Captain America", "Green Lantern" },
         { "Detective Comics #18", "Detective Comics #20", "Action Comics #3", "Detective Comics #27" }
   };

   char[] answers = {
         'B',
         'D',
         'C',
         'B',
         'A',
         'A',
         'C',
         'D',
         'B',
         'D'
   };

   char userAns;
   char correctAns;
   int index = 0;
   int correctUserAns = 0;
   int totalQuestions = questions.length;
   int result;

   JFrame frame = new JFrame();
   JTextField textfield = new JTextField();
   JTextArea textArea = new JTextArea();

   JLabel infoLbl = new JLabel();

   JButton playAgainBtn = new JButton();
   JButton aBtn = new JButton();
   JButton bBtn = new JButton();
   JButton cBtn = new JButton();
   JButton dBtn = new JButton();
   JLabel aLbl = new JLabel();
   JLabel bLbl = new JLabel();
   JLabel cLbl = new JLabel();
   JLabel dLbl = new JLabel();
   JButton nextBtn = new JButton();

   JTextField number_right = new JTextField();
   JTextField percentage = new JTextField();

   public HeroQuiz() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(700, 650);
      frame.getContentPane().setBackground(new Color(108, 183, 240));
      frame.setResizable(false);
      frame.setLayout(null);

      textfield.setBounds(0, 0, 650, 50);
      textfield.setBackground(new Color(108, 183, 240));
      textfield.setForeground(new Color(155, 0, 0));
      textfield.setFont(new Font("Arial", Font.BOLD, 30));
      textfield.setBorder(BorderFactory.createBevelBorder(5));
      textfield.setHorizontalAlignment(JTextField.CENTER);
      textfield.setEditable(false);
      textfield.setText("Superhero Quiz");

      textArea.setBounds(35, 50, 650, 90);
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      textArea.setBackground(null);
      textArea.setForeground(new Color(155, 0, 0));
      textArea.setFont(new Font("Arial", Font.BOLD, 25));
      textArea.setBorder(BorderFactory.createBevelBorder(5));
      textArea.setEditable(false);
      
      aBtn.setBounds(10,150,75,75);
      aBtn.setFont(new Font("Ariel",Font.BOLD, 35));
      aBtn.setFocusable(false);
      aBtn.addActionListener(this);
      aBtn.setText("A");

      bBtn.setBounds(10, 225, 75, 75);
      bBtn.setFont(new Font("Ariel", Font.BOLD, 35));
      bBtn.setFocusable(false);
      bBtn.addActionListener(this);
      bBtn.setText("B");

      cBtn.setBounds(10, 300, 75, 75);
      cBtn.setFont(new Font("Ariel", Font.BOLD, 35));
      cBtn.setFocusable(false);
      cBtn.addActionListener(this);
      cBtn.setText("C");

      dBtn.setBounds(10, 375, 75, 75);
      dBtn.setFont(new Font("Ariel", Font.BOLD, 35));
      dBtn.setFocusable(false);
      dBtn.addActionListener(this);
      dBtn.setText("D");

      aLbl.setBounds(125, 135, 500, 100);
      aLbl.setBackground(new Color(50, 50, 50));
      aLbl.setForeground(new Color(0, 0, 0));
      aLbl.setFont(new Font("Arial", Font.BOLD, 35));

      bLbl.setBounds(125, 210, 500, 100);
      bLbl.setBackground(new Color(50, 50, 50));
      bLbl.setForeground(new Color(0, 0, 0));
      bLbl.setFont(new Font("Arial", Font.BOLD, 35));

      cLbl.setBounds(125, 285, 500, 100);
      cLbl.setBackground(new Color(50, 50, 50));
      cLbl.setForeground(new Color(0, 0, 0));
      cLbl.setFont(new Font("Arial", Font.BOLD, 35));

      dLbl.setBounds(125, 360, 500, 100);
      dLbl.setBackground(new Color(50, 50, 50));
      dLbl.setForeground(new Color(0, 0, 0));
      dLbl.setFont(new Font("Arial", Font.BOLD, 35));

      frame.add(aLbl);
      frame.add(bLbl);
      frame.add(cLbl);
      frame.add(dLbl);

      frame.add(textArea);
      frame.add(textfield);
      frame.add(aBtn);
      frame.add(bBtn);
      frame.add(cBtn);
      frame.add(dBtn);

      number_right.setBounds(250, 220, 200, 100);
      number_right.setForeground(new Color(155, 0, 0));
      number_right.setFont(new Font("Arial", Font.BOLD, 50));
      number_right.setBorder(BorderFactory.createBevelBorder(1));
      number_right.setHorizontalAlignment(JTextField.CENTER);
      number_right.setEditable(false);

      percentage.setBounds(250, 320, 200, 100);
      percentage.setForeground(new Color(155, 0, 0));
      percentage.setFont(new Font("Arial", Font.BOLD, 50));
      percentage.setBorder(BorderFactory.createBevelBorder(1));
      percentage.setHorizontalAlignment(JTextField.CENTER);
      percentage.setEditable(false);

      nextBtn.setBounds(10, 500, 100, 75);
      nextBtn.setFont(new Font("Arial", Font.BOLD, 20));
      nextBtn.setText("Next");
      nextBtn.setFocusable(false);
      nextBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            nextPerformed(); // Call nextPerformed method when next button is clicked
         }
      });
      frame.add(nextBtn);
      frame.setVisible(true);

      nextQuestion();
   }

   public void initializePlayAgainButton() {
      playAgainBtn.setBounds(500, 500, 125, 75);
      playAgainBtn.setFont(new Font("Arial", Font.BOLD, 20));
      playAgainBtn.setText("Play Again");
      playAgainBtn.setFocusable(false);
      playAgainBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              playAgain(); 
          }
      });
    }

   public void playAgain() {
      index = 0; // Reset the index to the first question
      correctUserAns = 0; // Reset the number of correct answers
      nextQuestion(); // Start the quiz again with the first question
      aBtn.setEnabled(true);
      bBtn.setEnabled(true);
      cBtn.setEnabled(true);
      dBtn.setEnabled(true);
      nextBtn.setEnabled(true);
      frame.remove(playAgainBtn);
      frame.remove(percentage);
      frame.remove(number_right);
      frame.revalidate();
      frame.repaint();
  }

   public void nextQuestion() {
      if (index >= totalQuestions) {
         results();
      } else {
         textfield.setText("Question " + (index + 1));
         textArea.setText(questions[index]);
         aLbl.setText(choices[index][0]);
         bLbl.setText(choices[index][1]);
         cLbl.setText(choices[index][2]);
         dLbl.setText(choices[index][3]);

      }
   }

   public void nextPerformed() {
      aBtn.setEnabled(true);
      bBtn.setEnabled(true);
      cBtn.setEnabled(true);
      dBtn.setEnabled(true);
      aLbl.setForeground(new Color(0, 0, 0));
      bLbl.setForeground(new Color(0, 0, 0));
      cLbl.setForeground(new Color(0, 0, 0));
      dLbl.setForeground(new Color(0, 0, 0));
      nextQuestion();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      aBtn.setEnabled(false);
      bBtn.setEnabled(false);
      cBtn.setEnabled(false);
      dBtn.setEnabled(false);

      if (e.getSource() == aBtn) {
         correctAns = 'A';
         if (correctAns == answers[index]) {
            correctUserAns++;
         }
      }
      if (e.getSource() == bBtn) {
         correctAns = 'B';
         if (correctAns == answers[index]) {
            correctUserAns++;
         }
      }
      if (e.getSource() == cBtn) {
         correctAns = 'C';
         if (correctAns == answers[index]) {
            correctUserAns++;
         }
      }

      if (e.getSource() == dBtn) {
         correctAns = 'D';
         if (correctAns == answers[index]) {
            correctUserAns++;
         }
      }
      displayAnswer();
      try {
         index++;
      } catch (ArrayIndexOutOfBoundsException aiobe) {

      }
   }

   public void displayAnswer() {
      aBtn.setEnabled(false);
      bBtn.setEnabled(false);
      cBtn.setEnabled(false);
      dBtn.setEnabled(false);

      if (answers[index] != 'A') {
         aLbl.setForeground(new Color(255, 0, 0));
      }
      if (answers[index] != 'B') {
         bLbl.setForeground(new Color(255, 0, 0));
      }
      if (answers[index] != 'C') {
         cLbl.setForeground(new Color(255, 0, 0));
      }
      if (answers[index] != 'D') {
         dLbl.setForeground(new Color(255, 0, 0));
      }
      if (answers[index] == 'A') {
         aLbl.setForeground(new Color(0, 255, 0));
      }
      if (answers[index] == 'B') {
         bLbl.setForeground(new Color(0, 255, 0));
      }
      if (answers[index] == 'C') {
         cLbl.setForeground(new Color(0, 255, 0));
      }
      if (answers[index] == 'D') {
         dLbl.setForeground(new Color(0, 255, 0));
      }

   }

   public void results() {
      initializePlayAgainButton();
      frame.add(playAgainBtn);
      aBtn.setEnabled(false);
      bBtn.setEnabled(false);
      cBtn.setEnabled(false);
      dBtn.setEnabled(false);
      nextBtn.setEnabled(false);
      result = (int) ((correctUserAns / (double) totalQuestions) * 100);

      if (correctUserAns < 5) {
         percentage.setForeground(new Color(200, 0, 0));
         number_right.setForeground(new Color(200, 0, 0));
      } else if (correctUserAns >= 5 && correctUserAns <= 7) {
         percentage.setForeground(new Color(255, 165, 0));
         number_right.setForeground(new Color(255, 165, 0));
      } else {
         percentage.setForeground(new Color(0, 200, 0));
         number_right.setForeground(new Color(0, 200, 0));
      }
      result = (int)((correctUserAns/(double)totalQuestions)*100);
      textfield.setText("Results");
      textArea.setText("");
      aLbl.setText("");
      bLbl.setText("");
      cLbl.setText("");
      dLbl.setText("");
      number_right.setText("(" + correctUserAns + "/" + totalQuestions + ")");
      percentage.setText(result + "%");
      frame.add(number_right);
      frame.add(percentage);
   }
}
