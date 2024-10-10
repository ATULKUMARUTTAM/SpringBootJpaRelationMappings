package com.atuluttam.SpringBootJpaRelationMappings.Controller;

import com.atuluttam.SpringBootJpaRelationMappings.Model.Project;
import com.atuluttam.SpringBootJpaRelationMappings.Model.Student;
import com.atuluttam.SpringBootJpaRelationMappings.Model.Address;
import com.atuluttam.SpringBootJpaRelationMappings.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create a new Student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // Update Student by ID
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // Get all Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Delete Student by ID
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // Associate Address with Student
    @PutMapping("/{studentId}/address")
    public Student associateAddress(@PathVariable Long studentId, @RequestBody Address address) {
        return studentService.associateAddress(studentId, address);
    }

    // Associate Project with Student
    @PutMapping("/{studentId}/projects/{projectId}")
    public Student associateProject(@PathVariable Long studentId, @PathVariable Long projectId) {
        return studentService.associateProject(studentId, projectId);
    }

    // Get Students by Department
    @GetMapping("/department/{deptId}")
    public List<Student> getStudentsByDepartment(@PathVariable Long deptId) {
        return studentService.getStudentsByDepartment(deptId);
    }

    // Get all Students working on a specific Project
    @GetMapping("/projects/{projectId}/students")
    public List<Student> getStudentsByProject(@PathVariable Long projectId) {
        return studentService.getStudentsByProject(projectId);
    }

    // Get all Projects of a specific Student
    @GetMapping("/{studentId}/projects")
    public List<Project> getProjectsByStudent(@PathVariable Long studentId) {
        return studentService.getProjectsByStudent(studentId);
    }
}