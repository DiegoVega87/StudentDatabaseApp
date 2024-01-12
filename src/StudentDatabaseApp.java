import java.util.HashSet;
import java.util.Set;

public class StudentDatabaseApp {

    public static void main(String[] args) {

        Set<String> IDs = new HashSet<>();
        Student st = new Student("Diego", "Vega", "junior", IDs);

    }
}
