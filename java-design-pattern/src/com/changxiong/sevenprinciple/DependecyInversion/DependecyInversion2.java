package com.changxiong.sevenprinciple.DependecyInversion;

public class DependecyInversion2 {

    public static void main(String[] args) {
        // �ͻ�������ı�
        Person2 person = new Person2();
        person.receive(new Email2());
        person.receive(new WeiXin2());
    }

}

//����ӿ�
interface IReceiver {
    public String getInfo();
}

class Email2 implements IReceiver {
    public String getInfo() {
        return "�����ʼ���Ϣ: hello,world";
    }
}

//����΢��
class WeiXin2 implements IReceiver {
    public String getInfo() {
        return "΢����Ϣ: hello,ok";
    }
}

//��ʽ2
class Person2 {
    // ���������ǶԽӿڵ�����
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}


