package com.example.taskmanager.service;

import org.springframework.stereotype.Service;

@Service
public class StringService {
    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public long countVowels(String input) {
        return input.chars().filter(c -> "aeiouAEIOU".indexOf(c) != -1).count();
    }

    public String toUpperCase(String input) {
        return input.toUpperCase();
    }
}
