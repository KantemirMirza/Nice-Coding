package com.example.nicecoding.hr.service;

import com.example.nicecoding.hr.model.Department;
import com.example.nicecoding.hr.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    //Get All Departments
    public List<Department> listOfDepartment() {
        return departmentRepository.findAll();
    }

    public Department findDepartmentById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    //Delete Department
    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    //Save Department
    public void saveDepartment( Department department) {
        departmentRepository.save(department);
    }

}
