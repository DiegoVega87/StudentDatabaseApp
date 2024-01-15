import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StudentDatabaseApp {

    public static void main(String[] args) {
        Student st = new Student();
        st.addCourse();
        st.payTuition();
        System.out.println(st);
    }
}
