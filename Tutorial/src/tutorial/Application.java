package tutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

// Java 8 terminology: interface that defines a single method is called 
// functional interface
interface Executable {
	int execute(int a);
}

interface StringExecutable {
	int execute(String a);
}

class Runner {
	public void run(Executable e){
		System.out.println("Executing code block ...");
		int value = e.execute(12);
		System.out.println("Return value is: " + value);
	}
	
	public void run(StringExecutable e){
		System.out.println("Executing code block ...");
		int value = e.execute("Hello");
		System.out.println("Return value is: " + value);
	}	
}

class UrlLibrary implements Iterable<String> {
	private LinkedList<String> urls = new LinkedList<String>();

	private class UrlIterator implements Iterator<String> {

		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < urls.size();
		}

		@Override
		public String next() {
			StringBuilder sb = new StringBuilder();

			try {
				URL url = new URL(urls.get(index));

				BufferedReader br = new BufferedReader(new InputStreamReader(
						url.openStream()));

				String line = null;

				while ((line = br.readLine()) != null) {
					sb.append(line);
					sb.append("\n");
				}

				br.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			index++;
			return sb.toString();
		}

		@Override
		public void remove() {
			urls.remove(index);
		}
	}

	public UrlLibrary() {
		urls.add("https://www.udemy.com");
		urls.add("http://www.index.hu");
		urls.add("http://www.unicreditbank.hu");
	}

	// @Override
	// public Iterator<String> iterator() {
	// return urls.iterator();
	// }

	@Override
	public Iterator<String> iterator() {
		return new UrlIterator();
	}

}

class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 > len2) {
			return 1;
		} else if (len1 < len2) {
			return -1;
		}

		return 0;
	}

}

class ReverseAlphabeticalComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return -s1.compareTo(s2);
	}

}

interface IPlant {
	public void grow();
}

// import everything from the package
// import ocean.*;
// CTRL SHIFT O : import everything I need and remove everything I don't need

class OpticalMachine {

	@Override
	public String toString() {
		return "I am an optical machine";
	}

	public void start() {
		System.out.println("Optical Machine started");
	}

	public void stop() {
		System.out.println("Optical Machine stopped");
	}

}

class Camera extends OpticalMachine {

	@Override
	public String toString() {
		return "I am a Camera";
	}

	public void start() {
		System.out.println("Camera started");
	}

	public void stop() {
		System.out.println("Camera stopped");
	}

	public void snap() {
		System.out.println("Photo taken");
	}
}

class Frog {

	private int id;
	private String name;

