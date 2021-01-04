package com.nekashop.app.test;

public class TestClass {
    public String checks() {
        int i = 0;
        try {
             i = 0 / 12;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return String.valueOf(i);
    }

    public void newCheck() {
        String arithmeticException = checks();
        System.out.println(arithmeticException);
    }
}
