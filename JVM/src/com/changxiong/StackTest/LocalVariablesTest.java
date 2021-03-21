package com.changxiong.StackTest;

import java.util.Date;

/**
 * @author changxiong
 * @create 2020-12-18-3:15 PM
 */
public class LocalVariablesTest {
    private int count = 0;

//    public static void main(String[] args) {
//        LocalVariablesTest test = new LocalVariablesTest();
//        int num = 10;
//        test.test1();
//    }

    public static void main(String[] args) {
        if(args == null){
            LocalVariablesTest test = new LocalVariablesTest();
        }
        int num = 10;
    }

    public void test1() {
        Date date = new Date();
        String name1 = "atguigu.com";
        test2(date, name1);
        System.out.println(date + name1);
    }

    public String test2(Date dateP, String name2) {
        dateP = null;
        name2 = "songhongkang";
        double weight = 130.5;//占据两个slot
        char gender = '男';
        return dateP + name2;
    }

    //slot的 重用 局部变量 c 重用了局部变量 b 的 slot 位置
    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //变量c使用之前已经销毁的变量b占据的slot的位置
        int c = a + 1;
    }

    public void testAddOperation() {
        //byte、short、char、boolean：都以int型来保存
        byte i = 15;
        int j = 8;
        int k = i + j;
    }
}

