package com.example.rxjava.assignement;

import java.util.List;

public class StudentResponse {

    private int id;
    private List<Students> students;

    public StudentResponse(int id, List<Students> students) {
        this.id = id;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public List<Students> getStudents() {
        return students;
    }

}
