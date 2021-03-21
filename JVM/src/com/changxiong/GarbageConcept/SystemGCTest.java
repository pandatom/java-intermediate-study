package com.changxiong.GarbageConcept;

/**
 * @author shkstart  shkstart@126.com
 * @create 2020  14:49
 */
public class SystemGCTest {
    public static void main(String[] args) {
        new SystemGCTest();

        /*
            ����jvm������������ִ��gc,���ǲ�ȷ���Ƿ�����ִ��gc
            ��Runtime.getRuntime().gc();������һ����
         */
        //System.gc();

        // ǿ�Ƶ���ʹ�����õĶ����finalize()����
        System.runFinalization();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGCTest ��д��finalize()");
    }
}

