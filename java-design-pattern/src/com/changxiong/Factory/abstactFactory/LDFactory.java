package com.changxiong.Factory.abstactFactory;

public class LDFactory implements abFactory  {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~ʹ�õ��ǳ��󹤳�ģʽ~");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}


