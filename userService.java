package service;

import model.User;
import dao.UserDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    private Scanner sc = new Scanner(System.in);
    UserDAO dao = new UserDAO();
    ArrayList<User> users = dao.getUsers();
    public boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }


    public boolean isValidPhone(String phone) {
        return phone.matches("[0-9]{10}");
    }
    public void registerUser() {


        int id;

        try {

            System.out.print("Enter User ID: ");
            id = sc.nextInt();
            sc.nextLine();

        } catch (Exception e) {

            System.out.println("Invalid User ID.");

            sc.nextLine();
            return;
        }
        sc.nextLine();

        for (User user : users) {
            if (user.getUserId() == id) {
                System.out.println("User ID Already Exists.");
                return;
            }
        }

        System.out.print("Name : ");
        String name = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        System.out.print("Phone : ");
        String phone = sc.nextLine();
        if (!isValidEmail(email)) {
            System.out.println("Invalid Email Format!");
            return;
        }
        if (!isValidPhone(phone)) {
            System.out.println("Phone number must contain exactly 10 digits.");
            return;
        }
        if(password.length() < 4){
            System.out.println("Password should contain at least 4 characters.");
            return;
        }
        if(name.trim().isEmpty()){
            System.out.println("Name cannot be empty.");
            return;
        }

        dao.addUser(new User(id, name, email, password, phone));

        System.out.println("User Registered Successfully.");
    }
    public void searchUserById() {

        try {

            System.out.print("Enter User ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            userDAO.searchUserById(id);

        } catch (Exception e) {

            System.out.println("Invalid User ID.");
            sc.nextLine();
        }
    }

    public void viewUsers() {

        dao.viewUsers();   // Display users from database
    }

    public void searchUser() {

        System.out.print("Enter User ID : ");
        int id = sc.nextInt();

        for (User user : users) {
            if (user.getUserId() == id) {
                System.out.println(user);
                return;
            }
        }

        System.out.println("User Not Found.");
    }

    public void updateUser() {

        System.out.print("Enter User ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name : ");
        String name = sc.nextLine();

        System.out.print("Enter New Email : ");
        String email = sc.nextLine();

        System.out.print("Enter New Password : ");
        String password = sc.nextLine();

        System.out.print("Enter New Phone : ");
        String phone = sc.nextLine();

        User user = new User(id, name, email, password, phone);

        userDAO.updateUser(user);
    }
    public void searchUserByEmail() {

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        userDAO.searchUserByEmail(email);
    }
    public void deleteUser() {

        System.out.print("Enter User ID : ");
        int id = sc.nextInt();

       dao.deleteUser(id);
    }
    public void loginUser() {

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        boolean status = userDAO.loginUser(email, password);

        if (status) {
            System.out.println("\n✅ Login Successful!");
            System.out.println("Welcome to Job Portal.");
        } else {
            System.out.println("\n❌ Invalid Email or Password.");
        }
    }
    }
