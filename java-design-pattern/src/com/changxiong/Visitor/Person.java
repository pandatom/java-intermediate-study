package com.changxiong.Visitor;

public abstract class Person {

    String gender;

    // �ṩһ���������÷����߿��Է���
    public abstract void accept(Action action);

}

