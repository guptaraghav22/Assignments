package AdvanceJavaPackage;
import java.lang.*;
public  class Test extends Thread {
	@Override
	public void run() 
	{	int a=10;
		System.out.println(a);
	}
	
	
	
	public static void main(String[] args)
	{
		Test obj = new Test();
		obj.start();
	} 
}
