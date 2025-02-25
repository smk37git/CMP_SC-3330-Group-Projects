package middle_earth.subclasses;

import middle_earth.charactercreator.MiddleEarthCharacter;

public class Elf extends MiddleEarthCharacter {

	
	// Attack Method
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		// 1.5x damage to Orc
		// 1x damage to Human / Wizard
		// 0x damage to Dwarf / Elf

		// Attack Value / Damage Values
		double attack = attackValue();
		double damage;
		
		// Get the race of the target
		String targetRace = target.getRace();
		
		if(targetRace.equals("Orc")) {
			damage = attack * 1.5;
			target.setHealth(target.getHealth() - damage);
			return true;
			
		} else if(targetRace.equals("Human") || targetRace.equals("Wizard")) {
			damage = attack * 1;
			target.setHealth(target.getHealth() - damage);
			return true;
			
		}else {
			return false;
		}
		
	}

	// Get Race Method
	@Override
	public String getRace() {
		return "Elf";
	}
	
	// Attack Method
	private double attackValue() {
		
		// Base DMG value is at 10
		return 10.0;
	}

}
