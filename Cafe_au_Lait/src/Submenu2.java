import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Submenu2 extends Order{

	 JFrame Submenuframe2;
	 BufferedReader in;
	 PrintWriter out;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Submenu2 window = new Submenu2();
		             window.Submenuframe2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Submenu2() {
		initialize();
		this.Submenuframe2.setVisible(true);
	}

	public void initialize()
	{
		 Submenuframe2 = new JFrame();
		 Submenuframe2.getContentPane().setBackground(Color.PINK);
		 Submenuframe2.getContentPane().setLayout(null);
		 Submenuframe2.setTitle("Submenu");
		 Submenuframe2.setSize(400, 200);
		 Submenuframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	     JButton complete = new JButton("Complete");
	      complete.setBackground(Color.WHITE);
	      complete.addActionListener(new ActionListener() {
	      	@Override
	    	  public void actionPerformed(ActionEvent arg0) {
	      		Submenuframe2.setVisible(false);
	  			Order.Orderframe.setVisible(true);
	      	}
	      });
	      complete.setBounds(536, 403, 184, 100);
	      Submenuframe2.getContentPane().add(complete);
	      
	      
	      JButton sizeL = new JButton("L(2 shot)");
	      sizeL.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      	}
	      });
	      sizeL.setBounds(227, 158, 133, 54);
	      sizeL.setBackground(Color.PINK);
	      Submenuframe2.getContentPane().add(sizeL);
	      
	      JButton sizeS = new JButton("S(1 shot)");
	      sizeS.setBounds(403, 158, 133, 54);
	      sizeS.setBackground(Color.PINK);
	      Submenuframe2.getContentPane().add(sizeS);
	      
	      JButton kindI = new JButton("Ice");
	      kindI.setBounds(403, 268, 133, 54);
	      kindI.setBackground(Color.PINK);
	      Submenuframe2.getContentPane().add(kindI);
	      
	      JLabel selected = new JLabel("\uD604\uC7AC \uC120\uD0DD\uB41C \uBA54\uB274 ");
	      selected.setBounds(125, 31, 148, 46);
	      Submenuframe2.getContentPane().add(selected);
	      
	      JLabel lblNewLabel_4 = new JLabel("\uC0AC\uC774\uC988");
	      lblNewLabel_4.setBounds(125, 158, 117, 46);
	      Submenuframe2.getContentPane().add(lblNewLabel_4);
	      
	      JPanel menupanel = new JPanel();
	      menupanel.setBackground(Color.WHITE);
	      menupanel.setBounds(256, 31, 215, 46);
	      Submenuframe2.getContentPane().add(menupanel);
	      
	      JLabel lblNewLabel = new JLabel("\uC885\uB958");
	      lblNewLabel.setBounds(125, 286, 62, 18);
	      Submenuframe2.getContentPane().add(lblNewLabel);
	      
	      JButton kindH = new JButton((Icon) null);
	      kindH.setBounds(227, 268, 133, 54);
	      Submenuframe2.getContentPane().add(kindH);
	      kindH.setText("Hot");
	      kindH.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      	}
	      });
	      kindH.setBackground(Color.PINK);
	      
	      JPanel panel = new JPanel();
	      panel.setBackground(Color.WHITE);
	      panel.setBounds(70, 126, 650, 234);
	      Submenuframe2.getContentPane().add(panel);
	      Submenuframe2.setResizable(false);
	     
	      Submenuframe2.setBounds(400, 200, 800, 600);
	      Submenuframe2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     
	}
	
}
