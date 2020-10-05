package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.company.Employee.Level;

public class Main {

    public static void main(String[] args) {

        Employee[] employees;
        Stream<Employee> employeeStream;
        
        Scanner keyboard = new Scanner(System.in);
        //get user input
        System.out.println("Default emplyee record are stored in employeeRecords.txt");
        System.out.println("Please enter the name of the file you would like to open:");
        String file_path = keyboard.next();
        System.out.println("Opening "+file_path);

        //open file
        try(Stream<String> fileStream = Files.lines(Paths.get(file_path))){

            //map lines to employee objects
            employees = fileStream
                    .map(x -> Employee.parse(x))
                    .toArray(Employee[]::new);

            fileStream.close();

            System.out.println("Employees sorted by last name then first name:");
            Arrays.sort(employees, (a, b) -> a.firstName.compareTo(b.firstName));
            Arrays.sort(employees, (a, b) -> a.lastName.compareTo(b.lastName));
            employeeStream = Arrays.stream(employees);
            //display list
            employeeStream.forEach(System.out::println);
            employeeStream.close();

            System.out.println();

            System.out.println("Employees sorted by id:");
            Arrays.sort(employees, (a,b) -> Integer.parseInt(a.id) - Integer.parseInt(b.id));
            employeeStream = Arrays.stream(employees);

            employeeStream.forEach(System.out::println);
            employeeStream.close();

            //summary information
            System.out.println("\nEmployees Summary:");
            employeeStream = Arrays.stream(employees);
            Map<Level, DoubleSummaryStatistics> byLevel = employeeStream.collect(Collectors
                    .groupingBy(Employee::getLevel, Collectors.summarizingDouble(Employee::getSalary)));

            byLevel.entrySet().stream()
                    .sorted((a,b) -> (int)a.getValue().getAverage() - (int)b.getValue().getAverage())
                    .forEachOrdered((e) ->
                            System.out.println("There are "+e.getValue().getCount()+ " employees making "+ e.getKey() + " with an average salary of $"+ String.format("%.2f",e.getValue().getAverage()))
                    );

            employeeStream.close();





        }catch (IOException e){
            System.out.println("File not found");

        }







    }
}