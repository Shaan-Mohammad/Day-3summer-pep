package com.shaan.exceptionhanlingwithh2.Service;

import com.shaan.exceptionhanlingwithh2.Entity.Student;
import com.shaan.exceptionhanlingwithh2.Exception.StudentNotFoundException;
import com.shaan.exceptionhanlingwithh2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student getStudentById(Integer id){

        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id "+id));

    }
}


