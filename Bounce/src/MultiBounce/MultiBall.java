package MultiBounce;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MultiBall extends JFrame implements ActionListener  //Multiple Ball Class Start
{
	

	JPanel p2;
	Mypanel p1;
	JButton b1,b2;
	Random ra;
	Color c;
	private Thread t;
	ArrayList<Ball> balls;
	private boolean exit;
	boolean isStopped = false;
	
	public MultiBall(String str)
	{
		super(str);
		setSize(400, 200);
		setLocationRelativeTo(null);
		ra=new Random();
		
		p1=new Mypanel();
		add(p1);
		p2 = new JPanel(new GridLayout(1, 3, 20, 10));
		
		b1 = new JButton("Start");
		
		p2.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Stop");
		b2.addActionListener(this);
		p2.add(b2);
		// add p2 to frm --south region
		add(p2, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// pack();
		balls=new ArrayList<>();
		setVisible(true);
		
}//MultiBall Class Finish 
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("in action");
		
		if (e.getSource()== b1)
		{
			exit=false;
			Ball b=new Ball();
			balls.add(b);
			System.out.println(balls);
			Thread t=new MoveBall(b);			
			t.start();			
			
			if(isStopped)
			{
				for(Ball temp : balls)
				{
					new MoveBall(temp).start();
					System.out.println("here");
					
				}
			}
			isStopped = false;			
			
		}
		else
		{
			exit=true;
			isStopped = true;
		}
		
	} //Coustom Panel
	
	
	class MoveBall extends Thread
	{
		private Ball b;

		public MoveBall(Ball b) {
			super();
			this.b = b;
		}
		
		public void run()
		{
	
			try{
				while(!exit)
				{
					System.err.println("in run"+b.dx+b.dy);
				b.x=b.x+b.dx;
				b.y=b.y+b.dy;
			if(b.x>(p1.getBounds().getWidth()-30)||b.x<=0)
			{
				b.dx=b.dx*-1;
				//c=new Color(ra.nextInt(255), ra.nextInt(255),  ra.nextInt(255));
			}
			if(b.y>(p1.getBounds().getHeight()-30)||b.y<=0)
				{
				//c=new Color(ra.nextInt(255), ra.nextInt(255),  ra.nextInt(255));
				b.dy=b.dy*-1;
				}
				//p2.repaint();
			
			Thread.sleep(b.delay);
			repaint();
				}	
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		
	}
	
	class Ball //Ball Class Start
	{
		Random r=new Random();
		private int x;
		private int y;
		int dx=5;
		int dy=5;
		int size= r. nextInt(5*10)+20;
		int delay = r. nextInt(10*10)+20;
		
		Color c=new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public Color getC() {
			return c;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public String toString() {
			return "Ball [x=" + x + ", y=" + y + ", c=" + c + "]";
		}
		
		
	} //Ball Class Finish
	
	class Mypanel extends JPanel //Coustom Panel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			System.out.println("In paint");
			for (Ball b : balls)
			{
				System.out.println("for balls");
				g.setColor(b.getC());
				g.fillOval(b.getX(), b.getY(), b.size, b.size);
			}
		}
	}
	public static void main(String args[])
	{
		MultiBall m=new MultiBall("MultiBounce");
	}
}

	
	

