package ShutDownServer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BrodcastServer extends JFrame implements ActionListener
{
	JPanel p1,p2;
	JRadioButton r1,r2;
	JLabel l,l2,l3;
	JTextField t;
	JButton b;
	ButtonGroup bg;
	
	ArrayList<Socket> list = new ArrayList<>();
	
	String command; 
	
	public BrodcastServer() 
	{
		super("Brodcast");
		
		setSize(300, 200);
		setLocationRelativeTo(null);
		
		p1=new JPanel(new GridLayout(1,2,5,5));
		add(p1);
		r1=new JRadioButton("Msg");
		p1.add(r1);
		r2=new JRadioButton("cmd");
		p1.add(r2);
		
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		p2=new JPanel(new GridLayout(1,3,5,5));
		add(p2,BorderLayout.SOUTH);
		l=new JLabel("ENter Txt");
		p2.add(l);
		
		t=new JTextField();
		p2.add(t);
		r1.addActionListener(this);
		r2.addActionListener(this);
		b=new JButton("Send");
		p2.add(b);
		b.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		acceptconnection();
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==r1)
			command="T";
		if(e.getSource()==r2)
			command="C";
		
		if(e.getSource()==b)
		{
			
			for(Socket temp : list)
			{
				try {
					 DataOutputStream out=new DataOutputStream(temp.getOutputStream());
					out.writeUTF(command+":"+t.getText());
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
			System.out.println("msg send");
		}
		
		
		
		
		
	}
	
	
	public void acceptconnection()
	{
		try{
		ServerSocket ss = new ServerSocket(4444);
		while(true)
		{
			System.out.println("Server Waiting ");
			Socket s=ss.accept();
			list.add(s);
			System.out.println("Client Connected");
		}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) 
	{
		BrodcastServer s=new BrodcastServer();		
	}

	

}
