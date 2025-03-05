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
		
		Wizard staffGuy = new Wizard();
		charManager.addCharacter(staffGuy);
		charManager.updateCharacter(staffGuy, "Jorge", 75, 30);
		
		
		/**
		 * @while When the user has not used the "exit" function of the
		 * menu, it keeps playing so the player can use it.
		 */
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
			
			
			/**
			 * Case 1: Add character - This takes the users input again
			 * to make a character of the desired race for the user
			 */
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
				charManager.updateCommonNames();
					
				
			} 
			
			/**
			 * Case 2: Display characters - This uses the display
			 * all characters function to display the characters
			 * for the user
			 */
			else if (userInput.equals("2")) {
				charManager.updateCommonNames();
				charManager.displayAllCharacters();
			} 
			
			/**
			 * Case 3: Update character - this uses the update character
			 * function combined with the user's input to get new values
			 * for the desired character.
			 */
			else if (userInput.equals("3")) {
				System.out.println("Which character would you like to update? (Type the name of the character)");
				charManager.displayAllCharacters();
				
				testUserInput = scanner.nextLine();
				
				//use the users input to find a character and update it with the user's input
				characterChoice = charManager.getCharacter(testUserInput);
				if (characterChoice != null) {
					double newPower = 0;
					double newHP = 0;
					
					System.out.println("What will the character's new name be?");
					String userCharacterName = scanner.nextLine();
					
					System.out.println("What will the character's Health Points be?");
					String userCharacterHP = scanner.nextLine();
					try {
					    newHP = Double.parseDouble(userCharacterHP);
					    System.out.println(userCharacterName + " now has an HP of " + newHP);
					} catch (NumberFormatException e) {
					    System.out.println("Invalid number format: " + userCharacterName);
					}
					
					System.out.println("What will the character's new power be?");
					String userCharacterPower = scanner.nextLine();
					
					try {
					    newPower = Double.parseDouble(userCharacterPower);
					    System.out.println(userCharacterPower + " now has a power of " + newPower);
					} catch (NumberFormatException e) {
					    System.out.println("Invalid number format: " + userCharacterPower);
					}
					
					charManager.updateCharacter(characterChoice, userCharacterName, newHP, newPower);
					
				} else {
					System.out.println("Sorry, I couldn't understand that input.");
					continue;
				}
			} else if (userInput.equals("4")) {
				System.out.println("Which character do you want to delete? (Type the name)");
				charManager.displayAllCharacters();
				characterChoice = charManager.getCharacter(scanner.nextLine());
				charManager.deleteCharacter(characterChoice);
				
			} 
			
			/**
			 * Case 5: Attacking someone - this part of the menu gets
			 * an attacker and defender from the user and uses the
			 * attack. If the attacker and defender are the same person,
			 * the attack does not do anything
			 */
			else if (userInput.equals("5")) {
				System.out.println("Who is attacking? (Type the name)");
				charManager.displayAllCharacters();
				String attackerName = scanner.nextLine();
				
				MiddleEarthCharacter attacker = charManager.getCharacter(attackerName);
				if (attacker != null) {
					System.out.println("Who is getting attacked? (Type the name)");
					charManager.displayAllCharacters();
					String defenderName = scanner.nextLine();
					
					//make sure the character is not hitting themselves
					MiddleEarthCharacter defender = charManager.getCharacter(defenderName);
					if (defender != null) {
						if (attackerName.equals(defenderName)) {
							System.out.println("Someone can not attack themselves.");
							continue;
						}
						attacker.attack(defender);
						
						if (defender.getHealth() < 0) {
							System.out.println(attackerName + " has slain " + defenderName);
							charManager.deleteCharacter(defender);
						}
						
					} else {
						System.out.println("Sorry, I couldn't understand that input.");
						continue;
					}
				} else {
					System.out.println("Sorry, I couldn't understand that input.");
					continue;
				}
				
			} 
			
			/**
			 * This case if for when a user wants to exit the game,
			 * the loop will break and the game will end
			 */
			else if (userInput.equals("6")) {
				System.out.println("Thank you for playing!");
				break;
			} 
			
			/**
			 * If the 
			 */
			else {
				System.out.println("Sorry, I couldn't understand that input.");
				continue;
			}
		}
	}

}