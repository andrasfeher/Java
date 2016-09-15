package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Temp implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("closed!");
		
		throw new Exception("oh no!");
		
	}
	
}

abstract class Animal{
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// method that must be implemented in child classes
	public abstract void grow();
	
	// abstract methods can be called
	public void doSomething(){
		grow();
	}
	
}

class Cat extends Animal{

	@Override
	public void grow() {
		System.out.println("growing");
		
	}
	
}

class Dog extends Animal{

	@Override
	public void grow() {
		System.out.println("growing");
		
	}
	
}

class ExceptionThrowingClass {

	public void run() throws ParseException, IOException {

	}
	
	public void input() throws FileNotFoundException, IOException{
		
	}

}

class Thing {

	// "final" is the Java way of telling that it is constant
	public final static int MY_LUCKY_NUMBER = 7;
	public String name;
	public static String description;
	public static int count = 0;
	public int id;

	public Thing() {

		// assigning unique id to the object is another use of static (/class)
		// variables
		id = count + 1000;
		count++;
	}

	public void showName() {
		System.out.println(name);
		showDescription();
	}

	// you can use static anytime when you don't have to deal with instance
	// variables
	public static void showDescription() {
		System.out.println(description);
		// Won't work, because the instance variable does not exists before
		// instantiating the object:
		// System.out.println(name);
	}

}

class Person {
	// instance variables (data or "state")
	private String name;
	private int age;

	// classes can contain
	// 1. Data
	// 2. methods

	public Person() {

		// call the Person(String name, int age) constructor
		// it needs to be in the first line
		this("Arnie", 45);

		System.out.println("**** default constructor run ****");
	}

	public Person(String name) {

		this(name, 56);

		System.out.println("**** constructor run ****");
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;

		System.out.println("**** name, age constructor run ****");
	}

	void speak() {
		System.out.println("My name is " + name + " and I am " + age + " years old");
	}

	void sayHello() {
		System.out.println("Hello my name is " + name);
	}

	int calculateYearsToRetirement() {
		int result = 65 - age;

		return result;
	}

	int getAge() {
		return age;
	}

	String getName() {
		return name;
	}

	public void jump(int height) {
		System.out.println("Jumping " + height);
	}

	public void setName(String name) {

		// to resolve ambiguity, local variables mask instance variables
		// "this" means instance variable
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setInfo(String name, int age) {
		setName(name);
		setAge(age);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Person other = (Person) obj;
		
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}


	
	
	
}

// if a class is public, the class name must match file name
public class test {

	/*
	 * public static void main(String[] args) {
	 * 
	 * // primitive types
	 * 
	 * int myNumber = 88; short myShort = 847; long myLong = 984783475; double
	 * myDouble = 7.8765; float myFloat = 324.f; char myChar = 'g'; boolean
	 * myBoolean = false; byte myByte = 127;
	 * 
	 * System.out.println(myNumber); System.out.println(myShort);
	 * System.out.println(myLong); System.out.println(myDouble);
	 * System.out.println(myFloat); System.out.println(myChar);
	 * System.out.println(myBoolean); System.out.println(myByte); }
	 */

	// string concatenation
	/*
	 * public static void main(String[] args) {
	 * 
	 * int myInt = 7; String text = "Hello"; String blank = " "; String name =
	 * "Bob";
	 * 
	 * String greeting = text + blank + name;
	 * 
	 * System.out.println(greeting); System.out.println("Hello" + " " + "Bob");
	 * System.out.println("My integer is: " + myInt);
	 * 
	 * double myDouble = 7.9;
	 * 
	 * System.out.println("My number is: " + myDouble + ".");
	 * 
	 * 
	 * }
	 */
	/*
	 * // loops public static void main(String[] args) {
	 * 
	 * int value = 0;
	 * 
	 * while (value < 3){ System.out.println("While loop " + value); value =
	 * value + 1; }
	 * 
	 * for (int i = 0; i < 3; i++){ System.out.println("for loop " + i);
	 * 
	 * // doesn't work: System.out.printf("The number of i is: %d\n", i); }
	 * 
	 * }
	 */

