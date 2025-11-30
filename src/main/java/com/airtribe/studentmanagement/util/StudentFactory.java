package com.airtribe.studentmanagement.util;

import com.airtribe.studentmanagement.entity.GraduateStudent;
import com.airtribe.studentmanagement.entity.Student;

public class StudentFactory {

    /**
     * Factory Method to generate Student objects.
     * @param type "UG" for Undergraduate, "GRAD" for Graduate
     * @param extraInfo For Graduates, this is the Thesis Topic. For others, it's ignored.
     */
    public static Student createStudent(String type, String id, String name, String email,
                                        double cpa, int attendancePct, String extraInfo) {

        if (type.equalsIgnoreCase("GRAD")) {
            return new GraduateStudent(id, name, email, cpa, attendancePct, extraInfo);
        } else {
            return new Student(id, name, email, cpa, attendancePct);
        }
    }
}