package com.thread;

import java.util.Scanner;

class Thread1 implements Runnable{
	
	String name;
	boolean flag = true;

	public Thread1() {}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		System.out.println("Start");
		while(true) {
			if(flag ==false) {
				System.out.println("Stop...");
				break;
			}
			System.out.println("Connecting ...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("End");
	}
	
}

public class Test3 {

	public static void main(String[] args) {
		Thread1 r = new Thread1();
		Thread t1 = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input Cmd");
			String cmd = sc.nextLine();
			if(cmd.equals("start")) {
				r.setFlag(true);
				t1 = new Thread(r);
				t1.start();
			}else if(cmd.equals("stop")) {
				r.setFlag(false);
			}else {
				break;
			}
		}
		sc.close();
		System.out.println("Exit Application...");
	}

}
