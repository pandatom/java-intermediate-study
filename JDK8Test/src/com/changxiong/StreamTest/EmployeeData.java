package com.changxiong.StreamTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changxiong
 * @create 2020-12-15-2:41 PM
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee("1001","小明",40,100));
        list.add(new Employee("1002","小白",50,101));
        list.add(new Employee("1003","小黑",60,102));
        list.add(new Employee("1004","虎妹",70,103));
        list.add(new Employee("1005","卡喵",80,104));
        list.add(new Employee("1006","花花",90,105));
        list.add(new Employee("1007","小咕噜",120,106));
        list.add(new Employee("1008","小憨包",130,107));
        list.add(new Employee("1009","白居居",140,109));

        return list;
    }
}