	public Frog(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {

		// inefficient because id is wrapped into an Int object
		// return id + ": " + name;

		// The StringBuilder way:
		// StringBuilder sb = new StringBuilder();
		// sb.append(id).append(" :").append(name);

		// return sb.toString();

		return String.format("%4d: %s", id, name);
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

class Person implements Comparable<Person> {
	// instance variables (data or "state")
	private String name;
	private int age;
	private int id;

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

	public Person(int id, String name) {
		this.name = name;
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Person person) {
		return -name.compareTo(person.name);
	}

	void speak() {
		System.out.println("My name is " + name + " and I am " + age
				+ " years old");
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

	public String toString() {
		return "ID is: " + id + "; name is: " + name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}

// if a class is public, the class name must match file name
public class Application {

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
	 */

	/*
	 * // Static and final public static void main(String[] args) {
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

	// string builder, string formatting and string buffer
	/*
	 * public static void main(String[] args) {
	 * 
	 * // inefficient because strings are immutable; we are reassigning not
	 * changing the // string
	 * 
	 * String info = "";
	 * 
	 * info += "My name is "; info += "Bob";
	 * 
	 * System.out.println(info);
	 * 
	 * // the proper way
	 * 
	 * StringBuilder sb = new StringBuilder("");
	 * 
	 * sb.append("My name is Sue"); sb.append(" ");
	 * sb.append("I am a lion tamer.");
	 * 
	 * System.out.println(sb.toString());
	 * 
	 * // chaining appends
	 * 
	 * StringBuilder s = new StringBuilder();
	 * 
	 * s.append("My name is Roger") .append(" ") .append("I am a skydiver");
	 * 
	 * System.out.println(s.toString());
	 * 
	 * // StringBuffer is just a thread-safe version of StringBuilder //
	 * StringBuilder is more lightweight
	 * 
	 * // formatting integers
	 * 
	 * System.out.printf("Total cost of %s is %d\n", "apple", 5);
	 * 
	 * for (int i = 0; i < 20; i++){ System.out.printf("%2d: some text here\n",
	 * i); }
	 * 
	 * // formatting floating values, automatic rounding
	 * 
	 * System.out.printf("Total value: %.2f\n", 5.6867);
	 * System.out.printf("Total value: %6.1f\n", 345.6867);
	 * 
	 * // left align System.out.printf("Total value: %-6.1f\n", 345.6867); }
	 */

	// toString method
	// standard methods of the Object class
	/*
	 * public static void main(String[] args) {
	 * 
	 * Frog frog1 = new Frog(0, "Freddy"); Frog frog2 = new Frog(1, "Bobby");
	 * 
	 * // calls the toString method // if the toString method not exists in Frog
	 * then calls Object.toString which returns // class name and hash code
	 * (identifier): tutorial.Frog@139a55 System.out.println(frog1);
	 * System.out.println(frog2); }
	 */

	// inheritance
	/*
	 * public static void main(String[] args) {
	 * 
	 * Machine mach1 = new Machine();
	 * 
	 * mach1.start(); mach1.stop();
	 * 
	 * Car car1 = new Car();
	 * 
	 * car1.start(); car1.wipeWindShield(); car1.stop();
	 * 
	 * }
	 */

	// using packages
	/*
	 * public static void main(String[] args) { Fish fish = new Fish(); Seaweed
	 * seaweed = new Seaweed();
	 * 
	 * }
	 */

	// public, private, protected
	// private: only within same class
	// public: from anywhere
	// protected: same class, subclass, and same package
	// no modifier: same package only

	// in case of class
	// public: visible from outside of the file, only one can be as it must
	// match the file name
	// private: cannot declare, not exists
	// no specifier: visible within the file
	/*
	 * public static void main(String[] args) { Plant plant = new Plant();
	 * 
	 * System.out.println(plant.name); System.out.println(Plant.ID);
	 * 
	 * // although size is protected, works --- they are in the same package
	 * System.out.println(plant.size);
	 * 
	 * // no access specifier System.out.println(plant.height);
	 * 
	 * // won't work --- type is private // System.out.println(plant.type);
	 * 
	 * Rabbit rabbit = new Rabbit();
	 * 
	 * // won't work --- it is in another package //
	 * System.out.println(rabbit.name); }
	 */

	/*
	 * // polymorphism: you can use child class anywhere where the parent class
	 * public static void main(String[] args) { Plant plant1 = new Plant(); Tree
	 * tree = new Tree();
	 * 
	 * Plant plant2 = tree;
	 * 
	 * plant2.grow();
	 * 
	 * // won't work: plant2 is Plant type and has no shedLeaves method //
	 * plant2.shedLeaves();
	 * 
	 * doGrow(tree); }
	 * 
	 * public static void doGrow(Plant plant){ plant.grow(); }
	 */

	// casting
	/*
	 * public static void main(String[] args) { int intValue = 888; byte
	 * byteValue = 8; float floatValue = 23432.743f;
	 * 
	 * 
	 * //min and max value can be got from the class version of the type
	 * System.out.println(Byte.MAX_VALUE);
	 * 
	 * // chops the part after the decimal point! intValue = (int) floatValue;
	 * 
	 * System.out.println(intValue);
	 * 
	 * // you can use round
	 * 
	 * intValue = Math.round(floatValue); System.out.println(intValue); }
	 */

	// upcasting and downcasting
	/*
	 * public static void main(String[] args) {
	 * 
	 * OpticalMachine machine1 = new OpticalMachine(); Camera camera1 = new
	 * Camera();
	 * 
	 * machine1.start(); camera1.start(); camera1.snap();
	 * 
	 * 
	 * // Upcasting is safe, guaranteed by polymorfism OpticalMachine machine2 =
	 * camera1; machine2.start(); // error // machine2.snap();
	 * 
	 * // Downcasting is potentially unsafe // cannot call snap() at this point
	 * OpticalMachine machine3 = new Camera(); // Java wants confirmation that
	 * you know what you are doing Camera camera2 = (Camera) machine3;
	 * camera2.start(); camera2.snap();
	 * 
	 * // Doesn't work: runtime error OpticalMachine machine4 = new
	 * OpticalMachine(); // Camera camera3 = (Camera) machine4; //
	 * camera3.start(); }
	 */

	// generic class: can work with other object and you specify what type of
	// object it can work with when you instantiate the class e.g. the ArrayList
	// class in its generic form
	/*
	 * public static void main(String[] args) {
	 * 
	 * // ArrayList implements an array without size constraint, add, remove ...
	 * // parametrized class ArrayList<String> strings = new
	 * ArrayList<String>();
	 * 
	 * strings.add("cat"); strings.add("dog"); strings.add("alligator");
	 * 
	 * String animal = strings.get(1);
	 * 
	 * System.out.println(animal);
	 * 
	 * for (String a: strings){ System.out.println(a); }
	 * 
	 * // There can be more than one type argument
	 * 
	 * HashMap<Integer, String> map = new HashMap<Integer, String>();
	 * 
	 * // works for any kind of objects // it is not necessary to repeat the
	 * class parameter list ArrayList<Plant> someList = new ArrayList<>();
	 * 
	 * showList(strings);
	 * 
	 * ArrayList<OpticalMachine> omList = new ArrayList<OpticalMachine>();
	 * 
	 * omList.add(new OpticalMachine()); omList.add(new OpticalMachine());
	 * 
	 * ArrayList<Camera> cList = new ArrayList<>();
	 * 
	 * cList.add(new Camera()); cList.add(new Camera()); cList.add(new
	 * Camera());
	 * 
	 * showOpticalMachineList(omList);
	 * 
	 * showOpticalMachineAndChildList(omList);
	 * showOpticalMachineAndChildList(cList); showCameraOrSuperClass(cList);
	 * 
	 * }
	 * 
	 * public static void showList(ArrayList<String> list){
	 * 
	 * for (String value: list){ System.out.println(value); } }
	 * 
	 * // a more general solution // but in this case you have to cast the
	 * Object to a class that has // the specific methods that you want to use.
	 * In this case the Object // also has the method toString() public static
	 * void showObjectList(ArrayList<?> list){
	 * 
	 * for (Object o: list){ System.out.println(o); } }
	 * 
	 * public static void showOpticalMachineAndChildList(ArrayList<? extends
	 * OpticalMachine> list){
	 * 
	 * for (OpticalMachine om: list){ System.out.println(om); } }
	 * 
	 * // downcast if you need class specific method call public static void
	 * showCameraOrSuperClass(ArrayList<? super Camera> list){
	 * 
	 * for (Object om: list){ System.out.println(om); } }
	 * 
	 * public static void showOpticalMachineList(ArrayList<OpticalMachine>
	 * list){ for (OpticalMachine om: list){ System.out.println(om); } }
	 */

	// anonymous classes: override method without creating new class
	// it does not create new class, only overrides for the specific
	// instance
	/*
	 * public static void main(String[] args) {
	 * 
	 * OpticalMachine m = new OpticalMachine(){
	 * 
	 * @Override public void start(){ System.out.println("Overridden start"); }
	 * };
	 * 
	 * m.start();
	 * 
	 * // implement interface without creating a class IPlant plant1 = new
	 * IPlant(){ public void grow(){ System.out.println("growing"); } };
	 * 
	 * plant1.grow(); }
	 */

	// inner classes

	/*
	 * 
	 * public static void main(String[] args) {
	 * 
	 * Robot robot = new Robot(7); robot.start();
	 * 
	 * // this is never used but possible if the Brain is public // Robot.Brain
	 * brain = robot.new Brain(); // brain.think();
	 * 
	 * Robot.Battery battery = new Robot.Battery(); battery.charge(); }
	 */

	// enumeration
	// to represent fixed set of values; to have type safety
	// enum: "enumerated"
	/*
	 * public static void main(String[] args) {
	 * 
	 * Animal animal = Animal.CAT;
	 * 
	 * switch(animal){ case CAT: System.out.println("cat"); break; case DOG:
	 * System.out.println("dog"); break; case MOUSE:
	 * System.out.println("mouse"); break; default: break;
	 * 
	 * }
	 * 
	 * System.out.println(Animal.DOG);
	 * 
	 * // name method is a specially for returning enum object as string //
	 * handy when you want to save an enum constant to a database
	 * System.out.println("Enum name as a string: " + Animal.DOG.name());
	 * 
	 * // the reverse of name System.out.println(Animal.valueOf("CAT"));
	 * 
	 * System.out.println(Animal.DOG.getClass()); System.out.println(Animal.DOG
	 * instanceof Enum); System.out.println(Animal.MOUSE.getName());
	 * 
	 * }
	 */

	// recursion
	// elegant e.g. tower of hanoi (wikipedia)
	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println(factorial(15)); }
	 * 
	 * public static int factorial(int value){
	 * 
	 * if(value == 1){ return 1; }
	 * 
	 * return factorial(value - 1) * value; }
	 */

	// custom objects in sets and keys in maps
	/*
	 * public static void main(String[] args) {
	 * 
	 * Person p1 = new Person(0, "Bob"); Person p2 = new Person(1, "Sue");
	 * Person p3 = new Person(2, "Mike");
	 * 
	 * // same as p2 Person p4 = new Person(1, "Sue");
	 * 
	 * Map<Person, Integer> map = new LinkedHashMap<Person, Integer>();
	 * 
	 * map.put(p1, 1); map.put(p2, 2); map.put(p3, 3); map.put(p4, 1);
	 * 
	 * for (Person key: map.keySet()){ System.out.println(key + "; hash value:"
	 * + map.get(key)); }
	 * 
	 * Set<Person> set = new LinkedHashSet<Person>();
	 * 
	 * set.add(p1); set.add(p2); set.add(p3); set.add(p4);
	 * 
	 * System.out.println(set);
	 * 
	 * }
	 */

	// sorting lists
	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * ////////////////// sorting strings ///////////////////// List<String>
	 * animals = new ArrayList<String>();
	 * 
	 * animals.add("cat"); animals.add("elephant"); animals.add("tiger");
	 * animals.add("lion"); animals.add("snake");
	 * 
	 * Collections.sort(animals, new StringLengthComparator());
	 * 
	 * for (String animal: animals){ System.out.println(animal); }
	 * 
	 * System.out.println("**************************");
	 * 
	 * Collections.sort(animals, new ReverseAlphabeticalComparator());
	 * 
	 * for (String animal: animals){ System.out.println(animal); }
	 * 
	 * ////////////////// sorting numbers ///////////////////// List<Integer>
	 * numbers = new ArrayList<Integer>();
	 * 
	 * numbers.add(3); numbers.add(36); numbers.add(73); numbers.add(43);
	 * numbers.add(1);
	 * 
	 * 
	 * // the compare method can be implemented as anonymous class
	 * Collections.sort(numbers, new Comparator<Integer>(){ public int
	 * compare(Integer num1, Integer num2){ return -num1.compareTo(num2); }
	 * 
	 * });
	 * 
	 * System.out.println(numbers);
	 * 
	 * ////////////////// sorting arbitrary object /////////////////////
	 * 
	 * List<Person> people = new ArrayList<Person>();
	 * 
	 * people.add(new Person(1, "Joe")); people.add(new Person(2, "Bob"));
	 * people.add(new Person(4, "Clare")); people.add(new Person(3, "Sue"));
	 * 
	 * // sort in order of id Collections.sort(people, new Comparator<Person>(){
	 * 
	 * @Override public int compare(Person p1, Person p2) {
	 * 
	 * if (p1.getId() > p2.getId()){ return 1; } else if (p1.getId() <
	 * p2.getId()){ return -1; }
	 * 
	 * return 0; }
	 * 
	 * });
	 * 
	 * for (Person person: people){ System.out.println(person); }
	 * 
	 * System.out.println("***************************");
	 * 
	 * // sort in order of name Collections.sort(people, new
	 * Comparator<Person>(){
	 * 
	 * @Override public int compare(Person p1, Person p2) {
	 * 
	 * return p1.getName().compareTo(p2.getName()); }
	 * 
	 * });
	 * 
	 * for (Person person: people){ System.out.println(person); }
	 * 
	 * }
	 */

