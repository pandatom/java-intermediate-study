package com.changxiong.Composite;

public class client {
    public static void main(String[] args) {
        // �Ӵ�С�������� ѧУ
        OriganizationComponent university = new University("�廪��ѧ", " �й�������ѧ ");

        // ���� ѧԺ
        OriganizationComponent computerCollege = new College("�����ѧԺ", " �����ѧԺ ");
        OriganizationComponent infoEngineercollege = new College("��Ϣ����ѧԺ", " ��Ϣ����ѧԺ ");

        // ��������ѧԺ�����ϵ(רҵ)
        computerCollege.add(new Department("�������", " ������̲��� "));
        computerCollege.add(new Department("���繤��", " ���繤�̲��� "));
        computerCollege.add(new Department("�������ѧ�뼼��", " �������ѧ�뼼�������Ƶ�רҵ "));
        infoEngineercollege.add(new Department("ͨ�Ź���", " ͨ�Ź��̲���ѧ "));
        infoEngineercollege.add(new Department("��Ϣ����", " ��Ϣ���̺�ѧ "));

        // ��ѧԺ���뵽 ѧУ
        university.add(computerCollege);
        university.add(infoEngineercollege);

        university.print();
        // infoEngineercollege.print();


    }
}
