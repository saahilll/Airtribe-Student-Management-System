package com.airtribe.studentmanagement.service;

import com.airtribe.studentmanagement.entity.Student;
import com.airtribe.studentmanagement.exception.StudentNotFoundException;
import com.airtribe.studentmanagement.util.AIHelper; // Integrating our AI
import java.util.ArrayList;
import java.util.List;

// DESIGN PATTERN: Singleton
public class StudentService {

    private static StudentService instance;
    private List<Student> studentDb;

    // Private Constructor (The Key to Singleton)
    private StudentService() {
        this.studentDb = new ArrayList<>();
        // Seeding some dummy data
        try {
            // Adding a dummy student without AI check to prevent startup errors if Python isn't ready
            Student dummy = new Student("S001", "Alice", "alice@test.com", 3.9, 95);
            studentDb.add(dummy);
        } catch (Exception e) {
            System.err.println("Error seeding data: " + e.getMessage());
        }
    }

    // Global Access Point
    public static synchronized StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    // === 1. CREATE (Add) ===
    public void addStudent(Student s) {
        studentDb.add(s);
        System.out.println("Success: Student " + s.getName() + " added to system.");

        // AI INTEGRATION: Auto-suggest course upon registration
        // We use the Java fallback method here to ensure it works even if Python is slow
        String recommendation = AIHelper.recommendCourse(s.getCpa());
        System.out.println("[AI Recommendation] Based on performance, we suggest: " + recommendation);
    }

    // === 2. READ (View All) ===
    public List<Student> getAllStudents() {
        return studentDb;
    }

    // === 3. READ (Search) - Using Java Streams ===
    public Student findStudentById(String id) throws StudentNotFoundException {
        return studentDb.stream()
                .filter(s -> s.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found."));
    }

    // === 4. UPDATE (Modify) ===
    public void updateStudent(String id, String newName, double newCpa) throws StudentNotFoundException {
        // Find the student first
        Student s = findStudentById(id);

        // Update fields (Requires Setters in Student.java/Person.java)
        s.setName(newName);
        s.setCpa(newCpa);

        System.out.println("Success: Record for " + id + " updated.");

        // Optional: Re-calculate course recommendation
        String newRec = AIHelper.recommendCourse(newCpa);
        System.out.println("[System Update] New Course Recommendation: " + newRec);
    }

    // === 5. DELETE (Remove) ===
    public void deleteStudent(String id) throws StudentNotFoundException {
        Student s = findStudentById(id);
        studentDb.remove(s);
        System.out.println("Success: Student " + id + " has been deleted.");
    }

    // === 6. AI FEEDBACK HELPER ===
    public void addStudentFeedback(String id, String feedback) throws StudentNotFoundException {
        Student s = findStudentById(id);
        s.addFeedback(feedback);

        // AI INTEGRATION: Analyze sentiment using Python
        String sentiment = AIHelper.analyzeSentiment(feedback);
        System.out.println("[AI Analysis] Feedback Sentiment: " + sentiment);
    }
}