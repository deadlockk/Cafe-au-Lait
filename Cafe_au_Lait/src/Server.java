import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
import java.lang.String;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Server extends JFrame implements Runnable 
{
	// 기존 서버내용
	private static final int PORT = 9001;
	private JPanel reservPane;
	static String sql;
	static String R_table, R_card;
	static int client_num = 0, count = 0, num, coffee = 0; // num 은 client 수가 증가되는 것을 저장해주는 변수.
															// coffee 는 order 들어온 수 count해줌.
	static int chat = 0, order = 0; // chat 은 if 문 걸어주기 위한 것. order 는 Test 를 통해 client 에게 true(1), false(0) 를 return 해주기 위해 비교해주는 변수.
	static String card, table; // card, table 은 Order 에서 주문하기 전에 client 가입력한
								// input 값을 나누어서 저장하기 위한 변수이다.

	// 기존 서버 인포 내용.
	JFrame serverframe;
	static JTextField chatInput;
	static JTextArea chatRoom;
	JPanel contentPane;
	static PrintWriter out; 

	public static void main(String[] args) throws Exception
	{
		// GUI 실행 부분. 개별적인 Thread 로 실행된다.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
					new Thread(window).start();
					window.serverframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		System.out.println("The server is running.");
		ServerSocket listener = new ServerSocket(PORT);
		new Handler(listener.accept()).start();

		try 
		{
			while (true) 
			{
				// Handler 가 매번 실행 되면서 Server 의 각 각 Socket Thread 생성해주는 것.
				new Handler(listener.accept()).start();
			}
		} 
		finally 
		{
			listener.close();
		}
	}

	// Constructor 부분.
	public Server() 
	{
		initialize();
		this.serverframe.setVisible(true);
	}

	// Handler (Server 가 Thread 로 실행되었을 때, 실질적으로 돌아가는 부분.)
	private static class Handler extends Thread
	{
		private Socket socket;
		private BufferedReader in;
		public boolean check = false; // 이거는 Order에서 필요한 Check 변수로 임의 설정.

		// Database 에 연결하기 위한 코드.
		Connection con;
		private String url = "jdbc:mysql://localhost/NETWORK"; // Mysql 실제 위치 이용.
		private String strUser = "root"; // Mysql 에서 사용하는 실제 user 이름 이용.
		private String strPassword = "12345"; // Mysql 에서 사용하는 실제 비밀번호 이용.
		private String strMySQLDriver = "com.mysql.jdbc.Driver"; // Mysql 연동하기 위한 driver.

		// Socket 변수에 Socket 의 Port number 를 받아서 설정한다.
		public Handler(Socket socket) 
		{
			this.socket = socket;
		}

		// Handler 의 Thread 의 Run 부분. 필수적으로 override 해주어야 하는 부분.
		// 이 부분이 Multithread 로 실행되어서 각 각 Thread 마다 실행되는 부분.
		public void run()
		{
			try 
			{
				try // Database 연결하기 위한 Try & Catch 문.
				{
					Class.forName(strMySQLDriver);
					con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
					System.out.println("연결 성공"); // Database 연결이 되었을 때, 성공을 확인할 수 있는 log.

				} 
				catch (Exception b) 
				{
					System.out.println("db연결실패"); // Database 연결이 안되었을 때, 실패를 확인할 수 있는 log.
				}

				// 소켓을 통해서 받을 변수들 설정해주는 것.
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				// 서버에서 Thread 로 while 문 돌면서 input, output 을 계속 해준다. (각 각의 thread 로...)
				while (true) 
				{
					// 소켓을 통해 in 으로 들어온 것을 input 에 저장.
					String input = in.readLine();

					// input 값에 prototype 을 이용해서 어디 class 에서 온것을 구분해 준다.
					if (input == null) 
					{
						return;
					}

					// Change the seat 에서 넘어온 정보.
					else if (input.startsWith("CH")) 
					{
						java.sql.Statement stmt = null;
						table = input.substring(10, 13);
						card = input.substring(20);
						try {
							stmt = con.createStatement();

							// sql 에서 input 받은 card number 를 이용해서 check_no (사용중인지) 를 확인한다.
							sql = "select check_no from info where card = '" + card + "'";

							ResultSet result = stmt.executeQuery(sql);
							if (result.next())
							{
								int Check_using = result.getInt(1);

								// Check_using == 1 이라는 것은 input 의 card number 가 유효한 card number 이다.
								if (Check_using == 1) 
								{
									System.out.println("The card number is valid ");
									// sql 에서 input 받은 table number 를 이용해서 check_no (사용중인지) 를 확인한다.
									sql = "select check_no from info where table_no = '" + table + "'";
									result = stmt.executeQuery(sql);
									result.next();
									int Can_change = result.getInt(1);

									// sql 에서 input 받은 card number 를 이용해서 현재 앉아있는 table number를 추출한다.
									sql = "select table_no from info where card = '" + card + "'";
									result = stmt.executeQuery(sql);
									result.next();
									String origin_table = result.getString(1);

									// sql 에서 orign table 를 이용해서 현재 앉아있는 table  주문 정보를 추출한다.
									sql = "select ord from info where table_no = '" + origin_table + "'";
									result = stmt.executeQuery(sql);
									result.next();
									String origin_order = result.getString(1);

									// sql 에서 orign table 를 이용해서 현재 앉아있는 table 가격을 추출한다.
									sql = "select price from info where table_no = '" + origin_table + "'";
									result = stmt.executeQuery(sql);
									result.next();
									int origin_price = result.getInt(1);

									// Can_change == 0 이라는 것은 input 받은 table이 비어있다는 것을 의미한다.
									if (Can_change == 0) {
										System.out.println("You can change the table ");
										// sql 에서 input 받은 table number 가 check_no == 0 (Not using) 이면, card number를 할당하고, 사용중으로 업데이트 한다.
										sql = "update info set card = '" + card + "', check_no = 1, ord = '"
												+ origin_order + "', price = '" + origin_price + "' where table_no = '"
												+ table + "'";
										int Update = stmt.executeUpdate(sql);

										// 자리를 변경했으므로, 기존에 앉아있던 자리는 free 상태로 update.
										sql = "update info set card = null, check_no = 0, ord = null, price = null where table_no = '"
												+ origin_table + "'";
										int Original = stmt.executeUpdate(sql);
										System.out.println("The table is updated ");
									}
									// Can_change == 1 이라는 것은 input 받은 table 이 사용중이라는 것을 의미한다.
									else 
									{
										System.out.println("This seat is using now!");
										Warning W1 = new Warning("This seat is using now!");
									}
								}
							} 
							else 
							{
								System.out.println("This card number is not valid");
								Warning W2 = new Warning("This card number is not valid");
							}

						} 
						catch (Exception e) 
						{
							e.printStackTrace(System.out);
						}
					}

					// Order 하기 전에 자리 랑 카드 먼저 확인.
					else if (input.startsWith("TS"))
					{
						java.sql.Statement stmt = null;
						table = input.substring(10, 13);
						card = input.substring(20);

						try 
						{
							stmt = con.createStatement();

							// sql 에서 input 받은 table number 를 이용해서 자리가 사용중인지 추출한다. -> 자리에 사람이 있어야 주문 가능을 위함.
							sql = "select check_no from info where table_no = '" + table + "'";

							ResultSet result = stmt.executeQuery(sql);
							result.next();
							int Isusing = result.getInt(1);

							// Isusing == 1 이라는 것은 자리에 사람이 존재한다. (즉, table이 사용중이다)
							if (Isusing == 1) 
							{
								System.out.println("The table number is right ");
								// sql 에서 사용중인 table 의 card number를 추출한다. (밑에 card number 유효성을 비교하기 위함.)
								sql = "select card from info where table_no = '" + table + "'";
								result = stmt.executeQuery(sql);
								result.next();
								int Isvalid = result.getInt(1);

								// Isvalid == card number 라는 것은 input 받은 card number 가 현재 사용중인 table 의 사용자의 card numuber가 같다.(-> 유효한 카드번호이다.)
								if (Integer.parseInt(card) == Isvalid) 
								{
									System.out.println("The card number is right ");
									System.out.println("You can order");
									out.println(1);
								}
								else 
								{
									System.out.println("The card number is not valid ");
									System.out.println("You can not order");
									Warning W3 = new Warning("The card number is not valid \n You can not order");
									out.println(0);
								}
							}
							// Isusing == 0 이라는 것은 자리에 사람이 존재하지 않는다. (즉, table이 비어있다.)
							else 
							{
								System.out.println("You can order");
								sql = "update info set card = '" + card + "', check_no = 1 where table_no = '" + table + "'";
								int rss = stmt.executeUpdate(sql);
								out.println(1);
							}
						} 
						catch (Exception e) 
						{
							e.printStackTrace(System.out);
						}
					}

					// Order 에서 넘어온 가격 과 음료 정보.
					else if (input.startsWith("OR")) 
					{
						java.sql.Statement stmt = null;

						// count == 0 or 홀수이면, order menu 가 server 에서 받고, DB에 저장한다.
						if ((count == 0) || (count % 2 == 0)) 
						{
							try 
							{
								stmt = con.createStatement();

								// sql 을 이용해서, menu 를 DB 에 update 한다.
								sql = "update info set Ord = '" + input.substring(2) + "' where Table_no = '" + table + "'";
								int menu = stmt.executeUpdate(sql);
							} 
							catch (Exception e) 
							{
								e.printStackTrace(System.out);
							}
						}

						// count == 1 or 짝수이면, price 가 server 에서 받고, DB에 저장한다.
						if (count % 2 == 1) 
						{
							try 
							{
								stmt = con.createStatement();

								// sql 을 이용해서, price 를 DB 에 update 한다.
								sql = "update info set Price = '" + input.substring(2) + "' where Table_no = '" + table+ "'";
								int price = stmt.executeUpdate(sql);
							} 
							catch (Exception e)
							{
								e.printStackTrace(System.out);
							}
							coffee++;
							out.println("주문이 완료 되었습니다.   ->    " + (coffee * 3) + "분만 기다려 주세요. \n");
						}
						count++;
					}

					// Reservation 에서 넘어온 정보를 받아서 서로 chating 해준다.
					else if (input.startsWith("RE")) 
					{
						num = Integer.parseInt(input.substring(2, 3));
						chatRoom.append("<From" + " client" + num + "> : " + input.substring(3) + "\n");
					}
				}
			} 
			catch (IOException e) 
			{
				System.out.println(e);
			}
		}
	}

	public void initialize()
	{
		/////// frame 배경, 사이즈 정함
		serverframe = new JFrame();
		serverframe.setTitle("server"); // Frame의 타이틀 이름 주기
		serverframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Frame의 X를 누를경우 종료
		serverframe.setSize(800, 800); // Frame의 크기 설정
		ImageIcon background = new ImageIcon("management.png");
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		serverframe.getContentPane().add(contentPane);
		contentPane.setLayout(null);

		///////// 오른쪽 정보 띄워줄 패널
		JPanel information = new JPanel();
		information.setBackground(Color.WHITE);
		information.setBounds(497, 211, 250, 208);
		contentPane.add(information);

		//////// 패널 위에 뜨는 주문정보 텍스트
		JTextArea infotext = new JTextArea();
		infotext.setBackground(Color.WHITE);
		infotext.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		infotext.setBounds(497, 211, 250, 208);
		information.add(infotext);

		////////// 테이블 패널들
		JPanel two_1 = new JPanel();
		two_1.setBackground(new Color(154, 205, 50));
		two_1.setBounds(53, 222, 90, 90);
		contentPane.add(two_1);
		two_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				two_1.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(221, 160, 221)));
				try {
					Connection con = null;
					con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/NETWORK", "root", "12345");

					java.sql.Statement stmt = null;
					stmt = con.createStatement();
					sql = "select Table_no, Card, Ord, Price from info where Table_no = 'T_1'";

					ResultSet result = stmt.executeQuery(sql);
					while (result.next())
					{
						String a = result.getString(1);
						String b = result.getString(2);
						String c = result.getString(3);
						String d = result.getString(4);
						char enter = '\n';
						StringBuilder sb = new StringBuilder(64);
						sb.append("\n\nTable : " + a + enter).append("Card number : " + b + enter).append("Order : " + c + enter).append("Price : " + d);
						infotext.setText(sb.toString());
					}
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				two_1.setBorder(null);
				infotext.setText("");
			}
		});
		two_1.setLayout(null);

		JLabel two_one = new JLabel("TWO_1");
		two_one.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		two_one.setForeground(new Color(0, 0, 0));
		two_one.setBounds(14, 36, 62, 18);
		two_1.add(two_one);
		
		JPanel two_2 = new JPanel();
		two_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				two_2.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(221, 160, 221)));
				try {
					Connection con = null;
					con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/NETWORK", "root", "12345");

					java.sql.Statement stmt = null;
					stmt = con.createStatement();
					sql = "select Table_no, Card, Ord, Price from info where Table_no = 'T_2'";

					ResultSet result = stmt.executeQuery(sql);
					while (result.next()) 
					{
						String a = result.getString(1);
						String b = result.getString(2);
						String c = result.getString(3);
						String d = result.getString(4);
						char enter = '\n';
						StringBuilder sb = new StringBuilder(64);
						sb.append("\n\nTable : " + a + enter).append("Card number : " + b + enter).append("Order : " + c + enter).append("Price : " + d);
						infotext.setText(sb.toString());
					}
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				two_2.setBorder(null);
				infotext.setText("");
			}
		});
		two_2.setBackground(new Color(154, 205, 50));
		two_2.setBounds(157, 222, 90, 90);
		contentPane.add(two_2);
		two_2.setLayout(null);

		JLabel two_two = new JLabel("TWO_2");
		two_two.setForeground(Color.BLACK);
		two_two.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		two_two.setBounds(14, 36, 62, 18);
		two_2.add(two_two);
		
		JPanel two_3 = new JPanel();
		two_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				two_3.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(221, 160, 221)));
				try {
					Connection con = null;
					con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/NETWORK", "root", "12345");

					java.sql.Statement stmt = null;
					stmt = con.createStatement();
					sql = "select Table_no, Card, Ord, Price from info where Table_no = 'T_3'";

					ResultSet result = stmt.executeQuery(sql);
					while (result.next()) 
					{
						String a = result.getString(1);
						String b = result.getString(2);
						String c = result.getString(3);
						String d = result.getString(4);
						char enter = '\n';
						StringBuilder sb = new StringBuilder(64);
						sb.append("\n\nTable : " + a + enter).append("Card number : " + b + enter).append("Order : " + c + enter).append("Price : " + d);
						infotext.setText(sb.toString());
					}
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				two_3.setBorder(null);
				infotext.setText("");
			}
		});
		two_3.setBackground(new Color(154, 205, 50));
		two_3.setBounds(261, 222, 90, 90);
		contentPane.add(two_3);
		two_3.setLayout(null);

		JLabel two_three = new JLabel("TWO_3");
		two_three.setForeground(Color.BLACK);
		two_three.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		two_three.setBounds(14, 34, 62, 18);
		two_3.add(two_three);
		
		JPanel two_4 = new JPanel();
		two_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				two_4.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(221, 160, 221)));
				try {
					Connection con = null;
					con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/NETWORK", "root","12345");

					java.sql.Statement stmt = null;
					stmt = con.createStatement();
					sql = "select Table_no, Card, Ord, Price from info where Table_no = 'T_4'";

					ResultSet result = stmt.executeQuery(sql);
					while (result.next())
					{
						String a = result.getString(1);
						String b = result.getString(2);
						String c = result.getString(3);
						String d = result.getString(4);
						char enter = '\n';
						StringBuilder sb = new StringBuilder(64);
						sb.append("\n\nTable : " + a + enter).append("Card number : " + b + enter).append("Order : " + c + enter).append("Price : " + d);
						infotext.setText(sb.toString());
					}
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				two_4.setBorder(null);
				infotext.setText("");
			}
		});
		two_4.setBackground(new Color(154, 205, 50));
		two_4.setBounds(365, 222, 90, 90);
		contentPane.add(two_4);
		two_4.setLayout(null);

		JLabel two4 = new JLabel("TWO_4");
		two4.setForeground(Color.BLACK);
		two4.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		two4.setBounds(13, 34, 76, 18);
		two_4.add(two4);
		
		JPanel four_1 = new JPanel();
		four_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				four_1.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(221, 160, 221)));
				try {
					Connection con = null;
					con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/NETWORK", "root","12345");

					java.sql.Statement stmt = null;
					stmt = con.createStatement();
					sql = "select Table_no, Card, Ord, Price from info where Table_no = 'F_1'";

					ResultSet result = stmt.executeQuery(sql);
					while (result.next()) 
					{
						String a = result.getString(1);
						String b = result.getString(2);
						String c = result.getString(3);
						String d = result.getString(4);
						char enter = '\n';
						StringBuilder sb = new StringBuilder(64);
						sb.append("\n\nTable : " + a + enter).append("Card number : " + b + enter).append("Order : " + c + enter).append("Price : " + d);
						infotext.setText(sb.toString());
					}
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				four_1.setBorder(null);
				infotext.setText("");
			}
		});
		four_1.setBackground(new Color(154, 205, 50));
		four_1.setBounds(53, 325, 90, 90);
		contentPane.add(four_1);
		four_1.setLayout(null);

		JLabel four_one = new JLabel("FOUR_1");
		four_one.setForeground(Color.BLACK);
		four_one.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		four_one.setBounds(14, 38, 76, 18);
		four_1.add(four_one);
		JPanel four_2 = new JPanel();
		four_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				four_2.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(221, 160, 221)));
				try {
					Connection con = null;
					con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/NETWORK", "root", "12345");

					java.sql.Statement stmt = null;
					stmt = con.createStatement();
					sql = "select Table_no, Card, Ord, Price from info where Table_no = 'F_2'";

					ResultSet result = stmt.executeQuery(sql);
					while (result.next()) 
					{
						String a = result.getString(1);
						String b = result.getString(2);
						String c = result.getString(3);
						String d = result.getString(4);
						char enter = '\n';
						StringBuilder sb = new StringBuilder(64);
						sb.append("\n\nTable : " + a + enter).append("Card number : " + b + enter).append("Order : " + c + enter).append("Price : " + d);
						infotext.setText(sb.toString());
					}
				} 
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				four_2.setBorder(null);
				infotext.setText("");
			}
		});
		four_2.setBackground(new Color(154, 205, 50));
		four_2.setBounds(157, 325, 90, 90);
		contentPane.add(four_2);
		four_2.setLayout(null);

		JLabel four_two = new JLabel("FOUR_2");
		four_two.setForeground(Color.BLACK);
		four_two.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		four_two.setBounds(14, 38, 76, 18);
		four_2.add(four_two);
		
		JPanel group_1 = new JPanel();
		group_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				group_1.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(221, 160, 221)));
				try {
					Connection con = null;
					con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/NETWORK", "root","12345");

					java.sql.Statement stmt = null;
					stmt = con.createStatement();
					sql = "select Table_no, Card, Ord, Price from info where Table_no = 'G_1'";

					ResultSet result = stmt.executeQuery(sql);
					while (result.next()) {
						String a = result.getString(1);
						String b = result.getString(2);
						String c = result.getString(3);
						String d = result.getString(4);
						char enter = '\n';
						StringBuilder sb = new StringBuilder(64);
						sb.append("\n\nTable : " + a + enter).append("Card number : " + b + enter).append("Order : " + c + enter).append("Price : " + d);
						infotext.setText(sb.toString());
					}
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				group_1.setBorder(null);
				infotext.setText("");
			}
		});
		group_1.setBackground(new Color(154, 205, 50));
		group_1.setBounds(261, 325, 90, 90);
		contentPane.add(group_1);
		group_1.setLayout(null);

		JLabel gruop1 = new JLabel("GROUP1");
		gruop1.setForeground(Color.BLACK);
		gruop1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		gruop1.setBounds(14, 37, 76, 18);
		group_1.add(gruop1);
		
		JPanel group_2 = new JPanel();
		group_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				group_2.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(221, 160, 221)));
				try {
					Connection con = null;
					con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/NETWORK", "root","12345");

					java.sql.Statement stmt = null;
					stmt = con.createStatement();
					sql = "select Table_no, Card, Ord, Price from info where Table_no = 'G_2'";

					ResultSet result = stmt.executeQuery(sql);
					while (result.next()) 
					{
						String a = result.getString(1);
						String b = result.getString(2);
						String c = result.getString(3);
						String d = result.getString(4);
						char enter = '\n';
						StringBuilder sb = new StringBuilder(64);
						sb.append("\n\nTable : " + a + enter).append("Card number : " + b + enter).append("Order : " + c + enter).append("Price : " + d);
						infotext.setText(sb.toString());
					}
				} 
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				group_2.setBorder(null);
				infotext.setText("");
			}
		});
		group_2.setBackground(new Color(154, 205, 50));
		group_2.setBounds(365, 325, 90, 90);
		contentPane.add(group_2);
		group_2.setLayout(null);

		JLabel gruop2 = new JLabel("GROUP2");
		gruop2.setForeground(Color.BLACK);
		gruop2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		gruop2.setBounds(13, 37, 76, 18);
		group_2.add(gruop2);
		
		chatInput = new JTextField();
		chatInput.setBounds(42, 682, 421, 48);
		contentPane.add(chatInput);
		chatInput.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		chatInput.setColumns(10);

		chatInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(chatInput);
				out.println(chatInput.getText());
				chatRoom.append("<Server> : " + chatInput.getText() + '\n');
				chatInput.setText("");
			}
		});

		JButton send = new JButton("Send");
		send.setForeground(new Color(255, 215, 0));
		send.setFont(new Font("Harlow Solid Italic", Font.BOLD, 15));
		send.setBackground(new Color(0, 51, 102));
		send.setBounds(477, 688, 76, 39);
		contentPane.add(send);

		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chatRoom.append(chatInput.getText() + '\n');
				chatInput.setText("");
			}
		});

		chatRoom = new JTextArea();
		chatRoom.setBounds(51, 455, 398, 183);
		chatRoom.append("=========== Reservation ============" + "\n");
		chatRoom.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		contentPane.add(chatRoom);
		chatRoom.setEditable(false);

		JButton btnNewButton = new JButton("Reservation");
		btnNewButton.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.setForeground(new Color(255, 215, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame reserv = new JFrame();
				ImageIcon bg = new ImageIcon("reservation.png");
				reservPane = new JPanel() {
					public void paintComponent(Graphics g) {
						g.drawImage(bg.getImage(), 0, 0, null);
						setOpaque(false);// 배경 띄워주기
						super.paintComponent(g);
					}
				};
				reservPane.setLayout(null);
				reserv.setSize(800, 800);
				reserv.getContentPane().add(reservPane);
				reserv.setVisible(true);

				///////////// table 번호 받는 곳
				JTextField textField_1 = new JTextField();
				textField_1.setHorizontalAlignment(SwingConstants.CENTER);
				textField_1.setForeground(new Color(0, 0, 102));
				textField_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 30));
				textField_1.setBounds(304, 323, 209, 48);
				reservPane.add(textField_1);
				textField_1.setColumns(10);
				///////////// card 번호 받는 곳
				JTextField textField_2 = new JTextField();
				textField_2.setHorizontalAlignment(SwingConstants.CENTER);
				textField_2.setForeground(new Color(0, 0, 102));
				textField_2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 30));
				textField_2.setBounds(299, 526, 209, 48);
				reservPane.add(textField_2);
				textField_2.setColumns(10);

				JButton Sender = new JButton("SEND");
				Sender.setForeground(new Color(255, 215, 0));
				Sender.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 35));
				Sender.setContentAreaFilled(false);
				Sender.setBorderPainted(false);
				Sender.setBounds(532, 648, 122, 27);
				Sender.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						reserv.setVisible(false);
						R_table = textField_1.getText();
						R_card = textField_2.getText();
						try 
						{
							Connection con = null;

							con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/NETWORK", "root","12345");
							
							java.sql.Statement stmt = null;
							stmt = con.createStatement();
							sql = "select check_no from info where table_no = '" + R_table + "'";
							ResultSet rresult = stmt.executeQuery(sql);
							rresult.next();
							int Is_using = rresult.getInt(1);

							if (Is_using == 1) 
							{
								System.out.println("You can't reservation. Because that seat is already using.");
								Warning W4 = new Warning("You can't reservation. Because that seat is already using.");

							} 
							else 
							{
								System.out.println("The reservation is complete.");
								// sql 에서 input 받은 table number 가 check_no == 0(Not using) 이면, card number를 할당하고, 사용중으로 업데이트한다.
								sql = "update info set card = '" + R_card + "', check_no = 1 where table_no = '"+ R_table + "'";
								int Update = stmt.executeUpdate(sql);
							}
						}
						catch (SQLException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				reservPane.add(Sender);
			}
		});
		btnNewButton.setBounds(497, 455, 250, 64);
		contentPane.add(btnNewButton);
	}

	@Override
	public void run() 
	{
	}
}
