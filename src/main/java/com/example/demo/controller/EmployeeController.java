package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";//本地文件夹路径
    }

    @GetMapping("/emp")//get
    public String toAddPage(Model model) {//1109 添加员工
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/employee")//post
    public String addEmp(Employee employee) {//1109 添加员工
        //添加的操作
        System.out.println("save=>");
        employeeDao.save(employee);//调用底层业务方法保存员工信息
        return "redirect:/emps";
    }

    //员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpodateEmp(@PathVariable("id")Integer id,Model model){
        Employee employeeById = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employeeById);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";

    }
}
