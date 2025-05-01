package adoptme.model;

import java.util.Comparator;

import adoptme.model.PetModel;

public class PetAgeComparator implements Comparator<PetModel>{
	
	@Override
	public int compare(PetModel o1, PetModel o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}

}
