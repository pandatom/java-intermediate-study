package com.changxiong.Decorate;

//��װ����
public abstract class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}

