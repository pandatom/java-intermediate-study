package com.changxiong.ProtoType.deepCopy;

public class Client {

    public static void main(String[] args) throws Exception {
        DeepProtoType p = new DeepProtoType();
        p.setId("�ν�");
        DeepCloneableTarget deepCloneableTarget = new DeepCloneableTarget("��ţ", "Сţ");
        p.setDeepCloneableTarget(deepCloneableTarget);

        // ��ʽ1 ������
        System.out.println("p.name=" + p.id + "��p.deepCloneableTarget.hashCode=" + p.deepCloneableTarget.hashCode());
        DeepProtoType p2 = (DeepProtoType) p.clone();
        System.out.println("p2.name=" + p2.id + "��p2.deepCloneableTarget.hashCode=" + p2.deepCloneableTarget.hashCode());

        // ��ʽ2 ������
//		DeepProtoType p2 = (DeepProtoType) p.deepClone();
//		System.out.println("p.name=" + p.name + "��p.deepCloneableTarget.hashCode=" + p.deepCloneableTarget.hashCode());
//		System.out.println("p2.name=" + p2.name + "��p2.deepCloneableTarget.hashCode=" + p2.deepCloneableTarget.hashCode());
    }

}

