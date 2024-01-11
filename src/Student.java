import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
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

    public boolean enroll(){
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
            System.out.println("Enrollment successful!");
            balance += 600;
            return courses.add(option);
        }
        return false;
    }

    public int getBalance(){
        return balance;
    }


}
