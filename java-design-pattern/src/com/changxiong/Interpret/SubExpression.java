package com.changxiong.Interpret;

import java.util.HashMap;

/**
 * ����������
 *
 * @author Administrator
 *
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    // ���left �� right ���ʽ�����Ľ��
    public int interpreter(HashMap<String, Integer> var) {
        return left.interpreter(var) - right.interpreter(var);
    }
}

