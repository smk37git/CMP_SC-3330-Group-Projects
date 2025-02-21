package middle_earth.subclasses;

import middle_earth.charactercreator.MiddleEarthCharacter;

public class Elf extends MiddleEarthCharacter {

	
	// Attack Method
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		// 1.5x damage to Orc
		// 0x damage to Dwarf / Elf
		// 1x damage to Human / Wizard
		
		// Attack Value
		double attack;
		
		if(target == "Orc") {
			attack = attack * 1.5;
			target.health = target.health - attack;
			return true;
		} else if(target == "Human" || target == "Wizard") {
			attack = attack * 1;
			target.health = target.health - attack;
			return true;
		}else {
			return false;
		}
		
	}

	// Get Race Method
	@Override
	public void getRace() {
		// TODO Auto-generated method stub
		
	}

}
