package com.changxiong.Factory.MethodFactory;

public class PizzaStore {

    public static void main(String[] args) {
        String loc = "bj"; // �����������û������λ����Ϣ
        if (loc.equals("bj")) {
            // ����������ζ�ĸ���Pizza
            new BJOrderPizza();
        } else {
            // �����׶ؿ�ζ�ĸ���Pizza
            new LDOrderPizza();
        }
    }

}
