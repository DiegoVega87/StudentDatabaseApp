import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students to add to the database: ");
        int numStudents = input.nextInt();
        input.nextLine();
        while(numStudents > 0) {
            System.out.println("Please Enter student's First Name: ");
            this.firstName = input.nextLine();
            System.out.println("Please Enter student's Last Name: ");
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
            numStudents--;
        }
        setStudentID();
        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);

    }

    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" +  id;
    }

    public boolean addCourse(){
        Scanner in = new Scanner(System.in);
        String option = "";
        System.out.println("""
                Please choose:\s
                1 - History 101
                2 - Mathematics 101
                3 - English 101
                4 - Chemistry 101
                5 - Computer Science 101""");
        switch (in.nextInt()){
            case 1 -> option = "History 101";
            case 2 -> option = "Mathematics 101";
            case 3 -> option = "English 101";
            case 4 -> option = "Chemistry 101";
            case 5 -> option = "Computer Science 101";
            default -> {System.out.println("Invalid option, please choose from 1-5.");
            return false;}

        }
        if(courses.size() == 5){
            System.out.println("ERROR: Student reached max number of courses/term");
        }else if(courses.contains(option)){
            System.out.println("ERROR: Student already enrolled for " + option);
        }else{
            if(status.equals("Not enrolled")){
                status = "Enrolled";
            }
            System.out.println("Enrollment successful!");
            balance += COURSE_COST;
            return courses.add(option);
        }
        return false;
    }

    public int getBalance(){
        return balance;
    }

    public boolean payTuition(int amount){
        if(amount < balance/2){
            System.out.println("Payment not processed. Payment must be greater than " + balance/2 + "\n");
        }else if(amount > balance){
            System.out.println("Payment not processed. Payment must be less than or equal to " + balance + "\n");
        }else{
            balance -= amount;
            System.out.println("Your balance is: " + balance);
            return true;
        }
        return false;
    }

    public void showInfo(){
        System.out.println("Student StudentID:" + studentID);
        System.out.println("First Name: " + firstName + "\nLast Name: " + lastName);
        System.out.println("Status: " + status);
        System.out.println("Courses: ");
        for(String s : courses){
            System.out.println(s);
        }
        System.out.println("Balance: " + balance);
    }

}
