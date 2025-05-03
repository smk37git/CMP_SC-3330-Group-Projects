package adoptme.view;

import adoptme.model.*;
import adoptme.util.*;
import adoptme.comparators.*;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class PetView extends JFrame {
	
	private JTextArea petDisplay;
    private JButton saveButton;
    private JComboBox<String> sortComboBox;
    private JButton adoptButton;

    private List<IPetModel> pets; // store reference so we can sort it

    public PetView(List<IPetModel> pets) {
        this.pets = pets;

        setTitle("Adopt Me! - Pet Shelter");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Text area
        petDisplay = new JTextArea(15, 50);
        petDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(petDisplay);

        // Save button
        saveButton = new JButton("Save Pets");
        saveButton.addActionListener(e -> PetJsonSaver.savePetsToFile(pets));

        // Sort drop-down
        String[] sortOptions = {"Sort by Name", "Sort by Age", "Sort by Species"};
        sortComboBox = new JComboBox<>(sortOptions);
        sortComboBox.addActionListener(e -> {
            String choice = (String) sortComboBox.getSelectedItem();
            switch (choice) {
                case "Sort by Name":
                    Collections.sort(pets); // uses Comparable
                    break;
                case "Sort by Age":
                    Collections.sort(pets, new PetAgeComparator());
                    break;
                case "Sort by Species":
                    Collections.sort(pets, new PetSpeciesComparator());
                    break;
            }
            displayPets(pets);
        });
        
        adoptButton = new JButton("Adopt Pet");
        adoptButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter Pet ID to adopt:");
            if (input != null) {
                try {
                    int id = Integer.parseInt(input.trim());
                    boolean found = false;

                    for (IPetModel pet : pets) {
                        if (pet.getId() == id) {
                            found = true;
                            if (!pet.isAdopted()) {
                                pet.setAdopted(true);
                                JOptionPane.showMessageDialog(this, pet.getName() + " has been adopted!");
                            } else {
                                JOptionPane.showMessageDialog(this, pet.getName() + " is already adopted!");
                            }
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(this, "No pet found with ID " + id);
                    }

                    displayPets(pets);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid ID format.");
                }
            }
        });


        // Layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(sortComboBox);
        buttonPanel.add(adoptButton);
        buttonPanel.add(saveButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);


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
