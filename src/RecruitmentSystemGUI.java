import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class RecruitmentSystemGUI extends JFrame {
    private JTextField vacancyNumberField, designationField, jobTypeField, staffNameField, joiningDateField;
    private JTextField qualificationField, appointedByField, salaryField, weeklyFractionalHoursField;
    private JTextField workingHoursField, wagesPerHourField, shiftsField, terminateNumberField, displayNumberField;

    private JCheckBox joinedCheckBox;

    private ArrayList<StaffHire> staffList = new ArrayList<>(); //array list to store staff

    public RecruitmentSystemGUI() {
        setTitle("Recruitment System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        //main panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the form
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); // Space between form elements
        gbc.anchor = GridBagConstraints.WEST;


        int row = 0;

        //adds form fields
        formPanel.add(new JLabel("Vacancy Number:"), createGbc(0, row));
        vacancyNumberField = new JTextField(15);
        formPanel.add(vacancyNumberField, createGbc(1, row++));

        formPanel.add(new JLabel("Designation:"), createGbc(0, row));
        designationField = new JTextField(15);
        formPanel.add(designationField, createGbc(1, row++));

        formPanel.add(new JLabel("Job Type:"), createGbc(0, row));
        jobTypeField = new JTextField(15);
        formPanel.add(jobTypeField, createGbc(1, row++));

        formPanel.add(new JLabel("Staff Name:"), createGbc(0, row));
        staffNameField = new JTextField(15);
        formPanel.add(staffNameField, createGbc(1, row++));

        formPanel.add(new JLabel("Joining Date:"), createGbc(0, row));
        joiningDateField = new JTextField(15);
        formPanel.add(joiningDateField, createGbc(1, row++));

        formPanel.add(new JLabel("Qualification:"), createGbc(0, row));
        qualificationField = new JTextField(15);
        formPanel.add(qualificationField, createGbc(1, row++));

        formPanel.add(new JLabel("Appointed By:"), createGbc(0, row));
        appointedByField = new JTextField(15);
        formPanel.add(appointedByField, createGbc(1, row++));

        formPanel.add(new JLabel("Salary:"), createGbc(0, row));
        salaryField = new JTextField(15);
        formPanel.add(salaryField, createGbc(1, row++));

        formPanel.add(new JLabel("Weekly Fractional Hours:"), createGbc(0, row));
        weeklyFractionalHoursField = new JTextField(15);
        formPanel.add(weeklyFractionalHoursField, createGbc(1, row++));

        formPanel.add(new JLabel("Working Hours:"), createGbc(0, row));
        workingHoursField = new JTextField(15);
        formPanel.add(workingHoursField, createGbc(1, row++));

        formPanel.add(new JLabel("Wages Per Hour:"), createGbc(0, row));
        wagesPerHourField = new JTextField(15);
        formPanel.add(wagesPerHourField, createGbc(1, row++));

        formPanel.add(new JLabel("Shifts:"), createGbc(0, row));
        shiftsField = new JTextField(15);
        formPanel.add(shiftsField, createGbc(1, row++));

        formPanel.add(new JLabel("Terminate Number:"), createGbc(0, row));
        terminateNumberField = new JTextField(15);
        formPanel.add(terminateNumberField, createGbc(1, row++));

        formPanel.add(new JLabel("Display Number:"), createGbc(0, row));
        displayNumberField = new JTextField(15);
        formPanel.add(displayNumberField, createGbc(1, row++));

        formPanel.add(new JLabel("Joined CheckBox:"), createGbc(0, row));
        joinedCheckBox = new JCheckBox();
        formPanel.add(joinedCheckBox, createGbc(1, row++));


        //adds buttons to the bottom of the panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        buttonPanel.setBackground(Color.LIGHT_GRAY); // Make it visible for debugging

        //Create buttons
        JButton addFullTimeButton = new JButton("Add Full Time Staff");
        JButton addPartTimeButton = new JButton("Add Part Time Staff");
        JButton displayStaffButton = new JButton("Display Staff Details");
        JButton setSalaryButton = new JButton("Set Salary");
        JButton setShiftsButton = new JButton("Set Shifts");
        JButton terminateButton = new JButton("Terminate Staff");
        JButton clearButton = new JButton("Clear");

        //Add all buttons to panel
        buttonPanel.add(addFullTimeButton);
        buttonPanel.add(addPartTimeButton);
        buttonPanel.add(displayStaffButton);
        buttonPanel.add(setSalaryButton);
        buttonPanel.add(setShiftsButton);
        buttonPanel.add(terminateButton);
        buttonPanel.add(clearButton);

        //scroll pane to make buttons fit
        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        //Add the scroll pane to the frame
        add(formPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        //action listeners
        addFullTimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //collects inputs
                    int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
                    String designation = designationField.getText();
                    String jobType = jobTypeField.getText();
                    String staffName = staffNameField.getText();
                    String joiningDate = joiningDateField.getText();
                    String qualification = qualificationField.getText();
                    String appointedBy = appointedByField.getText();
                    boolean joined = joinedCheckBox.isSelected();
                    double salary = Double.parseDouble(salaryField.getText());
                    double weeklyFractionalHours = Double.parseDouble(weeklyFractionalHoursField.getText());

                    //create and add full time staff
                    FullTimeStaffHire fullTimeStaff = new FullTimeStaffHire(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined, salary, weeklyFractionalHours);
                    staffList.add(fullTimeStaff);

                    JOptionPane.showMessageDialog(null, "Full-time staff added.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input: " + ex.getMessage());
                }
            }
        });

        addPartTimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //collect inputs for part time stuff
                    int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
                    String designation = designationField.getText();
                    String jobType = jobTypeField.getText();
                    String staffName = staffNameField.getText();
                    String joiningDate = joiningDateField.getText();
                    String qualification = qualificationField.getText();
                    String appointedBy = appointedByField.getText();
                    boolean joined = joinedCheckBox.isSelected();
                    double workingHours = Double.parseDouble(workingHoursField.getText());
                    double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
                    String shifts = shiftsField.getText();

                    //create and add part time staff
                    PartTimeStaffHire partTimeStaff = new PartTimeStaffHire(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined, (int) workingHours, wagesPerHour, shifts);
                    staffList.add(partTimeStaff);

                    JOptionPane.showMessageDialog(null, "Part-time staff added.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input: " + ex.getMessage());
                }
            }
        });

        displayStaffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //display staff details
                    int index = Integer.parseInt(displayNumberField.getText());
                    if (index >= 0 && index < staffList.size()) {
                        staffList.get(index).display(); // Console output
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid index.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid index.");
                }
            }
        });

        //button logic for set salary
        setSalaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //set salary for staff
                    int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
                    String staffName = staffNameField.getText();

                    for (StaffHire staff : staffList) {
                        if (staff instanceof FullTimeStaffHire) {
                            FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
                            if (fullTimeStaff.getVacancyNumber() == vacancyNumber && fullTimeStaff.getStaffName().equals(staffName)) {
                                double salary = Double.parseDouble(salaryField.getText());
                                fullTimeStaff.setSalary(salary);
                                JOptionPane.showMessageDialog(null, "Salary updated for full-time staff.");
                                return;
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(null, "No matching staff found.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error setting salary: " + ex.getMessage());
                }
            }
        });

        //button logic for set shifts
        setShiftsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //set shifts for part time
                    int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
                    String staffName = staffNameField.getText();

                    for (StaffHire staff : staffList) {
                        if (staff instanceof PartTimeStaffHire) {
                            PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                            if (partTimeStaff.getVacancyNumber() == vacancyNumber && partTimeStaff.getStaffName().equals(staffName)) {
                                String shifts = shiftsField.getText();
                                partTimeStaff.setShifts(shifts);
                                JOptionPane.showMessageDialog(null, "Shifts updated for part-time staff.");
                                return;
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(null, "No matching staff found.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error setting shifts: " + ex.getMessage());
                }
            }
        });

        //button logic for terminate staff
        terminateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //terminate stuff based on vacancy number
                    int vacancyNumber = Integer.parseInt(terminateNumberField.getText());

                    for (int i = 0; i < staffList.size(); i++) {
                        StaffHire staff = staffList.get(i);
                        if (staff.getVacancyNumber() == vacancyNumber) {
                            staffList.remove(i);
                            JOptionPane.showMessageDialog(null, "Staff terminated.");
                            return;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "No staff found with this vacancy number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error terminating staff: " + ex.getMessage());
                }
            }
        });

        //button logic for clear
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //clear all the fields in the form
                vacancyNumberField.setText("");
                designationField.setText("");
                jobTypeField.setText("");
                staffNameField.setText("");
                joiningDateField.setText("");
                qualificationField.setText("");
                appointedByField.setText("");
                salaryField.setText("");
                weeklyFractionalHoursField.setText("");
                workingHoursField.setText("");
                wagesPerHourField.setText("");
                shiftsField.setText("");
                terminateNumberField.setText("");
                displayNumberField.setText("");
                joinedCheckBox.setSelected(false);
            }
        });

        setVisible(true);
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = (x == 1) ? GridBagConstraints.HORIZONTAL : GridBagConstraints.NONE;
        gbc.weightx = (x == 1) ? 1.0 : 0.0;
        return gbc;
    }

    public static void main(String[] args) {
        new RecruitmentSystemGUI();
    }
}
