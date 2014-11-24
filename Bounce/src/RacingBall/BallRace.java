package RacingBall;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BallRace extends JFrame implements ActionListener
{

	JPanel p2;
	JButton d;
	ArrayList<Ball> balls;
	Mypanel p1;
	//Ball d1,d2,d3;
	boolean flag;
	Thread t;
	int count;
	int step;
	public BallRace(String str) 
	{
		
		super(str);
		step=5;
		balls =new ArrayList<>();
		setSize(400,600);
		setLocationRelativeTo(null);
		p1=new Mypanel();
		add(p1);
		
		p2=new JPanel();
		add(p2,BorderLayout.SOUTH);
		
		d=new JButton("Start");
		d.addActionListener(this);
		p2.add(d);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// pack();
		
		setVisible(true);
	}
	
	class Mypanel extends JPanel
	{
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			for(Ball b:balls)
			{
				
				g.setColor(Color.red);
				g.fillOval(b.dx, b.y, 50,50);
			}
			
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==d)
		{	
			if(!flag)
			{
			flag=true;
			Ball b1=new Ball(50,10);
			balls.add(b1);
			Ball b2=new Ball(150,30);
			balls.add(b2);
			Ball b3=new Ball(250,50);
			balls.add(b3);
			repaint();

			
			t=new MyBall(b1);
			t.start();
			
			t=new MyBall(b2);
			t.start();
		
			t=new MyBall(b3);
			t.start();
			
			}
		}
		
	}
	
	class MyBall extends Thread
	{
		private Ball b;
		MyBall(Ball b)
		{
			this.b=b;
		}
		
		
		public void run()
		{
			
			try{
				while(!b.exit)
				{
				Thread.sleep(b.delay);
				b.Ballmove();
				repaint();
				
				
					}
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
	}
	
	
	public synchronized void reached() throws Exception
	{
		count++;
		if(count!=3)
			wait();
		
		if(count==3)
			step=-step;
		count=0;
		notifyAll();		
	}
	
	
	class Ball
	{
		int dx,y;
		boolean exit;
		int delay;
		public Ball(int dx,int delay) {
			super();
			this.dx = dx;
			
			System.out.println(p1.getBounds().height);
			
			this.y=p1.getBounds().height-50;
			this.delay=delay;
		}

		@Override
		public String toString() {
			return "Ball [dx=" + dx + "]";
		}
		
		
		public void Ballmove()
		{
			
			try{
				y=y-step;
				if(y<=0||y>p1.getBounds().height-50)
				{
					reached();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

	
	public static void main(String[] args) {
		
		BallRace B=new BallRace("Racing Ball");

	}



	

}
