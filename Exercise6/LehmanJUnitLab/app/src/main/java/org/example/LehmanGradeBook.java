package org.example;

public class LehmanGradeBook {
    public boolean isPassing(int grade) {
        if(grade < 0 || grade > 100) {
            throw new IllegalArgumentException();
        }
        return grade >= 70;
    }

    public char getLetterGrade(int score) {
        if(score >= 90) return 'A';
        if(score >= 80) return 'B';
        if(score >= 70) return 'C';
        return 'F';
    }
}