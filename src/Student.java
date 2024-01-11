import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Student {

    private String firstName;
    private String lastName;
    private String year;
    private String status;
    private String ID;
    private int balance;

    private ArrayList<String> courses;
    private Set<String> IDs;

    public Student(String firstName, String lastName, String year) {


        courses = new ArrayList<>();
        IDs = new HashSet<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        status = "Not enrolled";
        balance = 0;
        ID = generateID(year);

    }

    private String generateID(String year) {

        String first = "";

        switch (year.toLowerCase()) {
            case "freshman" -> first = "1";
            case "sophomore" -> first = "2";
            case "junior" -> first = "3";
            case "senior" -> first = "4";
        }

        int number = (int) (Math.random() * 10000);
        ID = first + String.format("%04d", number);
        while(IDs.contains(ID)) {
            number = (int)(Math.random() * 10000);
            ID = first + String.format("%04d", number);
        }
        IDs.add(ID);
        System.out.println(ID);
        return ID;

    }


}
