package com.atuluttam.SpringBootJpaRelationMappings.Service;

import com.atuluttam.SpringBootJpaRelationMappings.Model.Department;
import com.atuluttam.SpringBootJpaRelationMappings.Model.Project;
import com.atuluttam.SpringBootJpaRelationMappings.Model.Student;
import com.atuluttam.SpringBootJpaRelationMappings.Model.Address;
import com.atuluttam.SpringBootJpaRelationMappings.Repository.AddressRepository;
import com.atuluttam.SpringBootJpaRelationMappings.Repository.DepartmentRepository;
import com.atuluttam.SpringBootJpaRelationMappings.Repository.ProjectRepository;
import com.atuluttam.SpringBootJpaRelationMappings.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create a new Student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Update a Student by ID
    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            updatedStudent.setSname(student.getSname());
            updatedStudent.setType(student.getType());
            updatedStudent.setDept(student.getDept());
            updatedStudent.setAddress(student.getAddress());
            updatedStudent.setProjects(student.getProjects());
            return studentRepository.save(updatedStudent);
        }
        return null;
    }

    // Get all Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get a Student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Delete a Student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Associate Address with Student
    public Student associateAddress(Long studentId, Address address) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            addressRepository.save(address);
            student.setAddress(address);
            return studentRepository.save(student);
        }
        return null;
    }

    // Associate Project with Student
    public Student associateProject(Long studentId, Long projectId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Project project = projectRepository.findById(projectId).orElse(null);
        if (student != null && project != null) {
            student.getProjects().add(project);
            return studentRepository.save(student);
        }
        return null;
    }

    // Get Students by Department
    public List<Student> getStudentsByDepartment(Long deptId) {
        Department department = departmentRepository.findById(deptId).orElse(null);
        if (department != null) {
            return department.getStudentList();
        }
        return null;
    }


    // Get all Students working on a specific Project
    public List<Student> getStudentsByProject(Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isPresent()) {
            return project.get().getStudents();
        }
        return null;
    }

    // Get all Projects of a specific Student
    public List<Project> getProjectsByStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            return student.get().getProjects();
        }
        return null;
    }
}