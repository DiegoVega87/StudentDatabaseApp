import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StudentDatabaseApp {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
       // Ask how many students we want to add
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of students to add: ");
        int numStudents = in.nextInt();

        do{
            numStudents--;
            Student st = new Student();
            st.addCourse();
            st.payTuition();
            students.add(st);

        }while(numStudents > 0);

        students.forEach(System.out::println);
    }
}
 // functionallity