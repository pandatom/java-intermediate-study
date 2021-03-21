package com.changxiong.newFunction;

import java.util.function.Predicate;

/**
 * @author changxiong
 * @create 2020-12-14-6:19 PM
 *
 *
 * predicate ���Ե���˼
 * ���ܴ���ֵ���жϣ�����Booleanֵ
 */
public class predicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicateInt = x -> x > 10;
        Predicate<String> predicateStr = r -> r.length() > 10;
        System.out.println("��һ��Predicate�Ĳ��ԣ�������ֵ�Ƿ����10�����Ϊ��" + predicateInt.test(11));
        System.out.println("�ڶ���Predicate�Ĳ��ԣ������ַ����ĳ����Ƿ����10�����Ϊ��" + predicateStr.test("test"));
        System.out.println("��һ��Predicate�ġ�negate���������ԣ�������ֵ�Ƿ����10�����Ϊ��" + predicateInt.negate().test(11));
        System.out.println("�ڶ���Predicate�ġ�negate���������ԣ������ַ����ĳ����Ƿ����10�����Ϊ��" + predicateStr.negate().test("test"));
    }

}
