import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Countries Maintenance Application!");
		
		String country = "";
		boolean cont = true;
		while(cont){
			System.out.println("\n1.See the list of countries\n2.Add a country\n3.Exit\n");
			int menuChoice = InputCheck.getInt(sc, "Enter a menu number: ", 1, 3);
			
			switch(menuChoice){
			//see list of countries
			case 1:
				System.out.println("");
				CountriesTextFile.listCountries();
				break;
			//add country
			case 2:
				System.out.print("Enter a country: ");
				country = sc.nextLine();
				CountriesTextFile.addCountry(country);
				break;
			//exit
			case 3:
				System.out.println("Buh-bye!");
				cont=false;
				break;
			}	
		}
	}
}
