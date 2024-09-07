package com.open.source.platform.entity;

public class Test01 {
    public int methodOne() {
        int a = 6;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        new Test01().methodOne();
        new Test01().methodTwo();
    }

    public static void methodTwo(){

    }
}