	// conditionals
	/*
	 * public static void main(String[] args) {
	 * 
	 * int myInt = 15;
	 * 
	 * if (myInt < 10){ System.out.println("it is true!"); } else if (myInt >
	 * 20){ System.out.println("it is false"); } else {
	 * System.out.println("none of the above"); }
	 * 
	 * 
	 * int loop = 0;
	 * 
	 * while(true){
	 * 
	 * System.out.println("Looping: " + loop);
	 * 
	 * if (loop == 5){ break; }
	 * 
	 * loop++;
	 * 
	 * System.out.println("Running"); } }
	 */

	/*
	 * // user input public static void main(String[] args) {
	 * 
	 * Scanner input = new Scanner(System.in);
	 * 
	 * System.out.println("Enter a line of text: "); String line =
	 * input.nextLine();
	 * 
	 * System.out.println("You entered: " + line);
	 * 
	 * System.out.println("Enter an integer: "); int myInt = input.nextInt();
	 * 
	 * System.out.println("You entered: " + myInt);
	 * 
	 * System.out.println("Enter a double: "); double myDouble =
	 * input.nextDouble();
	 * 
	 * System.out.println("You entered: " + myDouble);
	 * 
	 * 
	 * input.close();
	 * 
	 * 
	 * }
	 */

	// do while loop
	/*
	 * public static void main(String[] args) {
	 * 
	 * Scanner scanner = new Scanner(System.in);
	 * 
	 * int value = 0;
	 * 
	 * do { System.out.println("Enter a number"); value = scanner.nextInt(); }
	 * while(value != 5);
	 * 
	 * System.out.println("Got 5!");
	 * 
	 * scanner.close(); }
	 */

	// switch
	/*
	 * public static void main(String[] args) {
	 * 
	 * Scanner input = new Scanner(System.in);
	 * 
	 * System.out.println("Please enter a command");
	 * 
	 * String text = input.nextLine();
	 * 
	 * switch(text){ case "start": System.out.println("Machine started"); break;
	 * case "stop": System.out.println("Machine stopped"); break; default:
	 * System.out.println("Command not recognized"); }
	 * 
	 * input.close();
	 * 
	 * }
	 */

	// arrays
	/*
	 * public static void main(String[] args) {
	 * 
	 * int[] values; // reference
	 * 
	 * values = new int[3]; // allocates memory for 3 values; default: 0
	 * 
	 * values[0] = 10; values[1] = 20; values[2] = 30;
	 * 
	 * System.out.println(values[0]); System.out.println(values[1]);
	 * System.out.println(values[2]);
	 * 
	 * 
	 * for (int i = 0; i < values.length; i++){ System.out.println(values[i]); }
	 * 
	 * 
	 * int[] numbers = {5, 6, 7};
	 * 
	 * for (int i = 0; i < numbers.length; i++){ System.out.println(numbers[i]);
	 * }
	 * 
	 * 
	 * String[] words = new String[3];
	 * 
	 * words[0] = "Hello"; words[1] = "to"; words[2] = "you";
	 * 
	 * System.out.println(words[2]);
	 * 
	 * String[] fruits = {"apple", "banana", "pear", "kiwi"};
	 * 
	 * for (String fruit: fruits){ System.out.println(fruit); }
	 * 
	 * // multi-dimensional arrays
	 * 
	 * int[][] grid = { {3, 5, 2345}, {2, 4}, {1, 2, 3, 4} };
	 * 
	 * System.out.println(grid[1][0]); // row 1 column 1
	 * System.out.println(grid[0][2]); // row 0 column 2
	 * 
	 * String[][] texts = new String[2][3]; texts[0][1] = "Hello there";
	 * 
	 * System.out.println(texts[0][1]);
	 * 
	 * for(int row = 0; row < grid.length; row++){
	 * 
	 * for (int col = 0; col < grid[row].length; col++){
	 * System.out.print(grid[row][col] + "\t"); }
	 * 
	 * System.out.println(); }
	 * 
	 * String[][] multiWords = new String[2][];
	 * 
	 * System.out.println(multiWords[0]);
	 * 
	 * multiWords[0] = new String[3];
	 * 
	 * multiWords[0][1] = "Hi there";
	 * 
	 * System.out.println(multiWords[0][1]);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	// classes
	//
	/*
	 * public static void main(String[] args) {
	 * 
	 * Person person1 = new Person("John Kiss");
	 * 
	 * // it is not necessary to give name to the objec, the constructior will
	 * run anyways new Person(); new Person("John Kiss2", 52); new Person();
	 * 
	 * // changed to private // person1.name = "Joe Bloggs"; // person1.age =
	 * 37;
	 * 
	 * // person1.setName("John Doe"); person1.setAge(38); person1.speak();
	 * person1.sayHello(); person1.jump(5);
	 * 
	 * 
	 * System.out.println(person1.getName());
	 * System.out.println(person1.calculateYearsToRetirement());
	 * System.out.println(person1.getAge());
	 * System.out.println(person1.getName());
	 * 
	 * }
	 * 
	 */

