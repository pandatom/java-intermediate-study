package com.changxiong.StringTable;

import org.junit.Test;

/**
 * @author changxiong
 * @create 2020-12-22-12:01 PM
 */
public class StringTest {

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    /**
     * str �����ݲ�û�б䣺��test ok�� λ���ַ����������е���һ�����򣨵�ַ����
     * ���и�ֵ������û���޸�ԭ�� str ָ������õ�����
     * @param args
     */
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }


    public void change(String str, char ch[]) {
        str = "test ok";
        System.out.println("---"+str);
        ch[0] = 'b';
    }

    /**
     * -XX:StringTableSize=1009
     *
     * @author shkstart  shkstart@126.com
     * @create 2020  23:53
     */
    @Test
    public void test4() {
        // ����StringTableSize����
        System.out.println("�����������");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    @Test
    public void test1() {
        String s1 = "abc";//����������ķ�ʽ��"abc"�洢���ַ�����������
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1 == s2);//�жϵ�ַ��false

        System.out.println(s1);//hello
        System.out.println(s2);//abc
    }

    @Test
    public void test2() {
        String s1 = "abc";
        String s2 = "abc";
        s2 += "def";
        System.out.println(s2);//abcdef
        System.out.println(s1);//abc
    }

    @Test
    public void test3() {
        String s1 = "abc";
        String s2 = s1.replace('a', 'm');
        System.out.println(s1);//abc
        System.out.println(s2);//mbc
    }

    @Test
    public void test5(){
        System.out.println();//2330
        System.out.println("1");//2331
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2340

        //���µ��ַ���"1" �� "10"�����ٴμ���
        System.out.println("1");//2341
        System.out.println("2");//2341
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2341
    }

    @Test
    public void test6() {
        String s1 = "a" + "b" + "c";//�������Ż�����ͬ��"abc"
        String s2 = "abc"; //"abc"һ���Ƿ����ַ����������У����˵�ַ����s2
        /*
         * ����.java�����.class,��ִ��.class
         * String s1 = "abc";
         * String s2 = "abc"
         */
        System.out.println(s1 == s2); //true
        System.out.println(s1.equals(s2)); //true
    }

    /**
     * ƴ��ǰ��ֻҪ������һ���Ǳ�����������ڶ���
     * ���� intern() ���������������ַ�����������ַ����������У��������ַ����
     */
    @Test
    public void test7(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";//�������Ż�

        //���ƴ�ӷ��ŵ�ǰ������˱��������൱���ڶѿռ���new String()�����������Ϊƴ�ӵĽ����javaEEhadoop
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        //intern():�ж��ַ������������Ƿ����javaEEhadoopֵ��������ڣ��򷵻س�������javaEEhadoop�ĵ�ַ��
        //����ַ����������в�����javaEEhadoop�����ڳ������м���һ��javaEEhadoop�������ش˶���ĵ�ַ��
        String s8 = s6.intern();
        System.out.println(s3 == s8);//true
    }

    @Test
    public void test8(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";//�������Ż�

        //���ƴ�ӷ��ŵ�ǰ������˱��������൱���ڶѿռ���new String()�����������Ϊƴ�ӵĽ����javaEEhadoop
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        //intern():�ж��ַ������������Ƿ����javaEEhadoopֵ��������ڣ��򷵻س�������javaEEhadoop�ĵ�ַ��
        //����ַ����������в�����javaEEhadoop�����ڳ������м���һ��javaEEhadoop�������ش˶���ĵ�ַ��
        String s8 = s6.intern();
        System.out.println(s3 == s8);//true
    }

        @Test
        public void test9(){
            String s1 = "a";
            String s2 = "b";
            String s3 = "ab";
            /*
            ���µ�s1 + s2 ��ִ��ϸ�ڣ�(����s������ʱ����ģ�
            �� StringBuilder s = new StringBuilder();
            �� s.append("a")
            �� s.append("b")
            �� s.toString()  --> Լ���� new String("ab")

            ���䣺��jdk5.0֮��ʹ�õ���StringBuilder,��jdk5.0֮ǰʹ�õ���StringBuffer
             */
            String s4 = s1 + s2;//"ab"
            System.out.println(s3 == s4);//false
        }

    /*
        1. �ַ���ƴ�Ӳ�����һ��ʹ�õ���StringBuilder!
        ���ƴ�ӷ����������߶����ַ��������������ã�����Ȼʹ�ñ������Ż�������StringBuilder�ķ�ʽ��
        2. �����final�����ࡢ�����������������͡������������͵����Ľṹʱ����ʹ����final��ʱ����ʹ���ϡ�
    */
    @Test
    public void test10(){
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);//true
    }

    //��ϰ��
    @Test
    public void test11(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);//false

        final String s4 = "javaEE";//s4:����
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);//true

    }


    /*
���ִ��Ч�ʣ�ͨ��StringBuilder��append()�ķ�ʽ����ַ�����Ч��ҪԶ����ʹ��String���ַ���ƴ�ӷ�ʽ��

����ԭ��
    �� StringBuilder��append()�ķ�ʽ��
        ��ʼ������ֻ������һ��StringBuilder�Ķ���
        ʹ��String���ַ���ƴ�ӷ�ʽ�����������StringBuilder��String�Ķ���
    �� ʹ��String���ַ���ƴ�ӷ�ʽ��
        �ڴ������ڴ����˽϶��StringBuilder��String�Ķ����ڴ�ռ�ø���
        �������GC����Ҫ���Ѷ����ʱ�䡣

 �Ľ��Ŀռ䣺
    ��ʵ�ʿ����У��������ȷ��Ҫǰǰ�����ӵ��ַ������Ȳ�����ĳ���޶�ֵhighLevel�������,����ʹ�ù�����ʵ������
    StringBuilder s = new StringBuilder(highLevel);//new char[highLevel]
 */
    @Test
    public void test12(){

        long start = System.currentTimeMillis();

        // method1(100000);//4014
        method2(100000);//7

        long end = System.currentTimeMillis();

        System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));
    }

    public void method1(int highLevel){
        String src = "";
        for(int i = 0;i < highLevel;i++){
            src = src + "a";//ÿ��ѭ�����ᴴ��һ��StringBuilder��String
        }
    }

    public void method2(int highLevel){
        //ֻ��Ҫ����һ��StringBuilder
        StringBuilder src = new StringBuilder();
        for (int i = 0; i < highLevel; i++) {
            src.append("a");
        }
    }








}
