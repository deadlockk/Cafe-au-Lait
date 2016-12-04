import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.awt.Font;

public class Order extends Main_page
{
	static JFrame Orderframe;
	BufferedReader in;
	PrintWriter out;
	private JTextField Card;
	private JTextField Table;
	static Boolean Test = false;
	static String name, final_menu;
	static int price, sub = 0; // price 와 sub 변수는 각 각 주문에 대한 가격이 저장된다.
	String Beverage, Sub; // Beverage 와 sub 는 주문에 대한 이름이 저장된다.
	String txt_1, txt_2, text; // txt_1 와 txr_2 는 checking 해줄 때, Table 과 Card
								// number 저장하는 변수이다.
	String line = null;

	public static void main(String[] args) 
	{
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

	private String getServerAddress()
	{
		return "127.0.0.1";
		// return "192.168.35.16";
	}

	public Order() throws IOException 
	{
		initialize();
		Order.Orderframe.setVisible(true);
	}

	public void initialize() throws IOException 
	{
		Orderframe = new JFrame();
		Orderframe.getContentPane().setBackground(new Color(25, 25, 112));
		Orderframe.getContentPane().setLayout(null);
		Orderframe.setTitle("order");
		Orderframe.setSize(1500, 1050);
		Orderframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String serverAddress = getServerAddress();
		Socket socket = new Socket(serverAddress, 9001);

		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

		JLabel Card_no = new JLabel("Card.no");
		Card_no.setForeground(new Color(255, 140, 0));
		Card_no.setFont(new Font("Harlow Solid Italic", Font.BOLD, 15));
		Card_no.setBounds(257, 43, 168, 37);
		Orderframe.getContentPane().add(Card_no);

		JLabel Table_no = new JLabel("Table.no");
		Table_no.setFont(new Font("Harlow Solid Italic", Font.BOLD, 15));
		Table_no.setForeground(new Color(255, 165, 0));
		Table_no.setBounds(68, 46, 62, 30);
		Orderframe.getContentPane().add(Table_no);

		// 테이블 텍스트 받는 부분
		Table = new JTextField();
		Table.setColumns(10);
		Table.setBounds(141, 47, 99, 30);
		Orderframe.getContentPane().add(Table);

		// 카드 텍스트 받는 부분
		Card = new JTextField();
		Card.setBounds(343, 46, 84, 31);
		Orderframe.getContentPane().add(Card);
		Card.setColumns(10);

		/////// 체크 버튼
		JButton Check = new JButton("Check");
		Check.setBackground(new Color(255, 255, 240));
		Check.setFont(new Font("Harlow Solid Italic", Font.BOLD, 30));
		Check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_1 = "Table : " + Table.getText();
				txt_2 = "Card : " + Card.getText();
				text = txt_1 + txt_2;
				out.println("TS" + text);

				String Isvalid = null;
				try {
					Isvalid = in.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (Isvalid.equals("1")) {
					Test = true;
				}
			}
		});
		Check.setBounds(476, 43, 115, 37);
		Orderframe.getContentPane().add(Check);

		/////////////// 버튼들
		JButton americano = new JButton(new ImageIcon("tea.png"));
		americano.setBounds(109, 105, 133, 100);
		Orderframe.getContentPane().add(americano);
		americano.setBackground(new Color(255, 255, 240));
		americano.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					name = "Americano";
					Beverage = name;
					price = 3000;
					Submenu1 SM = new Submenu1();
					Order.Orderframe.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton espresso = new JButton("");
		espresso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					name = "Espresso";
					Beverage = name;
					price = 2000;
					Submenu1 SM = new Submenu1();
					Order.Orderframe.dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		espresso.setIcon(new ImageIcon("espresso.png"));
		espresso.setBounds(256, 105, 133, 100);
		espresso.setBackground(new Color(255, 255, 240));
		Orderframe.getContentPane().add(espresso);

		JButton greentea = new JButton("");
		greentea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					name = "Green tea";
					Beverage = name;
					price = 4000;
					Submenu2 SM = new Submenu2();
					Order.Orderframe.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		greentea.setIcon(new ImageIcon("tea-cup.png"));
		greentea.setBounds(550, 268, 133, 100);
		greentea.setBackground(new Color(255, 255, 240));
		Orderframe.getContentPane().add(greentea);

