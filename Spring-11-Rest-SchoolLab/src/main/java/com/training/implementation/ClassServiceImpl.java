package com.training.implementation;

import com.training.model.Class;
import com.training.repository.ClassRepository;
import com.training.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Class getClass(Long id) {
        return classRepository.findById(id).get();
    }

    @Override
    public List<Class> getClasses() {
        return classRepository.findAll();
    }

    @Override
    public List<Class> deleteClass(Long id) {
        classRepository.deleteById(id);
        return classRepository.findAll();
    }

    @Override
    public List<Class> updateClass(Long id, Class studentClass) {
        Class classEntity = classRepository.findById(id).get();
        studentClass.setId(classEntity.getId());
        classRepository.save(studentClass);
        return classRepository.findAll();
    }

    @Override
    public List<Class> createClass(Class studentClass) {
        classRepository.save(studentClass);
        return classRepository.findAll();
    }

}
