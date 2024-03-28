package com.myblog.myblog12;

public class SampleTest {
    public static void main(String[] args) {
        // Call the test1 method
        int result = test1();
        System.out.println("Result: " + result);
    }

    public static int test1() {
        int x = 10;
        int y = (x > 5) ? 100 : 200;
        System.out.println(y);  // Output: 100
        return y;
    }
}

