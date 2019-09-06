package com.shevlik;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID=11L;
    private String firstName;
    private String lastName;
    private int age;
    private int averageScore;

    Student(){}
    Student(String firstName, String lastName, int age, int averageScore){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.averageScore=averageScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return firstName + ' ' +lastName +
                "\nвозраст: "+age+
                "\nсредний балл: " + averageScore+"\n";
    }
}