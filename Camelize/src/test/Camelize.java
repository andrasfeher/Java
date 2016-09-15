package test;

public class Camelize {
	
	public static String camelize(String sentence){
		
		StringBuilder result = new StringBuilder();
		String lowerCaseWords[] = sentence.toLowerCase().split("\\s+");
		
		result.append(lowerCaseWords[0]);
		
		for (int i = 1; i < lowerCaseWords.length; i++){
			result.append(Character.toUpperCase(lowerCaseWords[i].charAt(0)) + lowerCaseWords[i].substring(1));
		}
		
		return result.toString();
		
	}
	
	
	public static void main(String[] args) {
		
		String sentence = "This is the problem: I have an array of arrays";
	
		
		System.out.println(camelize(sentence));
		
	}

}
