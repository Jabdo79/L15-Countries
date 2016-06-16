import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {

	private static File file;
	private static final Charset charset = Charset.forName("US-ASCII");

	public static void createCountriesFile() throws IOException {
		// creates a path including filename
		Path p = Paths.get("src/countries.txt");
		// creates a new file using the path
		file = new File(p.toString());
		// if file does not exist, it will create it
		file.createNewFile();
	}

	public static void listCountries() throws IOException {
		// create new reader using the file's path and US char set
		BufferedReader br = Files.newBufferedReader(file.toPath(), charset);
		String line = null;
		boolean empty = true;
		// while the line is not empty, print it
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			empty = false;
		}
		if(empty)
			System.out.println("List is empty!");
		br.close();
	}

	public static void addCountry(String country) throws IOException {
		// opens file with intention of appending
		FileWriter fw = new FileWriter(file.getAbsolutePath(), true); 
		BufferedWriter bw = new BufferedWriter(fw);
		// write to file
		bw.write(country+"\n");
		bw.close();
		System.out.println(country + " has been saved!");
	}
	
	public static void clearCountries() throws IOException{
		//opens/clears the file
		FileWriter fw = new FileWriter(file.getAbsolutePath()); 
		fw.close();
		System.out.println("List has been cleared!");
	}
}
