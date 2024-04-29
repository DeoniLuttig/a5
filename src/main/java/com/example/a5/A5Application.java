package com.example.a5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

@SpringBootApplication
public class A5Application {

    public static void main(String[] args) {

        SpringApplication.run(A5Application.class, args); //  0.7, 0.6, 0.5, 0.5, 0.5, 0.4, 0.2, 0.2, 0.1

        System.out.println();
        System.out.print("Enter list of item sizes (where 0 < item size < 1) as a comma seperated list and press enter: ");
        Scanner get = new Scanner(System.in);
        List<Double> items = List.of();

        try {
            items = Stream.of(get.nextLine().replaceAll("\\s", "").split(",")).map(Double::parseDouble).toList();
            (new BinPacking()).run(items);
        } catch (Exception var4) {
            System.out.println("Incorrect input. Please check and try again");
        }
    }
}
