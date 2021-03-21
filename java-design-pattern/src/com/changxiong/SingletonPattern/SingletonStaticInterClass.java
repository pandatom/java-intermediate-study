package com.changxiong.SingletonPattern;

/**
 * ����ʽ����̬�ڲ��ࣩ
 * ����ʽ����̬�ڲ��ࣩ�ľ���ʵ�ֲ���
 *
 * ������˽�л����ⲿ���� new
 * �ڱ����ڲ�����һ����̬�ڲ��࣬��װһ��������������ʵ�ֵ���ģʽ
 * ��̬�ڲ����ʵ�ַ�ʽ��������������ص�ͬ�����ƣ���֤����������̰߳�ȫ��
 * ���Ҹ÷�ʽ�ܱ�֤�õ�������������ػ��ƣ���Ϊֻ���õ���̬�ڲ���ʱ���Ż���ظþ�̬�ڲ����Լ���������
 * �ڱ����ڲ��ṩһ����̬���� getInstance() ���ڷ��ؾ�̬�ڲ����еĵ�������
 */
public class SingletonStaticInterClass {
    public static void main(String[] args) {
        System.out.println("ʹ�þ�̬�ڲ�����ɵ���ģʽ");
        Singleton5 instance = Singleton5.getInstance();
        Singleton5 instance2 = Singleton5.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}


// ��̬�ڲ�����ɣ� �Ƽ�ʹ��
class Singleton5 {
    //������˽�л�
    private Singleton5() {}

    //дһ����̬�ڲ���,��������һ����̬���� Singleton

    /**
     * �ڲ�����ص�:
     *
     * ���ڲ����п���ֱ�ӷ����ⲿ��ĳ�Ա,����˽�еĳ�Ա
     * ���ⲿ���в���ֱ�ӷ����ڲ���ĳ�Ա,����ͨ�������ڲ���Ķ����������ڲ����Ա
     *
     * ��̬�ڲ��෽ʽ��Singleton�౻װ��ʱ����������ʵ��������������Ҫʵ����ʱ������getInstance()������
     * �Ż�װ��SingletonInstance�࣬�Ӷ����Singleton��ʵ������
     * ��ľ�̬����ֻ���ڵ�һ�μ������ʱ���ʼ������������� JVM�������Ǳ�֤���̵߳İ�ȫ�ԣ�������г�ʼ��ʱ��
     * ����߳����޷������
     */
    private static class SingletonInstance {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    //�ṩһ����̬�Ĺ��з�����ֱ�ӷ���SingletonInstance.INSTANCE
    public static Singleton5 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}