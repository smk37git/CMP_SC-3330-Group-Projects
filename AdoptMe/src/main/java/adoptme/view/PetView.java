package adoptme.view;

import adoptme.model.*;
import adoptme.controller.*;
import adoptme.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * The pet view class extends JFrame to use the variety of display
 * functions in its database
 */
public class PetView extends JFrame {
	
	private PetController controller;
	private JTextArea petDisplay;
    private JButton saveButton;
    private JComboBox<String> sortComboBox;
    private JButton adoptButton;
    private JButton addButton;
    private JButton removeButton;

    private List<IPetModel> pets; // store reference so we can sort it

    public PetView(PetController controller) {
    	this.controller = controller;
    	this.pets = controller.getPets();

    	/**
    	 * Creates the window and makes the code end when the window
    	 * closes
    	 */
        setTitle("Adopt Me! - Pet Shelter");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // displays all of the pets in the shelter through JFrame functions
        petDisplay = new JTextArea(15, 50);
        petDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(petDisplay);

        // makes the save button
        saveButton = new JButton("Save Pets");
        saveButton.addActionListener(e -> PetJsonSaver.savePetsToFile(pets));

        /**
         * Makes a drop-down menu for sorting options
         * User can choose which option they want and it calls the
         * corresponding function through the controller
         */
        String[] sortOptions = {"Sort by Name", "Sort by Age", "Sort by Species"};
        sortComboBox = new JComboBox<>(sortOptions);
        sortComboBox.addActionListener(e -> {
            String choice = (String) sortComboBox.getSelectedItem();
            switch (choice) {
                case "Sort by Name":
                    controller.sortByName(); // uses Comparable
                    break;
                case "Sort by Age":
                    controller.sortByAge();
                    break;
                case "Sort by Species":
                    controller.sortBySpecies();
                    break;
            }
            displayPets(controller.getPets());
        });
        
        /**
         * Adopt function makes a button with "Adopt Pet" on it. When the
         * user clicks it, they are prompted and asked for an ID of the pet
         * they would wish to adopt. It then reads that input and adopts the
         * pet or returns and error to the user.
         */
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
        
        /**
         * makes and add pet button that prompts the user for the details
         * of the pet they want to add. The function is long because of all
         * the details but is actually pretty simple.
         */
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
        
        /**
         * Adopt function makes a button with "Remove Pet" on it. When the
         * user clicks it, they are prompted and asked for an ID of the pet
         * they would wish to remove. It then reads that input and removes the
         * pet or returns and error to the user.
         */
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
         * This makes a panel at the bottom of the window and
         * puts the buttons into the panel for nice formatting.
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

    //This functions displays all of the pets in the shelter
    public void displayPets(List<IPetModel> pets) {
        StringBuilder builder = new StringBuilder();
        for (IPetModel pet : pets) {
            builder.append(pet.toString()).append("\n");
        }
        petDisplay.setText(builder.toString());
    }
}
