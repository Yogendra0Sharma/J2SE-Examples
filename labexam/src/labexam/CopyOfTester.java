package labexam;
import java.util.*;

public class CopyOfTester
{
	static HashMap<Integer,prodInfo>prod=new HashMap<>();
	static HashMap<String,userinfo>user=new HashMap<>();
	 
	public static void main(String []arg)
	{
		Boolean exit=true;
		String ch;
		
		prod.put(100, new prodInfo( 100,"motoG","Mobile",1000));
		prod.put(101, new prodInfo( 101,"motoE","Mobile",1001));
		prod.put(102, new prodInfo( 102,"motoX","Mobile",1002));
		//System.out.println(prod);
		HashMap<String,userinfo>user=new HashMap<>();
		
		user.put("admin", new userinfo("admin","admin"));
		
		HashMap<Integer, Account> acc =new HashMap<>();
		acc.put(500, new Account(500, "Yogi", 120000,12345));
		acc.put(501, new Account(501, "Shivam", 150000,12345));
		acc.put(502, new Account(502, "Chotu", 200000,12345));
		
		Scanner sc=new Scanner(System.in);
		Collection<prodInfo> c=prod.values();
		LinkedList<prodInfo> l=new LinkedList<>(c);
		while(exit)
		{
			System.out.println("=========Welcome to EShop=========");
			System.out.println("Enter Your Choice");
			
			System.out.println("1: Login,2: Register, 3:ExitApp");
			
			
			boolean exit1=true;
			
			switch(sc.nextInt())
			{
			case 1:
				System.out.println("Enter Your Username & Password");
				
				String usern=sc.next();
				String pw=sc.next();
				/*userinfo chck=new userinfo(usern, pw);*/
				if(!usern.equals("admin") && !pw.equals("admin"))
				{
				if(user.containsKey(usern))
				{
					if(user.get(usern).getPw().equals(pw))
					{
						
						HashSet<prodInfo> cart=new HashSet<>();
				b1: while(exit1)
					{
				System.out.println("\n 1.Display All Product \n 2.Display A Product \n 3.Add To Cart \n 4.Show Cart \n 5.Remove From Cart \n 6.CheckOut");
				switch(sc.nextInt())
				{
				case 1: 
					for (prodInfo p1 : l)
					{
						System.out.println(p1);
					}
					
					break;
				
				case 2:
					System.out.println("Enter The Product Id\n");
					int id=sc.nextInt();
					prodInfo p2=new prodInfo(id);
					if(prod.containsKey(id))
					{
						System.out.println(prod.get(id));
					}
					break;
				case 3: System.out.println("Enter The Id\n");
					int id1=sc.nextInt();
					cart.add(prod.get(id1));
					break;
				case 4:
					
					for (prodInfo p4 : cart)
					{
					System.out.println("Your Cart is "+p4);	
					}
					break;
				case 5: System.out.println("Enter The Id To Be Removed\n");
						int id3=sc.nextInt();
						for (prodInfo p3 : cart)
						{
							if(id3 == p3.getPid())
							{
							cart.remove(p3);	
							}
						}
						break;
				case 6:
					System.out.println("######**** Total Bill ****#####");
					double total=0;
					for (prodInfo p4 : cart)
					{
						total=total+p4.getPrice();
					}
					System.out.println("Your Total bill is \n"+total);
					
					System.out.println("Do You Want to Pay Bill, Y or N\n");
					if(sc.next().equals("Y"))
					{
						System.out.println("Please Enter Your Acount Number");
						int ano=sc.nextInt();
						
						if(acc.containsKey(ano))
						{
							System.out.println("Enter Your Pin");
							int pno=sc.nextInt();
					
							if(acc.get(ano).getPin()==(pno))
							{
								System.out.println("Thankx For Transaction");
								double r=acc.get(ano).getAmount()-total;
								acc.get(ano).setAmount(r);
							}
						}
						Random r = new Random();
						System.out.println(r.nextInt());
						System.out.println("Your Billing info:\n ");
						System.out.println("Product Selected:: \n "+cart);
						System.out.println("Total Amount::\n "+total);
						System.out.println("Your Transcation id is \n"+Math.abs(r.nextInt()));
						System.out.println("Name and Account Number::\n "+acc.get(ano).getAname()+" \t"+acc.get(ano).getAid());
						System.out.println("Remaining amount is::\n "+acc.get(ano).getAmount());
						System.out.println("\n");
						System.out.println("\n");
						break b1;
					}
					
					else{
					System.out.println("Your are Logedout\n");
					exit1=false;
						break b1;
						
					}
					}
					}
					}
				}
				}
				else
				{
					System.out.println("\n1:Add Product\n2:Remove Product\n3:Update Price\n 4:Logout\n");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Enter Product Details:Product id,Product name,Category,Price\n");
					int pid=sc.nextInt();
					l.add(new prodInfo(pid,sc.next(), sc.next(), sc.nextDouble()));
					//prod.put(pid,new prodInfo(pid,sc.next(), sc.next(), sc.nextDouble()));
					break;
				case 2:
					System.out.println("Enter Product id to Remove\n");
					int pid1=sc.nextInt();
					if(prod.containsKey(pid1))
					{
						prod.remove(pid1);
					}
					else
						System.out.println("Product not found");
					break;
					case 3:
						System.out.println("Enter Product id and Price for Update");
						int id=sc.nextInt();
						double pri=sc.nextDouble();
						
						if(prod.containsKey(id))
						{
							prod.get(id).setPrice(pri);
							System.out.println("Product Updated"+prod.get(id));
						}
						else
							System.out.println("Product not Found");
						
						break;
				}
				}
				break;
			case 2:
				
				System.out.println("Enter Your Username or Password");
				String u=sc.next();
				String p=sc.next();
				user.put(u,new userinfo(u,p));
				break;
				
			case 3:
				System.out.println("Application Closed");
				exit=false;
				break;
			}
			
		}
		
	}
	
}
