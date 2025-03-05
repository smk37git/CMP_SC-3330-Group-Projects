package middle_earth.main;

import java.util.Scanner;

import middle_earth.charactercreator.MiddleEarthCharacter;
import middle_earth.subclasses.*;
import middle_earth.charactermanagementsystem.CharacterManager;

public class Main {

	public static void main(String[] args) {
		// Homework Assignment 2 -- Sebastian Main, Jase DeCota, Greg Gomez
		Scanner scanner = new Scanner(System.in);
		String userInput = "-1";
		String testUserInput = "-1";
		MiddleEarthCharacter characterChoice = null;
		String userCharacterName;
		int userCharacterHP;
		int userCharacterPower;
		

		
		// Subclass TEST
		Dwarf dwarf_test = new Dwarf();
		System.out.println(dwarf_test.toString());
		
		Elf elf_test = new Elf();
		System.out.println(elf_test.toString());
		
		Human human_test = new Human();
		System.out.println(human_test.toString());
		
		Orc orc_test = new Orc();
		System.out.println(orc_test.toString());
		
		Wizard wizard_test = new Wizard(); 
		System.out.println(wizard_test.toString());

		CharacterManager charManager = new CharacterManager();
		charManager.addCharacter(dwarf_test);
		charManager.addCharacter(orc_test);
		charManager.updateCharacter(dwarf_test, "Bob", 50, 10);
		charManager.updateCharacter(orc_test, "Dylan", 150, 20);
		charManager.displayAllCharacters();
		
		charManager.addCharacter(new Wizard());
		
		while (userInput != "6") {
			System.out.println("Menu (type a number for the desired option):");
			System.out.println("1. Add a character");
			System.out.println("2. View characters");
			System.out.println("3. Update a character");
			System.out.println("4. Delete character");
			System.out.println("5. Execute all characters attacks");
			System.out.println("6. Exit");
			
			userInput = scanner.nextLine();
			System.out.println(userInput);
			
			
			if (userInput.equals("1")) {
				System.out.println("What kind of character:");
				System.out.println("1. Dwarf");
				System.out.println("2. Elf");
				System.out.println("3. Human");
				System.out.println("4. Orc");
				System.out.println("5. Wizard");
				System.out.println("6. Exit");
				testUserInput = scanner.nextLine();
				
				
				if (testUserInput.equals("1")) {
					Dwarf newDwarf = new Dwarf();
					charManager.addCharacter(newDwarf);
				} else if (testUserInput.equals("2")) {
					Elf newElf = new Elf();
					charManager.addCharacter(newElf);
				} else if (testUserInput.equals("3")) {
					Human newHuman = new Human();
					charManager.addCharacter(newHuman);
				} else if (testUserInput.equals("4")) {
					Orc newOrc = new Orc();
					charManager.addCharacter(newOrc);
				} else if (testUserInput.equals("5")) {
					Wizard newWizard = new Wizard();
					charManager.addCharacter(newWizard);
				} else if (testUserInput.equals("6")) {
					continue;
				} else {
					System.out.println("Sorry, I couldn't understand that input.");
					continue;
				}

				System.out.println("Successfully added!");
					
				
			} else if (userInput.equals("2")) {
				charManager.displayAllCharacters();
			} else if (userInput.equals("3")) {
				System.out.println("Which character would you like to update? (Type the name of the character)");
				charManager.displayAllCharacters();
				
				testUserInput = scanner.nextLine();
				
				//use the users input to find a character and update it with the user's input
				characterChoice = charManager.getCharacter(testUserInput);
				if (characterChoice != null) {
					System.out.println("What will the character's new name be?");
					
					
				} else {
					System.out.println("Sorry, I couldn't understand that input.");
					continue;
				}
			} else if (userInput.equals("4")) {
				
			} else if (userInput.equals("5")) {
				
			} else if (userInput.equals("6")) {
				break;
			} else {
				System.out.println("Sorry, I couldn't understand that input.");
				continue;
			}
		}
	}

}