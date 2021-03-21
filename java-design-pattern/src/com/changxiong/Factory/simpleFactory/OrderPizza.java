package com.changxiong.Factory.simpleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    private simpleFactory spFactory;
    Pizza pizza = null;

    public OrderPizza(simpleFactory  spFactory) {
        setFactory(spFactory);
    }

    public void setFactory(simpleFactory spFactory) {
        String orderType = ""; // �û������
        this.spFactory = spFactory; // ���ü򵥹�������
        do {
            orderType = getType();
            pizza = this.spFactory.createfactory(orderType);
            // ���pizza
            if (pizza != null) { // �����ɹ�
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
                System.out.println();
            } else {
                System.out.println("��������ʧ��");
                break;
            }
        } while (true);
    }

    // дһ�����������Ի�ȡ�ͻ�ϣ����������������
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza ����:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
