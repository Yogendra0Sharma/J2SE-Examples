package ChatServer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChatServer extends JFrame
{
	JPanel p;
	private int Port=5000;
	ServerSocket ss;
	Socket ds;
	public ChatServer() throws Exception
	{
		super("ChatServer");
		setSize(600,600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		p=new JPanel();
		add(p);
		BufferedImage pic=ImageIO.read(new File("src/img/server.jpg"));
		JLabel l=new JLabel(new ImageIcon(pic));
		add(l);
		setVisible(true);
		
		BL();
	}
	
	public void BL() throws Exception
	{
		ss=new ServerSocket(Port);
		System.out.println("Chat Server Waiting For Client");
		
		ds=ss.accept();
		
		System.out.println("Client Connected!");
		
		
		
	}
	
	

	public static void main(String[] args) throws Exception
	{
	ChatServer c= new ChatServer();	
	}

}
