package com.changxiong.Facade;

public class Client {

    public static void main(String[] args) {
        // ����ֱ�ӵ��á��������鷳��Ҳ��������չ

        // ʹ�����ģʽ
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();
        homeTheaterFacade.end();
    }

}

