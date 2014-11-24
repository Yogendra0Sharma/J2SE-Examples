package CustomPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Bouncing extends JFrame implements Runnable,ActionListener{
	private JButton strt,stop;
	private JPanel p2;
	private int x,y,w,h,dx,dy;
	private int x_min,x_max,y_min,y_max;
	private MyPanel m1;
	private Thread t;
	boolean exit=false;
	private Color c;
	private Random ra;
	
	public static void main(String[] args) {
		new Bouncing();

	}
	public Bouncing()
	{
		super("Bouncing Ball");
		ra=new Random();
		x=y=0;
		w=30;h=30;
		dx=dy=5;
		setSize(600,400);
		setLocationRelativeTo(null);
		m1=new MyPanel();
		p2=new JPanel(new GridLayout(1,2));
		strt=new JButton("Start");
		strt.addActionListener(this);
		p2.add(strt);
		stop=new JButton("Stop");
		stop.addActionListener(this);
		p2.add(stop);
		add(p2,BorderLayout.SOUTH);
		add(m1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==strt)
		{
			if(t==null)
			{
				exit=false;
				
				t=new Thread(this);
				t.start();
			}
		}
		else 
			exit=true;
		
	}
	@Override
	public void run() {
		try{
			while(!exit)
			{
				custmove();
				m1.repaint();
				Thread.sleep(10);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		t=null;
	}
	
	public void custmove()
	{
	   Rectangle r=m1.getBounds();
	   x_min=(int)r.getMinX();
	   y_min=(int)r.getMinY();
	   x_max=(int)r.getMaxX();
	   
	   y_max=(int)r.getMaxY();
	  /* if(x < x_min)
	   {
		   x=x_min;
	   }
	   if(x >= x_max)
	   {
		   x=x_max;
		   dx=-dx;
	   }
	   if(y < y_min)
	   {
		   y=y_min;
	   }
	   if(y >= y_max)
	   {
		   y=y_max;
		   dy=-dy;
	   }*/
	   if(x < x_min || x >= x_max-40)
	   {
		   dx = -dx;
		   c=new Color(ra.nextInt(255), ra.nextInt(255),  ra.nextInt(255));
	   }
	   if(y < y_min || y >= y_max-40)
	   {
		  dy = -dy;
		  c=new Color(ra.nextInt(255), ra.nextInt(255),  ra.nextInt(255));
	   }
	   x=x+dx;
	   y=y+dy;
	   /*System.out.println("x = "+ x + "  y = "+y + "  "+x_min + "  "+x_max);*/
		   
	}
	
	
	class MyPanel extends JPanel {
		public MyPanel()
		{
			super();
		}
		@Override
		public void paintComponent(Graphics g)
		{
			
			super.paintComponent(g);
			
			g.setColor(c);
			g.fillOval(x, y, w, h);
		}
	
	}
	
}
