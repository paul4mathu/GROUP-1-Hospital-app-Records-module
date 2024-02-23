import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Person {
    private String name;
    private int id;

   
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    
    public int getId() {
        return id;
    }

   
    public abstract String getRole();
}

//class for patients
class Patient extends Person {
    private String diagnosis;

    
    public Patient(String name, int id, String diagnosis) {
        super(name, id);
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    
    public void displayPatientDetails() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Diagnosis: " + getDiagnosis());
    }
}

// class for doctor
class Doctor extends Person {
    private String specialty;

    
    public Doctor(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    
    public String getSpecialty() {
        return specialty;
    }

    
    @Override
    public String getRole() {
        return "Doctor";
    }

   
    public void displayDoctorDetails() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Specialty: " + getSpecialty());
    }
}


public class RecordsModule {
    private List<Person> people;
    // key is id
    private Map<Integer, Patient> patientRecords;

    public RecordsModule() {
        people = new ArrayList<>();
        patientRecords = new HashMap<>();
    }

    public void addPerson(Person person) {
        people.add(person);

        if (person instanceof Patient) {
            patientRecords.put(person.getId(), (Patient) person);
        }
    }

    public Patient getPatientRecord(int id) {
        return patientRecords.get(id);
    }

    
    public void displayAllPatientDetails() {
        for (Person person : people) {
            if (person instanceof Patient) {
                ((Patient) person).displayPatientDetails();
            }
        }
    }

    
    public void displayAllDoctorDetails() {
        for (Person person : people) {
            if (person instanceof Doctor) {
                ((Doctor) person).displayDoctorDetails();
            }
        }
    }
    
    public static void main(String[] args) {
    RecordsModule recordsModule = new RecordsModule();

    Patient patient1 = new Patient("Jonathan kii", 001, "Malaria");
    Doctor doctor1 = new Doctor("Omondi Abel", 230, "pedetrician");

    recordsModule.addPerson(patient1);
    recordsModule.addPerson(doctor1);

    System.out.println("Patient record: " + recordsModule.getPatientRecord(1).getDiagnosis());

    System.out.println("\nPatient Details:");
    recordsModule.displayAllPatientDetails();

    System.out.println("\nDoctor Details:");
    recordsModule.displayAllDoctorDetails();
}
}