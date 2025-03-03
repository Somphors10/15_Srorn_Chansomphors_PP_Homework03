import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HourlySalaryEmployee extends StaffMember{
    Scanner sc = new Scanner(System.in);
    private int hourWorked;
    private double rate;
    private ArrayList<StaffMember> employees;
    private int nextId;

    public HourlySalaryEmployee(ArrayList<StaffMember> employees, int nextId) {
        this.employees = employees;
        this.nextId = nextId;

    }
    public HourlySalaryEmployee(int id, String name, String address, int hourWorked, double rate){
        super(id, name, address);
        this.hourWorked = hourWorked;
        this.rate = rate;
    }


    public double getSalary() {
        return 0;
    }

    public void setSalary(double v) {
    }

    public int getHourWorked(){
        return hourWorked;
    }

    public int setHourWorked(){
        return hourWorked;
    }

    public double getRate(){
        return rate;
    }

    public double setRate(){
        return rate;
    }

    public String toString(){
        return "";
    }

    @Override
    public double pay() {
        return hourWorked * rate;

    }
    
    //Input Hourly salary employee
    public void InsertHourlySalaryEmployee(int id) {
        boolean inputCheck = false;
        String name, address;
        int hourWorked;
        double rate;

        System.out.println("   ID: " + id);

        // Validate Name
        while (true) {
            System.out.print("=> Enter Name: ");
            name = sc.nextLine();
            if (Pattern.matches("^[A-Za-z ]+$", name)) {
                break;
            } else {
                System.out.println("Invalid name! Please enter only letters and spaces." );
            }
        }

        // Validate Address
        while (true) {
            System.out.print("=> Enter Address: ");
            address = sc.nextLine();
            if (Pattern.matches("^[A-Za-z0-9 ,.]+$", address)) {
                break;
            } else {
                System.out.println("Invalid address! Please Enter Again." );
            }
        }

        // Validate Hours Worked
        while (true) {
            System.out.print("=> Enter Hours Worked: ");
            if (sc.hasNextInt()) {
                hourWorked = sc.nextInt();
                if (hourWorked > 0) break;
            } else {
                sc.next(); // Clear invalid input
            }
            System.out.println("Invalid hours worked! Please enter a positive whole number." );
        }

        // Validate Rate
        while (true) {
            System.out.print("=> Enter Rate: ");
            if (sc.hasNextDouble()) {
                rate = sc.nextDouble();
                if (rate >= 0) break;
            } else {
                sc.next();
            }
            System.out.println("Invalid rate! Please enter a valid positive number." );
        }
        sc.nextLine(); // Clear buffer

        // Add to the list
        employees.add(new HourlySalaryEmployee(id, name, address, hourWorked, rate));
        inputCheck = true;

        if (inputCheck) {
            System.out.println( "* You added " + name + " of type HourlySalaryEmployee successfully! *\n\n" );
        }
    }


}
