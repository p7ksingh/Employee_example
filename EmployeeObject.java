package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeObject {
    int emp_id;
    String emp_name;
    int emp_age;
    String emp_gender;
    String emp_dep;
    int year_of_joining;
    double emp_salary;
     static List<EmployeeObject> employeeObjectList = new ArrayList<EmployeeObject>();

 public static void main(String[] args) {
employeeObjectList.add(new EmployeeObject(111, "Jeya", 30, "Female", "HR", 2011, 25000.0));
  employeeObjectList.add(new EmployeeObject(122, "Polish", 29, "Male", "Sales", 2015, 18500.0));
  employeeObjectList.add(new EmployeeObject(133, "Thomas", 26, "Male", "Administartion", 2012, 18700.0));
  employeeObjectList.add(new EmployeeObject(144, "Gowthami", 29, "Female", "Development", 2014, 33500.0));
  employeeObjectList.add(new EmployeeObject(155, "Nisha", 25, "Female", "HR", 2013, 22000.0));
  employeeObjectList.add(new EmployeeObject(166, "Issac", 40, "Male", "Maintenance", 2016, 12000.0));
  employeeObjectList.add(new EmployeeObject(177, "Sharmila", 30, "Female", "Finance", 2010, 29000.0));
  employeeObjectList.add(new EmployeeObject(188, "Linga", 33, "Male", "Development", 2015, 35000.0));
  employeeObjectList.add(new EmployeeObject(199, "John", 34, "Male", "Sales", 2016, 14500.0));
  employeeObjectList.add(new EmployeeObject(200, "Jeyam", 36, "Male", "Maintenance", 2015, 17000.0));
  employeeObjectList.add(new EmployeeObject(211, "kumar", 37, "Male", "Administartion", 2014, 18700.0));
  employeeObjectList.add(new EmployeeObject(222, "Joshi", 25, "Male", "Development", 2016, 29000.0));
  employeeObjectList.add(new EmployeeObject(233, "Reddy", 29, "Male", "Finance", 2013, 27000.0));
  employeeObjectList.add(new EmployeeObject(244, "Denwer", 28, "Male", "Sales", 2017, 18000.));
  employeeObjectList.add(new EmployeeObject(255, "Alia", 26, "Female", "Administartion", 2018, 13000.0));
  employeeObjectList.add(new EmployeeObject(266, "Sangavi", 36, "Female", "Development", 2015, 29000.0));
  employeeObjectList.add(new EmployeeObject(277, "Anuja", 32, "Female", "Development", 2012, 38000.0));
//Q1. How many EmployeeObjects in the company are male and female?

Map<String, Long> genderCount = employeeObjectList.stream().collect(Collectors.groupingBy(EmployeeObject::getEmp_gender , Collectors.counting()));
System.out.println(genderCount);

//Q2. How about printing the names of every department in the company?

employeeObjectList.stream().map(EmployeeObject::getEmp_dep).distinct().forEach(System.out::println);
//Q3. What is the average age of the employees, including men and women?
Map<String, Double> avgAgeOfEmployees = employeeObjectList.stream()
.collect(Collectors.groupingBy(EmployeeObject::getEmp_gender, Collectors.averagingInt(EmployeeObject::getEmp_age)));
System.out.println(avgAgeOfEmployees);
System.out.println("================================================================");
//Q4. Find the Highest paid employee in the Company?
String emp_name2 = employeeObjectList.stream().collect( Collectors.maxBy(Comparator.comparingDouble(EmployeeObject::getEmp_salary))).get().getEmp_name();
System.out.println(emp_name2);

//Q5. List the names of all employees in the Company who have joined after 2014?
employeeObjectList.stream().filter(e -> e.getYear_of_joining() > 2015).map(EmployeeObject::getEmp_name)
.forEach(System.out::println);
}
}