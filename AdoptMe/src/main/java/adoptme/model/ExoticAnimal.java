package adoptme.model;

public class ExoticAnimal {
	
	// Attributes
	private String uniqueId;
	private String animalName;
	private String category;
	private String subSpecies;
	private int yearsOld;
	
	// Getters and Setters
	
	// Get / Set ID
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	// Get / Set Name
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	
	// Get / Set Category
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	// Get / Set Species
	public String getSubSpecies() {
		return subSpecies;
	}
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}
	
	// Get / Set Age
	public int getYearsOld() {
		return yearsOld;
	}
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
	
	// To String
	@Override
	public String toString() {
		return "ExoticAnimal [uniqueId=" + uniqueId + ", animalName=" + animalName + ", category=" + category
				+ ", subSpecies=" + subSpecies + ", yearsOld=" + yearsOld + "]";
	}
}
