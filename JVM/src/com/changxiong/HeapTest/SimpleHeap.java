package com.changxiong.HeapTest;

/**
 * @author changxiong
 * @create 2020-12-19-1:31 PM
 */
public class SimpleHeap {
    private int id;//���ԡ���Ա����

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void show() {
        System.out.println("My ID is " + id);
    }

    public static void main(String[] args) {
        SimpleHeap sl = new SimpleHeap(1);
        SimpleHeap s2 = new SimpleHeap(2);
        int[] arr = new int[10];
        Object[] arr1 = new Object[10];
    }
}

