package adoptme.comparators;

import java.util.Comparator;

import adoptme.model.IPetModel;

public class PetAgeComparator implements Comparator<IPetModel>{
	
	@Override
	public int compare(IPetModel o1, IPetModel o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}

}
