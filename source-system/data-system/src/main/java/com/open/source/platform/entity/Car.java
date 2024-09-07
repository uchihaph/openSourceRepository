package com.open.source.platform.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Car {

    private Engine engine;
    public Car() {
    }

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void run(){
        engine.run();
    }

    public static void main(String[] args) {

        Engine e1 = new Engine(1, 2);
        Engine e2 = new Engine(1, 2);
        Set<Engine> es = new HashSet<>();
        es.add(e1);
        es.add(e2);
    }
}