	// natural ordering : string
	/*
	 * public static void main(String[] args) {
	 * 
	 * List<String> list = new ArrayList<String>(); SortedSet<String> set = new
	 * TreeSet<String>();
	 * 
	 * addElements(list); addElements(set);
	 * 
	 * Collections.sort(list);
	 * 
	 * showElements(list); System.out.println(); showElements(set);
	 * 
	 * }
	 * 
	 * private static void addElements(Collection<String> col){ col.add("Joe");
	 * col.add("Sue"); col.add("Juliet"); col.add("Claire"); col.add("Mike");
	 * 
	 * }
	 * 
	 * private static void showElements(Collection<String> col){
	 * 
	 * for (String element: col){ System.out.println(element); }
	 * 
	 * }
	 */

	// natural ordering : own class
	/*
	 * public static void main(String[] args) {
	 * 
	 * List<Person> list = new ArrayList<Person>(); SortedSet<Person> set = new
	 * TreeSet<Person>();
	 * 
	 * addElements(list); addElements(set);
	 * 
	 * // Collections.sort(list);
	 * 
	 * showElements(list); System.out.println(); showElements(set);
	 * 
	 * }
	 * 
	 * private static void addElements(Collection<Person> col){ col.add(new
	 * Person("Joe")); col.add(new Person("Sue")); col.add(new
	 * Person("Juliet")); col.add(new Person("Claire")); col.add(new
	 * Person("Mike"));
	 * 
	 * }
	 * 
	 * private static void showElements(Collection<Person> col){
	 * 
	 * for (Person element: col){ System.out.println(element); }
	 * 
	 * }
	 */

