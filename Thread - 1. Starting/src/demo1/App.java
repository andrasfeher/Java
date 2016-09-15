package demo1;

class Runner extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++){
			System.out.println(this.toString() + i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


/*
 * Method1: extend class Thread
 * 
 */
public class App {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		Runner runner2 = new Runner();
		
		runner1.start();
		runner2.start();

	}

}
