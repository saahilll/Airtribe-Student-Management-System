package com.airtribe.studentmanagement.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AIHelper {

    private static final String PYTHON_SCRIPT_PATH = "ai_engine.py";
    // NOTE: Change to "python3" if you are on Mac/Linux
    private static final String PYTHON_COMMAND = "python";

    /**
     * Executes the Python script to perform AI tasks.
     */
    private static String runPythonModel(List<String> commandBuilder) {
        try {
            ProcessBuilder pb = new ProcessBuilder(commandBuilder);
            pb.redirectErrorStream(true);

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder result = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            process.waitFor();
            return result.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "AI Service Unavailable: " + e.getMessage();
        }
    }

    public static String predictPerformance(double cpa, int attendancePct) {
        List<String> cmd = new ArrayList<>();
        cmd.add(PYTHON_COMMAND);
        cmd.add(PYTHON_SCRIPT_PATH);
        cmd.add("predict");
        cmd.add(String.valueOf(cpa));
        cmd.add(String.valueOf(attendancePct));

        return runPythonModel(cmd);
    }

    public static String analyzeSentiment(String text) {
        List<String> cmd = new ArrayList<>();
        cmd.add(PYTHON_COMMAND);
        cmd.add(PYTHON_SCRIPT_PATH);
        cmd.add("sentiment");
        cmd.add(text);

        return runPythonModel(cmd);
    }

    public static String recommendCourse(double cpa) {
        if (cpa >= 3.8) return "Advanced Artificial Intelligence (CS-450)";
        if (cpa >= 3.0) return "Machine Learning Fundamentals (CS-300)";
        return "Introduction to Python & Data Science (CS-101)";
    }
}