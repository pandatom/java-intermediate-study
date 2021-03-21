package com.changxiong.newFunction;

import java.util.function.Function;

/**
 * @author changxiong
 * @create 2020-12-14-7:58 PM
 *
 * Funtion接口，定义了一个apply的抽象方法，接收一个泛型T对象，并且返回泛型R对象
 */
public class FunctionDemo {
    public static void main(String[] args) {
        Function<String,Integer> f1=s->s.length();
        Integer sdfsdlkf = f1.apply("sdfsdlkf");
        System.out.println(sdfsdlkf);

        Function<Integer, Integer> f2 = x -> x * 2;
        System.out.println(f2.apply(4));// 8

        Function<Integer, String> function2 = x -> x * 2 + "dd";
        System.out.println(function2.apply(4));//8dd

        Function<String, String> strFunction1 = (str) -> new String(str);
        System.out.println(strFunction1.apply("aa"));//aa

        Function<String, String> strFunction2 = String::new;
        System.out.println(strFunction2.apply("bb"));//bb

        Function<String, Emp> objFunction1 = (str) -> new Emp(str);
        System.out.println(objFunction1.apply("cc").getName());//cc

        Function<String, Emp> objFunction2 = Emp::new;
        System.out.println(objFunction2.apply("dd").getName());//dd
    }
}
