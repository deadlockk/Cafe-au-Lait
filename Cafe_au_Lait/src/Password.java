import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Password extends Main_page {
	JFrame PassFrame;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Password frame = new Password();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Password() {
		PassFrame = new JFrame();
		PassFrame.setTitle("Type the password");
		PassFrame.setBounds(900, 800, 450, 98);
		PassFrame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		PassFrame.getContentPane().add(contentPane);

		passwordField = new JPasswordField(15);
		passwordField.setForeground(new Color(250, 240, 230));
		passwordField.setFont(new Font("±¼¸²", Font.PLAIN, 21));
		passwordField.setBackground(new Color(0, 0, 0));
		contentPane.add(passwordField, BorderLayout.CENTER);
		passwordField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JPasswordField field = (JPasswordField) event.getSource();
				char[] password = field.getPassword();

			}
		});

		char[] correctPass = new char[] { 's', 'e', 'c', 'r', 'e', 't' };

		passwordField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JPasswordField field = (JPasswordField) event.getSource();
				char[] password = field.getPassword();
				if (Arrays.equals(password, correctPass)) {
				    System.out.println("Password is correct");
					Server SV = new Server();
				} else {
					Wrong_password WP = new Wrong_password();
				}
			}
		});

	}

}
