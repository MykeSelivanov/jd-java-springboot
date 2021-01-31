package com.training.service;

import com.training.model.Class;

import java.util.List;

public interface ClassService {

    Class getClass(Long id);
    List<Class> getClasses();
    List<Class> deleteClass(Long id);
    Class updateClass(Long id, Class studentClass) throws Exception;
    List<Class> createClass(Class studentClass);

}
