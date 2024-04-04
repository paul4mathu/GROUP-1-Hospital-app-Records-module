import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("deprecation")
public class PatientApplet extends JApplet implements ActionListener {
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField diagnosisField;
    private JTextArea displayArea;
    private JButton addButton;

    @Override
    public void init() {
        
        JLabel idLabel = new JLabel("ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel diagnosisLabel = new JLabel("Diagnosis:");
        idField = new JTextField(10);
        nameField = new JTextField(20);
        ageField = new JTextField(5);
        diagnosisField = new JTextField(20);
        addButton = new JButton("Add Patient");
        displayArea = new JTextArea(10, 40);

        // listner
        addButton.addActionListener(this);

        // Set layout
        setLayout(new FlowLayout());

        //component
        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(diagnosisLabel);
        add(diagnosisField);
        add(addButton);
        add(new JScrollPane(displayArea));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //buton click
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String diagnosis = diagnosisField.getText();

        Patient patient = new Patient(id, name, age, diagnosis);
        displayPatientInfo(patient);
    }

    // Display patient info
    private void displayPatientInfo(Patient patient) {
        String info = "Patient ID: " + patient.getId() + "\n" +
                      "Name: " + patient.getName() + "\n" +
                      "Age: " + patient.getAge() + "\n" +
                      "Diagnosis: " + patient.getDiagnosis() + "\n\n";

        displayArea.append(info);
    }
}

