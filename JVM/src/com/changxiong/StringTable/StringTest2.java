package com.changxiong.StringTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author changxiong
 * @create 2020-12-22-12:31 PM
 */
public class StringTest2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("words.txt"));
            long start = System.currentTimeMillis();
            String data;
            while ((data = br.readLine()) != null) {
                //����ַ�����������û�ж�Ӧdata���ַ����Ļ������ڳ�����������
                data.intern();
            }

            long end = System.currentTimeMillis();

            System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));//1009:143ms  100009:47ms
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}