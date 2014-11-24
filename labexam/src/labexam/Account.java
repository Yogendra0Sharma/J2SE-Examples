package labexam;

public class Account
{
	private int aid;
	private String aname;
	private double amount;
	private int pin;
	
	public Account(int aid, String aname, double amount,int pin) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.amount = amount;
		this.pin=pin;
		
	}
	
	@Override
	public String toString() {
		return "Account aid=" + aid + ", aname=" + aname + ", amount="
				+ amount;
	}
	@Override
	public boolean equals(Object o)
	{
		
		if(pin == ((Account)o).pin)
			return true;
		return false;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPin() {
		return pin;
	}

	public String getAname() {
		return aname;
	}

	public int getAid() {
		return aid;
	}	

	
	}
