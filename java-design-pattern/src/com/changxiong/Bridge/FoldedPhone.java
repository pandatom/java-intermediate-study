package com.changxiong.Bridge;

//�۵�ʽ�ֻ��࣬�̳� ������ Phone
public class FoldedPhone extends Phone {

    // ������
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println(" �۵���ʽ�ֻ� ");
    }

    @Override
    public void close() {
        super.close();
        System.out.println(" �۵���ʽ�ֻ� ");
    }

    @Override
    public void call() {
        super.call();
        System.out.println(" �۵���ʽ�ֻ� ");
    }

}
