package middle_earth.charactermanagementsystem;

import middle_earth.charactercreator.MiddleEarthCharacter;

public class CharacterManager {

	//Fields 
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[2];
	private int size;
	
	//methods
	//adds character c to characters array. doubles array length if full, returns true if necessary
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
	
	//searches characters array by name. returns that character if found, null if not
	MiddleEarthCharacter getCharacter(String name) {
		int d;
		for (d=0; d < characters.length; d++) {
			if (characters[d].getName().equals(name)) {
				return characters[d];
			}
		}
		return null;
	}
	
	
	boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		int g;
		for (g = 0; g < characters.length; g++) {
			if (characters[g].equals(character)) {
				
			}
		}
	}
	
	boolean deleteCharacter(MiddleEarthCharacter character) {
		
	}
	
	
}
