package pojo;

public class FullName {

    private String surname;
    private String name;
    private String fatherland;

    public FullName() {
        surname = "";
        name = "";
        fatherland = "";
    }

    public FullName(String surname, String name, String fatherland) {
        this.surname = surname;
        this.name = name;
        this.fatherland = fatherland;
    }

    public FullName(FullName fullName) {
        surname = fullName.surname;
        name = fullName.name;
        fatherland = fullName.fatherland;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getFatherland() {
        return fatherland;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherland(String fatherland) {
        this.fatherland = fatherland;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + fatherland;
    }
}
