# Airtribe Student Management System

[![Java](https://img.shields.io/badge/Java-25-orange.svg)](https://www.oracle.com/java/)
[![Python](https://img.shields.io/badge/Python-3.x-blue.svg)](https://www.python.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

A comprehensive, AI-powered student management system built with Java 25 and Python, demonstrating modern software engineering principles, design patterns, and cross-language integration for intelligent student performance prediction and sentiment analysis.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Key Components](#key-components)
- [AI Integration](#ai-integration)
- [Design Patterns](#design-patterns)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

The Airtribe Student Management System is an enterprise-grade application that combines robust Java backend architecture with Python-based AI/ML capabilities. The system provides comprehensive CRUD operations for student management while leveraging machine learning models for performance prediction and natural language processing for sentiment analysis of student feedback.

### Key Highlights

- **Full CRUD Operations**: Create, Read, Update, Delete student records
- **AI-Powered Analytics**: Machine learning-based performance prediction
- **Sentiment Analysis**: NLP-driven feedback analysis using TextBlob
- **Object-Oriented Design**: Demonstrates inheritance, polymorphism, and abstraction
- **Design Patterns**: Factory Pattern, Singleton Pattern implementation
- **Cross-Language Integration**: Seamless Java-Python communication via ProcessBuilder

## ✨ Features

### Core Functionality

- ✅ **Student Registration**: Add undergraduate and graduate students with comprehensive details
- ✅ **Student Search**: Fast lookup by student ID with exception handling
- ✅ **Student Updates**: Modify student information (name, CPA, attendance)
- ✅ **Student Deletion**: Remove student records from the system
- ✅ **View All Students**: Display complete student registry
- ✅ **Feedback Management**: Add and analyze student feedback with AI sentiment analysis

### AI-Powered Features

- 🤖 **Performance Prediction**: ML model predicts student success likelihood based on CPA and attendance
- 🧠 **Sentiment Analysis**: Real-time analysis of student feedback using NLP
- 📊 **Course Recommendations**: Intelligent course suggestions based on student performance

### Student Types

- **Undergraduate Students**: Standard student records with CPA and attendance tracking
- **Graduate Students**: Extended records with thesis topic information

## 🏗️ Architecture

The system follows a layered architecture pattern with clear separation of concerns:

```
┌─────────────────────────────────────────┐
│         Presentation Layer              │
│         (Main.java - CLI)               │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│         Service Layer                   │
│    (StudentService - Singleton)         │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│         Entity Layer                    │
│  (Person, Student, GraduateStudent)     │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│         Utility Layer                   │
│  (AIHelper, StudentFactory)             │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│         AI Engine (Python)              │
│  (ai_engine.py - ML/NLP Models)         │
└─────────────────────────────────────────┘
```

## 🛠️ Technology Stack

### Backend
- **Java 25 (LTS)**: Core application language
- **JDK 25**: Development kit with latest features

### AI/ML Engine
- **Python 3.x**: AI model execution environment
- **Scikit-Learn**: Machine learning library for performance prediction
- **TextBlob**: Natural language processing for sentiment analysis
- **NumPy**: Numerical computing support

### Development Tools
- **IntelliJ IDEA 2025.2.3**: Recommended IDE (optional)
- **Maven/Gradle**: Not required (pure Java compilation)

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

1. **Java Development Kit (JDK) 25**
   - Download from [Oracle JDK 25](https://www.oracle.com/java/technologies/downloads/)
   - Verify installation:
     ```bash
     java -version
     javac -version
     ```

2. **Python 3.x**
   - Download from [Python.org](https://www.python.org/downloads/)
   - Verify installation:
     ```bash
     python --version
     ```

3. **Python Dependencies**
   - Install required packages:
     ```bash
     pip install scikit-learn textblob numpy
     ```

### Environment Variables (Windows)

Configure the following environment variables:

1. **JAVA_HOME**: Set to JDK 25 installation directory
   - Example: `C:\Program Files\Java\jdk-25`

2. **Path**: Append `%JAVA_HOME%\bin` to system Path variable

For detailed setup instructions, refer to [docs/Setup_Instructions.md](docs/Setup_Instructions.md)

## 🚀 Installation

### Step 1: Clone the Repository

```bash
git clone <repository-url>
cd "Airtribe Student Management System"
```

### Step 2: Install Python Dependencies

```bash
pip install scikit-learn textblob numpy
```

### Step 3: Compile Java Source Files

```bash
# Navigate to source directory
cd src/main/java

# Compile all Java files
javac com/airtribe/studentmanagement/**/*.java

# Or compile from project root
javac -d out/production src/main/java/com/airtribe/studentmanagement/**/*.java
```

### Step 4: Verify AI Engine

Ensure `ai_engine.py` is in the project root directory and executable:

```bash
python ai_engine.py predict 3.5 85
```

Expected output: Performance prediction result

## 💻 Usage

### Running the Application

```bash
# From project root directory
java -cp out/production com.airtribe.studentmanagement.Main
```

Or if compiled in source directory:

```bash
java -cp src/main/java com.airtribe.studentmanagement.Main
```

### Application Menu

Upon launching, you'll see the main menu:

```
=== AI-Powered Student Management System ===
Backend: Java 25 | AI Engine: Python 3 (Scikit-Learn)

--- MAIN MENU ---
1. Add Student (Triggers AI Prediction)
2. Add Feedback (Triggers AI Sentiment)
3. Search Student by ID
4. Update Student Details
5. Delete Student
6. View All Students
7. Exit
```

### Example Workflow

1. **Add a Student**:
   - Select option `1`
   - Enter student type (`UG` or `GRAD`)
   - Provide student details (ID, name, email, CPA, attendance)
   - For graduate students, enter thesis topic
   - System will automatically trigger AI performance prediction

2. **Add Feedback**:
   - Select option `2`
   - Enter student ID
   - Enter feedback text
   - System will analyze sentiment using NLP

3. **Search Student**:
   - Select option `3`
   - Enter student ID
   - View student details

4. **Update Student**:
   - Select option `4`
   - Enter student ID
   - Update name and/or CPA
   - System will recalculate course recommendations

5. **Delete Student**:
   - Select option `5`
   - Enter student ID to remove

6. **View All Students**:
   - Select option `6`
   - Display all registered students

## 📁 Project Structure

```
Airtribe Student Management System/
│
├── src/main/java/com/airtribe/studentmanagement/
│   ├── entity/
│   │   ├── Person.java              # Abstract base class
│   │   ├── Student.java             # Undergraduate student entity
│   │   ├── GraduateStudent.java     # Graduate student entity
│   │   ├── Course.java              # Course entity
│   │   └── Enrollment.java          # Enrollment relationship
│   │
│   ├── service/
│   │   └── StudentService.java      # Business logic layer (Singleton)
│   │
│   ├── util/
│   │   ├── AIHelper.java            # Python integration bridge
│   │   └── StudentFactory.java      # Factory pattern implementation
│   │
│   ├── exception/
│   │   └── StudentNotFoundException.java
│   │
│   ├── interfaces/
│   │   └── Searchable.java          # Generic search interface
│   │
│   └── Main.java                    # Application entry point
│
├── ai_engine.py                     # Python AI/ML engine
├── docs/
│   ├── Setup_Instructions.md
│   ├── JVM_Architecture_Report.md
│   └── *.PNG                        # Architecture diagrams
│
├── out/production/                  # Compiled class files
└── README.md                        # This file
```

## 🔧 Key Components

### Entity Classes

- **`Person`**: Abstract base class defining common attributes (id, name, email) and abstract `getRole()` method
- **`Student`**: Extends `Person`, represents undergraduate students with CPA and attendance tracking
- **`GraduateStudent`**: Extends `Student`, adds thesis topic for graduate students
- **`Course`**: Represents course entities with ID, title, and credits
- **`Enrollment`**: Manages student-course relationships

### Service Layer

- **`StudentService`**: Singleton service class implementing CRUD operations
  - Thread-safe singleton pattern
  - In-memory data storage
  - Integration with AI helper for recommendations

### Utility Classes

- **`AIHelper`**: Bridges Java and Python execution
  - Executes Python scripts via `ProcessBuilder`
  - Handles performance prediction and sentiment analysis
  - Provides fallback course recommendations

- **`StudentFactory`**: Factory pattern implementation
  - Creates appropriate student type based on input
  - Supports extensibility for new student types

### Exception Handling

- **`StudentNotFoundException`**: Custom exception for missing student records
  - Provides meaningful error messages
  - Integrated with service layer operations

## 🤖 AI Integration

### Performance Prediction Model

The system uses a **Linear Regression** model (via Scikit-Learn) to predict student success:

- **Features**: CPA (0.0-4.0) and Attendance Percentage (0-100)
- **Training Data**: Historical student performance data
- **Output**: Pass/Fail prediction with confidence score

**Usage in Java**:
```java
String prediction = AIHelper.predictPerformance(3.5, 85);
// Returns: "PASS (Confidence: 0.85)" or "RISK OF FAILURE (Confidence: 0.45)"
```

### Sentiment Analysis

TextBlob-based NLP analysis of student feedback:

- **Input**: Free-form text feedback
- **Output**: Sentiment classification (POSITIVE, NEGATIVE, NEUTRAL) with polarity score

**Usage in Java**:
```java
String sentiment = AIHelper.analyzeSentiment("Great course, very helpful!");
// Returns: "POSITIVE (Score: 0.75)"
```

### Course Recommendations

Rule-based recommendation system:

- **High Performers** (CPA ≥ 3.8): Advanced AI courses
- **Average Performers** (CPA ≥ 3.0): Machine Learning Fundamentals
- **Others**: Introduction to Python & Data Science

## 🎨 Design Patterns

### 1. Singleton Pattern
**Location**: `StudentService.java`

Ensures a single instance of the service layer:
```java
public static synchronized StudentService getInstance() {
    if (instance == null) {
        instance = new StudentService();
    }
    return instance;
}
```

### 2. Factory Pattern
**Location**: `StudentFactory.java`

Centralized object creation:
```java
Student s = StudentFactory.createStudent(type, id, name, email, cpa, att, extra);
```

### 3. Inheritance & Polymorphism
**Location**: `Person` → `Student` → `GraduateStudent`

Demonstrates:
- Abstract classes and methods
- Method overriding
- Constructor chaining
- Polymorphic behavior

### 4. Interface Segregation
**Location**: `Searchable.java`

Generic search interface with default methods:
```java
public interface Searchable<T> {
    T search(String query);
    default void printSearchResults(T result) { ... }
}
```

## 🧪 Testing

### Manual Testing

1. **Add Student Test**:
   - Add undergraduate student with CPA 3.5, attendance 85%
   - Verify AI prediction appears
   - Add graduate student with thesis topic
   - Verify different role display

2. **Search Test**:
   - Search for existing student ID
   - Search for non-existent ID (should throw exception)

3. **Update Test**:
   - Update student CPA
   - Verify new course recommendation

4. **AI Integration Test**:
   - Test performance prediction with various CPA/attendance values
   - Test sentiment analysis with positive, negative, and neutral feedback

## 🐛 Troubleshooting

### Common Issues

1. **Python Not Found**:
   - Ensure Python is in system PATH
   - Update `PYTHON_COMMAND` in `AIHelper.java` if needed (use `python3` on Mac/Linux)

2. **Missing Python Dependencies**:
   ```bash
   pip install scikit-learn textblob numpy
   ```

3. **Class Not Found Error**:
   - Ensure all Java files are compiled
   - Check classpath includes compiled classes directory

4. **AI Engine Not Responding**:
   - Verify `ai_engine.py` is in project root
   - Check Python script execution permissions
   - Review error messages in console output

## 📚 Documentation

Additional documentation available in the `docs/` directory:

- [Setup Instructions](docs/Setup_Instructions.md): Detailed environment setup guide
- [JVM Architecture Report](docs/JVM_Architecture_Report.md): JVM internals and architecture documentation

**Built with ❤️ using Java 25 and Python 3**

