package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	public static void main(String[] args) {
		Robot[] a = new Robot[5];
		Thread[] tead = new Thread[5];
	
		// 2. create an array of 5 robots.
		// 3. use a for loop to initialize the robots.
		for (int i = 0; i < a.length; i++) {
			a[i] = new Robot(50 + i*(100), 600);
			a[i].setSpeed(1000);
			
		}
		// 4. make each robot start at the bottom of the screen, side by side, facing up
		Random random = new Random();
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.
		
		for (int i = 0; i < a.length; i++) {
			int g = i;
			tead[i] = new Thread(()->{
				Boolean tf = true;
				while(tf) {
				int y = random.nextInt(10);
				a[g].move(y);
				if (a[g].getY() <= 0) {
					System.out.println("The winner is " + g );
					tf = false;
					System.exit(0);
				}	
			}
			});
		}
		for (int i = 0; i < tead.length; i++) {
			tead[i].start();
		}
			
		// 6. use a while loop to repeat step 5 until a robot has reached the top of the
		// screen.
		 
		// 7. declare that robot the winner and throw it a party!
	}
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	
}
