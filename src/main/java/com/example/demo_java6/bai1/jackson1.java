package com.example.demo_java6.bai1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class jackson1 {
    public static void main(String[] args) throws Exception {
        demo1();
    } 

    private static void demo2() throws IOException {
        String path = "D:\\Java5\\demo_java6\\src\\main\\resources\\templates\\student2.json";
        ObjectMapper mapper =  new ObjectMapper();
        JsonNode student2  = mapper.readTree(new File(path));
        student2.iterator().forEachRemaining(sv ->{
            System.out.println("name: " + sv.get("name").asText());
        });
    }

    private static void demo1() throws Exception {
        String path = "D:\\Java5\\demo_java6\\src\\main\\resources\\templates\\studen.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(path));

        System.out.println(">> Name" + student.get("name").asText());
        System.out.println(">> Gender" + student.get("gender").asBoolean());
        System.out.println(">> marks" + student.get("marks").asDouble());
        System.out.println(">> Email" + student.get("contact").get("email").asText());
        System.out.println(">> Phone" + student.findValue("phone").asText());
        student.get("subject").iterator().forEachRemaining(sub -> {
            System.out.println(">> Subject" + sub.asText());
        });
    }
}
