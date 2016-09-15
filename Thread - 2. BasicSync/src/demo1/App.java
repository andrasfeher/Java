package demo1;

import java.util.Scanner;

class Processor extends Thread {
	
	private volatile boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.println("Hello");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running = false;
		System.out.println("Thread terminated");
	}

}

/*
 * The main program has it's own thread and spawns a new new thread for proc1
 * Sometimes the variable is cached and proc1 does not stop -> "volatile" keyword: prevents caching 
 * variables 
 */

public class App {
	
	public static void main(String[] args) {

		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press return to terminate");
		Scanner scanner = new Scanner(System.in);
		
		scanner.nextLine();
		proc1.shutdown();
		scanner.close();
	}
	
}
