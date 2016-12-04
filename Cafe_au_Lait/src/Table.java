import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;

public class Table
{
	JDialog dia;

	public Table(String str)
	{
		dia = new JDialog();
		ImageIcon tableinfo = new ImageIcon("tableinfo.png");
		JPanel infopanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(tableinfo.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		dia.getContentPane().add(infopanel);
		infopanel.setLayout(null);

		JTextArea txtrAa = new JTextArea();
		txtrAa.setText(str.toString());
		txtrAa.setBounds(212, 262, 187, 196);
		txtrAa.setForeground(new Color(0, 0, 102));
		txtrAa.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		txtrAa.setEditable(false);
		infopanel.add(txtrAa);

		//////////////// 그룹테이블만 여기에서
		if (str.substring(0, 5).equals("group")) 
		{
			JPanel panel = new JPanel();
			dia.getContentPane().add(panel, BorderLayout.SOUTH);
	
			JButton reservation = new JButton("Reservation");
			reservation.setForeground(new Color(0, 0, 0));
			reservation.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 30));
			reservation.setBorderPainted(false);
			reservation.setContentAreaFilled(false);
			reservation.setFocusable(false);
			panel.add(reservation);
			reservation.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					dia.setVisible(false);
					Server.client_num++;
					Reservation R = new Reservation();
					new Thread(R).start();
					R.RESframe.setVisible(true);
				}
			});
			 reservation.addMouseListener(new MouseAdapter() {
		         @Override
		         public void mouseEntered(MouseEvent arg0) {
		        	 reservation.setForeground(new Color(0, 0, 0));
		        	 reservation.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
		         }

		         @Override
		         public void mouseExited(MouseEvent e) {
		        	 reservation.setForeground(new Color(0, 0, 0));
		        	 reservation.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 30));
		         }
		      });
		}

		dia.setBounds(100, 200, 610, 630);
		dia.setModal(true);
		dia.setVisible(true);
	}
}