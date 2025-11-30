package com.airtribe.studentmanagement.entity;

public class Course {
    private String courseId;
    private String title;
    private int credits;

    public Course(String courseId, String title, int credits) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
    }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return "[" + courseId + "] " + title + " (" + credits + " credits)";
    }
}