	// queues
	/*
	 * public static void main(String[] args) {
	 * 
	 * // (head) <- oooooooooooooooooo <- (tail) FIFO // linked list can be also
	 * used as queue, but it is endless // ArrayBlockingQueue ha max size, 3
	 * items in this case Queue<Integer> q1 = new
	 * ArrayBlockingQueue<Integer>(3);
	 * 
	 * q1.add(10); q1.add(20); q1.add(30);
	 * 
	 * System.out.println("Head of queue is: " + q1.element());
	 * 
	 * // the queue does not force handling the exception of too many //
	 * elements, I have to add myself
	 * 
	 * try { q1.add(10); } catch (IllegalStateException e) {
	 * System.out.println("Trying to add too many items to the queue"); }
	 * 
	 * 
	 * for (Integer value: q1){ System.out.println("Queue value: " + value); }
	 * 
	 * System.out.println("Removed from queue: " + q1.remove());
	 * System.out.println("Removed from queue: " + q1.remove());
	 * System.out.println("Removed from queue: " + q1.remove());
	 * 
	 * try { System.out.println("Removed from queue: " + q1.remove()); } catch
	 * (NoSuchElementException e) {
	 * System.out.println("Tried to remove too many items from queue"); }
	 * 
	 * 
	 * /////////////// return special value instead of throwing exception
	 * ///////////////////
	 * 
	 * Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(2);
	 * 
	 * // peek is like element(), but does not throw exception
	 * System.out.println("Queue 2 peek: " + q2.peek());
	 * 
	 * 
	 * // offer is like add(), but does not throw exception q2.offer(10);
	 * q2.offer(20);
	 * 
	 * System.out.println("Queue 2 peek: " + q2.peek());
	 * 
	 * if (q2.offer(30) == false){
	 * System.out.println("Offer failed to add third item."); }
	 * 
	 * 
	 * for (Integer value: q1){ System.out.println("Queue value: " + value); }
	 * 
	 * // poll is like remove(), but does not throw exception
	 * System.out.println("Queue 2 poll: " + q2.poll());
	 * System.out.println("Queue 2 poll: " + q2.poll());
	 * System.out.println("Queue 2 poll: " + q2.poll());
	 * 
	 * 
	 * // there are others that suspend the program running in case of
	 * multithreading: // put: wait until the new element can be added // take:
	 * wait until an element appears in the queue // offer and poll with timeout
	 * }
	 */

