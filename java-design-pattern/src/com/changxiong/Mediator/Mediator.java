package com.changxiong.Mediator;

public abstract class Mediator {

    // �����н��߶��󣬼��뵽������
    public abstract void Register(String colleagueName, Colleague colleague);

    // ������Ϣ, ��Ϣ�ɾ����ͬ�¶��󷢳�
    public abstract void GetMessage(int stateChange, String colleagueName);

    public abstract void SendMessage();

}

