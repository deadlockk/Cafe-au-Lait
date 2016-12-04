import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChangeSeat extends Main_page 
{
   JFrame ChangeFrame;
   JPanel contentPane;
   JLabel head;
   PrintWriter out;
   String txt_1, txt_2, text;

   public static void main(String[] args) 
   {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try 
            {
               ChangeSeat framechange = new ChangeSeat();
               framechange.ChangeFrame.setVisible(true);
            } 
            catch (Exception e) 
            {
               e.printStackTrace();
            }
         }
      });
   }

   private String getServerAddress() 
   {
      return "127.0.0.1";
    //   return "192.168.35.16";
   }

   private JTextField CardField;
   private JTextField Tablefield;

   public ChangeSeat() throws IOException 
   {
      String serverAddress = getServerAddress();
      Socket socket = new Socket(serverAddress, 9001);

      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);

     ChangeFrame = new JFrame();
     ChangeFrame.setTitle("Change the seat"); // Frame의 타이틀 이름 주기s
     ChangeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     ChangeFrame.setSize(800, 800); // Frame의 크기 설정
     ImageIcon background = new ImageIcon("changeseat.png");
     contentPane = new JPanel() {
      public void paintComponent(Graphics g) {
         g.drawImage(background.getImage(), 0, 0, 800, 800, null);
         setOpaque(false);// 배경 띄워주기s
         super.paintComponent(g);
      }
   };

   contentPane.setVisible(true);
   ChangeFrame.getContentPane().add(contentPane);
   ChangeFrame.setVisible(true);
   contentPane.setLayout(null);
   Tablefield = new JTextField();
   Tablefield.setHorizontalAlignment(SwingConstants.CENTER);
   Tablefield.setForeground(new Color(0, 0, 102));
   Tablefield.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 30));
   Tablefield.setBounds(299, 321, 209, 48);
   contentPane.add(Tablefield);
   Tablefield.setColumns(10);

   CardField = new JTextField();
   CardField.setHorizontalAlignment(SwingConstants.CENTER);
   CardField.setForeground(new Color(0, 0, 102));
   CardField.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 30));
   CardField.setBounds(299, 508, 209, 48);
   contentPane.add(CardField);
   CardField.setColumns(10);
      
      JButton go_back = new JButton("BACK");
      go_back.setForeground(new Color(255, 215, 0));
      go_back.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 35));
      go_back.setBounds(215, 644, 122, 27);
      contentPane.add(go_back);
      go_back.setContentAreaFilled(false);
      go_back.setBorderPainted(false);
      go_back.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent arg0) {
             ChangeFrame.setVisible(false);
             Main_page.frame.setVisible(true);
          }
       });
      
      JButton send = new JButton("SEND");
      send.setForeground(new Color(255, 215, 0));
      send.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 35));
      send.setContentAreaFilled(false);
      send.setBorderPainted(false);
      send.setBounds(469, 644, 122, 27);
      contentPane.add(send);
  
       send.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
             txt_1 = "Table : " + Tablefield.getText();
             txt_2 = "Card : " + CardField.getText();
             text = txt_1 + txt_2;
             out.println("CH" + text);
             ChangeFrame.setVisible(false);
             Main_page.frame.setVisible(true);
          }
       });
   }
}