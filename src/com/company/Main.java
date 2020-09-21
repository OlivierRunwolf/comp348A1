package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            List<Employee> listEmployees = new ArrayList<>();
        try{
            File myFile = new File("employeRecords.txt");
            Scanner reader = new Scanner(myFile);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                listEmployees.add(Employee.parse(data));
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
