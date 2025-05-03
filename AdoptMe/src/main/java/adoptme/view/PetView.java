package adoptme.view;

import adoptme.model.IPetModel;
import adoptme.util.PetJsonSaver;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PetView extends JFrame {
	
	private JTextArea petDisplay;
    private JButton saveButton;

    public PetView(List<IPetModel> pets) {
        setTitle("Adopt Me! - Pet Shelter");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Text area to display pets
        petDisplay = new JTextArea(15, 50);
        petDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(petDisplay);

        // Save button
        saveButton = new JButton("Save Pets");
        saveButton.addActionListener(e -> {
            PetJsonSaver.savePetsToFile(pets);
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);

        displayPets(pets);
    }

    public void displayPets(List<IPetModel> pets) {
        StringBuilder builder = new StringBuilder();
        for (IPetModel pet : pets) {
            builder.append(pet.toString()).append("\n");
        }
        petDisplay.setText(builder.toString());
    }
}
