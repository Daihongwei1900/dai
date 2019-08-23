package com.dai.spring;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private Date date;
    private List<String> mylist;
    private Map<String,String> map;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", mylist=" + mylist +
                ", map=" + map +
                '}';
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Person() {
    }

    public Person(String name, Date date, List<String> mylist, Map<String, String> map) {
        this.name = name;
        this.date = date;
        this.mylist = mylist;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getMylist() {
        return mylist;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }

}