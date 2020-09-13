package businessLogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ticket implements Serializable {

    private FullName fullName;
    private String visitingReason;
    private ArrayList<String> doctors;
    private Calendar visitingDate;

    public Ticket() {
        fullName = new FullName();
        visitingReason = "";
        doctors = new ArrayList<>();
        visitingDate = new GregorianCalendar();
    }

    public Ticket(FullName fullName, String visitingReason, ArrayList<String> doctors, GregorianCalendar visitingDate) {
        this.fullName = fullName;
        this.visitingReason = visitingReason;
        this.doctors = doctors;
        this.visitingDate = visitingDate;
    }

    public Ticket(Ticket ticket) {
        fullName = ticket.fullName;
        visitingReason = ticket.visitingReason;
        doctors = ticket.doctors;
        visitingDate = ticket.visitingDate;
    }

    public FullName getFullName() {
        return fullName;
    }

    public String getVisitingReason() {
        return visitingReason;
    }

    public ArrayList<String> getDoctors() {
        return doctors;
    }

    public Calendar getVisitingDate() {
        return visitingDate;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public void setVisitingReason(String visitingReason) {
        this.visitingReason = visitingReason;
    }

    public void setDoctors(ArrayList<String> doctors) {
        this.doctors = doctors;
    }

    public void setVisitingDate(Calendar visitingDate) {
        this.visitingDate = visitingDate;
    }

    @Override
    public String toString() {
        String result =  "Name: " + fullName + "\nVisiting reason: " + visitingReason + "\nDoctors: ";
        StringBuilder doctorsString = new StringBuilder();
        for (String doctor: doctors) {
            doctorsString.append(doctor).append(", ");
        }
        doctorsString.deleteCharAt(doctorsString.length() - 1);
        doctorsString.deleteCharAt(doctorsString.length() - 1);
        result += doctorsString.toString();
        result += "\nVisiting date: " + visitingDate.getTime();
        return result;
    }
}
