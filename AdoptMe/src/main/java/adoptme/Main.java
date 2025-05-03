package adoptme;

import adoptme.model.*;
import adoptme.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ShelterModel<IPetModel> shelter = new ShelterModel<>();

        List<IPetModel> regularPets = PetJsonLoader.loadPetsFromJson();
        List<IPetModel> exoticPets = PetJsonLoader.loadExoticsFromJson();

        regularPets.forEach(shelter::addPet);
        exoticPets.forEach(shelter::addPet);

        System.out.println("Loaded pets:");
        for (IPetModel pet : shelter.getAllPets()) {
            System.out.println(pet);
        }

     // ... inside main()
     PetJsonSaver.savePetsToFile(shelter.getAllPets());

    }
}