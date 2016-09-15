import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class WriteObjects {

	public static void main(String[] args) {

		System.out.println("Writing objects ...");
		
		Person[] people = {new Person(1, "Sue"), new Person(99, "Mike"), new Person(7, "Bob")};
		Person.setCount(88);
		
		ArrayList<Person> peopleList = new ArrayList<Person>(Arrays.asList(people));
		
		/*
		Person mike = new Person(45, "Mike");
		Person sue = new Person(454, "Sue");
		
		System.out.println(mike);
		System.out.println(sue);
		*/
		
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("people.bin"))){

			/*
			os.writeObject(mike);
			os.writeObject(sue);
			*/
			
			os.writeObject(people);
			os.writeObject(peopleList);
			os.writeInt(peopleList.size());
			
			for (Person person: peopleList){
				os.writeObject(person);
			}
			
			os.close();
			
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
