package com.changxiong.Factory.simpleFactory;

import java.util.function.Consumer;

public abstract class Pizza {

    private String name;

    public abstract void prepare();


    // �濾
    public void bake() {
        System.out.println(name + " baking;");
    }

    // �и�
    public void cut() {
        System.out.println(name + " cutting;");
    }

    //���
    public void box() {
        System.out.println(name + " boxing;");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
