package com.example.hari.demohb;

/**
 * Created by hari on 19/04/18.
 */

public class Student {
    private String name;
    private String regno;
    private String phno;

    public Student(String name,String regno,String phno)
    {
        this.name=name;
        this.phno=phno;
        this.regno=regno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
}
