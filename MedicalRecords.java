import javax.swing.*;

public class MedicalRecords extends JFrame {
    private StringBuilder medicalRecords = new StringBuilder();

    public MedicalRecords() {
        // Initialize components
        JButton searchPatient = new JButton("Search Patient's Diagnosis");
        JButton displayPatients = new JButton("Display All Patients");
        JButton backButton = new JButton("Back to Main Menu");

        // Action listener for the back button to return to the main menu
        backButton.addActionListener(e -> {
            Main mainMenu = new Main();
            mainMenu.setVisible(true);
            dispose(); // Close the medical records screen
        });

        // Action listener for searching patient's diagnosis
        searchPatient.addActionListener(e -> {
            // Prompt the user to enter the patient's name to search for
            String patientName = JOptionPane.showInputDialog("Enter Patient's Name to Search:");

            // Search for the patient's diagnosis in the medical records
            String diagnosis = searchDiagnosis(patientName);

            // Display the diagnosis in a message dialog
            if (diagnosis != null) {
                JOptionPane.showMessageDialog(null, "Diagnosis for " + patientName + ":\n" + diagnosis);
            } else {
                JOptionPane.showMessageDialog(null, "Patient " + patientName + " not found in medical records.");
            }
        });

        // Action listener for displaying all patients' details
        displayPatients.addActionListener(e -> {
            // Display all patients' details in a message dialog
            if (medicalRecords.length() == 0) {
                JOptionPane.showMessageDialog(null, "No patients' details available.");
            } else {
                JOptionPane.showMessageDialog(null, "All Patients' Details:\n" + medicalRecords.toString());
            }
        });

        JPanel panel = new JPanel();
        panel.add(searchPatient);
        panel.add(displayPatients);
        panel.add(backButton);

        // Set frame properties
        setTitle("Medical Records");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Add panel to the frame
        add(panel);
    }

    // Method to search for patient's diagnosis
    private String searchDiagnosis(String patientName) {
        // Iterate over medical records to find the diagnosis for the given patient name
        String medicalRecord = medicalRecords.toString();
        String[] records = medicalRecord.split("\n");
        for (String record : records) {
            if (record.contains(patientName)) {
                // Extract diagnosis from the record
                String[] parts = record.split(", ");
                for (String part : parts) {
                    if (part.startsWith("Diagnosis:")) {
                        return part.substring(11); // Extract diagnosis value
                    }
                }
            }
        }
        return null; // Patient not found or diagnosis not available
    }

    // Method to add new medical record
    public void addMedicalRecord(String patientName, String diagnosis) {
        // Append patient's name and diagnosis to the medical records
        medicalRecords.append("Patient: ").append(patientName).append(", Diagnosis: ").append(diagnosis).append("\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MedicalRecords medicalRecordsScreen = new MedicalRecords();
            medicalRecordsScreen.setVisible(true);
        });
    }
}
