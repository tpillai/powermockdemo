package com.demo.testing.service;




import com.demo.testing.exception.StudentNotFoundException;

public interface HelloService{

    String greet(Integer id) throws StudentNotFoundException;

}
