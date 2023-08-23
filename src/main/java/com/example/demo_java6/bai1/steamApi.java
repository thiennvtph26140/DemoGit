package com.example.demo_java6.bai1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class steamApi {
    static  List<Student> list = Arrays.asList(
            new Student("nguyen van a", 7.5),
            new Student("nguyen thi b", 5.5),
            new Student("nguyen van c", 6.5),
            new Student("nguyen van d", 9.5)
    ) ;
    public static void main(String[] args) {
        demo4();
    }

    private static void demo4() {
        Double average = list.stream()
                .mapToDouble(sv-> sv.getMark())
                .average().getAsDouble();
        System.out.println("--average: " + average);

        Double sum = list.stream()
                .mapToDouble(sv -> sv.getMark())
                .sum();
        System.out.println("sum: " + sum);

        Double min_mark = list.stream()
                .mapToDouble(sv -> sv.getMark())
                .min().getAsDouble();
        System.out.println("min mark: " + min_mark);

        boolean all_passed =  list.stream().allMatch(sv -> sv.getMark() >= 5);
        System.out.println("all_passed: " + all_passed);

        Student min_sv = list.stream()
                .reduce(list.get(0),(min,sv)-> sv.getMark() < min.getMark()?sv:min);
        System.out.println("min_sv" + min_sv.getName());
    }

    private static void demo3() {
        List<Student> result = list.stream()
                .filter(sv -> sv.getMark()>7)
                .peek(sv -> sv.setName(sv.getName().toUpperCase()))
                .collect(Collectors.toList());

        result.forEach(sv -> {
            System.out.println("-- Name:" + sv.getName());
            System.out.println("-- Mark:" + sv.getMark());
            System.out.println();
                });

    }

    private static void demo2() {
        List<Integer> list = Arrays.asList(1,9,4,7,5,2);
        List<Double> result = list.stream()
                .filter(n-> n % 2 == 0)
                .map(n -> Math.sqrt(n))
                .peek(d-> System.out.println(d))
                .collect(Collectors.toList());

    }

    private static void demo1() {
        Stream<Integer> stream1 = Stream.of(1,9,4,2,6,5,8);
        stream1.forEach(n -> {
            System.out.println(n);
        });
    }
}
