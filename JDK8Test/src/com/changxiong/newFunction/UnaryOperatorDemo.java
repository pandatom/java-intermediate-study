package com.changxiong.newFunction;

import java.util.function.UnaryOperator;

/**
 * @author changxiong
 * @create 2020-12-14-7:45 PM
 */
public class UnaryOperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<Integer> dda = x -> x + 1;
        System.out.println(dda.apply(10));// 11
        UnaryOperator<String> ddb = x -> x + 1;
        System.out.println(ddb.apply("aa"));// aa1
    }
}
