package com.shaan.exceptionhanlingwithh2.repository;

import com.shaan.exceptionhanlingwithh2.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
