package com.example.demo.base.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AuthConfirmReq implements Serializable {
    @NotNull
    private String name;

    @NotNull
    private String age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AuthConfirmReq{" +
                "name='" + name + '\'' +
                '}';
    }
}
