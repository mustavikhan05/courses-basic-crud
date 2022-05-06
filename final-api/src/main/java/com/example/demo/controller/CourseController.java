package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CourseController {
    
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    // create course rest api
    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }
	
	// get Course by id rest api
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course does not exist with id :" + id));
		return ResponseEntity.ok(course);
	}

    // update Course rest api
	
	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course CourseDetails){
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course does not exist with id :" + id));
		
		course.setCourseCode(CourseDetails.getCourseCode());
		course.setNameOfCourse(CourseDetails.getNameOfCourse());
		
		Course updatedCourse = courseRepository.save(course);
		return ResponseEntity.ok(updatedCourse);
	}
	
	// delete Course rest api
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable Long id){
		Course Course = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course does not exist with id :" + id));
		
		courseRepository.delete(Course);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	



}
