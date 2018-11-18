package com.company;

/*
Problem
Tatiana likes to keep things tidy. Her toys are sorted from smallest to largest, her pencils are sorted
from shortest to longest and her computers from oldest to newest. One day, when practicing her counting skills,
she noticed that some integers, when written in base 10 with no leading zeroes, have their digits sorted in
non-decreasing order. Some examples of this are 8, 123, 555, and 224488. She decided to call these numbers tidy.
Numbers that do not have this property, like 20, 321, 495 and 999990, are not tidy.

She just finished counting all positive integers in ascending order from 1 to N. What was the last tidy
number she counted?

Input
The first line of the input gives the number of test cases, T. T lines follow. Each line describes a
test case with a single integer N, the last number counted by Tatiana.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1)
and y is the last tidy number counted by Tatiana.

Limits
1 ≤ T ≤ 100.
Small dataset
1 ≤ N ≤ 1000.
Large dataset
1 ≤ N ≤ 1018.
Sample

Input

Output

4
132
1000
7
111111111111111110

Case #1: 129
Case #2: 999
Case #3: 7
Case #4: 99999999999999999
*/

public class TidyNumbers {

    public static void main(String[] args){
        System.out.println(solve(132));
    }


    public static long solve(long n){
        long copy = n;
        while (!isTidy(copy)){
            copy = nextNumber(copy);
        }
        return copy;
    }

    // 1234
    // 1234 % 10 = 4
    // 1234 % 100 = 34 / 10 = 3
    public static boolean isTidy(long n){
        long rightmost;
        long leftofit;
        for(long i = n; i >= 10; i=i/10){
            rightmost = i % 10;
            leftofit = i % 100 / 10;
            if (rightmost < leftofit) {
                return false;
            }
        }
        return true;
    }

    public static long nextNumber(long n){
        char[] digits = Long.toString(n).toCharArray();
        int current, next = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            current = Character.getNumericValue(digits[i]);
            next = Character.getNumericValue(digits[i+1]);
            // If the current digit is greater than the next
            // Like '1' '3' '2'
            // We want it to look like '1' '3' <--- current
            if (current > next) {
                // Add '1' and '3' to new string
                for (int x = 0; x < i; x++) {
                    sb.append(digits[x]);
                }
                // Subtract 1 from the current digit
                // '3' - 1 = '2' =>  '1' '2'
                sb.append(current - 1);
                // Then we append 9's at the end
                // '1' '2' '9'
                for (int m = i + 1; m < digits.length; m++) {
                    sb.append(9);
                }
                return Long.parseLong(new String(sb));
            }
        }
        return n-1;
    }



}