	// Static and final
	/*
	 * public static void main(String[] args) {
	 * 
	 * // example of constant (static final) System.out.println(Math.PI);
	 * 
	 * Thing.description = "I am a thing";
	 * System.out.println(Thing.MY_LUCKY_NUMBER); Thing.showDescription();
	 * 
	 * Thing thing = new Thing(); thing.name = "My name is anything";
	 * 
	 * thing.showName(); System.out.println("id :" + thing.id);
	 * 
	 * // using static variables to count the objects created for (int i = 0; i
	 * < 10; i++){ new Thing(); }
	 * 
	 * System.out.println(Thing.count +
	 * " thing objects have been created so far...");
	 * 
	 * }
	 */

	// reading files using scanner
	/*
	 * public static void main(String[] args) throws FileNotFoundException {
	 * 
	 * // if it is a project file, the working directory is the project folder
	 * String filePath = "C:/Users/András/Documents/Redis todo.txt";
	 * 
	 * File textFile = new File(filePath);
	 * 
	 * Scanner in = new Scanner(textFile);
	 * 
	 * // reading text file line by line while (in.hasNextLine()){ String line =
	 * in.nextLine(); System.out.println(line); }
	 * 
	 * // reading a file that has a number in the first line that tells how many
	 * lines to read int value = in.nextInt();
	 * 
	 * // nextInt does not read CR/LF in.nextLine();
	 * 
	 * // for (int i = 0; i < value; i++) .....
	 * 
	 * 
	 * 
	 * in.close(); }
	 */

	// exceptions handling
	/*
	 * public static void main(String[] args){
	 * 
	 * File file = new File("asdkfh");
	 * 
	 * try { FileReader fr = new FileReader(file);
	 * 
	 * // does not execute in case of exception
	 * System.out.println("Continuing ....");
	 * 
	 * fr.close();
	 * 
	 * } catch (IOException e) { System.out.println("File not found " +
	 * file.toString()); }
	 * 
	 * 
	 * // catch an exception from a method try { openFile(); } catch
	 * (IOException e) { System.out.println("File could not be opened"); }
	 * 
	 * 
	 * System.out.println("finished");
	 * 
	 * }
	 * 
	 * public static void openFile() throws IOException{
	 * 
	 * File file = new File("asdkfh");
	 * 
	 * FileReader fr = new FileReader(file);
	 * 
	 * fr.close(); }
	 */

	// multiple exceptions handling
	/*
	public static void main(String[] args) {
		
		ExceptionThrowingClass etc = new ExceptionThrowingClass();

		try {
			etc.run();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Java 7
		try {
			etc.run();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// polimorphysm
		
		try {
			etc.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// if one exception is a child of the other we must catch the child first, otherwise
		// the parent catches all and the child never executes. Anyway, in this case the Java 
		// won't compile
		try {
			etc.input();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	
	// runtime vs checked exceptions (like FileNotFoundException, IOException)
	/*
	public static void main(String[] args) {
		
		int n = 7;
		
		// catch any runtime exception
		try {
			System.out.println(n / 0);
			
			String text = null;
			
			System.out.println(text.length());
			
			String[] texts = {"one", "two", "three"};
			
			System.out.println(texts[10]);
			
		} catch (RuntimeException e){
			System.out.println(e.toString());
		}
		
	}
	*/

