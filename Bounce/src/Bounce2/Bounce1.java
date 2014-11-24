package Bounce2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bounce1 extends JFrame implements Runnable,ActionListener
{
	int x=0;
	int y=0;
	int dx=5;
	int dy=5;
	JPanel p2;
	mypanel p1;
	JButton b1,b2;
	Random ra;
	Color c;
	private Thread t;
	private boolean exit;
	
	public Bounce1(String str) {
		super(str);
		setSize(400, 200);
		setLocationRelativeTo(null);
		ra=new Random();
		
	 p1=new mypanel();
		add(p1);
		p2 = new JPanel(new GridLayout(1, 3, 20, 10));
		
		b1 = new JButton("Start");
		
		try {
			Runtime.getRuntime().exec("notepad");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p2.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Stop");
		b2.addActionListener(this);
		p2.add(b2);
		// add p2 to frm --south region
		add(p2, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// pack();
		setVisible(true);
	}
	
	
	public void run()
	{
		try {
			System.out.println("In run");
			while (!exit) 
			{
				 p1.bounce();
				 
				
			}
			
			
		} catch (Exception e) {
			System.out.println("Error in  thrd "
					+ Thread.currentThread().getName() + " " + e);
		}
		System.out.println("over " + Thread.currentThread().getName());
		t = null;
	}

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try {
			System.out.println("In actoion perform Thread: " + Thread.currentThread().getName());
			if (e.getSource()== b1)
			{
				if (t == null)
				{
					exit = false;
					t = new Thread(this);
					t.start();
				}
			} else
				exit = true;
		} catch (Exception e1) {
			System.out.println("Action perform error " + e1);
		}
	}
	
	class mypanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			System.out.println("In paint");
			g.setColor(c);
			g.fillOval(x, y, 20, 20);
			
		}
		
		public void bounce()
		{
			
			
				x=x+dx;
				y=y+dy;
			if(x>(getBounds().getMaxX()-30)||x<=0)
			{
				dx=dx*-1;
				c=new Color(ra.nextInt(255), ra.nextInt(255),  ra.nextInt(255));
			}
			if(y>(getBounds().getMaxY()-30)||y<=0)
				{
				c=new Color(ra.nextInt(255), ra.nextInt(255),  ra.nextInt(255));
				dy=dy*-1;
				}
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
	}
	public static void main(String[] args) {
		Bounce1 t1 = new Bounce1("Bouncing Boll");

	}
	
	
}
