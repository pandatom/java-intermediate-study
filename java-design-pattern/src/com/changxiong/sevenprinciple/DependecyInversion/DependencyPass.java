package com.changxiong.sevenprinciple.DependecyInversion;

public class DependencyPass {

    public static void main(String[] args) {
        // ͨ��������������������
        ChangHong changHong = new ChangHong();
        OpenAndClose openAndClose = new OpenAndClose(changHong);
        openAndClose.open();
    }

}

// ��ʽ2: ͨ�����췽����������
interface IOpenAndClose {
    public void open(); // ���󷽷�
}

interface ITV { // ITV�ӿ�
    public void play();
}

// ������ӣ�ʵ�� ITV �ӿ�
class ChangHong implements ITV {
    @Override
    public void play() {
        System.out.println("������ӻ�����");
    }
}

class OpenAndClose implements IOpenAndClose {
    public ITV tv; // ��Ա����

    public OpenAndClose(ITV tv) { // ͨ��������ע��ʵ���� ITV �ӿڵĶ���
        this.tv = tv;
    }

    public void open() {
        this.tv.play();
    }
}