	// using iterators
	/*
	 * public static void main(String[] args) {
	 * 
	 * // LinkedList is used because it is not efficient to add or remove //
	 * items from ArrayList unless it is at the end of the list
	 * LinkedList<String> animals = new LinkedList<>();
	 * 
	 * animals.add("fox"); animals.add("cat"); animals.add("dog");
	 * animals.add("rabbit");
	 * 
	 * // old iteration using the iterator // the advantage is that it can be
	 * used to remove items // this cannot be done in a for loop unless the
	 * class implements // the iterator interface // ListIterator allows you to
	 * add items to the list and has a previous() // method that allows to add
	 * items before the current one Iterator<String> it = animals.iterator();
	 * 
	 * while (it.hasNext()){ String value = it.next();
	 * System.out.println(value);
	 * 
	 * if (value.equals("cat")){ it.remove(); } }
	 * 
	 * System.out.println();
	 * 
	 * // modern iteration, Java 5 or later for (String animal: animals){
	 * System.out.println(animal); }
	 * 
	 * 
	 * }
	 */

	// own iterable class
	/*
	 * public static void main(String[] args) {
	 * 
	 * UrlLibrary urlLibrary = new UrlLibrary();
	 * 
	 * // for(String url: urlLibrary){ // System.out.println(url); // }
	 * 
	 * for(String html: urlLibrary){ System.out.println(html.length()); }
	 * 
	 * }
	 */

