package com.example.rxjava.assignement;

public class StudentModel {
    public boolean iscompleted;
    int studentid;
    String studentname;
    int studentage;


    public StudentModel(int studentid, String studentname) {
        this.studentid = studentid;
        this.studentname = studentname;
    }

    public int getStudentage() {
        return studentage;
    }

    public void setStudentage(int studentage) {
        this.studentage = studentage;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }


    public boolean iscompleted() {
        return true;
    }
}
