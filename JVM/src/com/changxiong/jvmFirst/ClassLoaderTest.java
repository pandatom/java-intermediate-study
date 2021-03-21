package com.changxiong.jvmFirst;

public class ClassLoaderTest {
    public static void main(String[] args) {

        //��ȡϵͳ�������
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //��ȡ���ϲ㣺��չ�������
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@1540e19d

        //��ȡ���ϲ㣺��ȡ���������������
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);//null

        //�����û��Զ�������˵��Ĭ��ʹ��ϵͳ����������м���
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //String��ʹ����������������м��صġ�---> Java�ĺ�����ⶼ��ʹ����������������м��صġ�
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);//null

    }
}

