package middle_earth.subclasses;

import middle_earth.charactercreator.MiddleEarthCharacter;

public class Dwarf extends MiddleEarthCharacter {

	
	// Attack Method
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		// 1.5x damage to Elf
		// 1x damage to Human / Orc
		// 0x (Zero DMG) damage to Wizard and Dwarf

		// Attack Value / Damage Values
		double attack = attackValue();
		double damage;
		
		// Get the race of the target
		String targetRace = target.getRace();
		
		if(targetRace.equals("Elf")) {
			damage = attack * 1.5;
			target.setHealth(target.getHealth() - damage);
			
		} else if(targetRace.equals("Human") || targetRace.equals("Orc")) {
			damage = attack * 1;
			target.setHealth(target.getHealth() - damage);
			
		} else if(targetRace.equals("Wizard") || targetRace.equals("Dwarf")) {
			damage = attack * 0;
			target.setHealth(target.getHealth() * damage);
			
		}else {
			return false;
		}
		
		System.out.println(this.getName() + " Swings his axe at " + target.getName()
		 + " and deals " + damage + " damage!");
		return true;
		
	}

	// Get Race Method
	@Override
	public String getRace() {
		return "Dwarf";
	}
	
	// Attack Method
	private double attackValue() {
		
		// Base DMG value is at 10
		return 10.0;
	}

}
