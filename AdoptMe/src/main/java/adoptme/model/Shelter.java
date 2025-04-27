package adoptme.model;

import java.util.ArrayList;
import java.util.List;

public class Shelter <T extends Pet> {
	
	// Create Pets List
	private List<T> pets = new ArrayList<>();
}