package com.changxiong.Strategy;

public class PekingDuck extends Duck {

    // ���籱��Ѽ���Է��裬���Ƿ��輼��һ��
    public PekingDuck() {
        flyBehavior = new BadFlyBehavior();
        quackBehavior = new GaGaQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("~~����Ѽ~~~");
    }

}

