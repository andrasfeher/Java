package demo1;

/*
 * to make variable change synchronized throug threads
 * synchronized keyword: every object has an intrinsic lock (mutex) and only one thread can aquire this lock
 * the other thread silently waits until this lock is released
 * you don't need to declare the variable as volatile
 */
public class App {
	
	private int count = 0;
	
	public synchronized void increment(){
		count++;
	}

	public static void main(String[] args) {
		
		App app = new App();
		app.doWork();
		

	}
	
	public void doWork(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++){
					increment();
				}				
			}
		});

		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++){
					increment();
				}				
			}
		});
		
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); // wait until thread starts
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(count);
		
		
	}
	

}
