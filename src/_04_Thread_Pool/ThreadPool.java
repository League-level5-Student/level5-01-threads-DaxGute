package _04_Thread_Pool;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	ArrayList <Thread> threads;
	ConcurrentLinkedQueue<Task> taskQueue;
	public ThreadPool(int totalThreads) {
		threads = new ArrayList <Thread> ();
		for (int i = 0; i < threads.size(); i++) {
			threads.set(i, new Thread(new Worker(taskQueue)));
		}
		taskQueue = new ConcurrentLinkedQueue<Task>();
	}

	public void addTask(Task t) {
		taskQueue.add(t);
	}

	public void start(){
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
			try {
				threads.get(i).join();
			} catch (InterruptedException e) {
				System.out.println("UHOH");
				e.printStackTrace();
			}
		}
	
	}
}
