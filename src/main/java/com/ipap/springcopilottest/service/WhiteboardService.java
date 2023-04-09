package com.ipap.springcopilottest.service;

public class WhiteboardService {

    // is palindrome?
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        for (int i = 0; i < s1.length() / 2; i++) {
            if (s1.charAt(i) != s1.charAt(s1.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // is anagram?
    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int[] letters = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i)]--;
            if (letters[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    // method will remove anu given substring from a string
    public String removeSubstring(String s, String sub) {
        return s.replaceAll(sub, "");
    }

    // method will reverse a string
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // method will reverse a string
    public String reverseString2(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
        return new String(a);
    }

    // method will remove any given substring from a string
    public String removeSubstring3(String s, String sub) {
        int index = s.indexOf(sub);
        while (index != -1) {
            s = s.substring(0, index) + s.substring(index + sub.length());
            index = s.indexOf(sub, index);
        }
        return s;
    }

    // method will remove any given substring from a string
    public String removeSubstring4(String s, String sub) {
        int index = s.indexOf(sub);
        while (index != -1) {
            s = s.replace(sub, "");
            index = s.indexOf(sub, index);
        }
        return s;
    }

    // count the number of times a substring occurs in a string
    public int countSubstring(String s, String sub) {
        int count = 0;
        int index = s.indexOf(sub);
        while (index != -1) {
            count++;
            index = s.indexOf(sub, index + 1);
        }
        return count;
    }


}
