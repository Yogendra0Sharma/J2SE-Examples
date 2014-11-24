package labexam;

public class prodInfo 
{

	private String pname;
	private int pid;
	private String cat;
	private double price;
	public prodInfo(int pid,String pname, String cat, double price) {
		super();
		this.pname = pname;
		this.pid = pid;
		this.cat = cat;
		this.price = price;
	}
	public prodInfo(int id)
	{
		this.pid=id;
	}
	@Override
	public String toString() {
		return "ProdInfo pname=" + pname + ", pid=" + pid + ", cat=" + cat
				+ ", price=" + price;
	}
	
	public boolean equals(Object o)
	{
		
		if(pid == ((prodInfo)o).pid)
			return true;
		return false;
		
		
	}
	public int getPid() {
		return pid;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	
	
	
}
