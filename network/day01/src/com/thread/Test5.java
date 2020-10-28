package com.thread;

class Th1 extends Thread{
	int sum;
	@Override
	public void run() {
		for(int i=1;i<=20;i++) {
			sum += i;
			try {
				Thread.sleep(200);
				System.out.println("TH1....");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int getSum() {
		return sum;
	}
	
}
class Th2 extends Thread{
	int sum;
	@Override
	public void run() {
		for(int i=1;i<=40;i++) {
			sum += i;
			try {
				Thread.sleep(100);
				System.out.println("TH2....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public int getSum() {
		return sum;
	}
}
public class Test5 {

	public static void main(String[] args) throws InterruptedException {
		Th1 th1 = new Th1();
		Th2 th2 = new Th2();
		th1.start();
		System.out.println("TH1 STARTED");
		th1.join();
		th2.start();
		System.out.println("TH2 STARTED");
		th2.join();
		System.out.println(th1.getSum()+" "+th2.getSum());
		System.out.println(th1.getSum()+th2.getSum());
	}

}
