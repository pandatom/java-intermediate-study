package com.changxiong.Strategy;

/**
 * ����ģʽ�� �ֱ��װ��Ϊ�ӿڣ� ʵ���㷨�壬 ���������Ϊ�ӿڶ��� ������������趨��Ϊ����
 * ԭ����ǣ�����仯���֣� ��װ�ӿڣ� ���ڽӿڱ�̸��ֹ��ܡ� ��ģʽ����Ϊ�ı仯�������㷨��ʹ����
 */
public class Client {

    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();

        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.fly();

        // ��̬�ı�ĳ���������Ϊ, ����Ѽ ���ܷ�
        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        System.out.println("����Ѽ��ʵ�ʷ�������");
        pekingDuck.fly();
    }

}

