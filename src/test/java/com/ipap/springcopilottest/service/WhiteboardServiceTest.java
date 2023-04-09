package com.ipap.springcopilottest.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteboardServiceTest {

    @Test
    void isPalindrome() {
        assertTrue(new WhiteboardService().isPalindrome("abba"));
        assertFalse(new WhiteboardService().isPalindrome("abbaa"));
    }

    @Test
    void isAnagram() {
        assertTrue(new WhiteboardService().isAnagram("abba", "baba"));
        assertFalse(new WhiteboardService().isAnagram("abba", "babaa"));
    }

    @Test
    void removeSubstring() {
        assertEquals("aa", new WhiteboardService().removeSubstring("abba", "b"));
        assertNotEquals("aaa", new WhiteboardService().removeSubstring("abba", "b"));
    }

    @Test
    void reverseString() {
        assertEquals("abba", new WhiteboardService().reverseString("abba"));
        assertNotEquals("abbaa", new WhiteboardService().reverseString("abba"));
    }

    @Test
    void reverseString2() {
        assertEquals("abba", new WhiteboardService().reverseString2("abba"));
        assertNotEquals("abbaa", new WhiteboardService().reverseString2("abba"));
    }

    @Test
    void removeSubstring3() {
        assertEquals("aa", new WhiteboardService().removeSubstring3("abba", "b"));
        assertNotEquals("aaa", new WhiteboardService().removeSubstring3("abba", "b"));
    }

    @Test
    void removeSubstring4() {
        assertEquals("aa", new WhiteboardService().removeSubstring4("abba", "b"));
        assertNotEquals("aaa", new WhiteboardService().removeSubstring4("abba", "b"));
    }

    @Test
    void countSubstring() {
        assertEquals(2, new WhiteboardService().countSubstring("abba", "b"));
        assertNotEquals(3, new WhiteboardService().countSubstring("abba", "b"));
    }
}