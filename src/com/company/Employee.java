package com.company;

import java.math.BigDecimal;

public class Employee implements Person{

    String id,firstName,lastName;
    BigDecimal salary;
    Level salaryLevel;
    
    //optional enum for salary
    enum Level {
    	UNDER25 ("under $25,000.00"),
    	UNDER40 ("under $40,000.00"),
    	UNDER70 ("under $70,000.00"),
    	OVER70 ("over $70,000.00");
    	private String levelString; 
    	private Level(String levelString) {
    		this.levelString = levelString;
    	}
    	@Override
    	public String toString() {
    		return this.levelString;
    	}
    	
    }


    public Employee(String id,String firstName,String lastName,BigDecimal salary){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
    
    //assign salary level
    int intSal = salary.intValue();
    if(intSal < 25000) {
    	this.salaryLevel = Level.UNDER25;
    }else if(intSal < 40000) {
    	this.salaryLevel = Level.UNDER40;
    }else if (intSal < 70000) {
    	this.salaryLevel = Level.UNDER70;
    }else {
    	this.salaryLevel = Level.OVER70;
    }
  
    }


    /**
     * This method returns the salary of the employee
     * @return this salary of the employee
     */
    public BigDecimal getBigDecimal(){
        return salary;
    };
    
    public double getSalary() {
    	return salary.doubleValue();
    }
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
    
    //return level of salary
    public Level getLevel() {
    	return this.salaryLevel;
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
