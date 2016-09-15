package tutorial;

public class Oak extends Plant {
	
	public Oak(){
		// won't work --- type is private in Plant
		// type = "tree";
		
		// size is protected in Plant
		size = "large";
		height = 10;
	}
	
}
