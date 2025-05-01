package adoptme.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import adoptme.model.PetModel;
import adoptme.model.PetAgeComparator;
import adoptme.model.PetSpeciesComparator;

public class ShelterModel <T extends PetModel> {
	
	// Create Pets List
	private List<T> pets = new ArrayList<>();
	
	// Add pet to list
	public void addPet (T pet) {
		pets.add(pet);
	}
	
	/** Remove pet from list
	 * 
	 * @param id
	 * @param pet
	 * @return (If statement to find ID: remove if true, do nothing if false)
	 */
	public boolean removePet(int id, T pet) {
		if (pet.getId() == id) {
			pets.remove(pet);
			return true;
		} else if (pet.getId() != id) {
			return false;
		}
		return false;
	}
	
	// Get all Pets
	public List<T> getAllPets() {
		return new ArrayList<>(pets);
	}
	
	/**
	 * For into If statement to check if a pet is adoptable (return true if yes and use setter, false if no).
	 * 
	 * @param int ID
	 * @return if true = adopt pet
	 * @return if false = pet is already adopted
	 */
	public boolean adoptPet(int id) {
		for (T pet: pets) {
			if (pet.getId() == id && !pet.isAdopted()) {
				pet.setAdopted(true);
				return true;
			} else if (pet.getId() == id && pet.isAdopted()) {
				return false;
			}
		}
		return false;
	}
	
	// Sort pets alphabetically
	public void nameSort() {
		Collections.sort(pets);
	}
	
	// Sort pets by age
	public void ageSort(PetAgeComparator comparator) {
		Collections.sort(pets, comparator);
	}
	
	//sort pets by species
	public void speciesSort(PetSpeciesComparator comparator) {
		Collections.sort(pets, comparator);
	}
}