		JButton frappe = new JButton("");
		frappe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					name = "Frappe";
					Beverage = name;
					price = 5500;
					Submenu2 SM = new Submenu2();
					Order.Orderframe.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frappe.setIcon(new ImageIcon("frappe.png"));
		frappe.setBounds(403, 105, 133, 100);
		frappe.setBackground(new Color(255, 255, 240));
		Orderframe.getContentPane().add(frappe);

		JButton juice = new JButton("");
		juice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					name = "Juice";
					Beverage = name;
					price = 3500;
					Submenu2 SM = new Submenu2();
					Order.Orderframe.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		juice.setIcon(new ImageIcon("milk-bottle.png"));
		juice.setBounds(403, 268, 133, 100);
		juice.setBackground(new Color(255, 255, 240));
		Orderframe.getContentPane().add(juice);

		JButton latte = new JButton("");
		latte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					name = "Latte";
					Beverage = name;
					price = 4000;
					Submenu1 SM = new Submenu1();
					Order.Orderframe.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		latte.setIcon(new ImageIcon("latte.png"));
		latte.setBounds(550, 105, 133, 100);
		latte.setBackground(new Color(255, 255, 240));
		Orderframe.getContentPane().add(latte);

		JButton mocha = new JButton(new ImageIcon("mocha.png"));
		mocha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					name = "Mocha";
					Beverage = name;
					price = 4000;
					Submenu1 SM = new Submenu1();
					Order.Orderframe.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mocha.setBounds(256, 268, 133, 100);
		mocha.setBackground(new Color(255, 255, 240));
		Orderframe.getContentPane().add(mocha);

		JButton cappuccino = new JButton(new ImageIcon("cappuccino.png"));
		cappuccino.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					name = "Cappuccino";
					Beverage = name;
					price = 4000;
					Submenu1 SM = new Submenu1();
					Order.Orderframe.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cappuccino.setBounds(109, 268, 133, 100);
		cappuccino.setBackground(new Color(255, 255, 240));
		Orderframe.getContentPane().add(cappuccino);

		/////// 그냥 아래 이름 띄워주기
		JLabel lblGreentea = new JLabel("Greentea");
		lblGreentea.setFont(new Font("Harlow Solid Italic", Font.BOLD, 24));
		lblGreentea.setForeground(new Color(255, 215, 0));
		lblGreentea.setLabelFor(greentea);
		lblGreentea.setBounds(570, 370, 115, 30);
		Orderframe.getContentPane().add(lblGreentea);
		JLabel lblJuice = new JLabel("Juice");
		lblJuice.setForeground(new Color(255, 215, 0));
		lblJuice.setFont(new Font("Harlow Solid Italic", Font.BOLD, 24));
		lblJuice.setBounds(441, 370, 115, 30);
		Orderframe.getContentPane().add(lblJuice);
		JLabel lblMocha = new JLabel("Mocha");
		lblMocha.setForeground(new Color(255, 215, 0));
		lblMocha.setFont(new Font("Harlow Solid Italic", Font.BOLD, 24));
		lblMocha.setBounds(283, 376, 84, 18);
		Orderframe.getContentPane().add(lblMocha);
		JLabel lblCappuccino = new JLabel("Cappuccino");
		lblCappuccino.setFont(new Font("Harlow Solid Italic", Font.BOLD, 24));
		lblCappuccino.setForeground(new Color(255, 215, 0));
		lblCappuccino.setBounds(119, 380, 149, 18);
		Orderframe.getContentPane().add(lblCappuccino);
		JLabel lblAmericano = new JLabel("Americano");
		lblAmericano.setForeground(new Color(255, 215, 0));
		lblAmericano.setFont(new Font("Harlow Solid Italic", Font.BOLD, 24));
		lblAmericano.setBounds(119, 217, 139, 18);
		Orderframe.getContentPane().add(lblAmericano);
		JLabel lblEspresso = new JLabel("Espresso");
		lblEspresso.setForeground(new Color(255, 215, 0));
		lblEspresso.setFont(new Font("Harlow Solid Italic", Font.BOLD, 24));
		lblEspresso.setBounds(272, 217, 133, 18);
		Orderframe.getContentPane().add(lblEspresso);
		JLabel lblFrappe = new JLabel("Frappe");
		lblFrappe.setForeground(new Color(255, 215, 0));
		lblFrappe.setFont(new Font("Harlow Solid Italic", Font.BOLD, 24));
		lblFrappe.setBounds(429, 217, 122, 18);
		Orderframe.getContentPane().add(lblFrappe);
		JLabel lblLatte = new JLabel("Latte");
		lblLatte.setForeground(new Color(255, 215, 0));
		lblLatte.setFont(new Font("Harlow Solid Italic", Font.BOLD, 24));
		lblLatte.setBounds(581, 217, 62, 18);
		Orderframe.getContentPane().add(lblLatte);

