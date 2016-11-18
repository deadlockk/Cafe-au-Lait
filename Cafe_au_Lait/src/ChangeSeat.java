
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeSeat extends Main_page {
	JFrame ChangeFrame;
	JLabel head;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeSeat framechange = new ChangeSeat();
					framechange.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	public ChangeSeat() {

		ChangeFrame = new JFrame();
		ChangeFrame.setSize(400, 400);
		panel.setBackground(new Color(189, 183, 107));
		ChangeFrame.getContentPane().add(panel);
		ChangeFrame.setTitle("ChangeSeat");
		ChangeFrame.setVisible(true);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(33, 184, 116, 24);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(235, 184, 116, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton imoticon = new JButton(new ImageIcon("espresso.png"));
		imoticon.setBounds(156, 45, 74, 71);
		imoticon.setBorderPainted(false);
		panel.add(imoticon);
		
		
		JTextPane txtpnCardNumber = new JTextPane();
		txtpnCardNumber.setFont(new Font("양재블럭체", Font.BOLD | Font.ITALIC, 16));
		txtpnCardNumber.setBackground(new Color(189, 183, 107));
		txtpnCardNumber.setText("Card Number");
		txtpnCardNumber.setBounds(33, 132, 112, 40);
		panel.add(txtpnCardNumber);

		JTextPane txtpnTableNumber = new JTextPane();
		txtpnTableNumber.setFont(new Font("양재블럭체", Font.BOLD | Font.ITALIC, 16));
		txtpnTableNumber.setBackground(new Color(189, 183, 107));
		txtpnTableNumber.setText("Table Number");
		txtpnTableNumber.setBounds(235, 132, 116, 40);
		panel.add(txtpnTableNumber);

		JButton btnNewButton = new JButton("\uC804\uC1A1");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton.setBackground(new Color(211, 211, 211));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(189, 183, 107));
			}
		});
		btnNewButton.setIcon(null);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		btnNewButton.setBounds(150, 236, 80, 55);
		btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);

		JButton back = new JButton("Go back");
		back.setIcon(new ImageIcon(CheckSeat.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		back.setFont(new Font("HY엽서L", Font.ITALIC, 10));
		back.setFocusable(false);
		back.setBounds(14, 314, 123, 27);
		panel.add(back);

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChangeFrame.setVisible(false);
				Main_page.frame.setVisible(true);
			}
		});

	}
}