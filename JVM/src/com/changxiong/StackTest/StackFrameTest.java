package com.changxiong.StackTest;

/**
 * @author changxiong
 * @create 2020-12-18-12:12 PM
 */
public class StackFrameTest {
    public static void main(String[] args) {
        StackFrameTest test = new StackFrameTest();
        test.method1();
    }

    public void method1() {
        System.out.println("method1()��ʼִ��...");
        method2();
        System.out.println("method1()ִ�н���...");
    }

    public int method2() {
        System.out.println("method2()��ʼִ��...");
        int i = 10;
        int m = (int) method3();
        System.out.println("method2()��������...");
        return i + m;
    }

    public double method3() {
        System.out.println("method3()��ʼִ��...");
        double j = 20.0;
        System.out.println("method3()��������...");
        return j;
    }
}

