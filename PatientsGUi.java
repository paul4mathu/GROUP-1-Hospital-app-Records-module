import javax.swing.*;
import java.util.ArrayList;

public class PatientsGUi extends JFrame {
    private ArrayList<Patient> patientList = new ArrayList<>();

    public PatientsGUi() {
        // Initialize components
        JButton addPatient = new JButton("Enter Patient's Details");
        JButton editPatient = new JButton("Edit Patient's Details");
        JButton displayPatient = new JButton("Display Patient's Details");
        JButton deletePatient = new JButton("Delete Patient's Details");
        JButton backButton = new JButton("Back to Main Menu");

        // Action listener for the back button to return to the main screen
        backButton.addActionListener(e -> {
            Main mainMenu = new Main();
            mainMenu.setVisible(true);
            dispose(); // Close the patient details screen
        });

        // Action listener for adding a patient
        addPatient.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient's ID:"));
            String name = JOptionPane.showInputDialog("Enter Patient's Name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient's Age:"));
            String diagnosis = JOptionPane.showInputDialog("Enter Patient's Diagnosis:");

            Patient newPatient = new Patient(id, name, age, diagnosis);
            patientList.add(newPatient);

            JOptionPane.showMessageDialog(null, "Patient's details added successfully!");
        });

        // Action listener for the editPatient button to edit patient's details
        editPatient.addActionListener(e -> {
            int idToEdit = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient's ID to Edit:"));
            for (Patient patient : patientList) {
                if (patient.getId() == idToEdit) {
                    String newName = JOptionPane.showInputDialog("Enter New Name:");
                    int newAge = Integer.parseInt(JOptionPane.showInputDialog("Enter New Age:"));
                    String newDiagnosis = JOptionPane.showInputDialog("Enter New Diagnosis:");
                    patient.setName(newName);
                    patient.setAge(newAge);
                    patient.setDiagnosis(newDiagnosis);
                    JOptionPane.showMessageDialog(null, "Patient's details updated successfully!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Patient's ID not found!");
        });

        // Action listener for the displayPatient button to display all patient's details
        displayPatient.addActionListener(e -> {
            StringBuilder allPatients = new StringBuilder();
            for (Patient patient : patientList) {
                allPatients.append("ID: ").append(patient.getId()).append(", Name: ").append(patient.getName())
                        .append(", Age: ").append(patient.getAge()).append(", Diagnosis: ").append(patient.getDiagnosis()).append("\n");
            }
            if (allPatients.length() > 0) {
                JOptionPane.showMessageDialog(null, allPatients.toString(), "Patient's Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No patient's details available.");
            }
        });

        // Action listener for the deletePatient button to delete patient's details
        deletePatient.addActionListener(e -> {
            int idToDelete = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient's ID to Delete:"));
            boolean removed = patientList.removeIf(patient -> patient.getId() == idToDelete);
            if (removed) {
                JOptionPane.showMessageDialog(null, "Patient's details deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Patient's ID not found!");
            }
        });

        JPanel panel = new JPanel();
        panel.add(addPatient);
        panel.add(editPatient);
        panel.add(displayPatient);
        panel.add(deletePatient);
        panel.add(backButton);

        // Set frame properties
        setTitle("Patient Details");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Add panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PatientsGUi patients = new PatientsGUi();
            patients.setVisible(true);
        });
    }
}
