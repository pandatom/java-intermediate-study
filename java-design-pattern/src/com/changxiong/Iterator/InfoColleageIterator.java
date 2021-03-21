package com.changxiong.Iterator;

import java.util.Iterator;
import java.util.List;

public class InfoColleageIterator implements Iterator {

    List<Department> departmentList; // ��Ϣ����ѧԺ����List��ʽ���ϵ
    int index = -1;// ����

    public InfoColleageIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    // �ж�list�л���û����һ��Ԫ��
    @Override
    public boolean hasNext() {
        if (index >= departmentList.size() - 1) {
            return false;
        } else {
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    // ��ʵ��remove
    @Override
    public void remove() {

    }

}

