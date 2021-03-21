package com.changxiong.SingletonPattern;

/**
 * ����ʽ����̬����飩�Ĵ���ʵ��
 */
public class SingletonTest02 {

    public static void main(String[] args) {
        // ����
        Singleton02 instance = Singleton02.getInstance();
        Singleton02 instance2 = Singleton02.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

//����ʽ(��̬����)
class Singleton02 {

    // 1. ������˽�л�, �ⲿ����new
    private Singleton02() {

    }

    // 2.�����ڲ���������ʵ��
    private static Singleton02 instance;

    static { // �ھ�̬������У������������� ��������ļ��ض�ִ�У�����ִֻ��һ�Σ�
        instance = new Singleton02();
    }

    // 3. �ṩһ�����еľ�̬����������ʵ������
    public static Singleton02 getInstance() {
        return instance;
    }

}

