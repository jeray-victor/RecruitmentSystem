public class FullTimeStaffHire extends StaffHire {
    private double salary;
    private double weeklyFractionalHours;

    // Constructor
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType,
                             String staffName, String joiningDate, String qualification,
                             String appointedBy, boolean joined, double salary,
                             double weeklyFractionalHours) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Getters
    public double getSalary() {
        return salary;
    }

    public double getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    // Setters
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setWeeklyFractionalHours(double weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Method to confirm hiring of full-time staff
    public void hireFullTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy) {
        if (!getJoined()) {
            setStaffName(staffName);
            setJoiningDate(joiningDate);
            setQualification(qualification);
            setAppointedBy(appointedBy);
            setJoined(true);
            System.out.println("Full-time staff hired successfully.");
        } else {
            System.out.println("This staff is already hired.");
        }
    }

    // Display method
    public void display() {
        super.display();
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
    }
}
