package com.changxiong.ProtoType;

public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("С��", 12, "��ɫ");

        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();

        System.out.println(sheep.getName()+" :::: "+sheep1.hashCode());
        System.out.println(sheep1.getName()+" :::: "+sheep1.hashCode());
        System.out.println(sheep2.getName()+" :::: "+sheep1.hashCode());
        System.out.println(sheep3.getName()+" :::: "+sheep1.hashCode());
        System.out.println(sheep4.getName()+" :::: "+sheep1.hashCode());

    }
}
