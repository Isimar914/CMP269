package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class AppTest {
    @Test
    @DisplayName("Grade 70 should return true for passing") void testPassingGrade() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertTrue(gb.isPassing(70), "A grade of 70 should pass.");
    }

    @Test
    @DisplayName("Score 95 should return A") void testLetterGradeA() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('A', gb.getLetterGrade(95));
    }
    @Test
    @DisplayName("Score 50 should return F") void testLetterGradeF() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('F', gb.getLetterGrade(50));
    }

    @Test
    @DisplayName("Score 90 should return A") void testBoundry90() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('A', gb.getLetterGrade(90));
    }
    @Test
    @DisplayName("Score 70 should return B") void testBoundry80() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('B', gb.getLetterGrade(80));
    }
    @Test
    @DisplayName("Score 70 should return C") void testBoundry70() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('C', gb.getLetterGrade(70));
    }

    @Test void testInvalidGradeThrowsException() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertThrows(IllegalArgumentException.class, () -> {
            gb.isPassing(150);
        });
    }
}
