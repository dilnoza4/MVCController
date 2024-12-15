package com.example.taskmanager.controller;

import com.example.taskmanager.service.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {
    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/add")
    public ResponseEntity<Double> add(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(mathService.add(a, b));
    }

    @GetMapping("/subtract")
    public ResponseEntity<Double> subtract(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(mathService.subtract(a, b));
    }

    @GetMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(mathService.multiply(a, b));
    }

    @GetMapping("/divide")
    public ResponseEntity<?> divide(@RequestParam double a, @RequestParam double b) {
        try {
            return ResponseEntity.ok(mathService.divide(a, b));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
