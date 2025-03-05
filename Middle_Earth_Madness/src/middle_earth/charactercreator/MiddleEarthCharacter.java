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
	public abstract boolean attack(MiddleEarthCharacter target);
	
	/**
	 * Abstract getRace Method
	 * Return's the race of a character
	 */
	public abstract String getRace();
	
	// Getters and Setters
	
	/**
	 * Request Character's Name
	 * @return Character's Name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Request to set/change Character's Name
	 * @param name
	 * Return Character's new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Request Character's Health
	 * @return Character's Health
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * Request to set/change Character's Health
	 * @param health
	 * Return Character's New Health
	 */
	public void setHealth(double health) {
		this.health = health;
	}

	/**
	 * Request Character's Power
	 * @return Character's power
	 */
	public double getPower() {
		return power;
	}

	/**
	 * Request to set/change Character's Power
	 * @param power
	 * Return Character's New Power
	 */
	public void setPower(double power) {
		this.power = power;
	}
	
	// Display Info Method
	/**
	 * Return full character's info in string format (name, health, power)
	 */
	@Override
	public String toString() {
		return "MiddleEarthCharacter [name=" + name + ", health=" + health + ", power=" + power + "]";
	}
	

}
