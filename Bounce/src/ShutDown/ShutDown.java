package ShutDown;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShutDown extends JFrame implements ActionListener
{
	JPanel p1,p2;
	JButton b1,b2,b3,b4;
	JTextField t;
	JLabel l;
	public ShutDown() 
	{
		setSize(400, 150);
		setLocationRelativeTo(null);
		p1=new JPanel(new GridLayout(2,3,5,5));
		add(p1);
		b1=new JButton("ShutDown");
		b2=new JButton("Logoff");
		b3=new JButton("Restart");
		b4=new JButton("Stop");
		l=new JLabel("Enter Time");
		t=new JTextField();
		p1.add(l);
		p1.add(t);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String time=t.getText();
		try{
		
		if(e.getSource()==b1)
		{
		
			Runtime.getRuntime().exec("shutdown -s -t "+time);
		
		}
		if(e.getSource()==b2)
		{
			
				Runtime.getRuntime().exec("shutdown -l");
			
		}
		if(e.getSource()==b3)
		{
			
				Runtime.getRuntime().exec("shutdown -r");
			
		}
		if(e.getSource()==b4)
		{
			
				Runtime.getRuntime().exec("shutdown -a");
			
		
		}
		
	}catch(Exception ae)
		{
		ae.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) 
	{
		
		ShutDown s=new ShutDown();
	}



}
