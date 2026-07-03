package com.shaan.exceptionhanlingwithh2.Controller;

import com.shaan.exceptionhanlingwithh2.Entity.Student;
import com.shaan.exceptionhanlingwithh2.Exception.StudentNotFoundException;
import com.shaan.exceptionhanlingwithh2.Service.StudentService;
import com.shaan.exceptionhanlingwithh2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    // GET ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id " + id));
    }

    // ADD
    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        return repository.save(student);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestBody Student updatedStudent) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id " + id));

        student.setName(updatedStudent.getName());

        return repository.save(student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id " + id));

        repository.delete(student);

        return "Deleted Successfully";
    }
}