/*Jonathan Abdo
 * create an app that allows users to add a country to a text file, 
 * and print the entire list of countries from the text file
 * 
 * (uses InputCheck.java https://github.com/Jabdo79/InputCheck)
 */
import java.io.IOException;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to the Countries Maintenance Application!");

		CountriesTextFile.createCountriesFile();

		String country = "";
		boolean cont = true;
		while (cont) {
			System.out.println("\n1.See the list of countries\n2.Add a country\n3.Clear List\n4.Exit\n");
			int menuChoice = InputCheck.getInt(sc, "Enter a menu number: ", 1, 4);

			System.out.println("");
			switch (menuChoice) {
			// see list of countries
			case 1:
				CountriesTextFile.listCountries();
				break;
			// add country
			case 2:
				System.out.print("Enter a country: ");
				country = sc.nextLine();
				CountriesTextFile.addCountry(country);
				break;
			// clear list
			case 3:
				CountriesTextFile.clearCountries();
				break;
			// exit
			case 4:
				System.out.println("Buh-bye!");
				cont = false;
				break;
			}
		}
	}
}
