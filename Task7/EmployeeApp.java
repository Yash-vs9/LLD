package Task7;

import java.sql.*;
import java.util.Scanner;

public class EmployeeApp {


    public static void addEmployee(String name, String designation, double salary) {
        String sql = "INSERT INTO employees (name, designation, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, designation);
            stmt.setDouble(3, salary);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " employee(s) added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void viewEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Designation: %s | Salary: %.2f%n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("designation"), rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void updateEmployee(int id, double newSalary) {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newSalary);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " employee(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " employee(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Employee Database App =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter designation: ");
                    String designation = sc.next();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    addEmployee(name, designation, salary);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee ID: ");
                    int idUpdate = sc.nextInt();
                    System.out.print("Enter new salary: ");
                    double newSalary = sc.nextDouble();
                    updateEmployee(idUpdate, newSalary);
                    break;
                case 4:
                    System.out.print("Enter employee ID: ");
                    int idDelete = sc.nextInt();
                    deleteEmployee(idDelete);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
