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

        list.add(new Employee("1001","С��",40,100));
        list.add(new Employee("1002","С��",50,101));
        list.add(new Employee("1003","С��",60,102));
        list.add(new Employee("1004","����",70,103));
        list.add(new Employee("1005","����",80,104));
        list.add(new Employee("1006","����",90,105));
        list.add(new Employee("1007","С����",120,106));
        list.add(new Employee("1008","С����",130,107));
        list.add(new Employee("1009","�׾Ӿ�",140,109));

        return list;
    }
}
