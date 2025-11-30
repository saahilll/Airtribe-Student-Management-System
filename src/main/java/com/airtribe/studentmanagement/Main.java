package com.airtribe.studentmanagement;

import com.airtribe.studentmanagement.entity.Student;
import com.airtribe.studentmanagement.exception.StudentNotFoundException;
import com.airtribe.studentmanagement.service.StudentService;
import com.airtribe.studentmanagement.util.AIHelper;
import com.airtribe.studentmanagement.util.StudentFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = StudentService.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== AI-Powered Student Management System ===");
        System.out.println("Backend: Java 25 | AI Engine: Python 3 (Scikit-Learn)");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add Student (Triggers AI Prediction)");
            System.out.println("2. Add Feedback (Triggers AI Sentiment)");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student");
            System.out.println("6. View All Students");
            System.out.println("7. Exit");
            System.out.print("Select Operation: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1: // CREATE
                        System.out.println("\n--- New Student Enrollment ---");
                        System.out.print("Type (UG/GRAD): ");
                        String type = scanner.nextLine();
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Current CPA (0.0 - 4.0): ");
                        double cpa = scanner.nextDouble();
                        System.out.print("Attendance %: ");
                        int att = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        String extra = "";
                        if (type.equalsIgnoreCase("GRAD")) {
                            System.out.print("Thesis Topic: ");
                            extra = scanner.nextLine();
                        }

                        // Factory Pattern
                        Student s = StudentFactory.createStudent(type, id, name, email, cpa, att, extra);
                        service.addStudent(s);

                        // AI Integration Call
                        System.out.println("...Contacting Python AI Engine...");
                        String prediction = AIHelper.predictPerformance(cpa, att);
                        System.out.println("\n[AI MODEL RESULT] " + prediction);
                        break;

                    case 2: // FEEDBACK (AI)
                        System.out.print("Enter Student ID: ");
                        String sId = scanner.nextLine();
                        System.out.print("Enter Feedback: ");
                        String feedback = scanner.nextLine();

                        service.addStudentFeedback(sId, feedback);
                        break;

                    case 3: // READ (Search)
                        System.out.print("Enter Student ID to Search: ");
                        String searchId = scanner.nextLine();
                        Student foundStudent = service.findStudentById(searchId);
                        System.out.println("--- Student Found ---");
                        System.out.println(foundStudent);
                        break;

                    case 4: // UPDATE
                        System.out.print("Enter Student ID to Update: ");
                        String updateId = scanner.nextLine();
                        // Verify existence first
                        service.findStudentById(updateId);

                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter New CPA: ");
                        double newCpa = scanner.nextDouble();

                        service.updateStudent(updateId, newName, newCpa);
                        break;

                    case 5: // DELETE
                        System.out.print("Enter Student ID to Delete: ");
                        String delId = scanner.nextLine();
                        service.deleteStudent(delId);
                        break;

                    case 6: // READ (View All)
                        System.out.println("\n--- All Registered Students ---");
                        if (service.getAllStudents().isEmpty()) {
                            System.out.println("No students registered yet.");
                        } else {
                            service.getAllStudents().forEach(System.out::println);
                        }
                        break;

                    case 7: // EXIT
                        System.out.println("Saving data... Shutting down.");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (StudentNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("System Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}