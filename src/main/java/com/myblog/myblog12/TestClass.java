package com.myblog.myblog12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(10, 20, 23, 14, 15, 65,14,20, 67,10,20, 68);
        List<Integer> val = data.stream().distinct().collect(Collectors.toList());
        System.out.println(val);
        System.out.println("hello");
    }
}

