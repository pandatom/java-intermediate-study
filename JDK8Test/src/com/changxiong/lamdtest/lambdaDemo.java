package com.changxiong.lamdtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Lambda表达式的使用
 * 1.举例：（o1,o2）->Interger.compare(o1,o2)
 * 2.格式：
 *      -> : lambda操作符 或者 箭头操作符
 *      -> : lambda形参列表（其实就是接口中的抽象方法的形参）
 *      -> : lambda体（其实就是重写方法的方法体）
 */
public class lambdaDemo {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个测试");
            }
        };
        r1.run();

        System.out.println("=========================");

        Runnable r2=()-> System.out.println("这是一个lambda测试");
        r2.run();
    }

    //无参 无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个测试");
            }
        };
        r1.run();

        System.out.println("=========================");

        Runnable r2=()-> System.out.println("这是一个lambda测试");
        r2.run();
    }

    //需要参数，但是没有返回值
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("这个 想法 可以讲 歪瑞 棒！！！");

        System.out.println("=======================");

        Consumer<String> con2=(String s)->{
            System.out.println(s);
        };

        con2.accept("用上lambda可以讲真的歪瑞good");
    }

    @Test
    public void test3() {
        Consumer<String> con=(String s)->{
            System.out.println(s);
        };
        con.accept("hhehehehhe");

        System.out.println("=========================");

        Consumer<String> con1=s -> System.out.println(s);

        con1.accept("hahahahaha");
    }

    @Test
    public void test4() {
        Comparator<Integer> comparable= (o1,o2)->{return o1.compareTo(o2);};

        System.out.println(comparable.compare(12,10));

        System.out.println("=====================");

        Comparator<Integer> comparator1=(o1,o2)->o1.compareTo(o2);

        System.out.println(comparator1.compare(12,10));
    }

    @Test
    public void test5() {
        happTime(500, new Consumer<Double>() {

            @Override
            public void accept(Double v) {
                System.out.println("你真是一个歪瑞good 的人"+v);
            }
        });

        System.out.println("===========================");

        happTime(400,money-> System.out.println("你真是一个歪瑞good 的人"+money));
    }

    public void happTime(double money,Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test6() {
        List<String> list = Arrays.asList("北京", "上海","天津","东京","西京","普京");

        List<String> filter1 = FilterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filter1);

        System.out.println("=================================");

        List<String> filter2 = FilterString(list, s -> s.contains("京"));

        System.out.println(filter2);

    }

    public List<String> FilterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterString = new ArrayList<>();

        for (String s : list){
            if (pre.test(s)){
                filterString.add(s);
            }
        }
        return filterString;
    }
}
