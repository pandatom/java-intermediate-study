package com.changxiong.Visitor;

public class Success extends Action {

    @Override
    public void getResult(Person person) {
        System.out.println(person.gender + "�������۸ø��ֺܳɹ� !");
    }

}

