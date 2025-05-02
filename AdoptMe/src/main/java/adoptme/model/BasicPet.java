package adoptme.model;

public abstract class BasicPet implements IPetModel{
	//attributes
	private int id;
	private String name;
	private String type;
	private String species;
	private int age;
	private boolean adopted;
	
	
	// Getters and Setters
	
	// Get / Set ID
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	// Get / Set Name
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// Get / Set Type
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
	
	// Get / Set Species
	public String getSpecies() {
		return species;
	}
	
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	
	// Get / Set Age
	public int getAge() {
		return age;
	}
	
	
	public void setAge(int age) {
		this.age = age;
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
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", age=" + age
				+ ", adopted=" + adopted + "]";
	}
	
	@Override
	public int compareTo(IPetModel p) {
		return this.name.compareTo(p.getName());
	}
}
