package com.changxiong.sevenprinciple.Liskovprinciple;

public class Liskov2 {

    public static void main(String[] args) {

        A2 a = new A2();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("-----------------------");
        B2 b = new B2();

        // ��ΪB�಻�ټ̳�A�࣬��˵����ߣ�������func1�������
        // ������ɵĹ��ܾͻ����ȷ
        System.out.println("11+3=" + b.func1(11, 3));// ���ﱾ�������11+3
        System.out.println("1+8=" + b.func1(1, 8));// ���ﱾ�������1+8
        System.out.println("11+3+9=" + b.func2(11, 3));

        // ʹ�������Ȼ����ʹ�õ�A����ط���
        System.out.println("11-3=" + b.func3(11, 3));// ���ﱾ�������11-3

    }

}

//����һ�����ӻ����Ļ���
class Base {
    // �Ѹ��ӻ����ķ����ͳ�Աд��Base��
}

// A��
class A2 extends Base {
    // �����������Ĳ�
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

// B��̳���A
// ������һ���¹��ܣ�������������,Ȼ���9���
class B2 extends Base {
    // ���B��Ҫʹ��A��ķ���,ʹ����Ϲ�ϵ
    private A a = new A();

    // ������Ȼ�������� fun1()���������� B �������� Base���Ѻ��� A �޹�
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    // ������Ȼ��ʹ��A�ķ���
    public int func3(int a, int b) {
        return this.a.func1(a, b);
    }
}


