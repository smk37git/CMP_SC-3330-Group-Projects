package adoptme.model;

public interface PetModel extends Comparable<PetModel>{

	// Getters and Setters
	
	// Get / Set ID
	public int getId();
	
	public void setId(int id);
	
	// Get / Set Name
	public String getName();
	
	public void setName(String name);
	
	// Get / Set Type
	public String getType();
	
	
	public void setType(String type);
	
	// Get / Set Species
	public String getSpecies();
	
	
	public void setSpecies(String species);
	
	
	// Get / Set Age
	public int getAge();
	
	
	public void setAge(int age);
	
	// Get / Set Adopted Status
	public boolean isAdopted();

	
	public void setAdopted(boolean adopted);
	
	
	// To String
	@Override
	public String toString();
	
	//Comparable
	@Override
	public int compareTo(PetModel p);
	
}
