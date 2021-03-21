package com.changxiong.SingletonPattern;

/**
 * ����ʽ���̲߳���ȫ���ľ���ʵ�ֲ���
 *
 * ������˽�л����ⲿ���� new
 * �ڱ����ڲ��� getInstance() ��̬�����У��жϵ��������Ƿ�Ϊ��
 * ���Ϊ�գ��򴴽��������󲢷���
 * �����Ϊ�գ���ֱ�ӷ��ش˶���
 */
public class SingletonTest03 {

    public static void main(String[] args) {
        System.out.println("����ʽ1 �� �̲߳���ȫ~");
        Singleton03 instance = Singleton03.getInstance();
        Singleton03 instance2 = Singleton03.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

class Singleton03 {
    private static Singleton03 instance;

    private Singleton03() {
    }

    // �ṩһ����̬�Ĺ��з�������ʹ�õ��÷���ʱ����ȥ���� instance
    // ������ʽ
    public static Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}


/*
// ����ʽ(�̰߳�ȫ��ͬ������)
/**
����ʽ��ͬ������������ȱ��˵��

������̰߳�ȫ����
Ч��̫���ˣ� ÿ���߳����������ʵ��ʱ�� ִ�� getInstance() ������Ҫ����ͬ����
����ʵ�������ִֻ��һ��ʵ��������͹��ˣ� ��������ø���ʵ���� ֱ�� return �����ˡ� ��������ͬ��Ч��̫��
���ۣ� ��ʵ�ʿ����У� ���Ƽ�ʹ�����ַ�ʽ
*/
/*
class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    // �ṩһ����̬�Ĺ��з���������ͬ������Ĵ��룬����̰߳�ȫ����
    // ������ʽ
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}*/


//����ʽ��ͬ������飩
/**
 * ����ʽ��ͬ������飩�ľ���ʵ�ֲ���
 *
 * ������˽�л����ⲿ���� new
 * �ڱ����ڲ��� getInstance() ��̬�����У����ж϶����Ƿ�Ϊ��
 * ���Ϊ�գ�����������������󣬲�����
 * �����Ϊ�գ���ֱ�ӷ��ش˶���
 */
/*class Singleton{
    private static Singleton singleton;
    private Singleton(){
    }

    public static singleton getInstance(){
        if(singleton==null){
            synchronized(Singleton. class){
                singleton=new Singleton();
            }
        }
    }
    return singleton;
}*/
