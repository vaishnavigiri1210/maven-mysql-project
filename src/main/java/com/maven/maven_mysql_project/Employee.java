package com.maven.maven_mysql_project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// import lombok.Getter;
// import lombok.Setter;

// @Setter
// @Getter
@AllArgsConstructor //parameterized constructor
@Data   //it includes @ToString, @EqualsAndHashCode, @Getter, @Setter
@NoArgsConstructor // default constructor

public class Employee {

    private Integer empID;
    private String empName;
    private String department;
    private double salary;

}
