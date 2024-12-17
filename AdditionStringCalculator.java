package com.app;

import java.util.ArrayList;
import java.util.List;

public class AdditionStringCalculator {

	public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\n"; 
        String numberString = numbers;

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEndIndex);
     
            delimiter = delimiter.replaceAll("\\.", "\\\\.");
                              
            numberString = numbers.substring(delimiterEndIndex + 1);
        }

        String[] tokens = numberString.split(delimiter);

        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                int num = Integer.parseInt(token.trim());
                if (num < 0) {
                    negatives.add(num);
                }
                sum += num;
            }
        }

        if (negatives.size()>0) {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + negatives);
        }

        return sum;
    }
	
	public static void main(String[] args) {
		AdditionStringCalculator calculator = new AdditionStringCalculator();

	        System.out.println(calculator.add("")); // Output: 0
	        System.out.println(calculator.add("1")); // Output: 1
	        System.out.println(calculator.add("1,5")); // Output: 6
	        System.out.println(calculator.add("1\n2,3")); // Output: 6
	        System.out.println(calculator.add("//;\n1;2")); // Output: 3

//		outputs 0, 1, 6, 6, 3
	}
}
