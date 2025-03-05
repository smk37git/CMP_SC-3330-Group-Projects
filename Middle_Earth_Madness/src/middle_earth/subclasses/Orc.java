package middle_earth.subclasses;

import middle_earth.charactercreator.MiddleEarthCharacter;

public class Orc extends MiddleEarthCharacter {

	
	// Attack Method
	/**
	 * Will get the target character's race and health and apply accurate damage.
	 * @parameters getRace(), getHealth(), damage
	 * @return boolean True + total damage for successful attack, boolean False for unsuccessful attack.
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		// 1.5x damage to Human
		// 1x damage to Dwarf and Wizard
		// 0x (Zero DMG) damage to Elf and Orc

		// Attack Value / Damage Values
		double attack = attackValue();
		double damage;
		
		// Get the race of the target
		String targetRace = target.getRace();
		
		if(targetRace.equals("Human")) {
			damage = attack * 1.5;
			target.setHealth(target.getHealth() - damage);
			return true;
			
		} else if(targetRace.equals("Dwarf") || targetRace.equals("Wizard")) {
			damage = attack * 1;
			target.setHealth(target.getHealth() - damage);
			return true;
			
		} else if(targetRace.equals("Elf") || targetRace.equals("Orc")) {
			damage = attack * 0;
			target.setHealth(target.getHealth() * damage);
			return true;
			
		}else {
			return false;
		}
		
	}

	// Get Race Method
	/**
	 * Request the target's race
	 * @return Target's Race
	 */
	@Override
	public String getRace() {
		return "Orc";
	}
	
	// Attack Method
	/**
	 * Initializes base damage
	 * @return base damage
	 */
	private double attackValue() {
		
		// Base DMG value is at 10
		return 10.0;
	}

}
