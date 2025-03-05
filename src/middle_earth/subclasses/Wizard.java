package middle_earth.subclasses;

import middle_earth.charactercreator.MiddleEarthCharacter;

public class Wizard extends MiddleEarthCharacter {

	
	// Attack Method
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		// 1.5x damage to Dwarf
		// 1x damage to Human and Wizard
		// 0x (Zero DMG) damage to Elf and Orc

		// Attack Value / Damage Values
		double attack = attackValue();
		double damage;
		
		// Get the race of the target
		String targetRace = target.getRace();
		
		if(targetRace.equals("Dwarf")) {
			damage = attack * 1.5;
			target.setHealth(target.getHealth() - damage);
			
		} else if(targetRace.equals("Human") || targetRace.equals("Wizard")) {
			damage = attack * 1;
			target.setHealth(target.getHealth() - damage);
			
		} else if(targetRace.equals("Elf") || targetRace.equals("Orc")) {
			damage = attack * 0;
			target.setHealth(target.getHealth() * damage);
			
		}else {
			return false;
		}
		
		System.out.println(this.getName() + " casts fireball on " + target.getName()
		 + " and deals " + damage + " damage!");
		return true;
		
	}

	// Get Race Method
	@Override
	public String getRace() {
		return "Wizard";
	}
	
	// Attack Method
	private double attackValue() {
		
		// Base DMG value is at 10
		return 10.0;
	}

}
