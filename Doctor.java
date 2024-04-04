public class Doctor {
    // Instance variables
    private String name;
    private String specialization;

    // Constructor
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
