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

public class Order extends Main_page{
   
   static JFrame Orderframe;
   BufferedReader in;
   PrintWriter out;
   private JTextField textField;
   private JTextField textField_1;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Order window = new Order();
               window.Orderframe.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public Order() {
      initialize();
      this.Orderframe.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   public void initialize() {
      Orderframe = new JFrame();
      Orderframe.getContentPane().setBackground(Color.PINK);
      Orderframe.getContentPane().setLayout(null);
      Orderframe.setTitle("order");
      Orderframe.setSize(400, 200);
      Orderframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JButton completeorder = new JButton("order");
      completeorder.setBackground(Color.WHITE);
      completeorder.addActionListener(new ActionListener() {
    	  @Override
      	public void actionPerformed(ActionEvent arg0) {
    		Orderframe.setVisible(false);
			Main_page.frame.setVisible(true);
      	}
      });
      completeorder.setBounds(520, 432, 184, 100);
      Orderframe.getContentPane().add(completeorder);
      
      JButton americano = new JButton(new ImageIcon("tea.png"));
      americano.setBounds(109, 123, 133, 100);
      Orderframe.getContentPane().add(americano);
      americano.setBackground(Color.PINK);
      americano.addActionListener(new ActionListener() {
    	  @Override
      	public void actionPerformed(ActionEvent e) {
    		  Submenu1 SM= new Submenu1();
      	}
      });
      
      
      JButton espresso = new JButton("");
      espresso.addActionListener(new ActionListener() {
    	  @Override
      	public void actionPerformed(ActionEvent arg0) {
    		Submenu1 SM= new Submenu1();
      	}
      });
      espresso.setIcon(new ImageIcon("espresso.png"));
      espresso.setBounds(256, 123, 133, 100);
      espresso.setBackground(Color.PINK);
      Orderframe.getContentPane().add(espresso);
      
      JButton greentea = new JButton("");
      greentea.addActionListener(new ActionListener() {
    	  @Override
      	public void actionPerformed(ActionEvent e) {
    		  Submenu2 SM= new Submenu2();
      	}
      });
      greentea.setIcon(new ImageIcon("tea-cup.png"));
      greentea.setBounds(550, 268, 133, 100);
      greentea.setBackground(Color.PINK);
      Orderframe.getContentPane().add(greentea);
      
      JButton frappe = new JButton("");
      frappe.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		Submenu2 SM= new Submenu2();
      	}
      });
      frappe.setIcon(new ImageIcon("frappe.png"));
      frappe.setBounds(403, 123, 133, 100);
      frappe.setBackground(Color.PINK);
      Orderframe.getContentPane().add(frappe);
      
      JButton juice = new JButton("");
      juice.addActionListener(new ActionListener() {
      	@Override
    	  public void actionPerformed(ActionEvent e) {
      		Submenu2 SM= new Submenu2();
      	}
      });
      juice.setIcon(new ImageIcon("milk-bottle.png"));
      juice.setBounds(403, 268, 133, 100);
      juice.setBackground(Color.PINK);
      Orderframe.getContentPane().add(juice);
      
      JButton latte = new JButton("");
      latte.addActionListener(new ActionListener() {
      	@Override
    	  public void actionPerformed(ActionEvent e) {
      		Submenu1 SM= new Submenu1();
      	}
      });
      latte.setIcon(new ImageIcon("latte.png"));
      latte.setBounds(550, 123, 133, 100);
      latte.setBackground(Color.PINK);
      Orderframe.getContentPane().add(latte);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBounds(109, 432, 361, 100);
      Orderframe.getContentPane().add(panel_1);
      
      JButton mocha = new JButton(new ImageIcon("mocha.png"));
      mocha.addActionListener(new ActionListener() {
      	@Override
    	  public void actionPerformed(ActionEvent e) {
      		Submenu1 SM= new Submenu1();
      	}
      });
      mocha.setBounds(256, 268, 133, 100);
      mocha.setBackground(Color.PINK);
      Orderframe.getContentPane().add(mocha);
      
      JButton cappuccino = new JButton(new ImageIcon("cappuccino.png"));
      cappuccino.addActionListener(new ActionListener() {
      	@Override
    	  public void actionPerformed(ActionEvent e) {
      		Submenu1 SM= new Submenu1();
      	}
      });
      cappuccino.setBounds(109, 268, 133, 100);
      cappuccino.setBackground(Color.PINK);
      Orderframe.getContentPane().add(cappuccino);
      
      JLabel lblGreentea = new JLabel("Greentea");
      lblGreentea.setLabelFor(greentea);
      lblGreentea.setBounds(589, 371, 115, 30);
      Orderframe.getContentPane().add(lblGreentea);
      
      JLabel lblJuice = new JLabel("Juice");
      lblJuice.setBounds(448, 371, 115, 30);
      Orderframe.getContentPane().add(lblJuice);
      
      JLabel lblNewLabel = new JLabel("Mocha");
      lblNewLabel.setBounds(305, 380, 62, 18);
      Orderframe.getContentPane().add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("Cappuccino");
      lblNewLabel_1.setBounds(141, 380, 101, 18);
      Orderframe.getContentPane().add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("Americano");
      lblNewLabel_2.setBounds(141, 235, 90, 18);
      Orderframe.getContentPane().add(lblNewLabel_2);
      
      JLabel lblNewLabel_3 = new JLabel("Espresso");
      lblNewLabel_3.setBounds(292, 235, 62, 18);
      Orderframe.getContentPane().add(lblNewLabel_3);
      
      JLabel lblNewLabel_4 = new JLabel("Frappe");
      lblNewLabel_4.setBounds(441, 235, 62, 18);
      Orderframe.getContentPane().add(lblNewLabel_4);
      
      JLabel lblNewLabel_5 = new JLabel("Latte");
      lblNewLabel_5.setBounds(591, 235, 62, 18);
      Orderframe.getContentPane().add(lblNewLabel_5);
      
      JPanel panel_2 = new JPanel();
      panel_2.setBounds(87, 106, 617, 307);
      Orderframe.getContentPane().add(panel_2);
      
      textField = new JTextField();
      textField.setBounds(141, 64, 73, 30);
      Orderframe.getContentPane().add(textField);
      textField.setColumns(10);
      
      textField_1 = new JTextField();
      textField_1.setColumns(10);
      textField_1.setBounds(294, 64, 73, 30);
      Orderframe.getContentPane().add(textField_1);
      
      JLabel lblNewLabel_6 = new JLabel("Card.no");
      lblNewLabel_6.setBounds(87, 58, 158, 36);
      Orderframe.getContentPane().add(lblNewLabel_6);
      
      JLabel lblNewLabel_7 = new JLabel("Table.no");
      lblNewLabel_7.setBounds(228, 70, 62, 18);
      Orderframe.getContentPane().add(lblNewLabel_7);
      Orderframe.setResizable(false);
     
      Orderframe.setBounds(400, 200, 800, 600);
      Orderframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
}