package lab9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * MovieSelection.java - Used to selecy a movie based on a list of students
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
	
	//Made by Ben
	public MovieSelection(String preferencesFile) {
		studentPreferences = new TreeMap<>();

		try (Scanner scanner = new Scanner(new File(preferencesFile))) {
			while (scanner.hasNextLine()) {
				//grabs a line and removes the spaces between every word or character
				String line = scanner.nextLine().trim();
				if (line.isEmpty()) {
					continue;
				}
				//splits off the name of the student from their preferences
				// parts[0] == students name 
				// parts[1] == the preferences as an entire string
				String[] parts = line.split(":");
				
				//Stores the name of the student in a string object
				String student = parts[0].trim();
				
				//Stores the movie preferences individually by splitting them from the comma
				String[] preferences = parts[1].trim().split(",");
				
				//Turn the Array to a treeset
				TreeSet<String> preferenceSet = new TreeSet<>(Arrays.asList(preferences));
				
				//Add the student and their preferences to the treemap
				studentPreferences.put(student, preferenceSet);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Finds a movie that is most preferable by the list of students given
	 * @param students the list of students you're looking a movie for
	 * @return the movie thats most preferable
	 */
	
	//Made by Jonathan
	//Jonathan's Part
		public String findMovie(TreeSet<String> students) {
				//creates a treemap to keep count of which movie is most popular
				TreeMap<String, Integer> movieCount = new TreeMap<>();
				
				//fills up the movieCount treemap
				for (String student : students) {
					//grab their preferences
					TreeSet<String> preferences = studentPreferences.get(student);
					
					//if preferences are null move on
					if (preferences == null) {
						continue;
					}
					//go through their movie preferences
					for (String movie : preferences) {
						//add to the movie count
						movieCount.put(movie, movieCount.getOrDefault(movie, 0) + 1);
					}
				}
				//if treemap is entirely empty return null
				if (movieCount.isEmpty()) {
					return null;
				}
				//Store the max value of the from the treemap as an int
				int maxCount = Collections.max(movieCount.values());
				//Create an arraylist to store the movie(s) with the highest preference
				ArrayList<String> maxMovies = new ArrayList<>();
				//search the treemap for the movie(s) with the highest preference
				
				for (Entry<String, Integer> entry : movieCount.entrySet()) {
					if (entry.getValue() == maxCount) {
						maxMovies.add(entry.getKey());
					}
				}
				
				//returns the movie with the highest count
				//if there are more than one movie, randomly choose the movie based off the size of arraylist
				return maxMovies.get(new Random().nextInt(maxMovies.size()));
		}

	/**
	 * Used to test the class
	 * 
	 */
	
	//made by Abbas
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