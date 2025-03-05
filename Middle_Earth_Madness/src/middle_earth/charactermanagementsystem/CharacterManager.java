package middle_earth.charactermanagementsystem;

import middle_earth.charactercreator.MiddleEarthCharacter;

/**
 * Manages array of MiddleEarthCharacter objects.
 * Provides methods to add, search by name, update, delete, or display all characters.
 */
public class CharacterManager {

	/**
	 * Array of MiddleEarthCharacter objects. Where every character is stored.
	 */
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[1];
	
	/**
	 * Integer that tracks the number of MiddleEarthCharacter objects in array "characters".
	 */
	private int size;
	
	//methods
	/**
	 * Adds a character to "characters" array. If full afterwards, doubles array size.
	 * @param c The character being added.
	 * @return True if array size was doubled, false otherwise.
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		int i;
		for (i = 0; i < characters.length; i++) {
			if (characters[i] == null) {
				characters[i] = c;
				size++;
			}
		}
		if (size == characters.length) {
			MiddleEarthCharacter[] characters2 = new MiddleEarthCharacter[characters.length*2];
			int b;
			for (b=0; b < characters.length; b++) {
				characters2[b] = characters[b];
			}
			characters = characters2;
			return true;
		}
		return false;
	}
	
	/**
	 * Searches array "characters" for a character by their name
	 * @param name The name used to search the array
	 * @return the MiddleEarthCharacter with specified name. Returns null if one does not exist.
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		int d;
		for (d=0; d < characters.length; d++) {
			if (characters[d].getName().equals(name)) {
				return characters[d];
			}
		}
		return null;
	}
	
	/**
	 * Updates the name, health, and/or power of a MiddleEarthCharacter object, ONLY IF they are different.
	 * @param character The character being updated
	 * @param name The updated name to be given to the character
	 * @param health The updated health to be given to the character.
	 * @param power The updated power to be given to the character
	 * @return True if any of the character's attributes were updated, false if not or if character did not exist
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		if (character == null) {
			return false;
		}
		if (!(character.getName().equals(name))) {
			character.setName(name);
			
		}
		if (character.getHealth() != health) {
			character.setHealth(health);
			return true;
		}
		if (character.getPower() != power) {
			character.setPower(power);
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes an existing MiddleEarthCharacter object and shifts any following in "characters" array left. 
	 * @param character The character to be deleted.
	 * @return True if character is deleted and array successfully updated. False otherwise.
	 */
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		int t;
		for (t = 0; t < characters.length; t++) {
			if (characters[t].equals(character)) {
				characters[t] = null;
				break;
			}
		}
		MiddleEarthCharacter[] temp = new MiddleEarthCharacter[characters.length-1];
		int p = 0;
		for (int l=0; l<characters.length; l++) {
			if(l != t) {
				temp[p] = characters[l];
				p++;
			}
		}
		characters = temp;
		if (characters[t] == character) {
			return false;
		}
		return true;
	}
	
	/**
	 * Prints out the information of every MiddleEarthCharacter object in the "characters" array.
	 */
	public void displayAllCharacters() {
		for (int o = 0; o < characters.length; o++) {
			if(characters[o] != null) {
				System.out.println(characters[o].toString());
			}
		}
	}
	
}
