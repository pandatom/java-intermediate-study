package com.changxiong.Strategy;

public class WildDuck extends Duck {

    // ������������FlyBehavior �� QuackBehavior �Ķ���
    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
        quackBehavior = new GeGeQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println(" ����ҰѼ ");
    }

}

