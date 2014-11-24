package ShutDownServer;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BrodcastClient extends JFrame
{

	JTextArea t1;
	
	public BrodcastClient() throws Exception
	{
		super("Client");
		setSize(200, 200);
		setLocationRelativeTo(null);
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());
	 t1=new JTextArea();
		add(p);
		p.add(t1);
		t1.setEditable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		connect();
		
	}
	
	public void connect() throws Exception
	{
		Socket s=new Socket("localhost",4444);
		System.out.println("Connected to server..");
		
		
		final DataInputStream in = new DataInputStream(s.getInputStream());
		
		Thread t= new Thread(){
			
			@Override
			public void run() {
				try {
				
					while(true)
					{
						
						System.out.println("Waiting for msg");
						String msg = in.readUTF();
						StringTokenizer token =new StringTokenizer(msg,":");
						String command=token.nextToken();
						String data=token.nextToken();
						
						if(command.equals("T"))
						t1.append("\n"+msg);
						else
							Runtime.getRuntime().exec(data);
					
				} 
				}catch (IOException e) {
					
					e.printStackTrace();
				}
					
			}
		};
		
		t.start();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		BrodcastClient c=new BrodcastClient();
	}

}
