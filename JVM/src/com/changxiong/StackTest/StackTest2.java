package com.changxiong.StackTest;

/**
 * @author changxiong
 * @create 2020-12-18-4:09 PM
 */
public class StackTest2 {
    public static void main(String[] args) {
       add();
    }

    // ����Ա���Թ����У� ������i++��++i �����𣬷ŵ��ֽ���ƪ��ʱ�ٽ��ܡ�
    public static void add(){
        //��1�����⣺
        int i1 = 10;
        i1++;

        int i2 = 10;
        ++i2;

        //��2�����⣺
        int i3 = 10;
        int i4 = i3++;

        int i5 = 10;
        int i6 = ++i5;

        //��3�����⣺
        int i7 = 10;
        i7 = i7++;

        int i8 = 10;
        i8 = ++i8;

        //��4�����⣺
        int i9 = 10;
        int i10 = i9++ + ++i9;
    }


}
