package com.training.implementation;

import com.training.model.Class;
import com.training.repository.ClassRepository;
import com.training.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    ClassRepository classRepository;

    @Override
    public Class getClass(Long id) {
        return null;
    }

    @Override
    public List<Class> getClasses() {
        return null;
    }

    @Override
    public List<Class> deleteClass(Long id) {
        return null;
    }

    @Override
    public List<Class> updateClass(Long id, Class address) {
        return null;
    }

    @Override
    public List<Class> createClass(Class address) {
        return null;
    }

}
