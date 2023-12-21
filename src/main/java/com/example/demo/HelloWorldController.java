package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Received request for /hello");
        String response = "Hello World";
        System.out.println("Returning response: " + response);
        return response;
    }

    @GetMapping("/reverse")
    public String reverseString(@RequestParam("input") String input) {
        System.out.println("Received request for /reverse with input: " + input);
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        String response = reversed.toString();
        System.out.println("Returning response: " + response);
        return response;
    }

    // operación para eleminar vocales del string
    @GetMapping("/removevocals")
    public String removeVocals(@RequestParam("input") String input) {
        System.out.println("Received request for /removevocals with input: " + input);
        String response = input.replaceAll("[AEIOUaeiou]", "");
        System.out.println("Returning response: " + response);
        return response;
    }

    @GetMapping("/palindrome")
    public boolean isPalindrome(@RequestParam("input") String input) {
        // Eliminar espacios y convertir a minúsculas
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();
        
        // Comparar el input con su reverso
        String reversedInput = new StringBuilder(cleanInput).reverse().toString();
        
        return cleanInput.equals(reversedInput);
    }

}
