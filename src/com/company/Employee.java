package com.company;

import java.math.BigDecimal;

public class Employee implements Person{

    String id,firstName,lastName;
    BigDecimal salary;


    public Employee(String id,String firstName,String lastName,BigDecimal salary){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
    }


    /**
     * This method returns the salary of the employee
     * @return this salary of the employee
     */
    public BigDecimal getBigDecimal(){
        return salary;
    };
    static public Employee parse(String input){
        String id,firstName,lastName;
        BigDecimal salary;
        String[] tempArray = new String[4];
        tempArray =  input.split(",");
        id = tempArray[0];
        firstName = tempArray[1];
        lastName = tempArray[2];
        salary = new BigDecimal(tempArray[3]);
        return new Employee(id,firstName,lastName,salary);
    }
    @Override
    public String getPersonId() {
        return id;
    }

    @Override
    public String getPersonName() {
        return firstName + " " + lastName;
    }

    /**
     * This is a method to return the properties of the variables of the class employee as a string
     * @return the values of the current instance of Employee
     */
    @Override
    public String toString() {
        return id+","+firstName+","+lastName+","+salary;
    }
}
