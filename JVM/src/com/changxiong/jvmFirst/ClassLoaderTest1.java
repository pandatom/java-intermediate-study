package com.changxiong.jvmFirst;

import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest1 {
    public static void main(String[] args) {

        System.out.println("**********�����������**************");
        //��ȡBootstrapClassLoader�ܹ����ص�api��·��
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }
        //�������·��������ѡ��һ����,�������������������ʲô:�����������
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);//null

        System.out.println("***********��չ�������*************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

        //�������·��������ѡ��һ����,�������������������ʲô:��չ�������
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@1540e19d

    }
}

