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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}
	
	// Display Info Method
	@Override
	public String toString() {
		return "MiddleEarthCharacter [name=" + name + ", health=" + health + ", power=" + power + "]";
	}
	

}
