import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class Server /*extends Main_page*/{
   
   JFrame serverframe;
   BufferedReader in;
   PrintWriter out;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Server window = new Server();
               window.serverframe.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public Server() {
      initialize();
      this.serverframe.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   public void initialize() {
      serverframe = new JFrame();
      serverframe.getContentPane().setBackground(new Color(221, 160, 221));
      serverframe.getContentPane().setLayout(null);
      serverframe.setTitle("server");
      serverframe.setSize(400, 200);
      serverframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBackground(new Color(175, 238, 238));
      panel_1.setBounds(490, 60, 222, 385);
      serverframe.getContentPane().add(panel_1);
      
      JLabel lblNewLabel_3 = new JLabel("Management");
      lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 24));
      lblNewLabel_3.setBounds(53, 12, 210, 35);
      serverframe.getContentPane().add(lblNewLabel_3);
      
      JPanel panel_2 = new JPanel();
      panel_2.setBackground(new Color(255, 192, 203));
      panel_2.setBounds(53, 60, 120, 120);
      serverframe.getContentPane().add(panel_2);
      
      JPanel panel = new JPanel();
      panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
      panel.setBackground(new Color(255, 192, 203));
      panel.setBounds(187, 60, 120, 120);
      serverframe.getContentPane().add(panel);
      
      JPanel panel_3 = new JPanel();
      panel_3.setBackground(new Color(255, 192, 203));
      panel_3.setBounds(321, 60, 120, 120);
      serverframe.getContentPane().add(panel_3);
      
      JPanel panel_4 = new JPanel();
      panel_4.setBackground(new Color(255, 192, 203));
      panel_4.setBounds(53, 192, 120, 120);
      serverframe.getContentPane().add(panel_4);
      
      JPanel panel_5 = new JPanel();
      panel_5.setBackground(new Color(250, 240, 230));
      panel_5.setBounds(187, 192, 120, 120);
      serverframe.getContentPane().add(panel_5);
      
      JPanel panel_6 = new JPanel();
      panel_6.setBounds(321, 192, 120, 120);
      serverframe.getContentPane().add(panel_6);
      
      JPanel panel_7 = new JPanel();
      panel_7.setBounds(53, 324, 120, 120);
      serverframe.getContentPane().add(panel_7);
      
      JPanel panel_8 = new JPanel();
      panel_8.setBackground(new Color(250, 235, 215));
      panel_8.setBounds(187, 324, 120, 120);
      serverframe.getContentPane().add(panel_8);
      serverframe.setResizable(false);
     
      serverframe.setBounds(400, 200, 800, 600);
      serverframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
}