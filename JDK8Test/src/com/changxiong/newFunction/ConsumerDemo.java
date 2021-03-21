package com.changxiong.newFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author changxiong
 * @create 2020-12-14-7:07 PM
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String>  c1=s-> System.out.println(s);
        c1.accept("aaaaaa");



        System.out.println("===BiConsumer”√∑®=======");

        BiConsumer<String,String> c2=(s1,s2)-> System.out.println(s1+s2);
        c2.accept("aaa","bbb");

        System.out.println();

        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.forEach((k, v) -> {
            System.out.print(k +" £∫");
            System.out.println(v);

        });

    }
}
