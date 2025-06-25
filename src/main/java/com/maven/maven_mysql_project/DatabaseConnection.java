package com.maven.maven_mysql_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;

public class DatabaseConnection {

    /* SOLID principle:
    Single Responsibility Principle (SRP) - This class is responsible only for database connection.
    Open/Closed Principle (OCP) - This class is open for extension but closed for modification.
    Liskov Substitution Principle (LSP) - This class can be used as a base class for other classes that need database connection functionality.
    Interface Segregation Principle (ISP) - This class does not implement any interfaces, but if it did, it would follow the ISP by not forcing clients to depend on methods they do not use.
    Dependency Inversion Principle (DIP) - This class does not depend on any high-level modules or abstractions, but it could be modified to do so in the future. */

    // create DataBase Connection
    private final static String URL = "jdbc:mysql://localhost:3306/my_first_db";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "admin";

    public static Connection con() {
        Connection connection = null;

        try {
            // which DBMS(MY SQL) I want to configure
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Register is successfully!!");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {
        }
        return connection;
    }

    public static List<Employee> getEmployee() {

        return Arrays.asList(
                new Employee(1, "Vaishu", "IT", 90000),
                new Employee(2, "Ravi", "HR", 50000),
                new Employee(3, "Raju", "Finance", 60000),
                new Employee(4, "Ramesh", "IT", 80000),
                new Employee(5, "Suresh", "Finance", 70000)
        );
    }
}
