package middle_earth.subclasses;

import middle_earth.charactercreator.MiddleEarthCharacter;

public class Human extends MiddleEarthCharacter {

	
	// Attack Method
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		// 1.5x damage to Wizard
		// 1x damage to Elf / Dwarf
		// 0x (Zero DMG) damage to Orc and Human

		// Attack Value / Damage Values
		double attack = attackValue();
		double damage;
		
		// Get the race of the target
		String targetRace = target.getRace();
		
		if(targetRace.equals("Wizard")) {
			damage = attack * 1.5;
			target.setHealth(target.getHealth() - damage);
			
		} else if(targetRace.equals("Elf") || targetRace.equals("Dwarf")) {
			damage = attack * 1;
			target.setHealth(target.getHealth() - damage);
			
		} else if(targetRace.equals("Orc") || targetRace.equals("Human")) {
			damage = attack * 0;
			target.setHealth(target.getHealth() * damage);
			
		}else {
			return false;
		}
		
		System.out.println(this.getName() + " parries " + target.getName()
		 + " and stabs them for " + damage + " damage!");
		return true;
		
	}

	// Get Race Method
	@Override
	public String getRace() {
		return "Human";
	}
	
	// Attack Method
	private double attackValue() {
		
		// Base DMG value is at 10
		return 10.0;
	}

}
