package com.yang.dao;

import com.yang.pojo.Department;
import com.yang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TangYuan
 * @create 2021--06--06--18:23
 * @description
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"tangyuan","tangyuan@gmail.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"niuniu","niuniu@gmail.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"yz","yz@gmail.com",1,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"laifu","laifu@gmail.com",0,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"yanglamu","yanglamu@gmail.com",1,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initId = 1006;

    //增加员工
    public void add(Employee employee){

        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工
    public Collection<Employee> getAllEmployee(){
        return employees.values();
    }

    //通过id得到员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }

}
