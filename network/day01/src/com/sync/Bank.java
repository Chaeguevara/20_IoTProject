package com.sync;

public class Bank {

	public static void main(String[] args) {
		Account acc = new Account(3000);
		DTh dt = new DTh(acc);
		Wth wt = new Wth(acc);
		DTh dt2 = new DTh(acc);
		Wth wt2 = new Wth(acc);
		DTh dt3 = new DTh(acc);
		Wth wt3 = new Wth(acc);
		wt.start();
		dt.start();
		wt2.start();
		dt2.start();

		wt3.start();
		dt3.start();


	}

}
