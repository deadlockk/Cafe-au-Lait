import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Main_page extends JFrame {
	
	public JFrame frame;
	private JPanel contentPane;
	public static Main_page Main_page;
	// 소켓 이용하기 위한 변수.
	BufferedReader in;
    PrintWriter out;
    String name;
    String whi = null;
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_page = new Main_page();
					Main_page.frame.setVisible(true);
					Main_page.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	  private String getServerAddress()
	    {
	    	return "127.0.0.1";
	       // return JOptionPane.showInputDialog(frame, "Enter IP Address of the Server:",
	         //   "Welcome to the Chatter", JOptionPane.QUESTION_MESSAGE);
	    }
	  
	  private void run() throws IOException 
	    {
		  int i = 0;
	        // Make connection and initialize streams
	        String serverAddress = getServerAddress();
	        Socket socket = new Socket(serverAddress, 9001);
	       
	        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        out = new PrintWriter(socket.getOutputStream(), true);

	        // Process all messages from server, according to the protocol.
	        //while (true) 
	        while(i == 0)
	        {
	        	i++;
	        	System.out.println("THeLAkhdalskjdgdl");
	           // String line = in.readLine();
	            
	            
	        }
	    }
	  
	public Main_page() {
		M_Page();
	}

	/**
	 * Create the frame.
	 * 
	 */
	public void M_Page() {
		frame = new JFrame();
		frame.setTitle("Cafe"); // Frame의 타이틀 이름 주기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Frame의 X를 누를경우 종료
		frame.setSize(1500, 1050); // Frame의 크기 설정
		ImageIcon background = new ImageIcon("background.jpg");
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);

		JButton Check_the_seat = new JButton("Check the seat");
		Check_the_seat.setForeground(new Color(255, 228, 225));
		Check_the_seat.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
		Check_the_seat.setFocusable(false);
		Check_the_seat.setBorderPainted(false);
		Check_the_seat.setContentAreaFilled(false);
		Check_the_seat.setBounds(78, 72, 453, 80);
		contentPane.add(Check_the_seat); // 패널에 버튼 add

		Check_the_seat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				CheckSeat CS = new CheckSeat();
			}

		});
		Check_the_seat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Check_the_seat.setForeground(new Color(255, 228, 225));
				Check_the_seat.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Check_the_seat.setForeground(new Color(255, 228, 225));
				Check_the_seat.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
			}
		});
		
		JButton Change_the_seat = new JButton("Change the seat");
		Change_the_seat.setForeground(new Color(255, 228, 225));
		Change_the_seat.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
		Change_the_seat.setBorderPainted(false);
		Change_the_seat.setContentAreaFilled(false);
		Change_the_seat.setFocusable(false);
		Change_the_seat.setBounds(14, 182, 592, 80);
		contentPane.add(Change_the_seat); // 패널에 버튼 add

		Change_the_seat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ChangeSeat CH = new ChangeSeat();
			}
		});
		Change_the_seat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Change_the_seat.setForeground(new Color(255, 228, 225));
				Change_the_seat.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Change_the_seat.setForeground(new Color(255, 228, 225));
				Change_the_seat.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
			}
		});

		JButton Order = new JButton("Order");
		Order.setForeground(new Color(255, 228, 225));
		Order.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
		Order.setBorderPainted(false);
		Order.setContentAreaFilled(false);
		Order.setFocusable(false);
		Order.setBounds(151, 295, 304, 85);
		contentPane.add(Order); // 패널에 버튼 add

		Order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Order.setForeground(new Color(255, 228, 225));
				Order.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Order.setForeground(new Color(255, 228, 225));
				Order.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
			}
		});
		Order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Order OD = new Order();
			}
		});
		
		JButton btnServerninfo = new JButton("Server Info");
		btnServerninfo.setBorderPainted(false);
		btnServerninfo.setFocusable(false);
		btnServerninfo.setBackground(new Color(255, 228, 225));
		btnServerninfo.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 23));
		btnServerninfo.setBounds(1239, 895, 179, 71);
		contentPane.add(btnServerninfo);
		btnServerninfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Password PW = new Password();
			}
		});
	}
}