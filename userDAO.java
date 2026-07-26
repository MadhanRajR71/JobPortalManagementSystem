package dao;

import model.User;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {

    public ArrayList<User> getUsers() {
        ArrayList<User> users=new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                users.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("phone")
                ));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }public boolean loginUser(String email, String password) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                con.close();
                return true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void addUser(User user) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(user_id,name,email,password,phone) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getPhone());

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("User Registered Successfully.");
            }

            con.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }public void removeUser(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM users WHERE user_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User Deleted Successfully.");
            } else {
                System.out.println("User Not Found.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void viewUsers() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== USER LIST =====");

            while (rs.next()) {
                System.out.println("User ID : " + rs.getInt("user_id"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Email   : " + rs.getString("email"));
                System.out.println("Phone   : " + rs.getString("phone"));
                System.out.println("---------------------------");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchUserById(int userId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE user_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n===== USER DETAILS =====");
                System.out.println("User ID : " + rs.getInt("user_id"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Email   : " + rs.getString("email"));
                System.out.println("Phone   : " + rs.getString("phone"));

            } else {

                System.out.println("User Not Found.");

            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchUserByEmail(String email) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n===== USER DETAILS =====");
                System.out.println("User ID : " + rs.getInt("user_id"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Email   : " + rs.getString("email"));
                System.out.println("Phone   : " + rs.getString("phone"));

            } else {

                System.out.println("User Not Found.");

            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(int userId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM users WHERE user_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User Deleted Successfully.");
            } else {
                System.out.println("User ID Not Found.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean emailExists(String email) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public void updateUser(User user) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE users SET name=?, email=?, password=?, phone=? WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setInt(5, user.getUserId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User Updated Successfully.");
            } else {
                System.out.println("User ID Not Found.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
