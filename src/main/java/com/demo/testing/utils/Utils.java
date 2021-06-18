package com.demo.testing.utils;


import java.util.Objects;

public class Utils {

    public static boolean validateId(Integer id) {
        return Objects.nonNull(id);
    }

}
