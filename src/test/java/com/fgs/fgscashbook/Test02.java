package com.fgs.fgscashbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test02 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("123");
        list2.add("123");
        Map<String, Long> result1 = list.stream().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));
        System.out.println(result1.toString());

    }
}
