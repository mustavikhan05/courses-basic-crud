package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "students")

public class Student extends Person{
    
    @Column(name = "cgpa")
    private double cgpa;
    @Column(name = "id")
    private String id;
    @Column(name = "courses")
    private Course[] courses;
    @Column(name = "numberOfCourses")
    private int numberOfCourses;


    public Student() {

    }

    public Student(String name, int age, String address, double cgpa, String id) {
        super(name, age, address);
        this.cgpa = cgpa;
        this.id = id;
    }


    public double getCgpa() {
        return this.cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Course[] getCourses() {
        return this.courses;
    }

    public int getNumOfCourses() {
        return this.numberOfCourses;
    }

    public void addCourse(Course newCourse) {
        if (cgpa >= 2.5) {
            if (numberOfCourses <= 5) {
                courses[numberOfCourses++] = newCourse;
            } else {
                System.out.print("You cannot take any more courses!\n");
            }
        } else {
            if (numberOfCourses <= 3) {
                courses[numberOfCourses++] = newCourse;
            } else {
                System.out.print("You cannot take any more courses!\n");
            }
        }
    }

    public void printCourses(){
        for (int i = 0; i < numberOfCourses; i++){
            System.out.print(courses[i]);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "CGPA: " + cgpa + "\n ID: " + id + "\n";
    }

}
