package Bounce1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Race extends JFrame implements ActionListener
{

	JPanel p2;
	Paint p1;
	JButton b1;
	Random ra;
	Thread t;
	int step=5;
	int count;
	ArrayList<Ball> balls;
	public static void main(String[] args) 
	{
	Race r=new Race();
	}
	Race()
	{
	setSize(400,600);
		balls=new ArrayList<>();
	p1=new Paint();
	add(p1);
	p2=new JPanel();
	b1=new JButton("start");
	add(p2,BorderLayout.SOUTH);
	p2.add(b1);
	b1.addActionListener(this);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	ra=new Random();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			Ball bb1=new Ball(50, 10);
			balls.add(bb1);
			Ball bb2=new Ball(100, 20);
			balls.add(bb2);
			Ball bb3=new Ball(150, 30);
			balls.add(bb3);
			repaint();
			t=new Mythread(bb1);
			t.start();
			t=new Mythread(bb2);
			t.start();
			t=new Mythread(bb3);
			t.start();
			
			
		}
		
	}
	class Mythread extends Thread{
		
		Ball b;
		public Mythread(Ball b) {
			this.b=b;
			
		}
		public void run()
		{
			while(!b.exit)
			{
				
				try {
					b.race();
					repaint();
					Thread.sleep(b.delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	class Paint extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			for (Ball b : balls)
			{
			g.setColor(b.c);
			g.fillOval(b.x, b.y, 20, 20);
			
			}
		}
		
	}
	public synchronized void reached()
	{
		count++;
		if(count != 3)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		count=0;
		step=-step;
		notifyAll();
		
	}
	class Ball 
	{
		int x,y,delay;
		Color c;
		boolean exit;
		Ball(int x,int delay)
		{
			this.c=new Color(ra.nextInt(255), ra.nextInt(255), ra.nextInt(255));
			this.x=x;
			this.y=500;	//int)p1.getBounds().getMaxY();
			this.delay=delay;
			
		}
		public void race()
		{
			y=y-step;
			if(y<=0 || y>500)
			{
				reached();
			}
			
		}
		
		
		
	}

}
