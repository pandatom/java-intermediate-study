package com.changxiong.Factory.simpleFactory;


/**
 * �ŵ��ǱȽϺ���⣬���ײ�����
 * ȱ����Υ�������ģʽ��ocpԭ�򣬼�����չ����(�ṩ��)�����޸Ĺر�(ʹ�÷�)���������Ǹ��������¹��ܵ�ʱ�򣬾������޸Ĵ��룬
 * ���߾��������޸Ĵ���.
 * ����������ʱҪ������һ��Pizza������(Pepper����)��������Ҫ��ʹ�÷� OderPizza ������µ��ж�������Υ������ԭ��
 */
public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("����������׼��ԭ���� ");
    }
}
