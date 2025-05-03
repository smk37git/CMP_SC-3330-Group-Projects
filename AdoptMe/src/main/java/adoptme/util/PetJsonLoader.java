package adoptme.util;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import adoptme.model.*;

public class PetJsonLoader {
	public static List<IPetModel> loadPetsFromJson() {
        List<IPetModel> allPets = new ArrayList<>();

        try (Reader reader = new InputStreamReader(
                PetJsonLoader.class.getResourceAsStream("/resources/pets.json"))) {

            Gson gson = new Gson();
            List<Map<String, Object>> rawPets = gson.fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());

            for (Map<String, Object> petData : rawPets) {
                String type = (String) petData.get("type");
                IPetModel model = null;

                switch (type) {
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
                        continue; // Skip unknown types
                }

                model.setId(((Double) petData.get("id")).intValue());
                model.setName((String) petData.get("name"));
                model.setType(type);
                model.setSpecies((String) petData.get("species"));
                model.setAge(((Double) petData.get("age")).intValue());
                model.setAdopted((Boolean) petData.get("adopted"));

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
                PetJsonLoader.class.getResourceAsStream("/resources/exotic_animals.json"))) {

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
