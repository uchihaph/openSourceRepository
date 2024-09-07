package com.open.source.platform.entity;

import java.util.ArrayList;

public class JVMTest {
    public static void main(String[] args) throws Exception {
        ArrayList<Test> tests = new ArrayList<>();
        sync();
        while (true) {
        }
    }

    public static void sync() {

        Object a = new Object();
        Object b = new Object();

        Thread threadA = new Thread(() -> {

            synchronized (a) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (b) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


        });
        Thread threadB = new Thread(() -> {
            synchronized (b) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (a) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


        });

        threadA.start();
        threadB.start();
    }

}
