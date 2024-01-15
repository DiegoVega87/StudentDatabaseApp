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

    private ArrayList<String> courses;


    public Student() {

        courses = new ArrayList<>();
        status = "Not Enrolled";

        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter student's First Name: ");
        this.firstName = input.nextLine();
        System.out.print("Please Enter student's Last Name: ");
        this.lastName = input.nextLine();
        System.out.println("""
                Please enter Student's year:\s
                1 - Freshman
                2 - Sophomore\s
                3 - Junior\s
                4 - Senior""");
        this.gradeYear = input.nextInt();
        input.nextLine();

        while ((this.gradeYear != 1) &&
                (this.gradeYear != 2) &&
                (this.gradeYear != 3) &&
                (this.gradeYear != 4)) {
            System.out.println("""
                    ERROR: Please enter a valid year: \s
                    1 - Freshman
                    2 - Sophomore\s
                    3 - Junior\s
                    4 - Senior
                    """);

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
            System.out.println("""
                    Please choose course to enroll:\s
                    0 - Quit
                    1 - History 101
                    2 - Mathematics 101
                    3 - English 101
                    4 - Chemistry 101
                    5 - Computer Science 101""");
            switch (in.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> option = "History 101";
                case 2 -> option = "Mathematics 101";
                case 3 -> option = "English 101";
                case 4 -> option = "Chemistry 101";
                case 5 -> option = "Computer Science 101";
                default -> System.out.println("Invalid option, please choose from 1-5.");

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
        in.close();
    }

    public void getBalance() {
        System.out.println("Your balance is : $" + balance);
    }

    public void payTuition() {
        getBalance();
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter amount: $");
        int amount = in.nextInt();
        in.close();
        if (amount < balance / 2) {
            System.out.println("Payment not processed. Payment must be greater than " + balance / 2 + "\n");
            getBalance();
        } else if (amount > balance) {
            System.out.println("Payment not processed. Payment must be less than or equal to " + balance + "\n");
        } else {
            balance -= amount;
            System.out.println("Your balance is: " + balance);
        }
    }

    public String toString() {
        return
                "Student StudentID:" + studentID +
                        "\nFirst Name: " + firstName + "\nLast Name: " + lastName +
                        "\nGrade Level: " + gradeYear +
                        "\nStatus: " + status +
                        "\nCourses: " + courses +
                        "\nBalance $" + balance;
    }

}
