package com.open.source.platform.entity;

import java.util.Objects;

public class Engine {

    public int e1;
    public int e2;

    public Object o;

    public Engine(int e1, int e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public void run() {
        System.out.println("输出say");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine)) return false;
        Engine engine = (Engine) o;
        return e1 == engine.e1 && e2 == engine.e2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(e1, e2);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "e1=" + e1 +
                ", e2=" + e2 +
                ", o=" + o +
                '}';
    }
}
