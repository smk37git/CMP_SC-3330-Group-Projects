package middle_earth.main;

import java.util.Scanner;

import middle_earth.charactercreator.MiddleEarthCharacter;
import middle_earth.subclasses.*;
import middle_earth.charactermanagementsystem.CharacterManager;

public class Main {

	public static void main(String[] args) {
		// Homework Assignment 2 -- Sebastian Main, Jase DeCota, Greg Gomez
		
		Scanner scanner = new Scanner(System.in);
		String userInput = "7";

		
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
			
			
			if (userInput == "1") {
				System.out.println("What kind of character:"
						+ "1. Dwarf"
						+ "2. Elf"
						+ "3. Human"
						+ "4. Orc"
						+ "5. Wizard");
			} else if (userInput == "2") {
				
			} else if (userInput == "3") {
				
			} else if (userInput == "4") {
				
			} else if (userInput == "5") {
				
			} else if (userInput == "1") {
				
			} else {
				System.out.println("Sorry, I couldn't understand that input.");
				continue;
			}
		}
	}

}