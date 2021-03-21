package com.changxiong.newFunction;

import java.util.function.Supplier;

/**
 * @author changxiong
 * @create 2020-12-14-9:18 PM
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> str = new Supplier<String>() {
            @Override
            public String get() {
                return new String("ssss");
            }
        };

        System.out.println(str.get());

        System.out.println("=============================");

        Supplier<String> s=()->new String("ssss");
        System.out.println(str.get());

        System.out.println("=============================");

        Supplier<String> s2=String :: new;
        System.out.println(s2.get());

    }
}