		/////////////// 현재 주문 정보
		JTextArea OrderInfo = new JTextArea();
		OrderInfo.setBounds(109, 432, 361, 100);
		Orderframe.getContentPane().add(OrderInfo);
		OrderInfo.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
		OrderInfo.append(final_menu); // 메뉴 띄게 해주는 것
		OrderInfo.append("\n");
		price = price + sub;
		String Price = price + "";
		OrderInfo.append(Price);

		/////////// 주문 버튼
		JButton completeorder = new JButton("order");
		completeorder.setFont(new Font("Harlow Solid Italic", Font.BOLD, 30));
		completeorder.setBackground(Color.WHITE);
		completeorder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (Test) {
					System.out.println("Compelete the checking ");
					String sendStr = final_menu.replace("\n", " ");
					out.println("OR " + sendStr);
					out.println("OR" + Price);
					sub = 0;
					Server.count = 0;
					Orderframe.setVisible(false);
					frame.setVisible(true);
					// 11월 30일 수정.
					final_menu = null;
					price = 0;

					if (Server.count == 0) 
					{
						try 
						{
							line = in.readLine();
						} 
						catch (IOException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(line);
						Warning W5 = new Warning(line);
												
					} else
					{					
						System.out.println("The card number is not correct ");
					}
				}
			}
		});
		completeorder.setBounds(520, 432, 184, 100);
		Orderframe.getContentPane().add(completeorder);

		JLabel ame_price = new JLabel("3000");
		ame_price.setForeground(new Color(255, 255, 224));
		ame_price.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
		ame_price.setBounds(152, 238, 62, 18);
		Orderframe.getContentPane().add(ame_price);

		JLabel esp_price = new JLabel("2000");
		esp_price.setForeground(new Color(255, 255, 240));
		esp_price.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
		esp_price.setBounds(305, 238, 62, 18);
		Orderframe.getContentPane().add(esp_price);

		JLabel fra_price = new JLabel("5500");
		fra_price.setForeground(new Color(255, 255, 240));
		fra_price.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
		fra_price.setBounds(441, 238, 62, 18);
		Orderframe.getContentPane().add(fra_price);

		JLabel lat_price = new JLabel("4000");
		lat_price.setForeground(new Color(255, 255, 240));
		lat_price.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
		lat_price.setBounds(592, 238, 62, 18);
		Orderframe.getContentPane().add(lat_price);

		JLabel cap_price = new JLabel("4000");
		cap_price.setForeground(new Color(255, 255, 240));
		cap_price.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
		cap_price.setBounds(151, 402, 62, 18);
		Orderframe.getContentPane().add(cap_price);

		JLabel moc_price = new JLabel("4000");
		moc_price.setForeground(new Color(255, 255, 240));
		moc_price.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
		moc_price.setBounds(305, 402, 62, 18);
		Orderframe.getContentPane().add(moc_price);

		JLabel juc_price = new JLabel("3500");
		juc_price.setForeground(new Color(255, 255, 240));
		juc_price.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
		juc_price.setBounds(448, 402, 62, 18);
		Orderframe.getContentPane().add(juc_price);

		JLabel gre_price = new JLabel("4000");
		gre_price.setForeground(new Color(255, 255, 240));
		gre_price.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
		gre_price.setBounds(599, 402, 62, 18);
		Orderframe.getContentPane().add(gre_price);
		Orderframe.setResizable(false);
		Orderframe.setBounds(400, 200, 800, 600);
	}
}