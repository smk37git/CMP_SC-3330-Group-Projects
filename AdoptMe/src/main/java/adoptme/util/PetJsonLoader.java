package adoptme.util;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import adoptme.model.*;

public class PetJsonLoader {
	public static List<IPetModel> loadPetsFromJson() {
        List<IPetModel> allPets = new ArrayList<>();

        try (Reader reader = new InputStreamReader(
                PetJsonLoader.class.getResourceAsStream("/pets.json"))) {

            Gson gson = new Gson();
            List<BasicPet> pets = gson.fromJson(reader, new TypeToken<List<BasicPet>>() {}.getType());

            for (BasicPet pet : pets) {
                IPetModel model;

                switch (pet.getType()) {
                    case "Dog":
                        model = new DogModel();
                        break;
                    case "Cat":
                        model = new CatModel();
                        break;
                    case "Rabbit":
                        model = new RabbitModel();
                        break;
                    default:
                        continue; // skip unknown types
                }
                
                model.setId(pet.getId());
                model.setName(pet.getName());
                model.setType(pet.getType());
                model.setSpecies(pet.getSpecies());
                model.setAge(pet.getAge());
                model.setAdopted(pet.isAdopted());

                allPets.add(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return allPets;
    }
	
	public static List<IPetModel> loadExoticsFromJson() {
        List<IPetModel> exoticPets = new ArrayList<>();

        try (Reader reader = new InputStreamReader(
                PetJsonLoader.class.getResourceAsStream("/exotic_animals.json"))) {

            Gson gson = new Gson();
            List<ExoticAnimalModel> exotics = gson.fromJson(reader, new TypeToken<List<ExoticAnimalModel>>() {}.getType());

            for (ExoticAnimalModel animal : exotics) {
                ExoticPetAdapter adapter = new ExoticPetAdapter();
                adapter.setId(Integer.parseInt(animal.getUniqueId().substring(5)));
                adapter.setName(animal.getAnimalName());
                adapter.setType(animal.getCategory());
                adapter.setSpecies(animal.getSubSpecies());
                adapter.setAge(animal.getYearsOld());
                adapter.setAdopted(false); // assume not adopted

                exoticPets.add(adapter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exoticPets;
    }
}
