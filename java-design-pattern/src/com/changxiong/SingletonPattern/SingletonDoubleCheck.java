package com.changxiong.SingletonPattern;

/**
 * ����ʽ��˫�ؼ�飩�ľ���ʵ�ֲ���
 *
 * ������˽�л����ⲿ���� new
 * �ڱ����ڲ��� getInstance() ��̬�����У����ж϶����Ƿ�Ϊ��
 * ���Ϊ�գ����ȼ��������жϴ˵��������Ƿ�Ϊ�գ������Ϊ�գ��Ŵ�������
 * �����Ϊ�գ���ֱ�ӷ��ش˶���
 * ע�⣺����������Ҫʹ�� volatile �ؼ��ֽ������Σ���֤�ڴ�ɼ��ԣ��Լ���ָֹ��������
 */
public class SingletonDoubleCheck {
    public static void main(String[] args) {
        System.out.println("˫�ؼ��");
        Singleton04 instance = Singleton04.getInstance();
        Singleton04 instance2 = Singleton04.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}


// ����ʽ(�̰߳�ȫ��ͬ������)
class Singleton04 {
    private static volatile Singleton04 instance;//volatile�ؼ�����Ҫ�Ǳ����ڶ���̼߳�ɼ���

    private Singleton04() {
    }

    // �ṩһ����̬�Ĺ��з���������˫�ؼ����룬����̰߳�ȫ����, ͬʱ�������������
    // ͬʱ��֤��Ч��, �Ƽ�ʹ��
    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            synchronized (Singleton04.class) {
                if (instance == null) {
                    instance = new Singleton04();
                }
            }

        }
        return instance;
    }
}