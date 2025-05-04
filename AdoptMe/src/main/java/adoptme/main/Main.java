package adoptme.main;

import adoptme.model.*;
import adoptme.controller.*;
import adoptme.util.*;
import adoptme.view.*;
import java.util.List;

public class Main {

	/**
	 * The main function calls the necessary functions to
	 * get the PetView window to activate so the user can use it.
	 * it makes the shelter, then the controller for the shelter,
	 * then gets the pets from the provided files, puts them in the
	 * shelter, then calls the PetView display.
	 */
    public static void main(String[] args) {
        ShelterModel<IPetModel> shelter = new ShelterModel<>();
        PetController controller = new PetController(shelter);

        List<IPetModel> regularPets = PetJsonLoader.loadPetsFromJson();
        List<IPetModel> exoticPets = PetJsonLoader.loadExoticsFromJson();

        regularPets.forEach(shelter::addPet);
        exoticPets.forEach(shelter::addPet);

        new PetView(controller);

    }
}