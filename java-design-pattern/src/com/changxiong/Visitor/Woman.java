package com.changxiong.Visitor;

//˵��
//1. ��������ʹ�õ���˫����, �������ڿͻ��˳����У�������״̬��Ϊ��������Woman��(��һ�η���)
//2. Ȼ��Woman �������Ϊ������ "���巽��" �з���getResult, ͬʱ���Լ�(this)��Ϊ�������룬��ɵڶ��εķ���
public class Woman extends Person{

    public Woman() {
        gender = "Ů��";
    }

    @Override
    public void accept(Action action) {
        action.getResult(this);
    }

}


