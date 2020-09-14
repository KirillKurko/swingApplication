package application;

import application.verifiers.NameVerifier;
import pojo.FullName;
import pojo.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Frame extends JFrame  {

    private final String[] doctors = {"General doctor", "Neurologist", "Ophthalmologist", "Pediatrician", "Doctor therapist", "Doctor surgeon"};

    private JLabel nameLabel;
    private JTextField nameTextField;

    private  JLabel visitingReasonLabel;
    private JTextArea visitingReasonTextArea;

    private JLabel dayLabel;
    private JTextField dayTextField;

    private JLabel monthLabel;
    private JTextField monthTextField;

    private JLabel yearLabel;
    private JTextField yearTextField;

    private JLabel timeLabel;
    private JComboBox<String> timeComboBox;
    private DefaultComboBoxModel<String> timeComboBoxModel;

    private JLabel doctorsLabel;
    private JList<String> doctorsList;
    private DefaultListModel<String> doctorsListModel;

    private JButton confirmButton;


    Frame() {
        super("Order ticket");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 650);
        setLayout(null);

        nameLabel = new JLabel("Name: ");
        nameLabel.setSize(100, 25);
        nameLabel.setLocation(100, 25);

        nameTextField = new JTextField(30);
        nameTextField.setSize(250, 25);
        nameTextField.setLocation(150, 25);

        visitingReasonLabel = new JLabel("Visiting reason:");
        visitingReasonLabel.setSize(100, 25);
        visitingReasonLabel.setLocation(100, 75);

        visitingReasonTextArea = new JTextArea(30, 5);
        visitingReasonTextArea.setSize(175, 125);
        visitingReasonTextArea.setLocation(220, 75);
        visitingReasonTextArea.setLineWrap(true);
        visitingReasonTextArea.setWrapStyleWord(true);

        dayLabel = new JLabel("Day: ");
        dayLabel.setSize(200, 25);
        dayLabel.setLocation(100, 225);

        dayTextField = new JTextField(30);
        dayTextField.setSize(250, 25);
        dayTextField.setLocation(150, 225);

        monthLabel = new JLabel("Month: ");
        monthLabel.setSize(200, 25);
        monthLabel.setLocation(100, 250);

        monthTextField = new JTextField(30);
        monthTextField.setSize(250, 25);
        monthTextField.setLocation(150, 250);

        yearLabel = new JLabel("Year: ");
        yearLabel.setSize(200, 25);
        yearLabel.setLocation(100, 275);

        yearTextField = new JTextField(30);
        yearTextField.setSize(250, 25);
        yearTextField.setLocation(150, 275);

        timeLabel = new JLabel("Time: ");
        timeLabel.setSize(200, 25);
        timeLabel.setLocation(100, 325);

        timeComboBoxModel = new DefaultComboBoxModel<>();
        for (int i = 10; i < 20; ++i) {
            timeComboBoxModel.addElement(i + ":00");
        }
        timeComboBox = new JComboBox<>(timeComboBoxModel);
        timeComboBox.setSize(250, 25);
        timeComboBox.setLocation(150, 325);

        doctorsLabel = new JLabel("Doctors: ");
        doctorsLabel.setSize(200, 25);
        doctorsLabel.setLocation(100, 375);

        doctorsListModel = new DefaultListModel<>();
        for (int i = 0; i < doctors.length; ++i) {
            doctorsListModel.add(i, doctors[i]);
        }
        doctorsList = new JList<>(doctorsListModel);
        doctorsList.setSize(240, 125);
        doctorsList.setLocation(160, 375);
        doctorsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        confirmButton = new JButton("Confirm");
        confirmButton.setSize(200, 50);
        confirmButton.setLocation(150, 550);

        nameTextField.setInputVerifier(new NameVerifier(confirmButton));

        add(nameLabel);
        add(nameTextField);

        add(visitingReasonLabel);
        add(visitingReasonTextArea);

        add(dayLabel);
        add(dayTextField);

        add(monthLabel);
        add(monthTextField);

        add(yearLabel);
        add(yearTextField);

        add(timeLabel);
        add(timeComboBox);

        add(doctorsLabel);
        add(doctorsList);

        add(confirmButton);

        confirmButton.addActionListener(new ButtonActionListener());
    }

    public class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Ticket ticket = createTicket();
            saveTicket(ticket);
            reset();
        }

        private Ticket createTicket() {
            Ticket ticket = new Ticket();
            ticket.setFullName(createFullName());
            ticket.setVisitingReason(visitingReasonTextArea.getText());
            ticket.setDoctors(new ArrayList<>(doctorsList.getSelectedValuesList()));
            ticket.setVisitingDate(createVisitingDate());
            return ticket;
        }

        private FullName createFullName() {
            String fullNameStringRepresentation = nameTextField.getText();
            String[] fullNameParts = fullNameStringRepresentation.split(" ");
            return new FullName(fullNameParts[0], fullNameParts[1], fullNameParts[2]);
        }

        private Calendar createVisitingDate() {
            Calendar visitingDate = new GregorianCalendar();
            visitingDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(monthTextField.getText()));
            visitingDate.set(Calendar.MONTH, Integer.parseInt(monthTextField.getText()) - 1);
            visitingDate.set(Calendar.YEAR, Integer.parseInt(yearTextField.getText()));
            visitingDate.set(Calendar.HOUR_OF_DAY, timeComboBox.getSelectedIndex() + 10);
            visitingDate.set(Calendar.MINUTE, 0);
            visitingDate.set(Calendar.SECOND, 0);
            return visitingDate;
        }

        private void saveTicket(Ticket ticket)  {
            try {
                Writer writer = new FileWriter("tickets.txt", true);
                writer.write("\n\n" + ticket.toString());
                writer.close();
            }
            catch (IOException exception) {
                System.err.println(exception.getMessage());
            }
        }

        private void reset() {
            nameTextField.setText("");
            visitingReasonTextArea.setText("");
            dayTextField.setText("");
            monthTextField.setText("");
            yearTextField.setText("");
            timeComboBox.setSelectedIndex(0);
            doctorsList.clearSelection();
        }
    }
}

