package com.changxiong.Decorate;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class decorate {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        // ˵��
        // 1. InputStream �ǳ�����, ��������ǰ�潲�� Drink
        // 2. FileInputStream �� InputStream ���࣬��������ǰ��� DeCaf, LongBlack
        // 3. FilterInputStream �� InputStream ���ࣺ��������ǰ�� �� Decorator ������
        // 4. DataInputStream �� FilterInputStream ���࣬����������ߣ�����ǰ��� Milk, Soy ��
        // 5. FilterInputStream �� �� protected volatile InputStream in; ������װ����
        // 6. �����ó���jdk ��io��ϵ�У�����ʹ��װ����ģʽ

        DataInputStream dis = new DataInputStream(new FileInputStream("d:\\abc.txt"));
        System.out.println(dis.read());
        dis.close();
    }
}
