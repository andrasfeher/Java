package tutorial;

public class Car extends Machine{
	
	public void start(){
		System.out.println("Car started");
	}	
	

	@Override // the annotation causes that it checks that it is really an override
	public void stop() {
		System.out.println("Car stopped");
	}

	public void wipeWindShield(){
		System.out.println("wiping windshield");
	}

}
