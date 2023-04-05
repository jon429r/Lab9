package lab99;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class MovieSelection {
	
	
	
	public MovieSelection() {
		
		TreeMap<String, TreeSet<Movie>> mainMap = new TreeMap<String, TreeSet<Movie>>();
		
		Scanner scnrS = new Scanner("students.txt");
		Scanner scnrM = new Scanner("movies.txt");
		
		while (scnrS.hasNextLine()) {
			
			String currStu = scnrS.nextLine();
			TreeSet<Movie> movieMap = new TreeSet<Movie>();
			
			while (scnrM.hasNextLine()) {
				
				
				Movie currmov = new Movie (scnrM.next());
				
				movieMap.add(currmov);
				
				mainMap.put(currStu, movieMap);
			}
			
			mainMap.put(currStu, movieMap);
			
			
		}
		
	}

}
