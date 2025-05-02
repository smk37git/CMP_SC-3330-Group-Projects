package adoptme.model;


public class ExoticPetAdapter implements IPetModel {

	private ExoticAnimalModel exoticAnimal;
	private boolean adopted;
	
	public ExoticPetAdapter() {
		this.exoticAnimal = new ExoticAnimalModel();
		
	}
	
	public int getId() {
		return exoticAnimal.getUniqueId().charAt(5);
	}
	
	public void setId(int id) {
		exoticAnimal.setUniqueId("exo00" + id);
	}
	
	// Get / Set Name
	public String getName() {
		return exoticAnimal.getAnimalName();
	}
	
	public void setName(String name) {
		exoticAnimal.setAnimalName(name);
	}
	
	// Get / Set Type
	public String getType() {
		return exoticAnimal.getCategory();
	}
	
	
	public void setType(String type) {
		exoticAnimal.setCategory(type);
	}
	
	// Get / Set Species
	public String getSpecies() {
		return exoticAnimal.getSubSpecies();
	}
	
	
	public void setSpecies(String species) {
		exoticAnimal.setSubSpecies(species);
	}
	
	
	// Get / Set Age
	public int getAge() {
		return exoticAnimal.getYearsOld();
	}
	
	
	public void setAge(int age) {
		exoticAnimal.setYearsOld(age);
	}
	
	// Get / Set Adopted Status
	public boolean isAdopted() {
		return adopted;
	}

	
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + this.getId() + ", name=" + this.getName() + ", type=" + this.getType() + ", species=" + this.getSpecies() + ", age=" + this.getAge()
				+ ", adopted=" + adopted + "]";
	}
	
	@Override
	public int compareTo(IPetModel p) {
		return this.getName().compareTo(p.getName());
	}
	
}
