package com.changxiong.Constructor;

public class CommonHouse extends HouseBuilder {

    @Override
    public void buildBasic() {
        house.setBase("��ͨ���Ӵ�ػ�5��");
    }

    @Override
    public void buildWalls() {
        house.setWall("��ͨ������ǽ10cm");
    }

    @Override
    public void roofed() {
        house.setRoofed("��ͨ�����ݶ�");
    }

}

