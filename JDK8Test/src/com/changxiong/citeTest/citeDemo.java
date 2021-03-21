package com.changxiong.citeTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author changxiong
 * @create 2020-12-14-9:07 PM
 *
 * 引用模式
 */
public class citeDemo {
    public static void main(String[] args) {
        Consumer<String> consumer=c-> System.out.println(c);
        consumer.accept("aaa");

        System.out.println();

        Consumer<String> c1=System.out::println;
        c1.accept("aaaa");
    }


    @Test
    public void demo(){
        Employee emp1 = new Employee("123", "tom", 10, 100);

        Supplier<String> s=()->emp1.getName();

        System.out.println(s.get());

        System.out.println();

        Supplier<String> s1=emp1 :: getName;

        System.out.println(s1.get());
    }

    //传两个参数
    @Test
    public void demo1() {
        Comparator<Integer> c = (c1, c2) -> c1.compareTo(c2);
        System.out.println(c.compare(10,11));

        System.out.println();

        Comparator<Integer> comparator= Integer::compareTo;
        System.out.println(comparator.compare(10, 11));
    }

    @Test
    public void demo2() {
        Function<String,Integer> f1=s->s.length();

        System.out.println(f1.apply("aaaa"));

        System.out.println();

        Function<String,Integer> f2= String :: length;
        System.out.println(f2.apply("ssss"));

        System.out.println();

        Function<Double, Double> f3 = s -> Math.floor(s);
        System.out.println(f3.apply(3.5));

        System.out.println();

        Function<Double,Double> f4=Math::floor;

        System.out.println(f4.apply(5.5));

    }

    @Test
    public void demo3() {
        BiPredicate<String,String> p=(s1,s2)->s1.equals(s2);
        System.out.println(p.test("aa", "bb"));

        System.out.println();
        BiPredicate<String,String> p1=String::equals;
        System.out.println(p1.test("aa", "bb"));


    }
}
