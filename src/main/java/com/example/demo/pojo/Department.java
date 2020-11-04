package com.example.demo.pojo;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//部门表

public class Department {
    private Integer id;
    private String departmentName;


    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

}
