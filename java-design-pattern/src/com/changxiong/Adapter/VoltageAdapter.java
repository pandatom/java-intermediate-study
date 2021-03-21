package com.changxiong.Adapter;

//��������
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        int srcV = output220V(); // ��ȡ��220V��ѹ
        int dstV = srcV / 44; // ��ѹת�� 5v
        return dstV;
    }
}

