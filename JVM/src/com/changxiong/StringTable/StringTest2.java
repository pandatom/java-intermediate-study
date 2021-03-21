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
                //如果字符串常量池中没有对应data的字符串的话，则在常量池中生成
                data.intern();
            }

            long end = System.currentTimeMillis();

            System.out.println("花费的时间为：" + (end - start));//1009:143ms  100009:47ms
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