	// deciding wich collections to use
	/*
	 * public static void main(String[] args) {
	 * 
	 * // List / Set / Map?
	 * 
	 * ///////////////// LISTS ///////////////////////
	 * 
	 * // ArrayList is fast if you want to remove or add to the end // otherwise
	 * use LinkedList
	 * 
	 * //////////////// SETS ///////////////////////
	 * 
	 * // to store unique values // fast to check if an object exists // for own
	 * objects, hashCode() and equals() must be implemented // // order is
	 * unimportant: HashSet // sorted in natural order: TreeSet (must implement
	 * Comparable interface for custom) // elements in order of adding:
	 * LinkedHashSet
	 * 
	 * ///////////////// MAP ///////////////////////// // key value // iterating
	 * over map values is very slow // maps are not optimized for iteration //
	 * for own objects, hashCode() and equals() must be implemented // HashMap
	 * // TreeMap: must implement Comparable interface for custom //
	 * LinkedHashMap
	 * 
	 * 
	 * }
	 */

	// complex data structures: you don't know what data you will get
	/*
	public static String[] vehicles = { "ambulance", "helicopter", "lifeboat" };

	public static String[][] drivers = { 
		{ "Fred", "Sue", "Pete" },
		{ "Sue", "Richard", "Bob", "Fred" }, 
		{ "Pete", "Mary", "Bob" } 
	};

	public static void main(String[] args) {

		Map<String, Set<String>> personnel = new HashMap<String, Set<String>>();

		for (int i = 0; i < vehicles.length; i++) {
			String vehicle = vehicles[i];
			String[] driversList = drivers[i];

			Set<String> driverSet = new LinkedHashSet<String>();

			for (String driver : driversList) {
				driverSet.add(driver);
			}

			personnel.put(vehicle, driverSet);
		}

		{ // brackets just to scope driversList variable so can use again later
			// Example usage
			Set<String> driversList = personnel.get("helicopter");

			for (String driver : driversList) {
				System.out.println(driver);
			}
		}

		// iterate through whole thing
		for (String vehicle : personnel.keySet()) {
			System.out.print(vehicle);
			System.out.print(": ");
			Set<String> driversList = personnel.get(vehicle);

			for (String driver : driversList) {
				System.out.print(driver);
				System.out.print(" ");
			}
			
			System.out.println();
		}

	}
	*/
	
	// Eclipse shortcuts
	/*
	public static void main(String[] args) {
		// rename a variable: Alt-Shift-R
		// find all places where the variable is referenced: Right click -> References
		// go to the place where the variable is declared: F3
		// remove line: Ctrl-D
		ArrayList some;
		
		some = new ArrayList();
	}
	*/
	
	
	// lambda expression: passing a block of code to a method
	// e.g. passing code to a thread or button that is executed when the button 
	// is clicked
	public static void main(String[] args) {
		
		// if we declare a variable and don't change it it is called 
		// "effectively final"
		
		// Java 8:
		// int c = 100; 
		// 
		// Java < 8:
		final int c = 100;
		
		
		// in previous versions of Java: interface and anonymous class
		Runner runner = new Runner();
		runner.run(new Executable(){
			public int execute(int a){
				System.out.println("Hello there.");
				return c + 7 + a;
			}
		});
		
		System.out.println("================================");
		
		// with lambda expression
		// for passing parameters you should use the old method
		// runner.run(() -> {
		//	System.out.println("This is code passed in a lambda expression.");
		//	System.out.println("Hello there.");
		//  return 8;
		// });
		//
		// or just return a single value
		//
		// runner.run((int a) -> {8 + a});
		// 
		// in case of single parameter with no type
		// runner.run(a -> {8 + a});
		//
		// in case of multiple paramaters with no ambiguity
		// runner.run((a, b) -> {8 + a}); 
		// 
		// Executable ex = (a, b) -> { return a + b + c };
		// runner.run(ex);
		
	}
}
