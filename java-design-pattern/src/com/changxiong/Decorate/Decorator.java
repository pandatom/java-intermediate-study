package com.changxiong.Decorate;

// װ����
public class Decorator extends Drink {

    private Drink obj; // �ۺ�һ����Ʒ���ȣ���װ���ߣ�

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        // super.getPrice����ζƷ��װ���ߣ��ļ۸�
        // obj.cost()����Ʒ���ȣ���װ���ߣ��ļ۸�
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        // des����ζƷ��װ���ߣ���������Ϣ
        // getPrice()����ζƷ��װ���ߣ��ļ۸�
        // obj.getDes()����Ʒ���ȣ���װ���ߣ�����Ϣ
        return des + " " + getPrice() + " && " + obj.getDes();
    }

}

