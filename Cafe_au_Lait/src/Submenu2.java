import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Submenu2 extends Order 
{
   JFrame Submenuframe2;
   BufferedReader in;
   PrintWriter out; 
   static String Sub="";

   public static void main(String[] args) 
   {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Submenu2 window = new Submenu2();
               window.Submenuframe2.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public Submenu2() throws IOException 
   {
      initialize();
      this.Submenuframe2.setVisible(true);
   }

   public void initialize() 
   {
      Submenuframe2 = new JFrame();
      Submenuframe2.getContentPane().setBackground(new Color(25, 25, 112));
      Submenuframe2.getContentPane().setLayout(null);
      Submenuframe2.setTitle("Submenu");
      Submenuframe2.setSize(400, 200);
      Submenuframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // 현재 선택된 메뉴
      JTextArea menuinfo = new JTextArea();
      menuinfo.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
      menuinfo.setBackground(Color.WHITE);
      menuinfo.setBounds(296, 23, 215, 65);
      Submenuframe2.getContentPane().add(menuinfo);
      menuinfo.append(Order.name);

      //////////// 버튼들
      JButton sizeL = new JButton("Large");
      sizeL.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 25));
      sizeL.setForeground(new Color(255, 215, 0));
      sizeL.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            final_menu = name + "(Large)" + " ";
            sub = sub + 500;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(Large)");
            name = final_menu;
         }
      });
      sizeL.setBounds(227, 158, 133, 54);
      sizeL.setBackground(new Color(25, 25, 112));
      Submenuframe2.getContentPane().add(sizeL);

      JButton sizeS = new JButton("Small");
      sizeS.setForeground(new Color(255, 215, 0));
      sizeS.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 25));
      sizeS.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            final_menu = name + "(Small)" + " ";
            sub = sub + 0;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(Small)");
            name = final_menu;
         }
      });
      sizeS.setBounds(403, 158, 133, 54);
      sizeS.setBackground(new Color(25, 25, 112));
      Submenuframe2.getContentPane().add(sizeS);

      JButton kindH = new JButton((Icon) null);
      kindH.setForeground(new Color(255, 215, 0));
      kindH.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 25));
      kindH.setBounds(227, 268, 133, 54);
      Submenuframe2.getContentPane().add(kindH);
      kindH.setText("Hot");
      kindH.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            final_menu = name + "(Hot)" + " ";
            sub = sub + 0;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(Hot)");
            name = final_menu;
         }
      });
      kindH.setBackground(new Color(25, 25, 112));

      JButton kindI = new JButton("Ice");
      kindI.setForeground(new Color(255, 215, 0));
      kindI.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 25));
      kindI.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            final_menu = name + "(Ice)" + " ";
            sub = sub + 500;
            Sub=sub+"";
            menuinfo.append(Sub);
            menuinfo.append("(Ice)");
            name = final_menu;
         }
      });
      kindI.setBounds(403, 268, 133, 54);
      kindI.setBackground(new Color(25, 25, 112));
      Submenuframe2.getContentPane().add(kindI);
      /////////////////////////////////////////

      JLabel selected = new JLabel("Now selected");
      selected.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 40));
      selected.setForeground(new Color(255, 215, 0));
      selected.setBounds(70, 31, 246, 46);
      Submenuframe2.getContentPane().add(selected);
      JLabel lblNewLabel_4 = new JLabel("Size");
      lblNewLabel_4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
      lblNewLabel_4.setForeground(new Color(25, 25, 112));
      lblNewLabel_4.setBounds(125, 158, 117, 46);
      Submenuframe2.getContentPane().add(lblNewLabel_4);

      JButton complete = new JButton("Complete");
      complete.setForeground(new Color(25, 25, 112));
      complete.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
      complete.setBackground(new Color(255, 215, 0));
      complete.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               Order or = new Order();
               Submenuframe2.setVisible(false);
               Orderframe.setVisible(true);
               sub=0;
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      });
      complete.setBounds(536, 403, 184, 100);
      Submenuframe2.getContentPane().add(complete);

      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      panel.setBounds(70, 126, 650, 234);
      Submenuframe2.getContentPane().add(panel);
      panel.setLayout(null);
      JLabel lblNewLabel = new JLabel("Type");
      lblNewLabel.setBounds(55, 145, 60, 39);
      panel.add(lblNewLabel);
      lblNewLabel.setForeground(new Color(25, 25, 112));
      lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
      Submenuframe2.setResizable(false);
      Submenuframe2.setBounds(400, 200, 800, 600);
   }

}