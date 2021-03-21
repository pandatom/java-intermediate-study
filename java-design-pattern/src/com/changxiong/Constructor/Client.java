package com.changxiong.Constructor;

public class Client {
    public static void main(String[] args) {
        // ����ͨ����
        CommonHouse commonHouse = new CommonHouse();
        // ׼���������ӵ�ָ����
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        // ��ɸǷ��ӣ����ز�Ʒ(��ͨ����)
        House house = houseDirector.constructHouse();
        // �鿴�������ͨ����
        System.out.println(house.getBase());

        System.out.println("--------------------------");
        // �Ǹ�¥
        HighBuilding highBuilding = new HighBuilding();
        // ���ý�����
        houseDirector.setHouseBuilder(highBuilding);
        // ��ɸǷ��ӣ����ز�Ʒ(��¥)
        house = houseDirector.constructHouse();
        // �鿴����ĸ�¥
        System.out.println(house.getBase());
    }
}

