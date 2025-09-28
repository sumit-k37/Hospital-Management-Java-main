package HMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HospitalManagementUI extends JFrame implements ActionListener {
    // Declare Swing components
    private JButton addDoctorBtn, addPatientBtn, addMedicineBtn, addLabBtn, addFacilityBtn, addStaffBtn, exitBtn;
    private JButton showDoctorsBtn, showPatientsBtn, showMedicinesBtn, showLaboratoriesBtn, showFacilitiesBtn, showStaffBtn;
    private JTextArea outputArea;
    private JScrollPane scrollPane;

    // Variables to store data
    private Doctor[] doctors = new Doctor[25];
    private Patient[] patients = new Patient[100];
    private Medical[] medicines = new Medical[100];
    private Lab[] laboratories = new Lab[20];
    private Facility[] facilities = new Facility[20];
    private Staff[] staffs = new Staff[100];
    private int doctorCount = 0, patientCount = 0, medicineCount = 0, labCount = 0, facilityCount = 0, staffCount = 0;

    public HospitalManagementUI() {
        // Initialize Swing components
        addDoctorBtn = new JButton("Add Doctor");
        addPatientBtn = new JButton("Add Patient");
        addMedicineBtn = new JButton("Add Medicine");
        addLabBtn = new JButton("Add Laboratory");
        addFacilityBtn = new JButton("Add Facility");
        addStaffBtn = new JButton("Add Staff");
        exitBtn = new JButton("Exit");

        showDoctorsBtn = new JButton("Show Doctors");
        showPatientsBtn = new JButton("Show Patients");
        showMedicinesBtn = new JButton("Show Medicines");
        showLaboratoriesBtn = new JButton("Show Laboratories");
        showFacilitiesBtn = new JButton("Show Facilities");
        showStaffBtn = new JButton("Show Staff");

        // Set button action commands
        addDoctorBtn.setActionCommand("AddDoctor");
        addPatientBtn.setActionCommand("AddPatient");
        addMedicineBtn.setActionCommand("AddMedicine");
        addLabBtn.setActionCommand("AddLaboratory");
        addFacilityBtn.setActionCommand("AddFacility");
        addStaffBtn.setActionCommand("AddStaff");
        exitBtn.setActionCommand("Exit");

        showDoctorsBtn.setActionCommand("ShowDoctors");
        showPatientsBtn.setActionCommand("ShowPatients");
        showMedicinesBtn.setActionCommand("ShowMedicines");
        showLaboratoriesBtn.setActionCommand("ShowLaboratories");
        showFacilitiesBtn.setActionCommand("ShowFacilities");
        showStaffBtn.setActionCommand("ShowStaff");

        // Add action listeners to buttons
        addDoctorBtn.addActionListener(this);
        addPatientBtn.addActionListener(this);
        addMedicineBtn.addActionListener(this);
        addLabBtn.addActionListener(this);
        addFacilityBtn.addActionListener(this);
        addStaffBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        showDoctorsBtn.addActionListener(this);
        showPatientsBtn.addActionListener(this);
        showMedicinesBtn.addActionListener(this);
        showLaboratoriesBtn.addActionListener(this);
        showFacilitiesBtn.addActionListener(this);
        showStaffBtn.addActionListener(this);

        // Initialize output text area
        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);
        scrollPane = new JScrollPane(outputArea);

        // Initialize panels
        JPanel buttonPanel = new JPanel(new GridLayout(7, 2));
        buttonPanel.add(addDoctorBtn);
        buttonPanel.add(showDoctorsBtn);
        buttonPanel.add(addPatientBtn);
        buttonPanel.add(showPatientsBtn);
        buttonPanel.add(addMedicineBtn);
        buttonPanel.add(showMedicinesBtn);
        buttonPanel.add(addLabBtn);
        buttonPanel.add(showLaboratoriesBtn);
        buttonPanel.add(addFacilityBtn);
        buttonPanel.add(showFacilitiesBtn);
        buttonPanel.add(addStaffBtn);
        buttonPanel.add(showStaffBtn);
        buttonPanel.add(exitBtn);

        JPanel outputPanel = new JPanel();
        outputPanel.add(scrollPane);

        // Set frame properties
        setTitle("Hospital Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.WEST);
        add(outputPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    // ActionPerformed method to handle button clicks
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "AddDoctor":
                addDoctor();
                break;
            case "AddPatient":
                addPatient();
                break;
            case "AddMedicine":
                addMedicine();
                break;
            case "AddLaboratory":
                addLaboratory();
                break;
            case "AddFacility":
                addFacility();
                break;
            case "AddStaff":
                addStaff();
                break;
            case "ShowDoctors":
                showDoctors();
                break;
            case "ShowPatients":
                showPatients();
                break;
            case "ShowMedicines":
                showMedicines();
                break;
            case "ShowLaboratories":
                showLaboratories();
                break;
            case "ShowFacilities":
                showFacilities();
                break;
            case "ShowStaff":
                showStaff();
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    // Methods to add data
    private void addDoctor() {
        if (doctorCount < 25) {
            DoctorForm doctorForm = new DoctorForm();
            int result = JOptionPane.showConfirmDialog(null, doctorForm, "Add Doctor", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Doctor doctor = doctorForm.getDoctor();
                doctors[doctorCount] = doctor;
                doctorCount++;
                updateOutputArea("Doctor added successfully!");
            }
        } else {
            updateOutputArea("Maximum limit reached for doctors!");
        }
    }

    private void addPatient() {
        if (patientCount < 100) {
            PatientForm patientForm = new PatientForm();
            int result = JOptionPane.showConfirmDialog(null, patientForm, "Add Patient", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Patient patient = patientForm.getPatient();
                patients[patientCount] = patient;
                patientCount++;
                updateOutputArea("Patient added successfully!");
            }
        } else {
            updateOutputArea("Maximum limit reached for patients!");
        }
    }

    private void addMedicine() {
        if (medicineCount < 100) {
            MedicalForm medicalForm = new MedicalForm();
            int result = JOptionPane.showConfirmDialog(null, medicalForm, "Add Medicine", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Medical medical = medicalForm.getMedical();
                medicines[medicineCount] = medical;
                medicineCount++;
                updateOutputArea("Medicine added successfully!");
            }
        } else {
            updateOutputArea("Maximum limit reached for medicines!");
        }
    }

    private void addLaboratory() {
        if (labCount < 20) {
            LabForm labForm = new LabForm();
            int result = JOptionPane.showConfirmDialog(null, labForm, "Add Laboratory", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Lab lab = labForm.getLab();
                laboratories[labCount] = lab;
                labCount++;
                updateOutputArea("Laboratory added successfully!");
            }
        } else {
            updateOutputArea("Maximum limit reached for laboratories!");
        }
    }

    private void addFacility() {
        if (facilityCount < 20) {
            FacilityForm facilityForm = new FacilityForm();
            int result = JOptionPane.showConfirmDialog(null, facilityForm, "Add Facility", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Facility facility = facilityForm.getFacility();
                facilities[facilityCount] = facility;
                facilityCount++;
                updateOutputArea("Facility added successfully!");
            }
        } else {
            updateOutputArea("Maximum limit reached for facilities!");
        }
    }

    private void addStaff() {
        if (staffCount < 100) {
            StaffForm staffForm = new StaffForm();
            int result = JOptionPane.showConfirmDialog(null, staffForm, "Add Staff", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Staff staff = staffForm.getStaff();
                staffs[staffCount] = staff;
                staffCount++;
                updateOutputArea("Staff added successfully!");
            }
        } else {
            updateOutputArea("Maximum limit reached for staff!");
        }
    }

    // Methods to display added data
    private void showDoctors() {
        updateOutputArea("Doctors:\n");
        for (int i = 0; i < doctorCount; i++) {
            updateOutputArea(doctors[i].toString());
        }
    }

    private void showPatients() {
        updateOutputArea("Patients:\n");
        for (int i = 0; i < patientCount; i++) {
            updateOutputArea(patients[i].toString());
        }
    }

    private void showMedicines() {
        updateOutputArea("Medicines:\n");
        for (int i = 0; i < medicineCount; i++) {
            updateOutputArea(medicines[i].toString());
        }
    }

    private void showLaboratories() {
        updateOutputArea("Laboratories:\n");
        for (int i = 0; i < labCount; i++) {
            updateOutputArea(laboratories[i].toString());
        }
    }

    private void showFacilities() {
        updateOutputArea("Facilities:\n");
        for (int i = 0; i < facilityCount; i++) {
            updateOutputArea(facilities[i].toString());
        }
    }

    private void showStaff() {
        updateOutputArea("Staff:\n");
        for (int i = 0; i < staffCount; i++) {
            updateOutputArea(staffs[i].toString());
        }
    }

    // Method to update the output area
    private void updateOutputArea(String message) {
        outputArea.append(message + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength()); // Scroll to the bottom
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HospitalManagementUI());
    }
}

// Doctor class
class Doctor {
    String id, name, specialization, appointment, qualification;
    int room;

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Specialization: " + specialization + ", Appointment: " + appointment + ", Qualification: " + qualification + ", Room: " + room;
    }
}

// Patient class
class Patient {
    String id, name, disease, sex, admitStatus;
    int age;

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Disease: " + disease + ", Sex: " + sex + ", Admit Status: " + admitStatus + ", Age: " + age;
    }
}

// Medical class
class Medical {
    String med_name, med_comp, exp_date;
    int med_cost, count;

    @Override
    public String toString() {
        return "Name: " + med_name + ", Composition: " + med_comp + ", Expiration Date: " + exp_date + ", Cost: " + med_cost + ", Count: " + count;
    }
}

// Lab class
class Lab {
    String fecility;
    int lab_cost;

    @Override
    public String toString() {
        return "Facility: " + fecility + ", Cost: " + lab_cost;
    }
}

// Facility class
class Facility {
    String fec_name;

    @Override
    public String toString() {
        return "Facility: " + fec_name;
    }
}

// Staff class
class Staff {
    String sid, sname, desg, sex;
    int salary;

    @Override
    public String toString() {
        return "ID: " + sid + ", Name: " + sname + ", Designation: " + desg + ", Sex: " + sex + ", Salary: " + salary;
    }
}