	/*
	// abstract classes
	// when to use an abstract class and when to use an interface
	// a class can implement many interfaces, but can have only one parent class
	// abstract class: 
	// - very strong statement about what the child fundametaly is. e.g. showInfo : is generic so it could be in interface
	// - great when you are starting a hierarchy
	// interface 
	// - implementing an interface says what it can *do*
	// 
	// you cannot have code in the interface, but in an abstract class you can
	// 
	public static void main(String[] args) {
		
		// won't work: abstract
		// Animal a = new Animal();
		
		Cat monica = new Cat();
		monica.setName("Monica");
		monica.grow();
	}
	*/
	
	// reading files with FileReader (old style Java 6 or below)
	/*
	public static void main(String[] args) {
		
		File file = new File("test.txt");
		BufferedReader br = null;
		
		try {
			
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line;
			
			while ((line = br.readLine()) != null){
				
				System.out.println(line);
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found:" + file.toString());
		} catch (IOException e) {
			System.out.println("Unable to read:" + file.toString());
		} finally {
			
			// we only have to close buffered reader, it closes everything above the chain
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Unable to close file:" + file.toString());
			} catch (NullPointerException e){
				// File was not opened!
			}			

		}
	}
	*/
	
	
	// try with resources from Java 7
	/*
	public static void main(String[] args) {
		
		// in general
		try(Temp temp = new Temp()){
			
		} catch (Exception e){
			System.out.println("Exception occurred");
		}
		
		// automatically closes the file
		File file = new File("test.txt");
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			
			while ((line = br.readLine()) != null){
				
				System.out.println(line);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found:" + file.toString());
		} catch (IOException e) {
			System.out.println("Unable to read:" + file.toString());
		}
	}
	*/
	
	// creating and writing text files
	/*
	public static void main(String[] args) {
		
		File file = new File("write_test.txt");
		
		try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
			
			br.write("line one");
			br.newLine();
			br.write("line two");
			br.newLine();
			br.write("line three");
			br.newLine();
			br.write("last line");
			
		} catch (IOException e) {
			System.out.println("Unable to write:" + file.toString());
		}		
	}
	*/
	
	// the .equals method
	/*
	public static void main(String[] args) {
		
		Person person1 = new Person("Bob");
		Person person2 = new Person("Bob");
		
		// == doesn't work: compares references
		System.out.println(person1 == person2);
		
		
		// .equals does semantic comparision, we have to override Object.equals 
		System.out.println(person1.equals(person2));
		
		Double value1 = 6.2;
		Double value2 = 6.2;
		
		// Double must be compared with .equals
		System.out.println(value1.equals(value2));
		
		Integer intVal1 = 6;
		Integer intVal2 = 6;
		
		// works because Java creates because in case of Integer the variables point to the same memory locatio
		// if the values are the same
		System.out.println(intVal1 == intVal2);
		
		// the safe way:
		System.out.println(intVal1.equals(intVal2));
		
		String text1 = "Hello";
		String text2 = "Hello";
		
		// works because Java optization, but usafe so don't rely on it
		System.out.println(text1 == text2);
		
		// because this returns false
		String text3 = "Hellosdkfjghsdfkjgh".substring(0, 5);
		System.out.println(text1 == text3);
		
		// the safe way (both return true):
		System.out.println(text1.equals(text2));
		System.out.println(text1.equals(text3));
		
	}
	*/
	
