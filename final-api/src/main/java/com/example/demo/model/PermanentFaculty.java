package com.example.demo.model;

public class PermanentFaculty extends Faculty{
    private double BASIC_SALARY = 5000;
    private Course[] courses;
    private int numberOfCourses;


    public PermanentFaculty() {
        
    }

    public PermanentFaculty(String name, int age, String address) {
        super(name, age, address);
        courses = new Course[7];
    }

    public void addCourse(Course newCourse){
        if (numberOfCourses <= 6){
            courses[numberOfCourses++] = newCourse;
        } else {
            System.out.print("You cannot take anymore courses!\n");
        }
    }

    public void printCourses(){
        for (int i = 0; i < numberOfCourses; i++){
            System.out.print(courses[i] + "\n");
        }
    }

    public int getNumberOfCourses(){
        return numberOfCourses;
    }


    public double getSalary(){
        return BASIC_SALARY + (numberOfCourses * (0.20 * BASIC_SALARY));
    }


    @Override
    public String toString() {
        return super.toString() + "Number of Courses: " + numberOfCourses + "\n Salary: " + getSalary() + "\n";
    }

}
