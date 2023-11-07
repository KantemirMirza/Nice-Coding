package com.example.nicecoding.hr.controler;

import com.example.nicecoding.hr.model.Employee;
import com.example.nicecoding.hr.service.EmployeeService;
import com.example.nicecoding.hr.model.Department;
import com.example.nicecoding.hr.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @GetMapping("/departments")
    public String listOfDepartment(Model model){
        List<Department> department = departmentService.listOfDepartment();
        model.addAttribute("listOfDepartment", department);
        return"hr/department/listOfDepartment";
    }

    @GetMapping("/addDepartment")
    public String addDepartment(Model model){
        List<Employee> employee = employeeService.listOfEmployee();
        model.addAttribute("listOfEmployee", employee);
        return"hr/department/addDepartment";
    }

    @PostMapping("/addDepartment")
    public String saveDepartment(@ModelAttribute Department department ){
        departmentService.saveDepartment(department);
        return"redirect:/departments";
    }

    @GetMapping("/departments/{id}/edit")
    public String editDepartment(@PathVariable Integer id, Model model) {
        Department department = departmentService.findDepartmentById(id);
        model.addAttribute("department", department);

        List<Employee> employee = employeeService.listOfEmployee();
        model.addAttribute("listOfEmployee", employee);
        return "hr/department/editDepartment";
    }

    @PostMapping("/departments/{id}/edit")
    public String updateDepartment(@PathVariable Integer id, @ModelAttribute("department") Department department) {
        Department dep = departmentService.findDepartmentById(id);
        dep.setName(department.getName());
        dep.setDescription(department.getDescription());
        dep.setManager(department.getManager());
       departmentService.saveDepartment(dep);
        return "redirect:/departments";
    }

    @GetMapping("/departments/{id}/delete")
    public String deleteDepartment(@PathVariable Integer id){
        Department dep = departmentService.findDepartmentById(id);
        departmentService.deleteDepartment(dep);
        return"redirect:/departments";
    }

    @GetMapping("/departments/{id}/info")
    public String infoDepartment(Model model, @PathVariable Integer id){
        Department department = departmentService.findDepartmentById(id);
        model.addAttribute("infoDepartment", department);

        List<Employee> employee = employeeService.listOfEmployee();
        model.addAttribute("listOfEmployee", employee);

        return"hr/department/infoDepartment";
    }
}
