package com.maven.maven_mysql_project;
import java.util.Comparator;

public class MyComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }

}
