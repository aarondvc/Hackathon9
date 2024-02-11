import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class HeroQuiz implements ActionListener{
   String [] questions = { 
      "Which superhero is known as the 'Man of Steel'?" ,
      "What is the name of Spider-Man's alter-ego?",
      "Who is the king of Wakanda and also known as the Black Panther",
      "What is the real name of the superhero known as Wonder Woman?",
      "What is the civilian name of the superhero known as Captain America?",
      "Which superhero is known for wielding a magical hammer called Mjolnir?", "What comic was Batman's first appearance?"
   };

   String[][] choices = {
      {"Thor", "Superman", "Iron Man", "Wolverine"},
      {"Barry Allen", "Steve Rodgers", "Peter Parker", "Bruce Banner"},
      {"T'Challa", "Bruce Wayne", "Tony Stark", "Clark Kent"},
      {"Diana Prince", "Natasha Romanoff", "Jessica Jones", "Carol Danvers"},
      {"Tony Stark", "Bruce Wayne", "Clark Kent", "Steve Rodgers"},
      {"Hulk", "Thor", "Captain America", "Green Lantern"}, {"Detective Comics #18", "Detective Comics #20", "Action Comics #3", "Detective Comics #27"}
   };

   char[] answers = {
      'B',
      'C',
      'A',
      'A',
      'D',
      'B',
      'D'
   };

   String[] images = {}
   
   //What is the Hulk's strength level
   //What comic was Batman's first appearance?
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

   JButton aBtn = new JButton();
   JButton bBtn = new JButton();
   JButton cBtn = new JButton();
   JButton dBtn = new JButton();
   JLabel aLbl = new JLabel();
   JLabel bLbl = new JLabel();
   JLabel cLbl = new JLabel();
   JLabel dLbl = new JLabel();
   JButton nextBtn = new JButton();
   ImageIcon display = new ImageIcon("resources/byte.jpeg");
   JLabel displayLbl = new JLabel();

   JTextField number_right = new JTextField();
   JTextField percentage = new JTextField();


   public HeroQuiz() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(650,650);
      frame.getContentPane().setBackground(new Color(108,183,240));
      frame.setResizable(false);
      frame.setLayout(null);

      //textfield.setBounds(0, 25, 400, 50);
      textfield.setBounds(0,0,650,50);
      textfield.setBackground(new Color(108,183,240));
      textfield.setForeground(new Color(155,0,0));
      textfield.setFont(new Font("Arial",Font.BOLD, 30));
      textfield.setBorder(BorderFactory.createBevelBorder(5));
      textfield.setHorizontalAlignment(JTextField.CENTER);
      textfield.setEditable(false);
      textfield.setText("Superhero Quiz");

      textArea.setBounds(0, 50, 650, 50);
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      textArea.setBackground(null);
      textArea.setForeground(new Color(155,0,0));
      textArea.setFont(new Font("Arial",Font.BOLD, 25));
      textArea.setBorder(BorderFactory.createBevelBorder(5));
      textArea.setEditable(false);
      //textArea.setText("SAMPLE TEXT");

      aBtn.setBounds(0,100,100,100);
      aBtn.setFont(new Font("Ariel",Font.BOLD, 35));
      aBtn.setFocusable(false);
      aBtn.addActionListener(this);
      aBtn.setText("A");

      bBtn.setBounds(0,200,100,100);
      bBtn.setFont(new Font("Ariel",Font.BOLD, 35));
      bBtn.setFocusable(false);
      bBtn.addActionListener(this);
      bBtn.setText("B");

      cBtn.setBounds(0,300,100,100);
      cBtn.setFont(new Font("Ariel",Font.BOLD, 35));
      cBtn.setFocusable(false);
      cBtn.addActionListener(this);
      cBtn.setText("C");

      dBtn.setBounds(0,400,100,100);
      dBtn.setFont(new Font("Ariel",Font.BOLD, 35));
      dBtn.setFocusable(false);
      dBtn.addActionListener(this);
      dBtn.setText("D");

      aLbl.setBounds(125,100,500,100);
      aLbl.setBackground(new Color(50,50,50));
      aLbl.setForeground(new Color(0,0,0));
      aLbl.setFont(new Font("Arial",Font.BOLD,35));

      bLbl.setBounds(125,200,500,100);
      bLbl.setBackground(new Color(50,50,50));
      bLbl.setForeground(new Color(0,0,0));
      bLbl.setFont(new Font("Arial",Font.BOLD,35));

      cLbl.setBounds(125,300,500,100);
      cLbl.setBackground(new Color(50,50,50));
      cLbl.setForeground(new Color(0,0,0));
      cLbl.setFont(new Font("Arial",Font.BOLD,35));
      
      dLbl.setBounds(125,400,500,100);
      dLbl.setBackground(new Color(50,50,50));
      dLbl.setForeground(new Color(0,0,0));
      dLbl.setFont(new Font("Arial",Font.BOLD,35));
  
      frame.add(aLbl);
      frame.add(bLbl);
      frame.add(cLbl);
      frame.add(dLbl);

      //picture settings
      //displayLbl.setBounds(125, 50, 400, 200);
      //displayLbl.setIcon(display);
      //displayLbl.setHorizontalAlignment(JLabel.CENTER);

      //add picture to the frame
      frame.add(displayLbl);
      
      frame.add(textArea);
      frame.add(textfield);
      frame.add(aBtn);
      frame.add(bBtn);
      frame.add(cBtn);
      frame.add(dBtn);
      number_right.setBounds(225,225,200,100);
      number_right.setBackground(new Color(25,25,25));
      number_right.setForeground(new Color(155,0,0));
      number_right.setFont(new Font ("Arial", Font.BOLD, 50));
      number_right.setBorder(BorderFactory.createBevelBorder(1));
      number_right.setHorizontalAlignment(JTextField.CENTER);
      number_right.setEditable(false);

      percentage.setBounds(225,325,200,100);
      percentage.setBackground(new Color(25,25,25));
      percentage.setForeground(new Color(155,0,0));
      percentage.setBorder(BorderFactory.createBevelBorder(1));
      percentage.setHorizontalAlignment(JTextField.CENTER);
      percentage.setEditable(false);

      nextBtn.setBounds(0, 500, 100, 100);
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

   public void nextQuestion() {
      if(index>=totalQuestions) {
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
      aLbl.setForeground(new Color(0,0,0));
      bLbl.setForeground(new Color(0,0,0));
      cLbl.setForeground(new Color(0,0,0));
      dLbl.setForeground(new Color(0,0,0));
      nextQuestion();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      aBtn.setEnabled(false);
      bBtn.setEnabled(false);
      cBtn.setEnabled(false);
      dBtn.setEnabled(false);

      if(e.getSource()==aBtn) {
         correctAns = 'A';
         if(correctAns == answers[index]) {
            correctUserAns++;
         }
      }
      if(e.getSource()==bBtn) {
         correctAns = 'B';
         if(correctAns == answers[index]) {
            correctUserAns++;
         }
      }
      if(e.getSource()==cBtn) {
         correctAns = 'C';
         if(correctAns == answers[index]) {
            correctUserAns++;  
         }
      }

      if(e.getSource()==dBtn) {
         correctAns = 'D';
         if(correctAns == answers[index]) {
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

      if(answers[index] != 'A') {
            aLbl.setForeground(new Color(255,0,0));
      }
      if(answers[index] != 'B') {
            bLbl.setForeground(new Color(255,0,0));
      }
      if(answers[index] != 'C') {
            cLbl.setForeground(new Color(255,0,0));
      }
      if(answers[index] != 'D') {
            dLbl.setForeground(new Color(255,0,0));
      }
      if(answers[index] == 'A') {
            aLbl.setForeground(new Color(0,255,0));
      }
      if(answers[index] == 'B') {
            bLbl.setForeground(new Color(0,255,0));
      }
      if(answers[index] == 'C') {
            cLbl.setForeground(new Color(0,255,0));
      }
      if(answers[index] == 'D') {
            dLbl.setForeground(new Color(0,255,0));
      }


   }

   public void results() {
      aBtn.setEnabled(false);
      bBtn.setEnabled(false);
      cBtn.setEnabled(false);
      dBtn.setEnabled(false);
      result = (int)((correctUserAns/(double)totalQuestions)*100);
      textfield.setText("Results");
      textArea.setText("");
      aLbl.setText("");
      bLbl.setText("");
      cLbl.setText("");
      dLbl.setText("");
      number_right.setText("("+correctUserAns+"/"+totalQuestions+")");
      percentage.setText(result+"%");

      frame.add(number_right);
      frame.add(percentage);
   }
}
