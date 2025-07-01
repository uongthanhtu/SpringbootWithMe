package com.tusry.spring.sb.entity;
//@Complonent tự động với IoC container
public class ExcepGenerator {
    // SRP - SINGLE Responsibility Principle - S trong SOLID
    // class chuyên làm 1 món mà nó giỏi
    //
    public void generateFile (String fileName){
        System.out.println("The" + fileName + "file has ben gen");
    }
}
