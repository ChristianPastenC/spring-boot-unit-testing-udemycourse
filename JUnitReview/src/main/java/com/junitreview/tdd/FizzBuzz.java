package com.junitreview.tdd;

public class FizzBuzz {
    // If number is divisible by 3, print Fuzz
    // If number is divisible by 5, print Buzz
    // If number is divisible by 3 and 5 (15), print FizBuzz
    // If number is NOT divisible by 3 or 5, then print the number

    public static String compute(int i) {
        StringBuilder result = new StringBuilder();
        if ( i % 3 == 0){
            result.append("Fizz");
        }

        if ( i % 5 == 0){
            result.append("Buzz");
        }

        if ( result.length() == 0 ){
            result.append(i);
        }

        return result.toString();
    }
}
/*
    public static String compute(int i) {
        if( (i % 3 == 0 ) && (i % 5 == 0)){
            return "FizzBuzz";
        }
        if(i % 3 == 0){
            return "Fizz";
        }else if(i % 5 == 0) {
            return "Buzz";
        }else {
            return Integer.toString(i);
        }
    }
*/
