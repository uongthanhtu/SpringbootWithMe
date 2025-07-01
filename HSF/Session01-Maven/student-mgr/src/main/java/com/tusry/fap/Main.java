package com.tusry.fap;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tusry.fap.entity.Employee;
import com.tusry.fap.entity.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Student s1 = new Student("SE1", "An Nguyen", 2004, 8.6);
        System.out.println(s1);
        Employee e1 = new Employee(1, "Binh Gold", 2000, 100000);
        System.out.println(e1);

        // bien doi object vung new -> json
        ObjectMapper mapper = new ObjectMapper();
        //Tao 1 object thuoc thu vien Jackson dung de lam viec voi json
        String empJson = mapper.writeValueAsString(e1);
        System.out.println("From object to json" + empJson);

        // JSON -> OBJECT
        String emp2Json = """
                {"empId":2,"empName":"Tu Gold","empAge":2004,"empSalary":200000}""";
        // raw string - cos sao de vay, ke ca ki tu dac biet
        Employee e2 = mapper.readValue(emp2Json, Employee.class);
        System.out.println(e2.getEmpSalary());
        System.out.println(e2);
    }
}