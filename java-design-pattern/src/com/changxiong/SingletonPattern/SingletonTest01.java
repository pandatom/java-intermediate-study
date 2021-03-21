package com.changxiong.SingletonPattern;

public class SingletonTest01 {

    public static void main(String[] args) {
        // ����
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

//����ʽ(��̬����)
class Singleton {

    // 1. ������˽�л�, �ⲿ����new
    private Singleton() {

    }

    // 2.�����ڲ���������ʵ��
    //  ��̬���������еĶ������������ڴ���ֻ��һ�������������ҽ���������μ���ʱ�ᱻ��ʼ��
    //����һ��final����������ǻ����������͵ı�����������ֵһ���ڳ�ʼ��֮��㲻�ܸ��ģ�������������͵ı�����
       // ���ڶ����ʼ��֮��㲻��������ָ����һ������
    private final static Singleton instance = new Singleton();

    // 3. �ṩһ�����еľ�̬����������ʵ������
    public static Singleton getInstance() {
        return instance;
    }

}
