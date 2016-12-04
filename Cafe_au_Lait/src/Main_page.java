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
import java.awt.Font;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main_page extends JFrame 
{
   public JFrame frame;
   private JPanel contentPane;
   public static Main_page Main_page;
   BufferedReader in;
   PrintWriter out;
   String name;
   String whi = null;

   public static void main(String[] args) 
   {
	   EventQueue.invokeLater(new Runnable() {
         public void run() 
         {
            try
            {
               Main_page = new Main_page();
               Main_page.frame.setVisible(true);
            }
            catch (Exception e) 
            {
               e.printStackTrace();
            }
         }
      });
   }

   public Main_page() 
   {
      M_Page();
   }

   public void M_Page() 
   {
      frame = new JFrame();
      frame.setTitle("Cafe"); // Frame의 타이틀 이름 주기
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            try 
            {
               CheckSeat CS = new CheckSeat();
            } 
            catch (IOException e) 
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      });
      
      // 마우스 갖다 댔을 때랑 뺐을 때
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
            try 
            {
               ChangeSeat CH = new ChangeSeat();
            } 
            catch (IOException e) 
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      });
      
      Change_the_seat.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent arg0) 
         {
            Change_the_seat.setForeground(new Color(255, 228, 225));
            Change_the_seat.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 50));
         }

         @Override
         public void mouseExited(MouseEvent e) 
         {
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
        	 // Main 창 꺼지게 하는거.
        	 frame.setVisible(false);
            try {
               Order OD = new Order();
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      });
   }
}