package adoptme.view;

import adoptme.model.*;
import adoptme.controller.*;
import adoptme.util.*;
import adoptme.comparators.*;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class PetView extends JFrame {
	
	private PetController controller;
	private JTextArea petDisplay;
    private JButton saveButton;
    private JComboBox<String> sortComboBox;
    private JButton adoptButton;
    private JButton addButton;
    private JButton removeButton;

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
            displayPets(controller.getPets());
        });
        
        adoptButton = new JButton("Adopt Pet");
        adoptButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter Pet ID to adopt:");
            if (input != null) {
                try {
                    int id = Integer.parseInt(input.trim());
                    boolean adopted = controller.adoptPet(id);
                    if (adopted) {
                        JOptionPane.showMessageDialog(this, "Pet has been adopted!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Pet not found or already adopted");
                    }

                    displayPets(controller.getPets());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid ID format.");
                }
            }
        });
        
        addButton = new JButton("Add Pet");
        addButton.addActionListener(e -> {
            JTextField nameField = new JTextField();
            JTextField speciesField = new JTextField();
            JTextField ageField = new JTextField();
            String[] petTypes = {"Dog", "Cat", "Rabbit"};
            JComboBox<String> typeComboBox = new JComboBox<>(petTypes);

            JPanel form = new JPanel(new GridLayout(0, 1));
            form.add(new JLabel("Type:"));
            form.add(typeComboBox);
            form.add(new JLabel("Name:"));
            form.add(nameField);
            form.add(new JLabel("Species:"));
            form.add(speciesField);
            form.add(new JLabel("Age:"));
            form.add(ageField);

            int result = JOptionPane.showConfirmDialog(this, form, "Add New Pet",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                try {
                    String type = (String) typeComboBox.getSelectedItem();
                    String name = nameField.getText().trim();
                    String species = speciesField.getText().trim();
                    int age = Integer.parseInt(ageField.getText().trim());

                    IPetModel pet = null;
                    switch (type) {
                        case "Dog":
                            pet = new DogModel();
                            break;
                        case "Cat":
                            pet = new CatModel();
                            break;
                        case "Rabbit":
                            pet = new RabbitModel();
                            break;
                    }

                    if (pet != null) {
                        int newId = pets.stream().mapToInt(IPetModel::getId).max().orElse(0) + 1;
                        pet.setId(newId);
                        pet.setName(name);
                        pet.setType(type);
                        pet.setSpecies(species);
                        pet.setAge(age);
                        pet.setAdopted(false);
                        controller.addPet(pet);
                        displayPets(controller.getPets());
                        JOptionPane.showMessageDialog(this, type + " added successfully!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid age.");
                }
            }
        });
        
        
        removeButton = new JButton("Remove Pet");
        removeButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter Pet ID to remove:");
            if (input != null) {
                try {
                    int id = Integer.parseInt(input);
                    boolean removed = controller.removePet(id);

                    if (removed) {
                        JOptionPane.showMessageDialog(this, "Pet with ID " + id + " removed.");
                    } else {
                        JOptionPane.showMessageDialog(this, "No pet found with ID " + id);
                    }

                    displayPets(controller.getPets());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid ID format.");
                }
            }
        });



        
        /**
         * This puts the buttons onto the window for the user to click
         */
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(sortComboBox);
        buttonPanel.add(adoptButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(addButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);


        add(panel);
        setVisible(true);

        displayPets(controller.getPets());
    }

    public void displayPets(List<IPetModel> pets) {
        StringBuilder builder = new StringBuilder();
        for (IPetModel pet : pets) {
            builder.append(pet.toString()).append("\n");
        }
        petDisplay.setText(builder.toString());
    }
    
    public PetView(PetController controller) {
    	this.controller = controller;
    	this.pets = controller.getPets();
    }
}
