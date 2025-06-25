package com.maven.maven_mysql_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JDK8features {

    // JDK 8 features
    // 1. Lambda Expressions
    // 2. Functional Interfaces
    // 3. Streams API
    // 4. Default Methods in Interfaces
    // 5. Method References
    // 6. Optional Class
    // 7. New Date and Time API
    public static void main(String[] args) {

        //1,2,3,4,5,6,7>1.8
        String name[] = {"Ravi", "Raju", "Ramesh", "Suresh", "Mahesh"};

        for (int i = 0; i < name.length; i++) {
            if (!name[i].equalsIgnoreCase("Raju")) {
                System.out.println(name[i]);
            }
        }
        System.out.println("-----------------------------------");

        // Collection
        List<String> names = new ArrayList<>();
        names.add("Ravi");
        names.add("Raju");
        names.add("Ramesh");
        names.add("Suresh");
        names.add("Mahesh");
        // names.add(50); // Removed to ensure all elements are Strings
        System.out.println(names);
        System.out.println("-----------------------------------");

        System.out.println("New approach...");
        names.stream().forEach(System.out::println);
        System.out.println("-----------------------------------");

        // Fetching employee data from Database
        List<Employee> employeeList = DatabaseConnection.getEmployee();
        System.out.println(employeeList);
        System.out.println("-----------------------------------");

        // legacy approach
        for (Employee e : employeeList) {
            if (e.getDepartment().equals("IT")) {
                System.out.println(e);
            }
        }
        System.out.println("-----------------------------------");

        // JDK 8 approach using Streams API
        // filtering the employee list based on variables(various conditions)
        employeeList.stream().filter(s -> s.getSalary() > 50000 && s.getEmpName().startsWith("R")).forEach(System.out::println);
        System.out.println("-----------------------------------");

        employeeList.stream().map(t -> t.getDepartment().toUpperCase()).forEach(System.out::println);
        System.out.println("-----------------------------------");

        List<String> s1 = Arrays.asList("A", "B", "C", "A", "D", "B");
        s1.stream().distinct().forEach(System.out::println); // to remove duplicates
        System.out.println("-----------------------------------");

        List<Integer> num = Arrays.asList(2, 4, 1, 7, 3, 5, 6);
        Collections.sort(num); // sorting the list i.e. ascending order
        Collections.reverse(num); // reversing the list i.e. descending order
        System.out.println(num);
        System.out.println("-----------------------------------");

        // JDK 1.8 approach using Lambda Expression
        // sorting employee list based on empName i.e. string using Lambda Expression
        Collections.sort(employeeList, (e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()));
        employeeList.stream().forEach(System.out::println);
        System.out.println("-----------------------------------");

        // sorting employee list based on salary i.e. integer using Lambda Expression
        Collections.sort(employeeList, (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        employeeList.stream().forEach(System.out::println);
        System.out.println("-----------------------------------");

        // sorting employee list based on salary using MyComparator class
        Collections.sort(employeeList, new MyComparator());
        employeeList.stream().forEach(System.out::println);
        System.out.println("-----------------------------------");

        Employee e1 = new Employee();
        e1.setEmpID(5);
        e1.setEmpName("John");
        e1.setDepartment("IT");
        e1.setSalary(60000);
        System.out.println(e1.getEmpID());
        System.out.println(e1.getEmpName());
        System.out.println(e1.getDepartment());
        System.out.println(e1.getSalary());
        System.out.println("-----------------------------------");
        System.out.println(e1);   // Using toString() method from @Data annotation        
        System.out.println("-----------------------------------");
    }
}
