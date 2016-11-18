import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Label;

public class Reservation extends JFrame {
	private JFrame frame;
	private JTextField chatInput;
	private JTextArea chatRoom;
	private JTextArea chatRoom_1;
	BufferedReader in;
	PrintWriter out;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation window = new Reservation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//
	// private void chatRun() throws IOException {
	//
	// // Make connection and initialize streams
	// String serverAddress = getServerAddress();
	// Socket socket = new Socket(serverAddress, 8888);
	// in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	// out = new PrintWriter(socket.getOutputStream(), true);
	//
	// // Process all messages from server, according to the protocol.
	// {
	// String line = in.readLine();
	// if (line.startsWith("SUBMITNAME")) {
	// out.println(getName());
	// } else if (line.startsWith("NAMEACCEPTED")) {
	// chatInput.setEditable(true);
	// } else if (line.startsWith("MESSAGE")) {
	// chatRoom.append(line.substring(8) + "\n");
	// }
	// }
	// }
	//
	// private String getServerAddress() {
	// return JOptionPane.showInputDialog(frame, "Enter IP Address of the
	// Server:", "Welcome to the Chatter",
	// JOptionPane.QUESTION_MESSAGE);
	// }
	//
	// private String getName() {
	// return JOptionPane.showInputDialog(frame, "Choose a screen name:",
	// "Screen name selection",
	// JOptionPane.PLAIN_MESSAGE);
	// }
	/**
	 * Create the frame.
	 */
	public Reservation() {

		getContentPane().setBackground(new Color(189, 183, 107));
		getContentPane().setLayout(null);
		setResizable(false);

		Label label = new Label();
		label.setBounds(129, 45, 331, 77);
		label.setAlignment(Label.CENTER);
		label.setText("우리 이거 다 할 수 있을까....");

		getContentPane().add(label);

		chatInput = new JTextField();
		chatInput.setBounds(55, 460, 484, 39);
		getContentPane().add(chatInput);
		chatInput.setColumns(10);
		chatInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// out.println(chatInput.getText());

				chatRoom.append(chatInput.getText() + '\n');
				chatInput.setText("");
			}
		});

		chatRoom = new JTextArea();
		JButton send = new JButton("전송");
		send.setBounds(706, 458, 76, 39);
		getContentPane().add(send);
		chatRoom = new JTextArea();
		chatRoom.setBounds(55, 190, 484, 225);
		getContentPane().add(chatRoom);
		chatRoom.setEditable(false);

		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chatRoom.append(chatInput.getText() + '\n');
				chatInput.setText("");
			}
		});
		setBounds(100, 100, 603, 597);
	}
}