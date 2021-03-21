package com.changxiong.Memento.demo1;

public class Client {

    public static void main(String[] args) {

        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState(" ״̬#1 ������ 100 "); // ���ù����ٶ�
        caretaker.add(originator.saveStateMemento()); // �����˵�ǰ��״̬

        originator.setState(" ״̬#2 ������ 80 "); // ���ù����ٶ�
        caretaker.add(originator.saveStateMemento()); // �����˵�ǰ��״̬

        originator.setState(" ״̬#3 ������ 50 "); // ���ù����ٶ�
        caretaker.add(originator.saveStateMemento()); // �����˵�ǰ��״̬

        System.out.println("��ǰ��״̬�� =" + originator.getState());

        // ϣ���õ�״̬ 1, �� originator �ָ���״̬1
        originator.getStateFromMemento(caretaker.get(0)); // �ָ���������
        System.out.println("�ָ���״̬1 , ��ǰ��״̬��");
        System.out.println("��ǰ��״̬�� =" + originator.getState());

    }

}

