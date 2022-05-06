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
@Table(name = "courses")
public class Course {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name="course_code")
    private String courseCode;
    
    @Column(name = "name_of_course")
    private String nameOfCourse;



    public Course() {

    }

    public Course(String nameOfCourse, String courseCode) {
        this.nameOfCourse = nameOfCourse;
        this.courseCode = courseCode;
    }

    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

    public String getNameOfCourse() {
        return this.nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return
            " Name: " + getNameOfCourse() +
            " Course Code: " + getCourseCode();
    }

}
