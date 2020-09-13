package businessLogic;

public enum Doctor {
    GENERAL_DOCTOR("General doctor"),
    NEUROLOGIST("Neurologist"),
    OPHTHALMOLOGIST("Ophthalmologist"),
    PEDIATRICIAN("Pediatrician"),
    DOCTOR_THERAPIST("Doctor therapist"),
    DOCTOR_SURGEON("Doctor surgeon");

    String type;

    Doctor(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
