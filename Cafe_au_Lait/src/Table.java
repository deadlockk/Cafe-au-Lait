import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table {
	JDialog dia;
	JLabel jlb = new JLabel("");
	Reservation R = new Reservation();

	public Table(String str) {
		dia = new JDialog();
		dia.getContentPane().add(jlb);
		jlb.setText(str.toString());

		if (str.substring(0, 5).equals("group")) {// 그룹테이블만 여기다가
			JPanel panel = new JPanel();
			dia.getContentPane().add(panel, BorderLayout.SOUTH);

			JButton reservation = new JButton("Reservation");
			panel.add(reservation);
			reservation.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					dia.setVisible(false);
					R.setVisible(true);
				}
			});

		}
		dia.setBounds(300, 400, 300, 300);
		dia.setModal(true);
		dia.setVisible(true);
	}
}