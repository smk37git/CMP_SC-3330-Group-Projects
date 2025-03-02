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
}
