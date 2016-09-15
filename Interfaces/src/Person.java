
public class Person implements ICanGiveInfo  {
	
	private String name;

	public void showInfo() {

		System.out.println(name);
		
	}

	public Person(String name) {
		super();
		this.name = name;
	}

}
