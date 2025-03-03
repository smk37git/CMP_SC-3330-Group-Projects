package middle_earth.main;

import middle_earth.charactercreator.MiddleEarthCharacter;
import middle_earth.subclasses.*;

public class Main {

	public static void main(String[] args) {
		// Homework Assignment 2 -- Sebastian Main, Jase DeCota, Greg Gomez
		
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

	}

}
