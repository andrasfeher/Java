package tutorial;

public class Plant {
	
	// bad practice
	public String name;
	
	// acceptable practice --- it's final
	public static final int ID = 8;
	
	// only can be accessed within the class
	private String type;
	
	protected String size;
	
	// within package
	int height;
	
	public Plant(){
		name = "Cactus";
		this.type = "plant";
		
		size = "medium";
		height = 1;
	}
	
	public void grow(){
		
		System.out.println("plant growing");
	}

}
