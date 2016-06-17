import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountriesTextFile {

	private static File file;
	private static final Charset charset = Charset.forName("US-ASCII");

	public static void createCountriesFile() {
		// creates a path including filename
		Path p = Paths.get("src/countries.txt");

		// creates a new file using the path
		file = new File(p.toString());

		try {
			// if file does not exist, it will create it
			file.createNewFile();

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void listCountries() {

		String line = null;
		boolean empty = true;

		try {
			// create new reader using the file's path and US char set
			BufferedReader br = Files.newBufferedReader(file.toPath(), charset);

			// while the line is not empty, print it
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				empty = false;
			}
			br.close();

		} catch (IOException e) {
			System.out.println(e);
		}

		if (empty)
			System.out.println("List is empty!");
	}

	public static void addCountry(String country) {
		
		country = country.trim();
		
		if (!containsCountry(country)) {
			try {
				// opens file with intention of appending
				FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
				BufferedWriter bw = new BufferedWriter(fw);
				// write to file
				bw.write(country + "\n");
				bw.close();

			} catch (IOException e) {
				System.out.println(e);
			}
			System.out.println(country + " has been saved!");
		}
		else
			System.out.println(country+" is already in the list.");
	}

	public static void clearCountries() {
		
		try {
			// opens/clears the file
			FileWriter fw = new FileWriter(file.getAbsolutePath());
			fw.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("List has been cleared!");
	}

	public static boolean containsCountry(String country) {
		
		String line = null;
		boolean found = false;
		
		try {
			// create new reader using the file's path and US char set
			BufferedReader br = Files.newBufferedReader(file.toPath(), charset);

			// while the line is not empty, check it for the country
			while ((line = br.readLine()) != null) {
				if(line.equalsIgnoreCase(country)){
					found = true;
					break;
				}
			}
			br.close();

		} catch (IOException e) {
			System.out.println(e);
		}

		return found;
	}

	public static void removeCountry(String country) {

	}
}
