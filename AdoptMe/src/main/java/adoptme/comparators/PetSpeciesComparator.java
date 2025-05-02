package adoptme.comparators;

import java.util.Comparator;

import adoptme.model.IPetModel;

public class PetSpeciesComparator implements Comparator<IPetModel>{
	
	@Override
	public int compare(IPetModel o1, IPetModel o2) {
		return o1.getSpecies().compareTo(o2.getSpecies());
	}

}
