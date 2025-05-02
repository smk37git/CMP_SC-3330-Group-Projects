package adoptme.model;

import adoptme.model.PetModel;

public class CatModel implements PetModel {

	//attributes
	private int id;
	private String name;
	private String type;
	private String species;
	private int age;
	private boolean adopted;
	
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", age=" + age
				+ ", adopted=" + adopted + "]";
	}
	
	@Override
	public int compareTo(PetModel p) {
		return this.name.compareTo(p.getName());
	}
}
