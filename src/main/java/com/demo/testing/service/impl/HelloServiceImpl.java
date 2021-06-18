package com.demo.testing.service.impl;

import com.demo.testing.exception.StudentNotFoundException;
import com.demo.testing.service.HelloService;
import com.demo.testing.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;



@Service
public class HelloServiceImpl implements HelloService {

    public String greet(Integer id) throws StudentNotFoundException {
        if(Utils.validateId(id) && id > 0 && id < 3){
            return "Hello " + getStudentName(id);
        }
        throw new StudentNotFoundException("Student Not Found");
    }

    private String getStudentName(Integer id){
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(1, "Tejas");
        studentMap.put(2, "Naga");
        return studentMap.get(id);
    }

}
