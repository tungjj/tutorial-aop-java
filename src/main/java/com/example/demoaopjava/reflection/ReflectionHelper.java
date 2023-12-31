package com.example.demoaopjava.reflection;

import com.example.demoaopjava.annotation.DateFormat;
import com.example.demoaopjava.entity.Ticket;

import java.lang.reflect.Field;

public class ReflectionHelper {
    public static String getValueFromAnnotation(Class<?> clazz, String fieldName) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:
                fields) {
            if(field.getName().equals(fieldName)){
                DateFormat anno = field.getAnnotation(DateFormat.class);
                return anno.value();
            }
        }
        return null;
    }
}
