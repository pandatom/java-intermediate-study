package com.changxiong.ChainResponsiblity;

public abstract class Approver {

    Approver approver; // ��һ��������
    String name; // ����

    public Approver(String name) {
        this.name = name;
    }

    // ��һ��������
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    // ������������ķ������õ�һ������, ������������ɣ���˸÷������ɳ���
    public abstract void processRequest(PurchaseRequest purchaseRequest);

}

