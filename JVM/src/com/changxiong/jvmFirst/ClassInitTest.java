package com.changxiong.jvmFirst;

public class ClassInitTest {
    private static int num = 1;
    private static int number = 10;      //linking֮prepare: number = 0 --> initial: 10 --> 20

    static {
        num = 2;
        number = 20;
        System.out.println(num);
        //System.out.println(number);    //�����Ƿ���ǰ�����ã����Ը�ֵ�������ܵ��ã�
    }

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);//2
        System.out.println(ClassInitTest.number);//10
    }
}

