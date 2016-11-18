import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;

public class Serv 
{
    private static final int PORT = 9001;
    
    public static void main(String[] args) throws Exception 
    {
        System.out.println("The server is running.");
        ServerSocket listener = new ServerSocket(PORT);
        try 
        {
            while (true) 
            {
                new Handler(listener.accept()).start();
            }
        } 
        finally 
        {
            listener.close();
        }
    }
	
    private static class Handler extends Thread
    {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        public String temp;
        public boolean check = false;
        public BufferedReader test;
        
        public Handler(Socket socket) 
        {
            this.socket = socket;
        }

        public void run() 
        {
            try 
            {
                // Create character streams for the socket.
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                
                while (true) 
                {
                	
                	
                	
                }
            }
            catch (IOException e) 
            {
                System.out.println(e);
            } 
            
            }
        }
    }	

