/*
   PartTimeStaffHire is a subclass that extends StaffHire
   and is used to handle part-time staff members, including working
   hours, wages, and shifts
 */

public class PartTimeStaffHire extends StaffHire {
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    //constructor to initialize all attributes
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType,
                             String staffName, String joiningDate, String qualification,
                             String appointedBy, boolean joined, int workingHour,
                             double wagesPerHour, String shifts) {
        //super calls the StaffHire constructor to set parent attributes
        super(vacancyNumber, designation, jobType, staffName, joiningDate,
                qualification, appointedBy, joined);

        //initialize part-time staff specific attributes
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;  // Default termination status is false
    }

    //Method to set shift which updates the shift if staff have joined
    public void setShifts(String newShift) {
        if (getJoined()) {  // Check if the staff member has joined
            this.shifts = newShift;
        } else {
            System.out.println("Staff member hasn't joined yet.");
        }
    }

    //Method to terminate part-time staff
    public void terminate() {
        if (terminated) {
            System.out.println("This staff member is already terminated.");
        } else {
            System.out.println("Staff member terminated.");
            this.workingHour = 0;
            this.wagesPerHour = 0;
            this.shifts = null;
            this.terminated = true;
        }
    }

    //Display method to show part-time staff details
    public void display() {
        super.display();  // Call the superclass display method
        System.out.println("Working Hours: " + workingHour);
        System.out.println("Wages Per Hour: " + wagesPerHour);
        System.out.println("Shifts: " + shifts);
        System.out.println("Terminated: " + terminated);
        System.out.println("Daily Income: " + (wagesPerHour * workingHour));
    }
}