package com.training.implementation;

import com.training.model.Class;
import com.training.model.Parent;
import com.training.repository.ClassRepository;
import com.training.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Class updateClass(Long id, Class studentClass) throws Exception {
        Optional<Class> classEntity = classRepository.findById(id);
        if (!classEntity.isPresent()) {
            throw new Exception("Address does not exist");
        }
        studentClass.setId(classEntity.get().getId());
        return classRepository.save(studentClass);
    }

    @Override
    public List<Class> createClass(Class studentClass) {
        classRepository.save(studentClass);
        return classRepository.findAll();
    }

}
