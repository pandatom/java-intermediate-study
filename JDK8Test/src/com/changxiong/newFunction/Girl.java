package com.changxiong.newFunction;

import java.util.Objects;

/**
 * @author changxiong
 * @create 2020-12-16-6:53 PM
 */
public class Girl {
    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Girl girl = (Girl) o;
        return Objects.equals(name, girl.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
