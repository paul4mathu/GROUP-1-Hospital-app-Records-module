import javax.swing.*;


public class Main extends JFrame {

    public Main() {
        // Initialize components
        JButton viewPatientsButton = new JButton("patients details");
        
        //add doctors  button
        JButton doctorsDetailsButton = new JButton( "doctors details");

        //add medicalRecords Button
        JButton medicalRecordButton = new JButton("medical records");
    
        // Add action listener for the button to switch to the patient details screen
        viewPatientsButton.addActionListener(e -> {
            PatientsGUi  patientDetailsScreen = new PatientsGUi();
            patientDetailsScreen.setVisible(true);
            dispose(); // Close the main menu screen
        });

        // Add action listener for the button to switch to the doctors details screen
        doctorsDetailsButton.addActionListener(e -> {
            DoctorsGUI  DoctorsDetailsScreen = new DoctorsGUI();
            DoctorsDetailsScreen.setVisible(true);
            dispose(); // Close the main menu screen
        });

        //add action listener for button to switch to medical records screen

        medicalRecordButton.addActionListener(e -> {
            MedicalRecords medicalRecordsScreen = new MedicalRecords();
            medicalRecordsScreen.setVisible(true);
            dispose();
        });

        

        

        // Add components to the main menu screen
        JPanel panel = new JPanel();
        panel.add(viewPatientsButton);
        panel.add(doctorsDetailsButton);
        panel.add(medicalRecordButton);
        add(panel);

        // Set frame properties
        setTitle("Main Menu");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
    }

     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainMenu = new Main();
            mainMenu.setVisible(true);
        });
    }
}