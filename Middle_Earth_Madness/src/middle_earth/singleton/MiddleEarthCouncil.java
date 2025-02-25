package middle_earth.singleton;

import middle_earth.charactermanagementsystem.CharacterManager;

public class MiddleEarthCouncil {
	
	// Attribute
	private static MiddleEarthCouncil instance;
	
	// Prevent from being invoked outside
	private MiddleEarthCouncil() {
		
	}
	
	// Get Instance Method
	public static MiddleEarthCouncil getInstance() {
		if(instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	// Character Manager
	CharacterManager getCharacterManager() {
		return null;
	}

}
