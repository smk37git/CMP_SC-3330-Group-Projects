package middle_earth.charactermanagementsystem;

import middle_earth.charactercreator.MiddleEarthCharacter;

public class CharacterManager {

	//Fields 
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[5];
	private int size;
	private int nameCount = 0;
	
	//methods
	//adds character c to characters array. doubles array length if full, returns true if necessary
	public boolean addCharacter(MiddleEarthCharacter c) {
		int i;
		for (i = 0; i < characters.length; i++) {
			if (characters[i] == null) {
				characters[i] = c;
				size++;
				break;
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
	public MiddleEarthCharacter getCharacter(String name) {
		int d;
		for (d=0; d < characters.length; d++) {
			if (characters[d].getName().equals(name)) {
				return characters[d];
			}
		}
		return null;
	}
	
	//if different, replaces character's name/health/power with the provided. returns false if no change
	//is made
	public boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
		if (character == null) {
			return false;
		}
		if (!(character.getName().equals(name))) {
			character.setName(name);
			
		}
		if (character.getHealth() != health) {
			character.setHealth(health);
		}
		if (character.getPower() != power) {
			character.setPower(power);
			return true;
		}
		return false;
	}
	
	//deletes a character, shortens characters length by 1 and shifts remaining entries down. 
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
		if (characters[characters.length-1] != null) {
			return false;
		}
		return true;
	}
	
	//prints every existing character's name/health/power
	public void displayAllCharacters() {
		for (int o = 0; o < characters.length; o++) {
			if(characters[o] != null) {
				System.out.println(characters[o].toString());
			}
		}
	}
	
	public void updateCommonNames() {
		for (int i=0; i<characters.length; i++) {
			MiddleEarthCharacter iTemp = characters[i];
			if (iTemp == null) {continue;}
			
			for (int j=0; j<=i; j++) {
				MiddleEarthCharacter jTemp = characters[j];
				if (jTemp == null) {continue;}
				if (iTemp.getName().equals(jTemp.getName()) && i != j) {
					String newName = iTemp.getName();
					nameCount++;
					updateCharacter(iTemp, newName + nameCount, iTemp.getHealth(), iTemp.getPower());
				}
			}
		}
	}
	
}