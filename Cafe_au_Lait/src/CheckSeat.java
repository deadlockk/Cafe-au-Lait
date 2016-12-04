import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.mysql.jdbc.Connection;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckSeat extends Main_page 
{
	JFrame frameCheckSeat;
	Table table_info;
	BufferedReader in;
	PrintWriter out;
	String txt_1, txt_2, text;
	ImageIcon img2 = new ImageIcon("two.png");
	Image originImg_2 = img2.getImage();
	Image changedImg_2 = originImg_2.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	ImageIcon bb = new ImageIcon(changedImg_2);

	int chk1 = 0, chk2 = 0, chk3 = 0, chk4 = 0, chk5 = 0, chk6 = 0, chk7 = 0, chk8 = 0;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					CheckSeat frameseat = new CheckSeat();
					frameseat.setVisible(true);
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
		// return "192.168.35.16";
	}

	public CheckSeat() throws IOException 
	{
		frameCheckSeat = new JFrame();
		
		try 
		{
			Connection con = null;
			 con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/NETWORK","root", "12345");
		
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery("Select Table_no from info where Check_no = 1");
			if (st.execute("Select Table_no from info where Check_no = 1")) 
			{
				rs = st.getResultSet();
			}

			while (rs.next()) 
			{
				String str1 = rs.getString(1);
				/// 사용중인 테이블을 check 해준다
				switch (str1) {
				case "T_1":
					chk1 = 1;
					break;
				case "T_2":
					chk2 = 1;
					break;
				case "T_3":
					chk3 = 1;
					break;
				case "T_4":
					chk4 = 1;
					break;
				case "F_1":
					chk5 = 1;
					break;
				case "F_2":
					chk6 = 1;
					break;
				case "G_1":
					chk7 = 1;
					break;
				case "G_2":
					chk8 = 1;
					break;
				}
			}
		} 
		catch (SQLException sqex) 
		{
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	
		ImageIcon img1 = new ImageIcon("CAFE.png");
		Image originImg_1 = img1.getImage();
		Image changedImg_1 = originImg_1.getScaledInstance(1300, 800, Image.SCALE_SMOOTH);
		ImageIcon aa = new ImageIcon(changedImg_1);
		JPanel Cafe = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(aa.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};

		frameCheckSeat.getContentPane().add(Cafe);
		frameCheckSeat.setBounds(100, 50, 1320, 900);
		frameCheckSeat.setVisible(true);
		Cafe.setLayout(null);

		//// 뒤로가기 버튼
		JButton back = new JButton("Go back");
		back.setIcon(new ImageIcon(CheckSeat.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		back.setFont(new Font("HY엽서L", Font.ITALIC, 17));
		back.setFocusable(false);
		back.setBounds(14, 814, 153, 27);
		Cafe.add(back);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameCheckSeat.setVisible(false);
				Main_page.frame.setVisible(true);
			}
		});

		if (chk1 == 0) 
		{// 자리 안 차있을 때
			JButton two_1 = new JButton(bb);
			two_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug O\n\nFor 2 people");
				}
			});
			two_1.setBounds(369, 165, 70, 70);
			two_1.setBorderPainted(false);
			Cafe.add(two_1);
		}

		if (chk1 == 1) {// 자리 차있을 때
			JButton two_1 = new JButton("USING");
			two_1.setForeground(new Color(255, 228, 225));
			two_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 40));
			two_1.setBorderPainted(false);
			two_1.setContentAreaFilled(false);
			two_1.setFocusable(false);
			two_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug O\n\nFor 2 people");
				}
			});
			two_1.setBounds(300, 165, 200, 70);
			Cafe.add(two_1);
		}

		if (chk2 == 0) 
		{
			JButton two_2 = new JButton(bb);
			two_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug X\n\nFor 2 people");
				}
			});
			two_2.setBounds(440, 559, 70, 70);
			two_2.setBorderPainted(false);
			Cafe.add(two_2);
		}

		if (chk2 == 1) 
		{
			JButton two_2 = new JButton("USING");
			two_2.setForeground(new Color(255, 228, 225));
			two_2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 40));
			two_2.setBorderPainted(false);
			two_2.setContentAreaFilled(false);
			two_2.setFocusable(false);
			two_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug X\n\nFor 2 people");
				}
			});
			two_2.setBounds(370, 559,200, 70);
			Cafe.add(two_2);
		}

		if (chk3 == 0) 
		{
			JButton two_3 = new JButton(bb);
			two_3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug O\n\nFor 2 people");
				}
			});
			two_3.setBounds(654, 496, 70, 70);
			two_3.setBorderPainted(false);
			Cafe.add(two_3);
		}

		if (chk3 == 1) 
		{
			JButton two_3 = new JButton("USING");
			two_3.setForeground(new Color(255, 228, 225));
			two_3.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 40));
			two_3.setBorderPainted(false);
			two_3.setContentAreaFilled(false);
			two_3.setFocusable(false);
			two_3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug O\n\nFor 2 people");
				}
			});
			two_3.setBounds(614, 496, 150, 70);
			Cafe.add(two_3);
		}

		if (chk4 == 0) 
		{
			JButton two_4 = new JButton(bb);
			two_4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug X\n\nFor 2 people");
				}
			});
			two_4.setBounds(658, 634, 70, 70);
			two_4.setBorderPainted(false);
			Cafe.add(two_4);
		}

		if (chk4 == 1) 
		{
			JButton two_4 = new JButton("USING");
			two_4.setForeground(new Color(255, 228, 225));
			two_4.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 40));
			two_4.setBorderPainted(false);
			two_4.setContentAreaFilled(false);
			two_4.setFocusable(false);
			two_4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug X\n\nFor 2 people");
				}
			});
			two_4.setBounds(614, 634, 150, 70);
			Cafe.add(two_4);
		}

		if (chk5 == 0) 
		{
			ImageIcon img3 = new ImageIcon("four_1.png");
			Image originImg_3 = img3.getImage();
			Image changedImg_3 = originImg_3.getScaledInstance(110, 65, Image.SCALE_SMOOTH);
			ImageIcon cc = new ImageIcon(changedImg_3);
			JButton four_1 = new JButton(cc);
			four_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug O\n\nFor 4 people");
				}
			});
			four_1.setBounds(128, 192, 110, 65);
			four_1.setBorderPainted(false);
			Cafe.add(four_1);
		}

		if (chk5 == 1) 
		{
			JButton four_1 = new JButton("USING");
			four_1.setForeground(new Color(255, 228, 225));
			four_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 40));
			four_1.setBorderPainted(false);
			four_1.setContentAreaFilled(false);
			four_1.setFocusable(false);
			four_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug O\n\nFor 4 people");
				}
			});
			four_1.setBounds(83, 192, 200, 65);
			Cafe.add(four_1);
		}

		if (chk6 == 0) 
		{
			ImageIcon img4 = new ImageIcon("four_2.png");
			Image originImg_4 = img4.getImage();
			Image changedImg_4 = originImg_4.getScaledInstance(77, 130, Image.SCALE_SMOOTH);
			ImageIcon dd = new ImageIcon(changedImg_4);
			JButton four_2 = new JButton(dd);
			four_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug X\n\nFor 4 people");
				}
			});
			four_2.setBounds(1012, 522, 77, 130);
			four_2.setBorderPainted(false);
			Cafe.add(four_2);
		}

		if (chk6 == 1) 
		{
			JButton four_2 = new JButton("USING");
			four_2.setForeground(new Color(255, 228, 225));
			four_2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 40));
			four_2.setBorderPainted(false);
			four_2.setContentAreaFilled(false);
			four_2.setFocusable(false);
			four_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("Plug X\n\nFor 4 people");
				}
			});
			four_2.setBounds(950,550, 200, 70);
			four_2.setBorderPainted(false);
			Cafe.add(four_2);
		}

		if (chk7 == 0) 
		{
			ImageIcon img5 = new ImageIcon("group_1.png");
			Image originImg_5 = img5.getImage();
			Image changedImg_5 = originImg_5.getScaledInstance(181, 70, Image.SCALE_SMOOTH);
			ImageIcon ee = new ImageIcon(changedImg_5);
			JButton group_1 = new JButton(ee);
			group_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("group table\nPlug O\nFor 6 people");
				}
			});
			group_1.setBounds(588, 150, 181, 70);
			group_1.setBorderPainted(false);
			Cafe.add(group_1);
		}

		if (chk7 == 1) 
		{
			JButton group_1 = new JButton("USING");
			group_1.setForeground(new Color(255, 228, 225));
			group_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 40));
			group_1.setBorderPainted(false);
			group_1.setContentAreaFilled(false);
			group_1.setFocusable(false);
			group_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("group table\nPlug O\nFor 6 people");
				}
			});
			group_1.setBounds(578, 163, 200, 39);
			Cafe.add(group_1);
		}

		if (chk8 == 0)
		{
			ImageIcon img6 = new ImageIcon("group_2.png");
			Image originImg_6 = img6.getImage();
			Image changedImg_6 = originImg_6.getScaledInstance(184, 70, Image.SCALE_SMOOTH);
			ImageIcon ff = new ImageIcon(changedImg_6);
			JButton group_2 = new JButton(ff);
			group_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("group table\nPlug O\nFor 6 people");
				}
			});
			group_2.setBounds(882, 153, 184, 70);
			group_2.setBorderPainted(false);
			Cafe.add(group_2);
		}

		if (chk8 == 1) 
		{
			JButton group_2 = new JButton("USING");
			group_2.setForeground(new Color(255, 228, 225));
			group_2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 40));
			group_2.setBorderPainted(false);
			group_2.setContentAreaFilled(false);
			group_2.setFocusable(false);
			group_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					table_info = new Table("group table\nPlug O\nFor 6 people");
				}
			});
			group_2.setBounds(882, 153, 184, 70);
			Cafe.add(group_2);
		}

		String serverAddress = getServerAddress();
		Socket socket = new Socket(serverAddress, 9001);

		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
	}
}