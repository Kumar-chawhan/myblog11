package com.myblog.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(10, 12, 13, 2, 4, 5, 7, 7);
//        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//        System.out.println(evenNumbers);

//        List<String > data = Arrays.asList("mike","stalin", "mike" ,"Adam");
//        List<String> d = data.stream().filter(n -> n .equals("mike")).collect(Collectors.toList());
//        List<String> d1 = data.stream().filter(n -> n.startsWith("A")).collect(Collectors.toList());
//        System.out.println(d1);
//
//
//        System.out.println(d);
//
//        Function<Integer ,Integer> result = i-> i+10;
//        Integer val = result.apply(30);
//        System.out.println(val);

//        List<String> d1 = Arrays.asList("mike","stalin","kumar","naveen");
//        List<String> collect = d1.stream().map(i -> i.replace()).collect(Collectors.toList());
//        System.out.println(collect);

//           List<Integer> data = Arrays.asList(10,20,23,14,15,65,67,57,80);
//        List<Integer> val = data.stream().distinct().collect(Collectors.toList());
//        System.out.println(val);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("Testing"));
    }
}
