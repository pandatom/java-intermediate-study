package com.changxiong.Factory.nonFactory;

//��Pizza �����ɳ���
public abstract class Pizza {

    protected String name; //����

    public void setName(String name) {
        this.name = name;
    }

    //׼��ԭ����, ��ͬ��������һ������ˣ��������ɳ��󷽷�
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

}

