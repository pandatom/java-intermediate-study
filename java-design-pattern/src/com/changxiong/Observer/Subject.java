package com.changxiong.Observer;

//�ӿ�, ��WeatherData ��ʵ��
public interface Subject {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();

}

