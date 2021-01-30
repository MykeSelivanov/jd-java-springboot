package com.training.service;

import com.training.model.Class;

import java.util.List;

public interface ClassService {

    Class getClass(Long id);
    List<Class> getClasses();
    List<Class> deleteClass(Long id);
    List<Class> updateClass(Long id, Class address);
    List<Class> createClass(Class address);

}
