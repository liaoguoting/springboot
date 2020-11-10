package com.example.demo.dao;

import com.example.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {
    //模拟数据库数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    //    获取所有部门信息
    /*
     要操作一个对象容易，如果需要存储多个对象，则需要一个容器，存储多个对象可以使用数组，
     但是数组的长度是不可变的。所以有了集合的概念。Collection 集合，就是为了方便操作处理对象而诞生的。*/
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    //    通过id得到部门
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
