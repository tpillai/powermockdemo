package com.demo.testing.controller;


import com.demo.testing.exception.StudentNotFoundException;
import com.demo.testing.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class HelloController {

    private final HelloService studentService;

    public HelloController(HelloService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public String greetStudent(@PathVariable Integer id) throws StudentNotFoundException {
        return studentService.greet(id);
    }

}
