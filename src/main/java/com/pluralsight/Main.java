package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args){


        try{
            FileReader fileReader = new FileReader("sample.txt");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;
            while((input = bufReader.readLine()) != null){
            Employee emp = makeEmployeeFromCode(input);
            displayEmployee(emp);
            }
            bufReader.close();

        }catch (Exception e) {
            System.out.println("There was a file error");
        }



    }

    public static void displayEmployee(Employee e){
        System.out.printf("%d %s worked %.1f hours for a total of %.2f\n", e.getEmployeeId(), e.getName(), e.getPayRate(), e.getGrossPay());
    }

    public static Employee makeEmployeeFromCode(String code){
        String [] split = code.split("\\|");
        int employeeId= Integer.parseInt(split[0]);
        String name= split[1];
        float hoursWorked= Float.parseFloat(split[2]);
        double payRate = Double.parseDouble(split[3]);

        return new Employee(employeeId, name, hoursWorked, payRate);
    }
}
