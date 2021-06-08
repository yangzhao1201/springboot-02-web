package com.yang.controller;

import com.yang.dao.DepartmentDao;
import com.yang.dao.EmployeeDao;
import com.yang.pojo.Department;
import com.yang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author TangYuan
 * @create 2021--06--07--00:33
 * @description
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAllEmployee();
        model.addAttribute("emps",employees);
        return "list";
    }

    @RequestMapping("/toAdd")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "add";
    }

    @RequestMapping("/addEmp")
    public String addEmp(Employee employee){
        employeeDao.add(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "update";
    }
    @RequestMapping("/updateEmp")
    public String UpdatePage(Employee employee){
        employeeDao.add(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.deleteEmployeeById(id);
        return "redirect:/emps";
    }

}
