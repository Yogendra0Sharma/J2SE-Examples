package ChatClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.Socket;
import java.util.concurrent.BrokenBarrierException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CopyOfChatClient extends JFrame implements ActionListener
	{
		Socket s;
		JPanel p1,p2,p3;
		JButton b1,b2,b3,b4;
		JLabel l,l1,l2;
		JTextField msg;
		JTextArea chat,sender;
		private String IP="127.0.0.1";
		private int Port  =5000;
		
		
	public CopyOfChatClient() throws Exception
	{
		setSize(400, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(Color.gray);
		
		
		p1=new JPanel(new GridLayout(1,3,10,10));
		add(p1,BorderLayout.NORTH);
		
		BufferedImage pic=ImageIO.read(new File("src/img/ll.png"));
		JLabel l=new JLabel(new ImageIcon(pic));
		p1.add(l);
		
		b1=new JButton("Login");
		b2=new JButton("Change Password");
		p1.add(b1);
		p1.add(b2);
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		p2=new JPanel(new GridLayout(1,2,10,10));
		chat =new JTextArea();
		chat.setFont(new Font("Courier New", Font.BOLD, 16));
		chat.setForeground(Color.red);
		chat.setBackground(Color.white);
		chat.setEditable(false);
		p2.add(chat);
		//sender chat
		
		sender =new JTextArea();
		sender.setFont(new Font("Courier New", Font.BOLD, 16));
		sender.setForeground(Color.red);
		sender.setBackground(Color.white);
		sender.setEditable(false);
		p2.add(chat,BorderLayout.EAST);
		p2.add(sender,BorderLayout.WEST);
		//add 
		add(p2,BorderLayout.CENTER);
		p3=new JPanel(new GridLayout(1,2,10,10));
		
		JPanel p4=new JPanel(new GridLayout(1,2,5,5));
		add(p3,BorderLayout.SOUTH);
		
		b3=new JButton("Send");
		msg = new JTextField();
		b4=new JButton("File");
		p3.add(msg);
		p3.add(p4);
		p4.add(b3);
		p4.add(b4);
		b4.addActionListener(this); //file Transfer
		
		//Scoket
		
		s=new Socket(IP,Port);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			String Username=JOptionPane.showInputDialog("Please Enter Username");
			String Password=JOptionPane.showInputDialog("Please Enter Password");
			
			chat.setText(Username);
			sender.setText(Password);
		}
		
		if(e.getSource()==b2)
		{
			String NewPassword=JOptionPane.showInputDialog("Please Enter New Password");
		}
		if(e.getSource()==b4){
			String image =JOptionPane.showInputDialog(new JFileChooser());
			
		}
	}
	

	public static void main(String[] args) throws Exception
	{
		CopyOfChatClient c=new CopyOfChatClient();
	}
}
