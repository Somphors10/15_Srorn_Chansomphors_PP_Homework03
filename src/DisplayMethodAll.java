import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayMethodAll {
    // Console Colors
    String RESET = "\u001B[0m";
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";

    // Console Colors Static
    static String RESETS = "\u001B[0m";
    static String GREENS = "\u001B[32m";
    static String REDS = "\u001B[31m";


    private int nextId = 8;
    Scanner scanner = new Scanner(System.in);
    ArrayList<StaffMember> employees = new ArrayList<>();
    {
        // Adding 7 default employees
        employees.add(new Volunter(1, "Jake", "PP", 0));
        employees.add(new SalariedEmployee(2, "Anna", "SR", 3000, 500));
        employees.add(new HourlySalaryEmployee(3, "Mike", "BTB", 20, 50));
        employees.add(new Volunter(4, "Heesung", "PP", 0));
        employees.add(new SalariedEmployee(5, "Jungwon", "SR", 3500, 500));
        employees.add(new HourlySalaryEmployee(6, "Mark", "BTB", 20, 50));
        employees.add(new Volunter(7, "Sunghoon", "PP", 0));
    }
    Volunter insertVolunteer = new Volunter(employees, nextId);
    SalariedEmployee insertSalariedEmployee = new SalariedEmployee(employees, nextId);
    HourlySalaryEmployee insertHourlySalaryEmployee = new HourlySalaryEmployee(employees, nextId);


    // Choose Option in table
    public static void ChooseShowTable() {
        CellStyle centerAlign = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(1, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.addCell( GREENS + "    STAFF MANAGEMENT SYSTEM    " + RESETS, centerAlign);
        table.addCell("1. Insert Employee", centerAlign);
        table.addCell("2. Update Employee", centerAlign);
        table.addCell("3. Display Employee", centerAlign);
        table.addCell("4. Remove Employee", centerAlign);
        table.addCell("      5. Exit");

        System.out.println(table.render());
    }

    // Display Data and Default Data
    public void DisplayEmployee() {
        System.out.println("=".repeat(20) + "* Display Employee *" + "=".repeat(20));

        CellStyle centerAlign = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(9, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
        table.addCell(GREEN + "Type" + RESET, centerAlign);
        table.addCell(GREEN + "ID" + " ".repeat(5) + RESET, centerAlign);
        table.addCell(GREEN + "Name" + " ".repeat(5)+ RESET , centerAlign);
        table.addCell(GREEN + "Address" + " ".repeat(5)+ RESET , centerAlign);
        table.addCell(GREEN + "Salary" + " ".repeat(5) + RESET , centerAlign);
        table.addCell(GREEN + "Bonus" + " ".repeat(5) + RESET , centerAlign);
        table.addCell(GREEN + "Hour" + " ".repeat(5) + RESET , centerAlign);
        table.addCell(GREEN + "Rate" + " ".repeat(5) + RESET , centerAlign);
        table.addCell(GREEN + "Pay" + " ".repeat(5) + RESET , centerAlign);

        // Display default and added employees
        for (StaffMember employee : employees) {
            if (employee instanceof Volunter) {
                table.addCell("Volunteer");
                table.addCell(String.valueOf(employee.id), centerAlign);
                table.addCell(employee.name, centerAlign);
                table.addCell(employee.address, centerAlign);
                table.addCell(String.valueOf(((Volunter) employee).getSalary()), centerAlign);
                table.addCell("...", centerAlign);
                table.addCell("...", centerAlign);
                table.addCell("...", centerAlign);
                table.addCell(String.valueOf(employee.pay()), centerAlign);
            } else if (employee instanceof SalariedEmployee) {
                table.addCell("Salaried Employee");
                table.addCell(String.valueOf(employee.id), centerAlign);
                table.addCell(employee.name, centerAlign);
                table.addCell(employee.address, centerAlign);
                table.addCell(String.valueOf(((SalariedEmployee) employee).getSalary()), centerAlign);
                table.addCell(String.valueOf(((SalariedEmployee) employee).getBunus()), centerAlign);
                table.addCell("...", centerAlign);
                table.addCell("...", centerAlign);
                table.addCell(String.valueOf(employee.pay()), centerAlign);
            } else if (employee instanceof HourlySalaryEmployee) {
                table.addCell("Hourly Salary Employee");
                table.addCell(String.valueOf(employee.id), centerAlign);
                table.addCell(employee.name, centerAlign);
                table.addCell(employee.address, centerAlign);
                table.addCell("...", centerAlign);
                table.addCell("...", centerAlign);
                table.addCell(String.valueOf(((HourlySalaryEmployee) employee).getHourWorked()), centerAlign);
                table.addCell(String.valueOf(((HourlySalaryEmployee) employee).getRate()), centerAlign);
                table.addCell(String.valueOf(employee.pay()), centerAlign);
            }
        }

        System.out.println(table.render());
    }

    // Insert Employee
    public void InsertEmployee(){
        System.out.println("=".repeat(20) + "* Insert Employee *" + "=".repeat(20));
        while (true){
            System.out.println("Choose Type: ");

            CellStyle centerAlign = new CellStyle(CellStyle.HorizontalAlign.center);
            Table table = new Table(4, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
            table.addCell(" 1. Volunteer ", centerAlign);
            table.addCell(" 2. Salaried Employee ", centerAlign);
            table.addCell(" 3. Hourly Employee ", centerAlign);
            table.addCell(" 4. Back ", centerAlign);
            System.out.println(table.render());
            System.out.print("=> Enter Type Number: ");
            int ChooseTypeOption = scanner.nextInt();
            switch (ChooseTypeOption){
                case 1:
                    insertVolunteer.InsertVolunteer(nextId++);
                    break;
                case 2:
                    insertSalariedEmployee.InsertSalariedEmployee(nextId++);
                    break;
                case 3:
                    insertHourlySalaryEmployee.InsertHourlySalaryEmployee(nextId++);
                    break;
                case 4:
                    System.out.println("\n");
                    return;
            }
        }
    }

    //Pagination
    public void Pagination(){

        System.out.print("1. First Page" + " ".repeat(5));
        System.out.print("2. Next Page" + " ".repeat(5));
        System.out.print("3. Previous Page" + " ".repeat(5));
        System.out.print("4. Last Page" + " ".repeat(5));
        System.out.print("5. Exit" + " ".repeat(5) + "\n");
        System.out.print("=> Enter your choice: ");
        int pagination = scanner.nextInt();

        // Table pagination
        switch (pagination) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                return;
            default:
                System.out.println(RED + "Invalid choice. Please try again." + RESET);
        }
    }


    //Update Data
    public void UpdateEmployee() {
        System.out.println("=".repeat(20) + "* Update Employee *" + "=".repeat(20));
        System.out.print("=> Enter or Search ID to update: ");
        int searchId = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline

        StaffMember selectedEmployee = null;
        for (StaffMember employee : employees) {
            if (employee.id == searchId) {
                selectedEmployee = employee;
                break;
            }
        }

        if (selectedEmployee == null) {
            System.out.println(RED + "Employee with ID " + searchId + " not found." + RESET);
            return;
        }

        // Display employee details in a table based on type
        CellStyle centerAlign = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = null;

        if (selectedEmployee instanceof Volunter) {
            table = new Table(5, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
            table.addCell(GREEN + "Type" + RESET, centerAlign);
            table.addCell(GREEN + "ID" + RESET, centerAlign);
            table.addCell(GREEN + "Name" + RESET, centerAlign);
            table.addCell(GREEN + "Address" + RESET, centerAlign);
            table.addCell(GREEN + "Salary" + RESET, centerAlign);
            table.addCell("Volunteer", centerAlign);
            table.addCell(String.valueOf(selectedEmployee.id), centerAlign);
            table.addCell(selectedEmployee.name, centerAlign);
            table.addCell(selectedEmployee.address, centerAlign);
            table.addCell(String.valueOf(((Volunter) selectedEmployee).getSalary()), centerAlign);
        } else if (selectedEmployee instanceof SalariedEmployee) {
            table = new Table(6, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
            table.addCell(GREEN + "Type" + RESET, centerAlign);
            table.addCell(GREEN + "ID" + RESET, centerAlign);
            table.addCell(GREEN + "Name" + RESET, centerAlign);
            table.addCell(GREEN + "Address" + RESET, centerAlign);
            table.addCell(GREEN + "Salary" + RESET, centerAlign);
            table.addCell(GREEN + "Bonus" + RESET, centerAlign);
            table.addCell("Salaried Employee", centerAlign);
            table.addCell(String.valueOf(selectedEmployee.id), centerAlign);
            table.addCell(selectedEmployee.name, centerAlign);
            table.addCell(selectedEmployee.address, centerAlign);
            table.addCell(String.valueOf(((SalariedEmployee) selectedEmployee).getSalary()), centerAlign);
            table.addCell(String.valueOf(((SalariedEmployee) selectedEmployee).getBunus()), centerAlign);
        } else if (selectedEmployee instanceof HourlySalaryEmployee) {
            table = new Table(7, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
            table.addCell(GREEN + "Type" + RESET, centerAlign);
            table.addCell(GREEN + "ID" + RESET, centerAlign);
            table.addCell(GREEN + "Name" + RESET, centerAlign);
            table.addCell(GREEN + "Address" + RESET, centerAlign);
            table.addCell(GREEN + "Hours" + RESET, centerAlign);
            table.addCell(GREEN + "Rate" + RESET, centerAlign);
            table.addCell(GREEN + "Salary" + RESET, centerAlign);
            table.addCell("Hourly Salary Employee", centerAlign);
            table.addCell(String.valueOf(selectedEmployee.id), centerAlign);
            table.addCell(selectedEmployee.name, centerAlign);
            table.addCell(selectedEmployee.address, centerAlign);
            table.addCell(String.valueOf(((HourlySalaryEmployee) selectedEmployee).getHourWorked()), centerAlign);
            table.addCell(String.valueOf(((HourlySalaryEmployee) selectedEmployee).getRate()), centerAlign);
            table.addCell(String.valueOf(((HourlySalaryEmployee) selectedEmployee).getSalary()), centerAlign);
        }

        System.out.println(table.render());

        while (true) {
            System.out.println("\n\nChoose one column to update:");
            if (selectedEmployee instanceof Volunter) {
                System.out.print("1. Name  2. Address  3. Salary  0. Cancel\n");
            } else if (selectedEmployee instanceof SalariedEmployee) {
                System.out.print("1. Name  2. Address  3. Salary  4. Bonus  0. Cancel\n");
            } else if (selectedEmployee instanceof HourlySalaryEmployee) {
                System.out.print("1. Name  2. Address  3. Hour Worked  4. Rate  5. Salary  0. Cancel\n");
            }

            System.out.print("=> Select Column Number: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("=> Change Name To : ");
                    selectedEmployee.name = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("=> Change Address To: ");
                    selectedEmployee.address = scanner.nextLine();
                    break;
                case 3:
                    if (selectedEmployee instanceof Volunter) {
                        System.out.print("=> Change Salary To : ");
                        ((Volunter) selectedEmployee).setSalary();
                    } else if (selectedEmployee instanceof HourlySalaryEmployee) {
                        System.out.print("=> Change Hour Worked To : ");
                        ((HourlySalaryEmployee) selectedEmployee).setHourWorked();
                    } else {
                        System.out.print("=> Change Salary To : ");
                        ((SalariedEmployee) selectedEmployee).setSalary();
                    }
                    scanner.nextLine();
                    break;
                case 4:
                    if (selectedEmployee instanceof SalariedEmployee) {
                        System.out.print("=> Change Bonus To : ");
                        ((SalariedEmployee) selectedEmployee).setBonus(scanner.nextDouble());
                    } else if (selectedEmployee instanceof HourlySalaryEmployee) {
                        System.out.print("=> Change Rate To : ");
                        ((HourlySalaryEmployee) selectedEmployee).setRate();
                    }
                    scanner.nextLine();
                    break;
                case 5:
                    if (selectedEmployee instanceof HourlySalaryEmployee) {
                        System.out.print("=> Change Salary To : ");
                        ((HourlySalaryEmployee) selectedEmployee).setSalary(scanner.nextDouble());
                        scanner.nextLine();
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        }
    }



    // Remove Data
    public void RemoveEmployee() {
        System.out.println("=".repeat(20) + "* Remove Employee *" + "=".repeat(20));
        System.out.print("=> Enter ID to remove: ");
        int removeId = scanner.nextInt();
        scanner.nextLine();

        boolean removed = employees.removeIf(employee -> employee.id == removeId);

        // Check if any employee was removed
        if (removed) {
            System.out.println(GREEN + "* Employee with ID: " + removeId + " has been removed successfully! *" + RESET);
        } else {
            System.out.println(RED + "Employee with ID " + removeId + " not found." + RESET);
        }
    }

}