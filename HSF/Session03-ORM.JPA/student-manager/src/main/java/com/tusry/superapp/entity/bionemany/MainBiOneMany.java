package com.tusry.superapp.entity.bionemany;

import com.tusry.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainBiOneMany {
    //psvm
    public static void main(String[] args) {
        //createMajorStudents();
        EntityManager em = JpaUtil.getEntityManager();
        Major se = em.find(Major.class, "SE");
        List<Student> students = se.getStudents();
        System.out.println("The list of students is: ");
        students.forEach(System.out::println);
        //-------------
        Student student1002 = em.find(Student.class, "SE1002");
        System.out.println(student1002.getMajor().getName());

        students.stream().filter(student -> student.getId().equals("1002")).forEach(System.out::println);


    }

    public static void createMajorStudents(){
        Major major = new Major("SE", "SOFTWARE ENGINEERING");
        Student s1 = new Student("SE1002", "AN NGUYỄN", 2004, 8.6);
        Student s2 = new Student("SE1003", "Bình Lê", 2005, 8.7);

        major.addStudent(s1);
        major.addStudent(s2);

        EntityManager em = JpaUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
        em.close();
    }

}
