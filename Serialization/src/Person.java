import java.io.Serializable;


public class Person implements Serializable{
	
	// to ensure that the object read is the same version as the written
	private static final long serialVersionUID = 4801633306273802062L;
	
	// transient: will not be serialized
	// at creating the object fields are automatically initialized, by the 
	// method variables not
	private transient int id;
	private String name;
	
	// static fields are not serialized: logical because they belong to the 
	// class and not the object
	private static int count;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Person.count = count;
	}


	public String toString(){
		return "Name: " + name + " id: " + id + "count: " + count;
	}
	

}
