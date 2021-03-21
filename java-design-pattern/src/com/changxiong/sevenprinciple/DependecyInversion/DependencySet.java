package com.changxiong.sevenprinciple.DependecyInversion;

    public class DependencySet {

        public static void main(String[] args) {
            // ͨ��setter����������������
            ITV2 changHong = new ChangHong2();
            OpenAndClose2 openAndClose2 = new OpenAndClose2();
            openAndClose2.setTv(changHong);
            openAndClose2.open();
        }

    }

    // ��ʽ3 , ͨ��setter��������
    interface IOpenAndClose2 {
        public void open(); // ���󷽷�
        public void setTv(ITV2 tv); // ͨ�� setter ����ע��
    }

    interface ITV2 { // ITV�ӿ�
        public void play();
    }

    // ������ӣ�ʵ�� ITV �ӿ�
    class ChangHong2 implements ITV2 {
        @Override
        public void play() {
            System.out.println("������ӻ�����");
        }
    }

    class OpenAndClose2 implements IOpenAndClose2 {
        private ITV2 tv;

        // ͨ�� setYv() ����ע��ʵ���� ITV �ӿڵĶ���ʵ��
        public void setTv(ITV2 tv) {
            this.tv = tv;
        }

        public void open() {
            this.tv.play();
        }
    }


