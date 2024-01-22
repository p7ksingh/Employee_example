package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
       List<Employee> list = Arrays.asList(
        new Employee("Sumit",18,2000),
        new Employee("Pankaj",29,5000),
        new Employee("Niraj", 18, 2000),
        new Employee("Karan", 23, 6000),
        new Employee("Arjun", 21, 4000),
        new Employee("zulum", 25, 4000)
       );
       // Create comparator for employee name and age.
       list.stream().sorted((o1, o2) ->o1.getName().compareTo(o2.getName())).forEach(System.out::println);
       list.stream().sorted((o1, o2) ->o1.getAge().compareTo(o2.getAge())).forEach(System.out::println);
       list.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));
       System.out.println(list);
    }
}
