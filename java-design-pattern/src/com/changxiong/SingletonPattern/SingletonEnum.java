package com.changxiong.SingletonPattern;

public class SingletonEnum {
    public static void main(String[] args) {
        Singleton6 instance = Singleton6.INSTANCE;
        Singleton6 instance2 = Singleton6.INSTANCE;
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

        instance.sayOK();


    }
}


//ʹ��ö�٣�����ʵ�ֵ���, �Ƽ�
enum Singleton6 {
    INSTANCE; // ����

    public void sayOK() {
        System.out.println("ok~");
    }
}