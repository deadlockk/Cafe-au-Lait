import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.Font;
import java.awt.Graphics;

public class Reservation implements Runnable 
{
   JFrame RESframe;
   JPanel RESpanel;
   JTextField chatInput;
   JTextArea chatRoom;

   // Socket 사용을 위한 변수.
   BufferedReader in;
   PrintWriter out;
   String txt_1, txt_2, text;
   // static int k = 0;

   public static void main(String[] args) 
   {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Reservation window = new Reservation();
               window.RESframe.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   private String getServerAddress() 
   {
      return "127.0.0.1";
      // return "192.168.35.16";
   }

   public Reservation() 
   {
      RESframe = new JFrame();
      RESframe.setSize(800, 800); // Frame의 크기 설정
      ImageIcon chat = new ImageIcon("chat.png");
      RESpanel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(chat.getImage(), 0, 0, null);
            setOpaque(false);// 배경 띄워주기
            super.paintComponent(g);
         }
      };
      RESpanel.setLayout(null);
      RESframe.getContentPane().add(RESpanel);

      JButton send = new JButton("SEND");
      send.setBackground(new Color(0, 0, 0));
      send.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
      send.setForeground(new Color(255, 215, 0));
      send.setBounds(544, 598, 76, 51);
      RESpanel.add(send);

      send.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            chatRoom.append(chatInput.getText() + '\n');
            chatInput.setText("");
         }
      });

      chatInput = new JTextField();
      chatInput.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
      chatInput.setBounds(115, 598, 415, 51);
      RESpanel.add(chatInput);
      chatInput.setColumns(10);

      chatInput.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            out.println("RE" + Server.client_num + chatInput.getText());
            chatRoom.append("<Client> : " + chatInput.getText() + '\n');
            chatInput.setText("");
         }
      });

      chatRoom = new JTextArea();
      chatRoom.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
      chatRoom.setBounds(115, 228, 568, 328);
      RESpanel.add(chatRoom);
      chatRoom.setEditable(false);
      RESframe.setBounds(100, 100, 800, 800);
   }

   @Override
   public void run()
   {
      String serverAddress = getServerAddress();
      Socket socket;

      try 
      {
         socket = new Socket(serverAddress, 9001);
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         out = new PrintWriter(socket.getOutputStream(), true);

      } 
      catch (UnknownHostException e) 
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } 
      catch (IOException e) 
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      while (true) 
      {
         String line = null;
         try 
         {
            line = in.readLine();
         } 
         catch (IOException e) 
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         chatRoom.append("<From Server> : " + line + '\n');
      }
   }
}