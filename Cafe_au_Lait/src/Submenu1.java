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

public class Submenu1 extends Order{
   
   JFrame Submenu1;
   BufferedReader in;
   PrintWriter out;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Submenu1 window = new Submenu1();
               window.Submenu1.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public Submenu1() {
      initialize();
      this.Submenu1.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   public void initialize() {
      Submenu1 = new JFrame();
      Submenu1.getContentPane().setBackground(Color.PINK);
      Submenu1.getContentPane().setLayout(null);
      Submenu1.setTitle("submenu");
      Submenu1.setSize(400, 200);
      Submenu1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JButton complete = new JButton("Complete");
      complete.setBackground(Color.WHITE);
      complete.addActionListener(new ActionListener() {
    	  @Override
      	public void actionPerformed(ActionEvent arg0) {
    		Submenu1.setVisible(false);
  			Order.Orderframe.setVisible(true);
      	}
      });
      complete.setBounds(532, 422, 184, 100);
      Submenu1.getContentPane().add(complete);
      
      
      JButton sizeL = new JButton("L(2 shot)");
      sizeL.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      	}
      });
      sizeL.setBounds(227, 158, 133, 54);
      sizeL.setBackground(Color.PINK);
      Submenu1.getContentPane().add(sizeL);
      
      JButton shot1 = new JButton("1 shot");
      shot1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      shot1.setBounds(403, 320, 133, 54);
      shot1.setBackground(Color.PINK);
      Submenu1.getContentPane().add(shot1);
      
      JButton sizeS = new JButton("S(1 shot)");
      sizeS.setBounds(403, 158, 133, 54);
      sizeS.setBackground(Color.PINK);
      Submenu1.getContentPane().add(sizeS);
      
      JButton kindI = new JButton("Ice");
      kindI.setBounds(403, 235, 133, 54);
      kindI.setBackground(Color.PINK);
      Submenu1.getContentPane().add(kindI);
      
      JButton shotN = new JButton("No");
      shotN.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      shotN.setBounds(227, 320, 133, 54);
      shotN.setBackground(Color.PINK);
      Submenu1.getContentPane().add(shotN);
      
      JButton kindH = new JButton((Icon) null);
      kindH.setText("Hot");
      kindH.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      kindH.setBounds(227, 235, 133, 54);
      kindH.setBackground(Color.PINK);
      Submenu1.getContentPane().add(kindH);
      
      JLabel selected = new JLabel("\uD604\uC7AC \uC120\uD0DD\uB41C \uBA54\uB274 ");
      selected.setBounds(125, 31, 148, 46);
      Submenu1.getContentPane().add(selected);
      
      JLabel lblNewLabel_4 = new JLabel("\uC0AC\uC774\uC988");
      lblNewLabel_4.setBounds(125, 158, 117, 46);
      Submenu1.getContentPane().add(lblNewLabel_4);
      
      JPanel menupanel = new JPanel();
      menupanel.setBackground(Color.WHITE);
      menupanel.setBounds(256, 31, 215, 46);
      Submenu1.getContentPane().add(menupanel);
      
      JLabel lblNewLabel = new JLabel("\uC885\uB958");
      lblNewLabel.setBounds(125, 253, 62, 18);
      Submenu1.getContentPane().add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("\uC0F7 \uCD94\uAC00");
      lblNewLabel_1.setBounds(125, 334, 62, 18);
      Submenu1.getContentPane().add(lblNewLabel_1);
      
      JButton shot2 = new JButton("2 shot");
      shot2.setBackground(Color.PINK);
      shot2.setBounds(568, 320, 133, 54);
      Submenu1.getContentPane().add(shot2);
      
      JPanel submenuList = new JPanel();
      submenuList.setBackground(Color.WHITE);
      submenuList.setBounds(76, 128, 640, 270);
      Submenu1.getContentPane().add(submenuList);
      Submenu1.setResizable(false);
     
      Submenu1.setBounds(400, 200, 800, 600);
      Submenu1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
}