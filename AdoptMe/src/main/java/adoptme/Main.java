package adoptme;

import adoptme.model.*;
import adoptme.util.*;
import adoptme.view.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ShelterModel<IPetModel> shelter = new ShelterModel<>();

        List<IPetModel> regularPets = PetJsonLoader.loadPetsFromJson();
        List<IPetModel> exoticPets = PetJsonLoader.loadExoticsFromJson();

        regularPets.forEach(shelter::addPet);
        exoticPets.forEach(shelter::addPet);

        new PetView(shelter.getAllPets());

    }
}