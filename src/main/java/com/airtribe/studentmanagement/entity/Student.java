package com.airtribe.studentmanagement.entity;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private double cpa; // Cumulative Performance Average
    private int attendancePct;
    private List<String> feedbackList;

    public Student(String id, String name, String email, double cpa, int attendancePct) {
        super(id, name, email); // INHERITANCE: Constructor chaining
        this.cpa = cpa;
        this.attendancePct = attendancePct;
        this.feedbackList = new ArrayList<>();
    }

    public Student(String id, String name) {
        this(id, name, "unknown@school.edu", 0.0, 0); // Calls the main constructor
    }


    public Student(Student other) {
        super(other.getId(), other.getName(), other.getEmail());
        this.cpa = other.getCpa();
        this.attendancePct = other.getAttendancePct();
        this.feedbackList = new ArrayList<>(other.getFeedbackList());
    }

    // POLYMORPHISM: Overriding the abstract method
    @Override
    public String getRole() {
        return "Undergraduate Student";
    }

    public void addFeedback(String feedback) {
        this.feedbackList.add(feedback);
    }

    public List<String> getFeedbackList() {
        return feedbackList;
    }

    // === GETTERS ===
    public double getCpa() { return cpa; }
    public int getAttendancePct() { return attendancePct; }

    // === SETTERS (CRITICAL FOR UPDATE FEATURE) ===
    public void setCpa(double cpa) {
        this.cpa = cpa;
    }

    public void setAttendancePct(int attendancePct) {
        this.attendancePct = attendancePct;
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: " + getRole() + " | CPA: " + cpa;
    }
}