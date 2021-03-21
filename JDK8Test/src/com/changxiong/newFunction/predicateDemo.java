package com.changxiong.newFunction;

import java.util.function.Predicate;

/**
 * @author changxiong
 * @create 2020-12-14-6:19 PM
 *
 *
 * predicate 断言的意思
 * 功能传入值做判断，返回Boolean值
 */
public class predicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicateInt = x -> x > 10;
        Predicate<String> predicateStr = r -> r.length() > 10;
        System.out.println("第一个Predicate的测试，测试数值是否大于10，结果为：" + predicateInt.test(11));
        System.out.println("第二个Predicate的测试，测试字符串的长度是否大于10，结果为：" + predicateStr.test("test"));
        System.out.println("第一个Predicate的【negate方法】测试，测试数值是否大于10，结果为：" + predicateInt.negate().test(11));
        System.out.println("第二个Predicate的【negate方法】测试，测试字符串的长度是否大于10，结果为：" + predicateStr.negate().test("test"));
    }

}
