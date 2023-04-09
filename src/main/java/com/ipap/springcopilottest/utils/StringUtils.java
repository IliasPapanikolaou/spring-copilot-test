package com.ipap.springcopilottest.utils;

public class StringUtils {

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public String appender(String str1, String str2) {
        return str1 + str2;
    }

    public String removeChar(String str, char c) {
        return str.replace(Character.toString(c), "");
    }

    public String replaceWord(String str, String word, String replacement) {
        return str.replace(word, replacement);
    }

    public String removeVowels(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }
}
