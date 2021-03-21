package com.changxiong.Factory.abstactFactory;

public class BJFactory implements abFactory {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~ʹ�õ��ǳ��󹤳�ģʽ~");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}

