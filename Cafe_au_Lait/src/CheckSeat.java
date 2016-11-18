import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CheckSeat extends Main_page {
	JFrame frameCheckSeat;
	Table table_info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckSeat frameseat = new CheckSeat();
					frameseat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckSeat() {
		frameCheckSeat = new JFrame();
		// table table_info;
		ImageIcon aa = new ImageIcon("CAFE.png");
		JPanel Cafe = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(aa.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};

		frameCheckSeat.getContentPane().add(Cafe);
		frameCheckSeat.setBounds(400, 400, 800, 540);
		// frameCheckSeat.setContentPane(Cafe);
		frameCheckSeat.setVisible(true);
		Cafe.setLayout(null);

		JButton back = new JButton("Go back");
		back.setIcon(new ImageIcon(CheckSeat.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		back.setFont(new Font("HY엽서L", Font.ITALIC, 17));
		back.setFocusable(false);
		back.setBounds(14, 454, 153, 27);
		Cafe.add(back);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameCheckSeat.setVisible(false);
				Main_page.frame.setVisible(true);
			}
		});

		JButton four_1 = new JButton(new ImageIcon("four_1.png"));
		four_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table_info = new Table("플러그 있습니다");

			}
		});
		four_1.setBounds(74, 105, 62, 34);
		four_1.setBorderPainted(false);
		Cafe.add(four_1);

		JButton two_1 = new JButton(new ImageIcon("two.png"));
		two_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table_info = new Table("플러그 X");

			}
		});
		two_1.setBounds(214, 92, 37, 34);
		two_1.setBorderPainted(false);
		Cafe.add(two_1);

		JButton two_2 = new JButton(new ImageIcon("two.png"));
		two_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table_info = new Table("플러그 X");

			}
		});
		two_2.setBounds(255, 309, 37, 34);
		two_2.setBorderPainted(false);
		Cafe.add(two_2);

		JButton two_3 = new JButton(new ImageIcon("two.png"));
		two_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table_info = new Table("플러그 X");

			}
		});
		two_3.setBounds(379, 277, 40, 34);
		two_3.setBorderPainted(false);
		Cafe.add(two_3);

		JButton two_4 = new JButton(new ImageIcon("two.png"));
		two_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table_info = new Table("플러그 X");

			}
		});
		two_4.setBounds(381, 346, 40, 34);
		two_4.setBorderPainted(false);
		Cafe.add(two_4);

		JButton four_2 = new JButton(new ImageIcon("four_2.png"));
		four_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table_info = new Table("플러그 있습니다");

			}
		});
		four_2.setBounds(587, 284, 39, 73);
		four_2.setBorderPainted(false);
		Cafe.add(four_2);

		JButton group_1 = new JButton(new ImageIcon("group_1.png"));
		group_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table_info = new Table("group table : 플러그 있지 당연히 시바");

			}
		});
		group_1.setBounds(342, 83, 100, 39);
		group_1.setBorderPainted(false);
		Cafe.add(group_1);

		JButton group_2 = new JButton(new ImageIcon("group_2.png"));
		group_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table_info = new Table("group table : 슬슬 어려워진다");

			}
		});
		group_2.setBounds(515, 83, 100, 39);
		group_2.setBorderPainted(false);
		Cafe.add(group_2);
	}
}
