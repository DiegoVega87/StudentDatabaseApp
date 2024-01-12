import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StudentDatabaseApp {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Set<String> IDs = new HashSet<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students to add to the database: ");
        int numStudents = input.nextInt();
        input.nextLine();
        while(numStudents > 0){
            System.out.println("Please Enter student's First Name: ");
            String firstName = input.nextLine();
            System.out.println("Please Enter student's Last Name: ");
            String lastName = input.nextLine();
            System.out.println("Please enter Student's year: ");
            String year = input.nextLine();
            //while (!year.equalsIgnoreCase(""))
        }

    }
}
