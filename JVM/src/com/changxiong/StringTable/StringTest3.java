package com.changxiong.StringTable;

import org.junit.Test;

/**
 * @author changxiong
 * @create 2020-12-22-1:16 PM
 */
public class StringTest3 {
    /**
     * ��Ŀ��
     * new String("ab")�ᴴ���������󣿿��ֽ��룬��֪����������
     * һ�������ǣ�new�ؼ����ڶѿռ䴴����
     * ��һ�������ǣ��ַ����������еĶ���"ab"�� �ֽ���ָ�ldc
     *
     * @author shkstart  shkstart@126.com
     * @create 2020  20:38
     */
    public static void main(String[] args) {
        String str = new String("ab");
    }

    /**
     * ˼����
     * new String("a") + new String("b")�أ�
     * ����1��new StringBuilder()
     * ����2�� new String("a")
     * ����3�� �������е�"a"
     * ����4�� new String("b")
     * ����5�� �������е�"b"
     * <p>
     * ���������� StringBuilder��toString():
     * ����6 ��new String("ab")
     * ǿ��һ�£�toString()�ĵ��ã����ַ����������У�û������"ab"
     */
    @Test
    public void test1() {
        String str = new String("a") + new String("b");
    }

    /**
     * ��α�֤����sָ������ַ����������е������أ������ַ�ʽ��
     * ��ʽһ�� String s = "shkstart";//����������ķ�ʽ
     * ��ʽ���� ����intern()
     * String s = new String("shkstart").intern();
     * String s = new StringBuilder("shkstart").toString().intern();
     *
     * @author shkstart  shkstart@126.com
     * @create 2020  18:49
     */
    @Test
    public void test2() {
        String s = new String("1");
        s.intern();//�ⷽ����ʵûɶ���ã����ô˷���֮ǰ���ַ������������Ѿ�����"1"
        String s2 = "1";

    /*
        jdk6��false   jdk7/8��false
        ��Ϊ s ָ��ѿռ��е� "1" ��s2 ָ���ַ����������е� "1"
     */
        System.out.println(s == s2);

        // ִ������һ�д����Ժ��ַ����������У��Ƿ����"11"�أ��𰸣������ڣ���
        String s3 = new String("1") + new String("1");//s3������¼�ĵ�ַΪ��new String("11")
    /*
        �����⣺jdk6:������һ���µĶ���"11",Ҳ�����µĵ�ַ��
                 jdk7:��ʱ�����в�û�д���"11",�����ڳ������м�¼��ָ��ѿռ���new String("11")�ĵ�ַ����ʡ�ռ䣩
     */
        s3.intern(); // ���ַ���������������"11"��
        String s4 = "11";//s4������¼�ĵ�ַ��ʹ�õ�����һ�д������ִ��ʱ���ڳ����������ɵ�"11"�ĵ�ַ

        // jdk6��false  jdk7/8��true
        System.out.println(s3 == s4);
    }

    /**
     * StringIntern.java����ϰ����չ��
     *
     * @author shkstart  shkstart@126.com
     * @create 2020  22:10
     */
    @Test
    public void test3() {
        //ִ������һ�д����Ժ��ַ����������У��Ƿ����"11"�أ��𰸣������ڣ���
        String s3 = new String("1") + new String("1");//new String("11")
        //���ַ��������������ɶ���"11"
        String s4 = "11";
        String s5 = s3.intern();

        // s3 �Ƕ��е� "ab" ��s4 ���ַ����������е� "ab"
        System.out.println(s3 == s4);//false

        // s5 �Ǵ��ַ�����������ȡ���������ã���Ȼ�� s4 ���
        System.out.println(s5 == s4);//true
    }

    //intern()����
    @Test
    public void test4() {
        //����һ�д���ִ�����Ժ��ַ����������в�û��"ab"
        String s = new String("a") + new String("b");//new String("ab")
        /*
            jdk6�У��ڴ����д���һ���ַ���"ab"
            jdk8�У�������û�д����ַ���"ab",���Ǵ���һ�����ã�ָ��new String("ab")���������÷���
         */
        String s2 = s.intern();
        System.out.println(s2 == "ab");//jdk6:true  jdk8:true
        System.out.println(s == "ab");//jdk6:false  jdk8:true
    }

    @Test
    public void test5() {
        // �������һ��
        String x = "ab";

        //����һ�д���ִ�����Ժ��ַ����������в�û��"ab"
        String s = new String("a") + new String("b");//new String("ab")
        /*
            jdk6�У��ڴ����д���һ���ַ���"ab"
            jdk8�У�������û�д����ַ���"ab",���Ǵ���һ�����ã�ָ��new String("ab")���������÷���
         */
        String s2 = s.intern();
        System.out.println(s2 == "ab");//jdk6:true  jdk8:true
        System.out.println(s == "ab");//jdk6:false  jdk8:false
    }

    @Test
    public void test6() {
        String s1 = new String("ab");//ִ�����Ժ󣬻����ַ����������л�����"ab"
        s1.intern();
        String s2 = "ab";
        System.out.println(s1 == s2); // false
    }

    // �����ڴ��ַ����ʹ��System.identityHashCode(object)������ȡ
    @Test
    public void test7() {
            String s1 = new String("a") + new String("b");//ִ�����Ժ󣬲������ַ����������л�����"ab"
            System.out.println(System.identityHashCode(s1));
            s1.intern();
            System.out.println(System.identityHashCode(s1));
            String s2 = "ab";
            System.out.println(System.identityHashCode(s2));
            System.out.println(s1 == s2); // true
    }

    /**
     * ʹ��intern()����ִ��Ч�ʣ��ռ�ʹ����
     * ���ۣ����ڳ����д������ڴ��ڵ��ַ������������д��ںܶ��ظ��ַ���ʱ��ʹ��intern()���Խ�ʡ�ڴ�ռ䡣
     *
     * @author shkstart  shkstart@126.com
     * @create 2020  21:17
     */

        static final int MAX_COUNT = 1000 * 10000;
        static final String[] arr = new String[MAX_COUNT];

        @Test
        public  void test8() {
            Integer[] data = new Integer[]{1,2,3,4,5,6,7,8,9,10};

            long start = System.currentTimeMillis();
            for (int i = 0; i < MAX_COUNT; i++) {
                // arr[i] = new String(String.valueOf(data[i % data.length]));
                arr[i] = new String(String.valueOf(data[i % data.length])).intern();

            }
            long end = System.currentTimeMillis();
            System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));

            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.gc();
        }

    @Test
    public void test9() {
        String a = new String("aa");
        String b = new String("aa");
        String c="aa";

        System.out.println(a==b);//false
        System.out.println(a==c);//false
        System.out.println(c==b);//false

        String d = b.intern();
        System.out.println(d==c);

        System.out.println();

        String s1 = new String("ab");
        s1=s1.intern();
        String s2 = "ab";
        System.out.println(s1 == s2); // false

        System.out.println();

        String ss1 = new String("a") + new String("b");
        ss1=ss1.intern();
        String ss2 = "ab";
        System.out.println(ss1 == ss2); // true
    }

    @Test
    public void test10() {
        String a = "aa";
        String b = "aa";

        String c = new String("aa");
        String d = c.intern();
        System.out.println(a==b);
        System.out.println(c==a);
        System.out.println(d == a);
    }




}
