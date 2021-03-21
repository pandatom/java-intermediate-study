package com.changxiong.State.OrderState;

class PublishState extends AbstractState {

    @Override
    public void acceptOrderEvent(Context context) {
        // �ѵ�ǰ״̬����Ϊ NotPayState������
        // ����Ӧ�ñ���ĸ�״̬��������ͼ������
        context.setState(new NotPayState());
    }

    @Override
    public void notPeopleAcceptEvent(Context context) {
        context.setState(new FeedBackState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.PUBLISHED.getValue();
    }
}