	// ArrayList: all collections are template classes
	// cannot handle primitives, must be the corresponding classes
	/*
	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		numbers.add(10);
		numbers.add(400);
		numbers.add(20);
		
		// retrieving 
		System.out.println(numbers.get(0));
		
		System.out.println("\nIteration #1");
		
		for (int i = 0; i < numbers.size(); i++){
			System.out.println(numbers.get(i));
		}
		
		// removing
		numbers.remove(numbers.size() - 1);
		
		// this is VERY SLOW because it copies the remaining items one slots below: in this case
		// LinkedList is faster
		numbers.remove(0);
		
		System.out.println("\nIteration #2");
		
		for (Integer value : numbers){
			System.out.println(value);
		}
		
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		
		doTiming("ArrayList", arrayList);
		doTiming("LinkedList", linkedList);
		
		
	}
	
	// I can pass anything that implements the List interface
	private static void doTiming(String type, List<Integer> list){
		
		for (int i = 0; i < 1E5; i++){
			list.add(i);
		}
		
		long start = System.currentTimeMillis();
		
		// add items at the end of list
		// ArrayList: 8 ms
		// LinkedList: 15 ms
		// for (int i = 0; i < 1E5; i++){
		// 	list.add(i);
		// }
		
		//
		// add items elsewhere
		// ArrayList: 5346 ms
		// LinkedList: 16 ms
		for (int i = 0; i < 1E5; i++){
			list.add(0, i);
		}
		//		

		
		// add items elsewhere
		// ArrayList: 3333 ms
		// LinkedList: 12149 ms
		for (int i = 0; i < 1E5; i++){
			list.add(50000, i);
		}		
		
		long end = System.currentTimeMillis();
		
		System.out.println(type + ": " + (end - start) + " ms" );
		
	}
*/
	// HashMap: uses the hash code of the object
	/*
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<>();
		
		map.put(4, "four");		
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");

		
		// non-existing key: null
		System.out.println(map.get(40));
		
		System.out.println(map.get(4));
		
		// iterating
		// not sorted!! changes randomly for different iterations
		for (Map.Entry<Integer, String> entry: map.entrySet() ){
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key + ":" + value);
			
		}
	}
	*/
	
	
	// Sorted Maps
	// all implement the map interface
	/*
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<>();
		
		// same as HashMap, but the entries are linked and they stay the same order
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();
		
		// stores the values in natural order
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		
		testMap(map);
		
		testMap(linkedMap);		

		// sorts the keys in natural order
		testMap(treeMap);
	}
	
	public static void testMap(Map<Integer, String> map){
		
		map.put(1, "fox");
		map.put(2, "cat");
		map.put(3, "dog");
		map.put(4, "horse");
		map.put(5, "donkey");
		map.put(6, "fish");
		
		for (Integer key: map.keySet()){
			
			System.out.println(map.getClass().getSimpleName() + ":" + map.get(key));
			
		}
		
		
		
	}
	*/
	
	// sets
	public static void main(String[] args) {
		
		// has set does not retain order!
		// Set<String> set = new HashSet<String>();
		
		// LinkedHashSet remembers the order of elements added
		// Set<String> set = new LinkedHashSet<String>();
		
		// TreeSet stores in natural order
		Set<String> set = new TreeSet<String>();

		if (set.isEmpty()){
			System.out.println("set is empty at start");
		}		
		
		set.add("fox");
		set.add("cat");
		set.add("dog");
		set.add("horse");
		set.add("donkey");
		set.add("fish");
		
		set.add("dog");

		System.out.println(set);
		
		// iteration
		for (String element: set){
			System.out.println(element);
		}
		
		
		// does the item exists in the set?
		// sets are optimized for finding elements quickly
		if (set.contains("pig")){
			System.out.println("contains: pig");
		}

		if (set.contains("fish")){
			System.out.println("contains: fish");
		}
		
		//////////////// intersection ////////////////////
		
		Set<String> set2 = new TreeSet<String>();

		// contains some new elements
		set2.add("fox");
		set2.add("cat");
		set2.add("fish");		
		set2.add("duck");
		set2.add("pigeon");
		set2.add("chicken");
		
		// HashSet is the most lightweight
		Set<String> intersection = new HashSet<String>(set);
		
		System.out.println(intersection);
		
		intersection.retainAll(set2);
		
		System.out.println(intersection);
		
		/////////////// difference ////////////////////////
		
		Set<String> difference = new HashSet<String>(set);
		
		difference.removeAll(set2);
		
		System.out.println(difference);
		
		
	
	}

}
