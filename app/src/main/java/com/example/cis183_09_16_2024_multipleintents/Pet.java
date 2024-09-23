package com.example.cis183_09_16_2024_multipleintents;

import java.io.Serializable;

public class Pet implements Serializable
{
    String name;
    int age;
    public Pet()
    {

    }
    public Pet(String n, int a)
    {
        name = n;
        age = a;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    //setter
    public void setName(String n)
    {
        this.name = n;
    }
    public void setAge(int a)
    {
        this.age = a;
    }




}
