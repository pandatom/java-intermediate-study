package com.changxiong.Visitor;

//˵��
//1. ��������ʹ�õ���˫����, �������ڿͻ��˳����У�������״̬��Ϊ��������Man��(��һ�η���)
//2. Ȼ��Man �������Ϊ������ "���巽��" �з���getResult, ͬʱ���Լ�(this)��Ϊ�������룬��ɵڶ��εķ���
public class Man extends Person {

    public Man() {
        gender = "����";
    }

    @Override
    public void accept(Action action) {
        action.getResult(this);
    }

}

