import service.UserService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        System.out.println("===== JOB PORTAL =====");
        System.out.println("1. Register User");
        System.out.println("2. View Users");
        System.out.println("3. Delete User");
        System.out.println("4. Update User");
        System.out.println("5. Login");
        System.out.println("6. Search User By ID");
        System.out.println("7. Search User By Email");
        System.out.println("8. Exit");
        System.out.print("Choose: ");
int choice;
        try {

            choice = sc.nextInt();
            sc.nextLine();

        } catch (Exception e) {

            System.out.println("Invalid Input! Please enter a number.");

            sc.nextLine();
            return;
        }
        switch(choice) {

            case 1:
                userService.registerUser();
                break;

            case 2:
                userService.viewUsers();
                break;
            case 3:
                userService.deleteUser();
                break;
            case 4:
                userService.updateUser();
                break;
            case 5:
                userService.loginUser();
                break;
            case 6:
                userService.searchUserById();
                break;
            case 7:
                userService.searchUserByEmail();
                break;


            case 8:
                System.out.println("Thank You...");
                break;

            default:
                System.out.println("Invalid Choice");
        }

    while(choice!=8);
}}
