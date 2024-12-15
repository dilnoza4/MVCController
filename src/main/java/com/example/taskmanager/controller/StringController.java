package com.example.taskmanager.controller;

import com.example.taskmanager.service.StringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/strings")
public class StringController {
    private final StringService stringService;

    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping("/reverse")
    public ResponseEntity<String> reverse(@RequestParam String input) {
        return ResponseEntity.ok(stringService.reverse(input));
    }

    @GetMapping("/count-vowels")
    public ResponseEntity<Long> countVowels(@RequestParam String input) {
        return ResponseEntity.ok(stringService.countVowels(input));
    }

    @GetMapping("/to-upper")
    public ResponseEntity<String> toUpperCase(@RequestParam String input) {
        return ResponseEntity.ok(stringService.toUpperCase(input));
    }
}
