import javax.swing.*;
import java.util.ArrayList;

public class DoctorsGUI   extends JFrame {
    private ArrayList<Doctor> doctorList = new ArrayList<>();

    public DoctorsGUI() {
        // Initialize components
        JButton addDoctor = new JButton("Enter Doctor's Details");
        JButton editDoctor = new JButton("Edit Doctor's Details");
        JButton displayDoctor = new JButton("Display Doctor's Details");
        JButton deleteDoctor = new JButton("Delete Doctor's Details");
        JButton backButton = new JButton("Back to Main Menu");

        // Action listener for the back button to return to the main screen
        backButton.addActionListener(e -> {
            Main mainMenu = new Main();
            mainMenu.setVisible(true);
            dispose(); // Close the doctor's details screen
        });

        // Action listener for adding a doctor
        addDoctor.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Doctor's Name:");
            String specialization = JOptionPane.showInputDialog("Enter Doctor's Specialization:");

            Doctor newDoctor = new Doctor(name, specialization);
            doctorList.add(newDoctor);

            JOptionPane.showMessageDialog(null, "Doctor's details added successfully!");
        });

        // Action listener for the editDoctor button to edit doctor's details
        editDoctor.addActionListener(e -> {
            String nameToEdit = JOptionPane.showInputDialog("Enter Doctor's Name to Edit:");
            for (Doctor doctor : doctorList) {
                if (doctor.getName().equalsIgnoreCase(nameToEdit)) {
                    String newName = JOptionPane.showInputDialog("Enter New Name:");
                    String newSpecialization = JOptionPane.showInputDialog("Enter New Specialization:");
                    doctor.setName(newName);
                    doctor.setSpecialization(newSpecialization);
                    JOptionPane.showMessageDialog(null, "Doctor's details updated successfully!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Doctor's Name not found!");
        });

        // Action listener for the displayDoctor button to display all doctor's details
        displayDoctor.addActionListener(e -> {
            StringBuilder allDoctors = new StringBuilder();
            for (Doctor doctor : doctorList) {
                allDoctors.append("Name: ").append(doctor.getName())
                        .append(", Specialization: ").append(doctor.getSpecialization()).append("\n");
            }
            if (allDoctors.length() > 0) {
                JOptionPane.showMessageDialog(null, allDoctors.toString(), "Doctor's Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No doctor's details available.");
            }
        });

        // Action listener for the deleteDoctor button to delete doctor's details
        deleteDoctor.addActionListener(e -> {
            String nameToDelete = JOptionPane.showInputDialog("Enter Doctor's Name to Delete:");
            boolean removed = doctorList.removeIf(doctor -> doctor.getName().equalsIgnoreCase(nameToDelete));
            if (removed) {
                JOptionPane.showMessageDialog(null, "Doctor's details deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Doctor's Name not found!");
            }
        });

        JPanel panel = new JPanel();
        panel.add(addDoctor);
        panel.add(editDoctor);
        panel.add(displayDoctor);
        panel.add(deleteDoctor);
        panel.add(backButton);

        // Set frame properties
        setTitle("Doctor Details");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Add panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DoctorsGUI doctors = new DoctorsGUI();
            doctors.setVisible(true);
        });
    }
}
