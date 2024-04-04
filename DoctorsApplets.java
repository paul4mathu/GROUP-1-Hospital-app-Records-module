import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("deprecation")
public class DoctorsApplets extends JApplet implements ActionListener {

    
    private JTextField nameField;
    private JTextField specializationField;
    private JTextArea displayArea;
    private JButton addButton;

    
    private Doctor doctor;

    @Override
    public void init() {
        // Initialize components
        JLabel nameLabel = new JLabel("Name:");
        JLabel specializationLabel = new JLabel("Specialization:");
        nameField = new JTextField(20);
        specializationField = new JTextField(20);
        displayArea = new JTextArea(10, 30);
        addButton = new JButton("Add Doctor");

        //  listner 
        addButton.addActionListener(this);

        // Add components to the applet
        add(nameLabel);
        add(nameField);
        add(specializationLabel);
        add(specializationField);
        add(addButton);
        add(new JScrollPane(displayArea));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // button click doctor obj
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String specialization = specializationField.getText();

            doctor = new Doctor(name, specialization);
            displayDoctorInfo();
        }
    }

    // Display doctor info
    private void displayDoctorInfo() {
        String info = "Doctor Name: " + doctor.getName() + "\n" +
                      "Specialization: " + doctor.getSpecialization() + "\n\n";

        displayArea.append(info);
    }
}
