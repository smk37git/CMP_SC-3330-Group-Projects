package adoptme.model;

import java.util.Comparator;

import adoptme.model.PetModel;

public class PetSpeciesComparator implements Comparator<PetModel>{
	
	@Override
	public int compare(PetModel o1, PetModel o2) {
		return o1.getSpecies().compareTo(o2.getSpecies());
	}

}
