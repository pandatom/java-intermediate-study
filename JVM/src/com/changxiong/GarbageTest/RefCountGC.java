package com.changxiong.GarbageTest;

/**
 * -XX:+PrintGCDetails
 * ֤����javaʹ�õĲ������ü����㷨
 *
 * @author shkstart
 * @create 2020 ���� 2:38
 */
public class RefCountGC {
    //�����Ա����Ψһ�����þ���ռ��һ���ڴ�
    private byte[] bigSize = new byte[5 * 1024 * 1024];//5MB

    Object reference = null;

    public static void main(String[] args) {
        RefCountGC obj1 = new RefCountGC();
        RefCountGC obj2 = new RefCountGC();

        obj1.reference = obj2;
        obj2.reference = obj1;

        obj1 = null;
        obj2 = null;

        //��ʽ��ִ������������Ϊ�����﷢��GC��obj1��obj2�ܷ񱻻��գ�

//        System.gc();
    }
}
