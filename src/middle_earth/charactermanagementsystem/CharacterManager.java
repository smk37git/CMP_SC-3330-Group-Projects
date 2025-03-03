package middle_earth.charactermanagementsystem;

import java.util.Arrays;

import middle_earth.charactercreator.MiddleEarthCharacter;

public class CharacterManager {

	//attributes
	private int size = 5;
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[size];
	private MiddleEarthCharacter[] newCharacters = characters;
	int a;
	
	//methods
	
	boolean addCharacter(MiddleEarthCharacter c) {
		for (a = 0; a < characters.length; a++) {
			if (characters[a] == null) {
				characters[a] = c;
				return true;
			}
			if (a == size-1) {
				size = size*2;
				newCharacters = new MiddleEarthCharacter[size];
				
				newCharacters = Arrays.copyOf(characters, 10);
				characters = newCharacters;
			
			}
		}
		
		return false;
	}
	
}
