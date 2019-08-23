package com.dai.spring;

public class Teacher {
    private Integer teach_id;
    private String teach_name;
    private String teach_title;

    public Teacher() {
    }

    public Teacher(Integer teach_id, String teach_name, String teach_title) {
        this.teach_id = teach_id;
        this.teach_name = teach_name;
        this.teach_title = teach_title;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teach_id=" + teach_id +
                ", teach_name='" + teach_name + '\'' +
                ", teach_title='" + teach_title + '\'' +
                '}';
    }

    public Integer getTeach_id() {
        return teach_id;
    }

    public void setTeach_id(Integer teach_id) {
        this.teach_id = teach_id;
    }

    public String getTeach_name() {
        return teach_name;
    }

    public void setTeach_name(String teach_name) {
        this.teach_name = teach_name;
    }

    public String getTeach_title() {
        return teach_title;
    }

    public void setTeach_title(String teach_title) {
        this.teach_title = teach_title;
    }
}
