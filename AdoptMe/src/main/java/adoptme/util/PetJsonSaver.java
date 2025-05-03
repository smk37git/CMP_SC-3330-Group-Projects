package adoptme.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import adoptme.model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PetJsonSaver {

    public static void savePetsToFile(List<IPetModel> pets) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = timestamp + "_pets.json";

        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(pets, writer);
            System.out.println("Pets saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
