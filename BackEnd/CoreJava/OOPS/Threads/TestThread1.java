package com.cap.thread;

public class TestThread1 {
	public static void main(String[] args) {
		System.out.println("main started");
		Thread2 t1= new Thread2();
		Thread t= new Thread(t1);
		t.start();
		System.out.println("main ended");
	}

}
