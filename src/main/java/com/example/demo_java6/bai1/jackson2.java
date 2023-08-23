package com.example.demo_java6.bai1;

import com.example.demo_java6.bean.Contact;
import com.example.demo_java6.bean.Student2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class jackson2 {
    public static void main(String[] args) throws IOException {
        demo6();
    }

    private static void demo6() {
        
    }

    private static void demo5() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name","nguyen viet trung thien");
        student.put("gender", true);
        student.put("marks",8.5);
        ObjectNode contact = student.putObject("contact");
        contact.put("email", "thiennvtph26140@gmail.com");
        student.put("phone","0983148720");
        ArrayNode subject = student.putArray("subject");
        subject.add("WEB1018");
        subject.add("COM104");

        //WRITE TO STRING
        String json = mapper.writeValueAsString(student);
        //write to output
        mapper.writeValue(System.out, student);
        //write to file
        mapper.writeValue(new File("D:\\Java5\\demo_java6\\src\\main\\resources\\templates\\studen.json"), student);
    }

    private static void demo4() throws IOException {
        String path =  "D:\\Java5\\demo_java6\\src\\main\\resources\\templates\\student2.json";
        TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {};
        ObjectMapper mapper = new ObjectMapper();
        List<Student2> student2s = mapper.readValue(new File(path), type);
        student2s.forEach(student2 -> {
            System.out.println("-- name: " + student2.getName());
        });
    }

    private static void demo3() throws IOException {
        // làm việc với đối tượng java thuần tuý
        String path ="D:\\Java5\\demo_java6\\src\\main\\resources\\templates\\studen.json";
        ObjectMapper mapper = new ObjectMapper();
        Student2 student = mapper.readValue(new File(path), Student2.class);

        System.out.println("-- name: " + student.getName());
        System.out.println("-- marks: " + student.getMarks());
        System.out.println("-- gender: " + student.getGender());
        Contact contact = student.getContact();
        System.out.println("-- email: " + contact.getEmail());
        System.out.println("-- phone: " + contact.getPhone());
        List<String> subjects = student.getSubject();
        subjects.forEach(subject->{
            System.out.println("--subject: " + subject);
        });
    }

    private static void demo2() throws IOException {
        //DÙNG MAP ĐỂ ĐỌC DANH SÁCH JSON
        String path = "D:\\Java5\\demo_java6\\src\\main\\resources\\templates\\student2.json";
        ObjectMapper mapper =  new ObjectMapper();
        List<Map<String , Object>> student = mapper.readValue(new File(path), List.class);
        student.forEach(students->{
            System.out.println("-- name: " + students.get("name"));
        });
    }

    private static void demo1() throws IOException {
        //khong su dung json note
         String path = "D:\\Java5\\demo_java6\\src\\main\\resources\\templates\\studen.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> student = mapper.readValue(new File(path), Map.class);

        System.out.println("-- name: " + student.get("name"));
        System.out.println("-- marks: " + student.get("marks"));
        System.out.println("-- gender: " + student.get("gender"));
        Map<String, Object> contact = (Map<String, Object>) student.get("contact");
        System.out.println("-- email: " + contact.get("email"));
        System.out.println("-- phone: " + contact.get("phone"));
        List<String> subjects = (List<String>) student.get("subject");
        subjects.forEach(subject->{
            System.out.println("--subject: " + subject);
        });
    }
}
