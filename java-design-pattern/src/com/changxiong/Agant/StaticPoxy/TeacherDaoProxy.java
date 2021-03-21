package com.changxiong.Agant.StaticPoxy;

//�������,��̬����
public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target; // Ŀ�����ͨ���ӿ����ۺ�

    // ������
    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("��ʼ����  ���ĳЩ�������������� ");// ����
        target.teach();
        System.out.println("�ύ����������");// ����
    }

}

