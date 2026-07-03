package com.shaan.demovalidaton.controller;

import com.shaan.demovalidaton.entity.Employee;
import com.shaan.demovalidaton.services.MyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    public class MyControler {

        @Autowired
        private MyServices service;

        @GetMapping("/getAllEmployee")
        public List<Employee> getAllEmployee() {
            return service.getAllEmployee();
        }

        @GetMapping("/getAllEmployee/{id}")
        public Optional<Employee>  getAllEmployeebyID(@PathVariable int id) {
            return service.getEmployeeById(id);
        }

        @PostMapping("/addEmployee")
        public String addEmployee(@Valid @RequestBody Employee employee) {
            return service.addEmployee(employee);
        }

        @PutMapping("/updateEmployee/{id}")
        public String updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
            return service.updateEmployee(id, updatedEmployee);
        }

        @DeleteMapping("/deleteEmployee/{id}")
        public String deleteEmployee(@PathVariable int id) {
            return service.deleteEmployee(id);
        }

        @DeleteMapping("/deleteAllEmployee")
        public String deleteAllEmployee() {
            return service.deleteAllEmployee();
        }
    }


