import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.awt.*;
import javax.swing.*;

public class HeroQuiz implements ActionListener {
   public static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
         .version(HttpClient.Version.HTTP_2)
         .followRedirects(HttpClient.Redirect.NORMAL)
         .build();

   public static Gson GSON = new GsonBuilder()
         .setPrettyPrinting() // enable nice output when printing
         .create();

   String[] questions = {
         "What is the Hulk's strength level?", "What comic was Batman's first appearance?",
   };

   private static final String API_KEY = "122093232008221254";
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
      frame.setSize(400, 650);
      frame.getContentPane().setBackground(new Color(136, 206, 235));
      frame.setResizable(false);
      frame.setLayout(null);

      title.setBounds(0, 25, 400, 50);
      title.setBackground(null);
      title.setForeground(new Color(186, 12, 47));
      title.setFont(new Font("Arial", Font.BOLD, 36));
      title.setBorder(BorderFactory.createBevelBorder(5));
      title.setHorizontalAlignment(JTextField.CENTER);
      title.setEditable(false);
      title.setText("SuperHero Quiz");

      questionArea.setBounds(0, 175, 400, 50);
      questionArea.setLineWrap(true);
      questionArea.setWrapStyleWord(true);
      questionArea.setBackground(null);
      questionArea.setForeground(new Color(186, 12, 47));
      questionArea.setFont(new Font("Arial", Font.BOLD, 20));
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

   private SuperheroApiResponse getResponse() {
      SuperheroApiResponse[] supeResp = new SuperheroApiResponse[1];

      String hero;
      String query = "https://superheroapi.com/api/access-token"
            + URLEncoder.encode(API_KEY, StandardCharsets.UTF_8)
            + "/search/" + URLEncoder.encode(hero, StandardCharsets.UTF_8);
      URI url = URI.create(query);
      HttpRequest req = HttpRequest.newBuilder()
            .uri(url)
            .build();
      try {
         HttpResponse<String> resp = HTTP_CLIENT.<String>send(req, BodyHandlers.ofString());
         String respBody = resp.body();
         System.out.println(respBody);
         supeResp[0] = GSON.<SuperheroApiResponse>fromJson(respBody, SuperheroApiResponse.class);
      } catch (IOException | InterruptedException ex) {
         System.err.println(ex.toString());
      }

      return supeResp[0];
   }
}
