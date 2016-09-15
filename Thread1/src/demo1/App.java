package demo1;
// one basic method is to extend the Thread class
class Runner extends Thread {
	public void run(){
		
		for(int i = 0; i < 10; i++){
			System.out.println("Hello " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class App {

	public static void main(String[] args) {
		
		Runner runner1  = new Runner();
		
		// look for the run method and run in a special thread
		// if .run() it will be run in the application
		runner1.start();

		Runner runner2  = new Runner();
		runner2.start();

	}

}
