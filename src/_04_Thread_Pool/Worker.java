package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	ConcurrentLinkedQueue<Task> taskQueue;
	public Worker(ConcurrentLinkedQueue<Task> tQ) {
		taskQueue = tQ;
	}
	public void run() {
		while (!taskQueue.isEmpty()) {
			Task task = taskQueue.remove();
			task.perform();
		}
		
	}


}
