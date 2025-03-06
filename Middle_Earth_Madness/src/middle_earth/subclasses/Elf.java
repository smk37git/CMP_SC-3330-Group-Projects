package middle_earth.subclasses;

import middle_earth.charactercreator.MiddleEarthCharacter;

public class Elf extends MiddleEarthCharacter {

	
	// Attack Method
	/**
	 * Will get the target character's race and health and apply accurate damage.
	 * @parameters getRace(), getHealth(), damage
	 * @return boolean True + total damage for successful attack, boolean False for unsuccessful attack.
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		// 1.5x damage to Orc
		// 1x damage to Human / Wizard
		// 0x (Zero DMG) damage to Dwarf / Elf

		// Attack Value / Damage Values
		double attack = attackValue();
		double damage;
		
		// Get the race of the target
		String targetRace = target.getRace();
		
		if(targetRace.equals("Orc")) {
			damage = attack * 1.5;
			target.setHealth(target.getHealth() - damage);
			
		} else if(targetRace.equals("Human") || targetRace.equals("Wizard")) {
			damage = attack * 1;
			target.setHealth(target.getHealth() - damage);
			
		} else if(targetRace.equals("Dwarf") || targetRace.equals("Elf")) {
			damage = attack * 0;
			target.setHealth(target.getHealth() * damage);
			
		}else {
			return false;
		}
		

		//Character specific attack sequence
		System.out.println(this.getName() + " shoots an arrow at " + target.getName()
		 + " and deals " + damage + " damage!");
		return true;
		
	}

	// Get Race Method
	/**
	 * Request the target's race
	 * @return Target's Race
	 */
	@Override
	public String getRace() {
		return "Elf";
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
