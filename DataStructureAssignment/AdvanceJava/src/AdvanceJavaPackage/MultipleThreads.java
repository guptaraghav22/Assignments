package AdvanceJavaPackage;

import java.lang.*;

class Thread1 extends Thread
{
	@Override
	public void run() 
	{
		System.out.println("Thread1");
	}

}
class Thread2 extends Thread
{
	@Override
	public void run() 
	{
		System.out.println("Thread2");
	}
}
class Thread3 extends Thread
{	@Override
	public void run() 
	{
		System.out.println("Thread3");
	}
}

public class MultipleThreads {

public static void main(String[] args)
{
	Thread1 obj = new Thread1();
	obj.run();
	Thread2 obj2 = new Thread2();
	obj2.run();
	Thread3 obj3 = new Thread3();
	obj3.run();
	
	
}
	
	
}

