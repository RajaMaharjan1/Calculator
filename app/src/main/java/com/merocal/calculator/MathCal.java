package com.merocal.calculator;

public class MathCal implements Cal {


    @Override
    public String add(Numbers n) {
        String add = (String.valueOf((n.getFirstNumber())+ (n.getSecondNumber())) );
        return add;
    }

    @Override
    public String sub(Numbers n) {
        String add = (String.valueOf((n.getFirstNumber())- (n.getSecondNumber())) );
        return add;

    }

    @Override
    public String divide(Numbers n) {
        String add = (String.valueOf((n.getFirstNumber())/ (n.getSecondNumber())) );
        return add;

    }

    @Override
    public String mul(Numbers n) {
        String add = (String.valueOf((n.getFirstNumber())* (n.getSecondNumber())) );
        return add;

    }
}
