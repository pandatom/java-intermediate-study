package com.changxiong.Factory.simpleFactory;

//�൱��һ���ͻ��ˣ���������
public class PizzaStore {

    public static void main(String[] args) {
        // ʹ�ü򵥹���ģʽ
        new OrderPizza(new simpleFactory());
        System.out.println("~~�˳�����~~");
    }

}

