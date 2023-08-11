package AdvanceJavaPackage;

public class implementsThread implements Runnable {

	public static void main(String[] args) {
		implementsThread obj = new implementsThread();
		Thread th = new Thread(obj);
		th.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("10");
	}

}
