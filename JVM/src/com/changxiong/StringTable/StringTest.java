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
     * str 的内容并没有变：“test ok” 位于字符串常量池中的另一个区域（地址），
     * 进行赋值操作并没有修改原来 str 指向的引用的内容
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
        // 测试StringTableSize参数
        System.out.println("我来打个酱油");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    @Test
    public void test1() {
        String s1 = "abc";//字面量定义的方式，"abc"存储在字符串常量池中
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1 == s2);//判断地址：false

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

        //如下的字符串"1" 到 "10"不会再次加载
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
        String s1 = "a" + "b" + "c";//编译期优化：等同于"abc"
        String s2 = "abc"; //"abc"一定是放在字符串常量池中，将此地址赋给s2
        /*
         * 最终.java编译成.class,再执行.class
         * String s1 = "abc";
         * String s2 = "abc"
         */
        System.out.println(s1 == s2); //true
        System.out.println(s1.equals(s2)); //true
    }

    /**
     * 拼接前后，只要其中有一个是变量，结果就在堆中
     * 调用 intern() 方法，则主动将字符串对象存入字符串常量池中，并将其地址返回
     */
    @Test
    public void test7(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";//编译期优化

        //如果拼接符号的前后出现了变量，则相当于在堆空间中new String()，具体的内容为拼接的结果：javaEEhadoop
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

        //intern():判断字符串常量池中是否存在javaEEhadoop值，如果存在，则返回常量池中javaEEhadoop的地址；
        //如果字符串常量池中不存在javaEEhadoop，则在常量池中加载一份javaEEhadoop，并返回此对象的地址。
        String s8 = s6.intern();
        System.out.println(s3 == s8);//true
    }

    @Test
    public void test8(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";//编译期优化

        //如果拼接符号的前后出现了变量，则相当于在堆空间中new String()，具体的内容为拼接的结果：javaEEhadoop
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

        //intern():判断字符串常量池中是否存在javaEEhadoop值，如果存在，则返回常量池中javaEEhadoop的地址；
        //如果字符串常量池中不存在javaEEhadoop，则在常量池中加载一份javaEEhadoop，并返回此对象的地址。
        String s8 = s6.intern();
        System.out.println(s3 == s8);//true
    }

        @Test
        public void test9(){
            String s1 = "a";
            String s2 = "b";
            String s3 = "ab";
            /*
            如下的s1 + s2 的执行细节：(变量s是我临时定义的）
            ① StringBuilder s = new StringBuilder();
            ② s.append("a")
            ③ s.append("b")
            ④ s.toString()  --> 约等于 new String("ab")

            补充：在jdk5.0之后使用的是StringBuilder,在jdk5.0之前使用的是StringBuffer
             */
            String s4 = s1 + s2;//"ab"
            System.out.println(s3 == s4);//false
        }

    /*
        1. 字符串拼接操作不一定使用的是StringBuilder!
        如果拼接符号左右两边都是字符串常量或常量引用，则仍然使用编译期优化，即非StringBuilder的方式。
        2. 针对于final修饰类、方法、基本数据类型、引用数据类型的量的结构时，能使用上final的时候建议使用上。
    */
    @Test
    public void test10(){
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);//true
    }

    //练习：
    @Test
    public void test11(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);//false

        final String s4 = "javaEE";//s4:常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);//true

    }


    /*
体会执行效率：通过StringBuilder的append()的方式添加字符串的效率要远高于使用String的字符串拼接方式！

分析原因：
    ① StringBuilder的append()的方式：
        自始至终中只创建过一个StringBuilder的对象
        使用String的字符串拼接方式：创建过多个StringBuilder和String的对象
    ② 使用String的字符串拼接方式：
        内存中由于创建了较多的StringBuilder和String的对象，内存占用更大；
        如果进行GC，需要花费额外的时间。

 改进的空间：
    在实际开发中，如果基本确定要前前后后添加的字符串长度不高于某个限定值highLevel的情况下,建议使用构造器实例化：
    StringBuilder s = new StringBuilder(highLevel);//new char[highLevel]
 */
    @Test
    public void test12(){

        long start = System.currentTimeMillis();

        // method1(100000);//4014
        method2(100000);//7

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start));
    }

    public void method1(int highLevel){
        String src = "";
        for(int i = 0;i < highLevel;i++){
            src = src + "a";//每次循环都会创建一个StringBuilder、String
        }
    }

    public void method2(int highLevel){
        //只需要创建一个StringBuilder
        StringBuilder src = new StringBuilder();
        for (int i = 0; i < highLevel; i++) {
            src.append("a");
        }
    }








}
