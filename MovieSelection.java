package lab99;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * MovieSelection.java - Used to select a movie based on a list of students
 * 
 * This is my last commitment because I need github to say im a contributor
 * 
 * @author abbasjabor jonathan, ben
 * @version 5 April 2023
 */
public class MovieSelection {
	
	private TreeMap<String, TreeSet<String>> studentPreferences;
	
	/**
	 * Creates a Movie Selection object using a textfile of students preferences
	 * @param preferencesFile the file used to determine the students preferences
	 */
	public MovieSelection(String preferencesFile) {
	
	}
	/**
	 * Finds a movie that is most preferable by the list of students given
	 * @param students the list of students you're looking a movie for
	 * @return the movie thats most preferable
	 */
	public String findMovie(TreeSet<String> students) {
		
	}
	
	/**
	 * Abbas Part - Used to test the class
	 * has 10 separate test cases
	 */
	public static void main(String[] args) {
		String preferencesFile = "studentPreferences.txt";
		MovieSelection movieSelection = new MovieSelection(preferencesFile);

		TreeSet<String> students = new TreeSet<>(Arrays.asList("Abbas", "Thomas", "Seth"));
		TreeSet<String> students2 = new TreeSet<>(Arrays.asList("Liban", "Jonathan", "Megan"));
		TreeSet<String> students3 = new TreeSet<>(Arrays.asList("Benjamin", "Jimmy", "Anusha"));
		TreeSet<String> students4 = new TreeSet<>(Arrays.asList("Nikki", "Abbas", "Kyrin"));
		TreeSet<String> students5 = new TreeSet<>(Arrays.asList("William", "Ahmad", "Esther"));
		TreeSet<String> students6 = new TreeSet<>(Arrays.asList("Dylan", "Thomas", "Thad"));
		TreeSet<String> students7 = new TreeSet<>(Arrays.asList("Megan", "Kyrin", "Esther"));
		TreeSet<String> students8 = new TreeSet<>(Arrays.asList("Dylan", "Jonathan", "Seth"));
		TreeSet<String> students9 = new TreeSet<>(Arrays.asList("Abbas", "Thomas", "Seth", "Liban", "Jonathan", "Megan",
				"Benjamin", "Jimmy", "Anusha", "Kyrin", "Nikki", "William", "Ahmad", "Esther", "Thad", "Dylan"));
		TreeSet<String> students10 = new TreeSet<>(Arrays.asList());
		
		String movie = movieSelection.findMovie(students);
		String movie2 = movieSelection.findMovie(students2);
		String movie3 = movieSelection.findMovie(students3);
		String movie4 = movieSelection.findMovie(students4);
		String movie5 = movieSelection.findMovie(students5);
		String movie6 = movieSelection.findMovie(students6);
		String movie7 = movieSelection.findMovie(students7);
		String movie8 = movieSelection.findMovie(students8);
		String movie9 = movieSelection.findMovie(students9);
		String movie10 = movieSelection.findMovie(students10);
		
		System.out.println("1. " + students + " = " + movie);
		System.out.println("2. " + students2 + " = " + movie2);
		System.out.println("3. " + students3 + " = " + movie3);
		System.out.println("4. " + students4 + " = " + movie4);
		System.out.println("5. " + students5 + " = " + movie5);
		System.out.println("6. " + students6 + " = " + movie6);
		System.out.println("7. " + students7 + " = " + movie7);
		System.out.println("8. " + students8 + " = " + movie8);
		System.out.println("9. " + students9 + " = " + movie9);
		System.out.println("10. " + students10 + " = " + movie10);

	}

}
