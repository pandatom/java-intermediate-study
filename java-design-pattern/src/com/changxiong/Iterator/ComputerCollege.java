package com.changxiong.Iterator;

import java.util.Iterator;

public class ComputerCollege implements College {

    Department[] departments;
    int numOfDepartment = 0;// ���浱ǰ����Ķ������

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("Javaרҵ", " Javaרҵ ");
        addDepartment("PHPרҵ", " PHPרҵ ");
        addDepartment("������רҵ", " ������רҵ ");
        numOfDepartment = 3;
    }

    @Override
    public String getName() {
        return "�����ѧԺ";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartment] = department;
        numOfDepartment += 1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }

}

