import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String status;
    private String studentID;
    private int balance;
    private static final int COURSE_COST = 600;
    private static int id = 1000;

    private final ArrayList<String> courses;


    public Student() {

        courses = new ArrayList<>();
        status = "Not Enrolled";

        Scanner input = new Scanner(System.in);
        System.out.print("\nPlease Enter student's First Name: ");
        this.firstName = input.nextLine();
        System.out.print("Please Enter student's Last Name: ");
        this.lastName = input.nextLine();
        System.out.print("""
                1 - Freshman
                2 - Sophomore
                3 - Junior
                4 - Senior
                Please enter Student's year:""");
        this.gradeYear = input.nextInt();

        while ((this.gradeYear != 1) &&
                (this.gradeYear != 2) &&
                (this.gradeYear != 3) &&
                (this.gradeYear != 4)) {
            System.out.print("""
                    
                    1 - Freshman
                    2 - Sophomore
                    3 - Junior
                    4 - Senior
                    ERROR: Please enter a valid year:""");

            this.gradeYear = input.nextInt();

        }
        setStudentID();
    }

    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    public void addCourse() {
        Scanner in = new Scanner(System.in);
        String option = "";
        do {
            System.out.print("""
                    
                    0 - Quit
                    1 - History 101
                    2 - Mathematics 101
                    3 - English 101
                    4 - Chemistry 101
                    5 - Computer Science 101
                    Please choose course to enroll:""");
            switch (in.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> option = "History 101";
                case 2 -> option = "Mathematics 101";
                case 3 -> option = "English 101";
                case 4 -> option = "Chemistry 101";
                case 5 -> option = "Computer Science 101";
                default -> {
                    System.out.println("Invalid option, please choose from 1-5.");
                    continue;
                }

            }

            if (courses.contains(option)) {
                System.out.println("ERROR: Student already enrolled for " + option);
            } else {
                if (status.equalsIgnoreCase("Not enrolled")) {
                    status = "Enrolled";
                }
                System.out.println("Enrollment successful!");
                balance += COURSE_COST;
                courses.add(option);
            }
        } while (courses.size() < 5);
    }

    public void getBalance() {
        System.out.println(firstName + " " +lastName + "'s balance is: $" + balance);
    }

    public void payTuition() {
        getBalance();
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter amount: $");
        int amount = in.nextInt();
        if (amount < balance / 2) {
            System.out.println("Payment not processed. Payment must be greater than " + balance / 2 + "\n");
            getBalance();
        } else if (amount > balance) {
            System.out.println("Payment not processed. Payment must be less than or equal to " + balance + "\n");
        } else {
            balance -= amount;
            getBalance();
        }
    }

    public String toString() {
        return
                "\nStudent StudentID: " + studentID +
                        "\nFirst Name: " + firstName + "\nLast Name: " + lastName +
                        "\nGrade Level: " + gradeYear +
                        "\nStatus: " + status +
                        "\nEnrolled Courses: " + courses +
                        "\n"+firstName + " " + lastName + "'s balance is: $" + balance;
    }

}
