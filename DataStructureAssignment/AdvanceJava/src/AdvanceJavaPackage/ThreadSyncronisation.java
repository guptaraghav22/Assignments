package AdvanceJavaPackage;
import java.lang.*;
class TicketBook 
{	
	void bookseat(int seat) 
	{	int ts=10;
		if(ts>seat) 
		{
			System.out.print("Seats booked");
			System.out.println();
			ts=ts-seat;
			System.out.println("Available seats"+ts);
		}
		else 
		{
			System.out.println("Cannot book");
			System.out.println();
			
			System.out.println("Available seats"+(ts));
		}
		
	}
}
 

public class ThreadSyncronisation extends Thread {
	TicketBook tb = new TicketBook();
	int s;
	synchronized public void run() 
	{	tb.bookseat(s);
		
		
	}
	public static void main(String[] args) {

		
	ThreadSyncronisation obj =new ThreadSyncronisation();
	obj.s=6;
	obj.start();
	ThreadSyncronisation obj1 =new ThreadSyncronisation();
	obj1.s=5;
	obj1.start();
	
	
}
}