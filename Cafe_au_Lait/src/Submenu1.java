import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Icon;
import java.awt.Font;

public class Submenu1 extends Order 
{
   JFrame Submenu1;
   BufferedReader in;
   PrintWriter out;
   String Sub="";
  
   public static void main(String[] args) 
   {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Submenu1 window = new Submenu1();
               window.Submenu1.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public Submenu1() throws IOException 
   {
      initialize();
      this.Submenu1.setVisible(true);
   }

   public void initialize() 
   {
      Submenu1 = new JFrame();
      Submenu1.getContentPane().setBackground(new Color(25, 25, 112));
      Submenu1.getContentPane().setLayout(null);
      Submenu1.setTitle("submenu");
      Submenu1.setSize(400, 200);
      Submenu1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // 현재 선택된 메뉴
      JTextArea menuinfo = new JTextArea();
      menuinfo.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 15));
      menuinfo.setBackground(Color.WHITE);
      menuinfo.setBounds(283, 25, 271, 62);
      Submenu1.getContentPane().add(menuinfo);
      menuinfo.append(Order.name);

      //////////// 버튼들
      JButton sizeL = new JButton("Large");
      sizeL.setForeground(new Color(255, 215, 0));
      sizeL.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
      sizeL.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            final_menu = name + "(Large)";
            sub = sub + 500;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(Large)");
            name = final_menu;
         }
      });
      sizeL.setBounds(227, 158, 133, 54);
      sizeL.setBackground(new Color(25, 25, 112));
      Submenu1.getContentPane().add(sizeL);

      JButton sizeS = new JButton("Small");
      sizeS.setForeground(new Color(255, 215, 0));
      sizeS.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
      sizeS.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            final_menu = name + "(Small)";
            sub = sub + 0;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(Small)");
            name = final_menu;
         }
      });
      sizeS.setBounds(403, 158, 133, 54);
      sizeS.setBackground(new Color(25, 25, 112));
      Submenu1.getContentPane().add(sizeS);

      JButton kindH = new JButton((Icon) null);
      kindH.setForeground(new Color(255, 215, 0));
      kindH.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
      kindH.setText("Hot");
      kindH.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            final_menu = name + "(Hot)";
            sub = sub + 0;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(Hot)");
            name = final_menu;
         }
      });
      kindH.setBounds(227, 235, 133, 54);
      kindH.setBackground(new Color(25, 25, 112));
      Submenu1.getContentPane().add(kindH);

      JButton kindI = new JButton("Ice");
      kindI.setForeground(new Color(255, 215, 0));
      kindI.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
      kindI.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            final_menu = name + "(Ice)";
            sub = sub + 500;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(Ice)");
            name = final_menu;
         }
      });
      kindI.setBounds(403, 235, 133, 54);
      kindI.setBackground(new Color(25, 25, 112));
      Submenu1.getContentPane().add(kindI);

      JButton shotN = new JButton("No");
      shotN.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
      shotN.setForeground(new Color(255, 215, 0));
      shotN.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            final_menu = name + "(No shot)";
            sub = sub + 0;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(No shot)");
            name = final_menu;
         }
      });
      shotN.setBounds(227, 320, 133, 54);
      shotN.setBackground(new Color(25, 25, 112));
      Submenu1.getContentPane().add(shotN);

      JButton shot1 = new JButton("1 shot");
      shot1.setForeground(new Color(255, 215, 0));
      shot1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
      shot1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            final_menu = name + "(1 shot)";
            sub = sub + 500;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(1 shot)");
            name = final_menu;
         }
      });
      shot1.setBounds(403, 320, 133, 54);
      shot1.setBackground(new Color(25, 25, 112));
      Submenu1.getContentPane().add(shot1);

      JButton shot2 = new JButton("2 shot");
      shot2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
      shot2.setForeground(new Color(255, 215, 0));
      shot2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            final_menu = name + "(2 shot)";
            sub = sub + 500;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(2 shot)");
            name = final_menu;
         }
      });
      shot2.setBackground(new Color(25, 25, 112));
      shot2.setBounds(568, 320, 133, 54);
      Submenu1.getContentPane().add(shot2);
      //////////////////////////////////////

      JLabel selected = new JLabel("Now selected");
      selected.setForeground(new Color(255, 215, 0));
      selected.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 35));
      selected.setBounds(85, 31, 226, 46);
      Submenu1.getContentPane().add(selected);
      JLabel lblNewLabel_4 = new JLabel("Size");
      lblNewLabel_4.setForeground(new Color(25, 25, 112));
      lblNewLabel_4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
      lblNewLabel_4.setBounds(125, 158, 117, 46);
      Submenu1.getContentPane().add(lblNewLabel_4);

      JButton complete = new JButton("Complete");
      complete.setForeground(new Color(25, 25, 112));
      complete.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
      complete.setBackground(new Color(255, 215, 0));
      complete.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               Order or = new Order();
               Submenu1.setVisible(false);
               Orderframe.setVisible(true);
               sub=0;
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      });
      complete.setBounds(532, 422, 184, 100);
      Submenu1.getContentPane().add(complete);

      JPanel submenuList = new JPanel();
      submenuList.setBackground(Color.WHITE);
      submenuList.setBounds(76, 128, 640, 270);
      Submenu1.getContentPane().add(submenuList);
      submenuList.setLayout(null);
      JLabel lblNewLabel = new JLabel("Type");
      lblNewLabel.setBounds(46, 112, 73, 36);
      submenuList.add(lblNewLabel);
      lblNewLabel.setForeground(new Color(25, 25, 112));
      lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
      JLabel lblNewLabel_1 = new JLabel("Add Shot");
      lblNewLabel_1.setBounds(24, 209, 117, 24);
      submenuList.add(lblNewLabel_1);
      lblNewLabel_1.setForeground(new Color(25, 25, 112));
      lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 25));
      Submenu1.setResizable(false);
      Submenu1.setBounds(400, 200, 800, 600);
   }
}