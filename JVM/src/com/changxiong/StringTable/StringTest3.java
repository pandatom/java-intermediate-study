package com.changxiong.StringTable;

import org.junit.Test;

/**
 * @author changxiong
 * @create 2020-12-22-1:16 PM
 */
public class StringTest3 {
    /**
     * 题目：
     * new String("ab")会创建几个对象？看字节码，就知道是两个。
     * 一个对象是：new关键字在堆空间创建的
     * 另一个对象是：字符串常量池中的对象"ab"。 字节码指令：ldc
     *
     * @author shkstart  shkstart@126.com
     * @create 2020  20:38
     */
    public static void main(String[] args) {
        String str = new String("ab");
    }

    /**
     * 思考：
     * new String("a") + new String("b")呢？
     * 对象1：new StringBuilder()
     * 对象2： new String("a")
     * 对象3： 常量池中的"a"
     * 对象4： new String("b")
     * 对象5： 常量池中的"b"
     * <p>
     * 深入剖析： StringBuilder的toString():
     * 对象6 ：new String("ab")
     * 强调一下，toString()的调用，在字符串常量池中，没有生成"ab"
     */
    @Test
    public void test1() {
        String str = new String("a") + new String("b");
    }

    /**
     * 如何保证变量s指向的是字符串常量池中的数据呢？有两种方式：
     * 方式一： String s = "shkstart";//字面量定义的方式
     * 方式二： 调用intern()
     * String s = new String("shkstart").intern();
     * String s = new StringBuilder("shkstart").toString().intern();
     *
     * @author shkstart  shkstart@126.com
     * @create 2020  18:49
     */
    @Test
    public void test2() {
        String s = new String("1");
        s.intern();//这方法其实没啥屌用，调用此方法之前，字符串常量池中已经存在"1"
        String s2 = "1";

    /*
        jdk6：false   jdk7/8：false
        因为 s 指向堆空间中的 "1" ，s2 指向字符创常量池中的 "1"
     */
        System.out.println(s == s2);

        // 执行完下一行代码以后，字符串常量池中，是否存在"11"呢？答案：不存在！！
        String s3 = new String("1") + new String("1");//s3变量记录的地址为：new String("11")
    /*
        如何理解：jdk6:创建了一个新的对象"11",也就有新的地址。
                 jdk7:此时常量中并没有创建"11",而是在常量池中记录了指向堆空间中new String("11")的地址（节省空间）
     */
        s3.intern(); // 在字符串常量池中生成"11"。
        String s4 = "11";//s4变量记录的地址：使用的是上一行代码代码执行时，在常量池中生成的"11"的地址

        // jdk6：false  jdk7/8：true
        System.out.println(s3 == s4);
    }

    /**
     * StringIntern.java中练习的拓展：
     *
     * @author shkstart  shkstart@126.com
     * @create 2020  22:10
     */
    @Test
    public void test3() {
        //执行完下一行代码以后，字符串常量池中，是否存在"11"呢？答案：不存在！！
        String s3 = new String("1") + new String("1");//new String("11")
        //在字符串常量池中生成对象"11"
        String s4 = "11";
        String s5 = s3.intern();

        // s3 是堆中的 "ab" ，s4 是字符串常量池中的 "ab"
        System.out.println(s3 == s4);//false

        // s5 是从字符串常量池中取回来的引用，当然和 s4 相等
        System.out.println(s5 == s4);//true
    }

    //intern()测试
    @Test
    public void test4() {
        //在下一行代码执行完以后，字符串常量池中并没有"ab"
        String s = new String("a") + new String("b");//new String("ab")
        /*
            jdk6中：在串池中创建一个字符串"ab"
            jdk8中：串池中没有创建字符串"ab",而是创建一个引用，指向new String("ab")，将此引用返回
         */
        String s2 = s.intern();
        System.out.println(s2 == "ab");//jdk6:true  jdk8:true
        System.out.println(s == "ab");//jdk6:false  jdk8:true
    }

    @Test
    public void test5() {
        // 在这儿加一句
        String x = "ab";

        //在下一行代码执行完以后，字符串常量池中并没有"ab"
        String s = new String("a") + new String("b");//new String("ab")
        /*
            jdk6中：在串池中创建一个字符串"ab"
            jdk8中：串池中没有创建字符串"ab",而是创建一个引用，指向new String("ab")，将此引用返回
         */
        String s2 = s.intern();
        System.out.println(s2 == "ab");//jdk6:true  jdk8:true
        System.out.println(s == "ab");//jdk6:false  jdk8:false
    }

    @Test
    public void test6() {
        String s1 = new String("ab");//执行完以后，会在字符串常量池中会生成"ab"
        s1.intern();
        String s2 = "ab";
        System.out.println(s1 == s2); // false
    }

    // 对象内存地址可以使用System.identityHashCode(object)方法获取
    @Test
    public void test7() {
            String s1 = new String("a") + new String("b");//执行完以后，不会在字符串常量池中会生成"ab"
            System.out.println(System.identityHashCode(s1));
            s1.intern();
            System.out.println(System.identityHashCode(s1));
            String s2 = "ab";
            System.out.println(System.identityHashCode(s2));
            System.out.println(s1 == s2); // true
    }

    /**
     * 使用intern()测试执行效率：空间使用上
     * 结论：对于程序中大量存在存在的字符串，尤其其中存在很多重复字符串时，使用intern()可以节省内存空间。
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
            System.out.println("花费的时间为：" + (end - start));

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
