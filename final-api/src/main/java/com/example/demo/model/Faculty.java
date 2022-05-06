package com.example.demo.model;

public abstract class Faculty extends Person{

    public Faculty(){

    }

    public Faculty(String name, int age, String address){
        super(name, age, address);
    }

    public abstract void addCourse(Course newCourse);

    public abstract void printCourses();

    public abstract int getNumberOfCourses();

    public abstract double getSalary();


    @Override
    public String toString() {
        return super.toString();
    }
    
}
