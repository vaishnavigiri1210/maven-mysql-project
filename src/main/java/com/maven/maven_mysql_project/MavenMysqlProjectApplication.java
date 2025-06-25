package com.maven.maven_mysql_project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MavenMysqlProjectApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(MavenMysqlProjectApplication.class, args);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your choice: \n1. Insert\n2. Read\n3. Update\n4. Delete");
            String choice = br.readLine();
            switch (choice) {
                case "Insert":
                    insertion();
                    main(args);
                    break;
                case "Read":
                    read();
                    main(args);
                    break;
                case "Update":
                    update();
                    main(args);
                    break;
                case "Delete":
                    delete();
                    main(args);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void delete() throws SQLException {
        System.out.println(" Start Deleting data from database...");
        Connection con = DatabaseConnection.con();
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, 4);
        int count = ps.executeUpdate();

        if (count > 0) {
            System.out.println("Data deleted Successfully");
        } else {
            System.out.println("Data deletion Failed");
        }

        ps.close();

    }

    private static void update() throws SQLException {
        System.out.println(" Start Updating data in database...");
        Connection con = DatabaseConnection.con();
        String sql = "UPDATE student SET address=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "Hyderabad");
        ps.setInt(2, 3);
        int count = ps.executeUpdate();

        if (count > 0) {
            System.out.println("Data updated Successfully");
        } else {
            System.out.println("Data update Failed");
        }

        ps.close();
    }

    private static void read() throws SQLException {
        System.out.println(" Start Reading data from database...");
        Connection con = DatabaseConnection.con();
        System.out.println("Connection object created successfully!!!");
        // String sql = "SELECT * FROM student where id=?";
        String sql = "SELECT * FROM student";
        PreparedStatement ps = con.prepareStatement(sql);
        // ps.setInt(1, 4);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Email: " + rs.getString(3));
            System.out.println("Age: " + rs.getInt(4));
            System.out.println("Mobile: " + rs.getString(5));
            System.out.println("Address: " + rs.getString(6));
            System.out.println("-----------------------------");
        }
        ps.close();

    }

    private static void insertion() {
        try {
            // critical code
            Connection con = DatabaseConnection.con();
            // create Statement for insertion
            String query = "INSERT INTO student VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, 4);
            ps.setString(2, "shravani");
            ps.setString(3, "mnp@gmail.com");
            ps.setInt(4, 15);
            ps.setString(5, "3234567890");
            ps.setString(6, "Latur");

            int count = ps.executeUpdate();

            if (count > 0) {
                System.out.println("Data Inserted Successfully");
            } else {
                System.out.println("Data Insertion Failed");
            }

            ps.close();

        } catch (Exception e) {
            // caught exception
            e.printStackTrace();
        }
    }

}
