package com.demo.testing.service.impl;

import com.demo.testing.exception.StudentNotFoundException;
import com.demo.testing.utils.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.internal.WhiteboxImpl;




@RunWith(PowerMockRunner.class)
//Define all the classes which have private/static methods that will be called
//by the testing method.
@PrepareForTest({Utils.class, HelloServiceImpl.class})
public class HelloServiceImplTest {

    private HelloServiceImpl helloService;

    @Before
    public void setUp() {
        //spy is used when we have to write test for public method which
        //calls the private method, and the private method should be mocked.
        helloService = PowerMockito.spy(new HelloServiceImpl());
        //we have to mock the static class whose method will behave on the way
        //in which we have defined in tests.
        PowerMockito.mockStatic(Utils.class);
    }

    @Test
    public void testGreetStudentForValidId() throws Exception {
        
        Integer i = 1;
        String expectedResult = "Hello Tejas";
        PowerMockito.when(Utils.validateId(i))
                .thenReturn(true);

        PowerMockito.when(helloService, "getStudentName", i)
                .thenReturn("Tejas");

       
        String actualResult = helloService.greet(i);

       
        Assert.assertEquals(expectedResult, actualResult);
    }

  
    @Test(expected = StudentNotFoundException.class)
    public void testGreetStudentForInvalidId() throws Exception {

        Integer i = 3;
       
        PowerMockito.when(Utils.validateId(i))
                .thenReturn(false);

        
        PowerMockito.when(helloService, "getStudentName", i)
                .thenReturn("Tejas");
        
        helloService.greet(i);
    }

    @Test
    public void testGetStudentName() throws Exception {
        //to call the private method we should use WhiteboxImpl or related class.
        Assert.assertEquals("Tejas", WhiteboxImpl.invokeMethod(helloService,
                "getStudentName", 1));
    }

}