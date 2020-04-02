package com.hztuen.androidinterview.reflect;

public class Person implements Action,Run{
    private int age;
    private String name;

    public Person(int age) {
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {

    }

    @Override
    public void run() {

    }

    class SubPerson{
        private int age;
        private String name;

    }
    interface OnChangeAgeListener{
        void onChangeAgeListener();
    }
}
