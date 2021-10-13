package com.example.rxjava.assignement;

public class StudentModel {
    public boolean iscompleted;
    int studentid;
    String studentname;


    public StudentModel(int studentid, String studentname) {
        this.studentid = studentid;
        this.studentname = studentname;
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
