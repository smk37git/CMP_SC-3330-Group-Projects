package adoptme.controller;

import adoptme.model.IPetModel;
import adoptme.model.ShelterModel;
import adoptme.comparators.PetAgeComparator;
import adoptme.comparators.PetSpeciesComparator;
import adoptme.util.PetJsonSaver;

import java.util.Collections;
import java.util.List;

public class PetController {
    private final ShelterModel<IPetModel> shelter;

    public PetController(ShelterModel<IPetModel> shelter) {
        this.shelter = shelter;
    }

    public List<IPetModel> getPets() {
        return shelter.getAllPets();
    }

    public void addPet(IPetModel pet) {
        shelter.addPet(pet);
    }

    public boolean adoptPet(int id) {
        return shelter.adoptPet(id);
    }

    public boolean removePet(int id) {
        List<IPetModel> all = shelter.getAllPets();
        for (IPetModel pet : all) {
            if (pet.getId() == id) {
                return shelter.removePet(id, pet);
            }
        }
        return false;
    }

    public void sortByName() {
        shelter.nameSort();
    }

    public void sortByAge() {
        shelter.ageSort(new PetAgeComparator());
    }

    public void sortBySpecies() {
        shelter.speciesSort(new PetSpeciesComparator());
    }

    public void savePets() {
        PetJsonSaver.savePetsToFile(shelter.getAllPets());
    }
}
