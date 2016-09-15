// interfaces: many developers first create the interfaces and then the 
// classes that implement them
public class App {

	public static void main(String[] args) {

		
		Machine mach1 = new Machine(7);
		mach1.showInfo();
		
		Person pers1 = new Person("Bob");
		pers1.showInfo();
		
		System.out.println();
		
		// machinfo only has the showInfo method
		ICanGiveInfo machinfo = new Machine(7);
		machinfo.showInfo();	
		
		ICanGiveInfo persinfo = new Person("Bob");
		persinfo.showInfo();
		
		System.out.println();
		
		// machinfo2 only has the showInfo method
		ICanGiveInfo machinfo2 = mach1;
		machinfo2.showInfo();
		
		// persinfo2 only has the showInfo method
		ICanGiveInfo persinfo2 = pers1;
		persinfo2.showInfo();
		
		System.out.println();
		
		outputInfo(persinfo);
		outputInfo(machinfo);

	}
	
	// info only has the showInfo method
	private static void outputInfo(ICanGiveInfo info){
		info.showInfo();
	}

}
