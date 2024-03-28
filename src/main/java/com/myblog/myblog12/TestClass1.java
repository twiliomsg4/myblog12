package com.myblog.myblog12;

import com.myblog.myblog12.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {
        List<
                Employee> employees = Arrays.asList(
                new Employee("mike", 30, "chennai"),
                new Employee("adam", 34, "pune"),
                new Employee("sam", 27, "bangalore"),
                new Employee("jame", 32, "pune"));

        Map<String, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));

        for (Map.Entry<String, List<Employee>> entry : collect.entrySet()) {
            String city = entry.getKey();
            List<Employee> employeesWithCity = entry.getValue();
            System.out.println("city:" + city + "----");
            for (Employee e : employeesWithCity) {
                System.out.println(e.getCity());
                System.out.println(e.getName());
            }
        }
    }
}







