package com.shaan.demovalidaton.Repos;

import com.shaan.demovalidaton.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepo  extends JpaRepository <Employee,Integer> {

}
