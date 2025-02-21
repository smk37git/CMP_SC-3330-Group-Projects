package middle_earth.charactercreator;

public abstract class MiddleEarthCharacter {
	// Must extend MiddleEarthCharacter and implement attack(MiddleEarthCharacter) and getRace():
	
	// Character Fields
	private String name;
	private double health;
	private double power;
	
	// Constructor to initialize name, health, and power
	public MiddleEarthCharacter() {
		this.name = "Unknown";
		this.health = 100;
		this.power = 0;
	}
	
	/**
	 * Abstract Attack Method
	 * @param target
	 * 
	 * If true, reduce target health
	 * if false OR target is same kin, do NOT reduce target health
	 */
	public abstract void attack(MiddleEarthCharacter target);
	
	/**
	 * Abstract getRace Method
	 * Return's the race of a character
	 */
	public abstract void getRace();

}
