package Download;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Download  extends JFrame implements ActionListener
{
	JPanel p1,p2;
	
	JButton b1;
	JLabel l1,l2,l3;
	JTextField t1,t2;
	public Download() {
		
		super("Downloader");
		
		setSize(200,200);
		setLocationRelativeTo(null);
		
		p1=new JPanel(new GridLayout(2,1,10,10));
		add(p1);
		
		p2=new JPanel(new GridLayout(1,2,5,5));
		add(p2,BorderLayout.SOUTH);
		l1=new JLabel("Enter Url");
		t1=new JTextField();
		p1.add(l1);
		p1.add(t1);
	t2=new JTextField();
		l2=new JLabel("Enter Dest");
		p1.add(l2);
		p1.add(t2);
		l3=new JLabel();
		
		b1=new JButton("DownLoad");
		p2.add(b1);
		p2.add(l3);
		
        b1.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
	
		try {
			URL url=new URL(t1.getText());
			
			FileOutputStream fout=new FileOutputStream(t2.getText());
			
			InputStream in = url.openStream();
			
			while(true)
			{
				
				int data=in.read();
			
				fout.write(data);
				if(data==-1)
					break;
				
			}
			
			String str="Downloaded...";
			l3.setText(str);
			
			fout.close();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Download d= new Download();

	}

	

}
