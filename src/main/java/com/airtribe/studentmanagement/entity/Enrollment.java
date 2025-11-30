package com.airtribe.studentmanagement.entity;

public class Enrollment {
    private Student student;
    private Course course;
    private String semester;

    public Enrollment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return student.getName() + " enrolled in " + course.getTitle() + " (" + semester + ")";
    }
}