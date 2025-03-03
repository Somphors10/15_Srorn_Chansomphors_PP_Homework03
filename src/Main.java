
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DisplayMethodAll.ChooseShowTable();

        DisplayMethodAll displayObj = new DisplayMethodAll();

        int option;
        do {
            System.out.print("-> Choose an option() : ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    displayObj.InsertEmployee();
                    break;
                case 2:
                    displayObj.UpdateEmployee();
                    break;
                case 3:
                    displayObj.DisplayEmployee();
                    displayObj.Pagination();
                    break;
                case 4:
                    displayObj.RemoveEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Input");
            }

        } while (option != 5);
    }
}

