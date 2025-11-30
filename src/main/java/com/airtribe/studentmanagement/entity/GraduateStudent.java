package com.airtribe.studentmanagement.entity;

public class GraduateStudent extends Student {
    private String thesisTopic;

    public GraduateStudent(String id, String name, String email, double cpa, int attendancePct, String thesisTopic) {
        super(id, name, email, cpa, attendancePct);
        this.thesisTopic = thesisTopic;
    }

    @Override
    public String getRole() {
        return "Graduate Student (Researcher)";
    }

    @Override
    public String toString() {
        return super.toString() + " | Thesis: " + thesisTopic;
    }
}