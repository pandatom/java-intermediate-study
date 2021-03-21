package com.changxiong.newFunction;

import org.junit.Test;

import java.util.Optional;

/**
 * @author changxiong
 * @create 2020-12-16-6:51 PM
 */
public class OperatorTest {

    @Test
    public void test1() {
      //optional.of(T t) 创建一个实列， t必须为空
        Girl girl = new Girl();
        girl=null;
        Optional<Girl> girl1 = Optional.of(girl);
        System.out.println(girl1);
    }

    @Test
    public void test2() {
      //optional.of(T t) 创建一个实列， t必须为空
        Girl girl = new Girl();
        girl=null;
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);
    }

    @Test
    public void test3() {
      //optional.of(T t) 创建一个实列， t必须为空
        Girl girl = new Girl();
        girl=null;
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);

        Girl mylove = girl1.orElse(new Girl("欧阳娜娜"));
        System.out.println(mylove);
        
    }


}
