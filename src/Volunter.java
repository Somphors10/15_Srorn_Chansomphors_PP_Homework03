import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Volunter extends StaffMember {
    // Console Colors
    String RESET = "\u001B[0m";
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";

    Scanner sc = new Scanner(System.in);

    private double salary;

    //Declare ArrayList name employee <StaffMember> is generic type
    private ArrayList<StaffMember> employees;


    public Volunter(ArrayList<StaffMember> employees, int nextId) {
        this.employees = employees;
    }

    public Volunter(int id, String name, String address, double salary) {
        super(id, name, address);
        this.salary = salary;
    }


    public double getSalary() {
        return salary;
    }


    public double setSalary() {
        return salary;
    }

    public String toString() {
        return "";
    }

    @Override
    public double pay() {
        return salary;
    }

    // Input Data
    public void InsertVolunteer(int id) {
        boolean inputCheck = false;
        String name, address;
        double salary;

        System.out.println("   ID: " + id);

        // Validate Name
        while (true) {
            System.out.print("=> Enter Name: ");
            name = sc.nextLine();
            if (Pattern.matches("^[A-Za-z ]+$", name)) {
                break;
            } else {
                System.out.println(RED + "Invalid name! Please enter only letters and spaces." + RESET);
            }
        }

        // Validate Address
        while (true) {
            System.out.print("=> Enter Address: ");
            address = sc.nextLine();
            if (Pattern.matches("^[A-Za-z0-9 ,.]+$", address)) {
                break;
            } else {
                System.out.println(RED + "Invalid address! Please Input Again." + RESET);
            }
        }

        // Validate Salary
        while (true) {
            System.out.print("=> Enter Salary: ");
            if (sc.hasNextDouble()) {
                salary = sc.nextDouble();
                if (salary >= 0) break;
            } else {
                sc.next();
            }
            System.out.println(RED + "Invalid salary! Please enter a valid positive number." + RESET);
        }

        // Add to the list
        employees.add(new Volunter(id, name, address, salary));
        inputCheck = true;

        if (inputCheck) {
            System.out.println(GREEN + "* You added " + name + " as a Volunteer successfully! *\n\n" + RESET);
        }
    }
}