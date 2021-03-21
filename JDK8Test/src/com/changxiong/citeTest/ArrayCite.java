package com.changxiong.citeTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author changxiong
 * @create 2020-12-15-10:09 AM
 *
 * 数组引用
 */
public class ArrayCite {

    @Test
    public void test1() {
        Supplier<Employee> e1 = () -> new Employee("1","xiaoming",10,100);

        System.out.println(e1.get().getName());

        System.out.println();

        Supplier<Employee> e2=Employee :: new;
        System.out.println(e2.get());

    }

    @Test
    public void test2() {
        Function<String,Employee> f1=id->new Employee(id);
        Employee apply = f1.apply("10");

        System.out.println(apply.getId());

        System.out.println();

        Function<String,Employee> f2= Employee::new;
        Employee apply1 = f2.apply("10");

        System.out.println(apply1.getId());
    }

    @Test
    public void test3() {
        BiFunction<String, String, Employee> f1 = (id, name) -> new Employee(id, name);
        System.out.println(f1.apply("10","tom").getId());

        System.out.println();

        BiFunction<String, String, Employee> f2=Employee::new;
        System.out.println(f2.apply("12","jack").getName());

    }

    @Test
    public void test4() {
        Function<Integer, String[]> f1 = length -> new String[length];
        System.out.println(Arrays.toString(f1.apply(10)));

        System.out.println();

        Function<Integer,String[]> f2=String[]::new;
        System.out.println(Arrays.toString(f2.apply(5)));
    }

}
