package tutorial;

public class Robot {

	private int id;
	
	// group together functionality and have access to the instance variables
	// of the outer class
	private class Brain{
		public void think(){
			System.out.println("Robot " + id + " is thinking");
		}
	}
	
	// to create an interchangeable battery and pass it to the robots 
	// that need it
	// we want a class that isn't accociated with the instances of the 
	// outer class but for some reason we want to group it
	// you can have Robot.Battery, Robot.CPU.. but the point is to group it
	// 
	public static class Battery{
		public void charge(){
			System.out.println("Battery chargin....");
		}
	}

	public Robot(int id) {
		this.id = id;
	}
	
	public void start(){
		System.out.println("Starting robot " + id);
		
		// the inner class instance is not created automatically
		Brain brain = new Brain();
		brain.think();
		
		final String name = "Robert";
		
		
		// create an instance only in this method
		class Temp {
			public void doSomething(){
				System.out.println("ID is: " + id);
				System.out.println("My name is " + name);
			}
		}
		
		Temp temp = new Temp();
		temp.doSomething();

	}
	
}
