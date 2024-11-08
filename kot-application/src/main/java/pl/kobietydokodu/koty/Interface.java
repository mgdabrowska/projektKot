package pl.kobietydokodu.koty;

import pl.kobietydokodu.koty.domain.Cat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interface {

	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	static CatDAO catDAO = new CatDAO();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Cat cat = new Cat();
		for (;;) {

			System.out.println("Hello, what kind activities do you want ?");
			System.out.println("[1] add new cat");
			System.out.println("[2] show all cats");
			System.out.println("[x] finish");
			String gUI = getUserInput();
			if (gUI.equals("1")) {
				createCat();
			} else if (gUI.equals("2")) {
				seeCat();
			} else if (gUI.equals("x")) {
				break;
			} else
				System.out.println("select the correct number!!!!");
			    System.out.println("  ");
		}
	}

	private static void createCat() {
		Cat cat = new Cat();
		System.out.println(" Give your's cat name ");
		cat.setName(getUserInput());

		System.out.println(" Give the name of its mentor ");
		cat.setNameofMentor(getUserInput());

		String dateofCat;
		do {

			System.out.println("Enter its date of birth in the format RRRR.MM.DD");
			dateofCat = getUserInput();
			if (Pattern.matches("^\\d{4}\\.(0[1-9]|1[0-2])\\.(0[1-9]|[12]\\d|3[01])$", dateofCat)) {
				try {
					cat.setDateBirth(sdf.parse(dateofCat));
				} catch (ParseException pe) {
					System.out.println(
							" Something is wrong with the date !!! Try to enter the correct format, e.g : 2013.03.21");
				}
			} else {
				System.out.println("Something is wrong with the date");
			}

		} while (cat.getDateBirth() == null);
		String weightofCat;
		do {
			System.out.println("give its weight in the format xx.xx ");
			weightofCat = getUserInput();
			if (Pattern.matches("[0-9]+(\\.[0-9]+)?", weightofCat)) {
				try {

					cat.setWeight(Float.parseFloat(weightofCat));
				} catch (NumberFormatException nfe) {
					System.out.println(" Something is wrong with the weight format");
				}
			}
		} while (cat.getWeight() == null);

		catDAO.addCat(cat);
		System.out.println(" Now you know everything about the cat !!!");
	}

	public static String getUserInput() {
		return sc.nextLine();

	}

	private static void seeCat() {
		// Cat cat = new Cat();

		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                 LIST OF CATS                ######");
		System.out.println("#########################################################");
		List<Cat> kitty = catDAO.kitty;
		Cat cat;
		for (int i = 0; i < kitty.size(); i++) {
			cat = kitty.get(i);
			System.out.println(i + ":   " + cat.getName());
		}

		System.out.println();
		String numberCat;
		do {
			System.out.println(" which cat do you want to get to know better ");
			numberCat = getUserInput();
		} while (!Pattern.matches("[0-9]+", numberCat));

		int numberOfCat = Integer.parseInt(numberCat);
		if (numberOfCat <= kitty.size()) {
			String selectedCat = kitty.get(numberOfCat).introduceYourself();
			System.out.println(selectedCat);
		} else {
			System.out.println("The cat with this number does not exist");
		}
	}
}
