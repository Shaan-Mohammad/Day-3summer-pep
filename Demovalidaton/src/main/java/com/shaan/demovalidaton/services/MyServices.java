package com.shaan.demovalidaton.services;

import com.shaan.demovalidaton.Repos.MyRepo;
import com.shaan.demovalidaton.entity.Employee;
import com.shaan.demovalidaton.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyServices {
    @Autowired
    private MyRepo repo;
    public List<Employee> getAllEmployee(){
        return repo.findAll();
    }
    public Optional<Employee> getEmployeeById(int id){
        return Optional.of(repo.findById(id)
                .orElseThrow(() -> new
                        EmployeeNotFoundException("Employee not found with id: " + id)));
    }

    public String addEmployee(Employee employee){

        if(employee.getAge() < 18 || employee.getAge() > 60){
            return "Age must be between 18 and 60";
        }

        repo.save(employee);
        return "Employee added successfully";
    }

    public String updateEmployee(int id,Employee updateEmployee){

        Optional<Employee> existingEmp=repo.findById(id);
        if(existingEmp.isPresent()){
            Employee emp=existingEmp.get();
            emp.setName(updateEmployee.getName());
            emp.setAge(updateEmployee.getAge());
            emp.setSalary(updateEmployee.getSalary());
            emp.setDesig(updateEmployee.getDesig());
            repo.save(emp);
            return "Employee updated successfully";
        }else{
            return "Enmpyee not found with id: "+ id;
        }

    }

    public String deleteEmployee(int id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "employee deleted successfully";

        }else{
            return "employee not found with id: "+id
;        }
    }

    public String deleteAllEmployee(){
        repo.deleteAll();
        return "All deleted";
    }

}
