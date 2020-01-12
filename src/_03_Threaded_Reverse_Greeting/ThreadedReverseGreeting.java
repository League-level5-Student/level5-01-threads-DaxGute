package _03_Threaded_Reverse_Greeting;

import java.util.ArrayList;

public class ThreadedReverseGreeting {
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	
	/* HINT: You will most likely need to do this with recursion */
	static ArrayList <Thread> threads = new ArrayList <Thread>();
	public static void main(String[] args) {
		thread(0);
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
		}
	}
	public static void thread(int num) {
		Thread t = new Thread(()-> {System.out.println("Hello from thread " + num);});
		if (num < 50) {
			thread(num + 1);
		}
		threads.add(t);
		
	}
}
