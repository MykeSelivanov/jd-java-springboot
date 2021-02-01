package com.training.implementation;

import com.training.model.Address;
import com.training.model.Parent;
import com.training.repository.ParentRepository;
import com.training.service.ParentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService {

    ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public Parent getParent(Long id) {
        return parentRepository.findById(id).get();
    }

    @Override
    public List<Parent> getParents() {
        return parentRepository.findAll();
    }

    @Override
    public List<Parent> deleteParent(Long id) {
        parentRepository.deleteById(id);
        return parentRepository.findAll();
    }

    @Override
    public Parent updateParent(Long id, Parent parent) throws Exception {
        Optional<Parent> parentEntity = parentRepository.findById(id);
        if (!parentEntity.isPresent()) {
            throw new Exception("Address does not exist");
        }
        parent.setId(parentEntity.get().getId());
        return parentRepository.save(parent);
    }

    @Override
    public List<Parent> createParent(Parent parent) {
        parentRepository.save(parent);
        return parentRepository.findAll();
    }
}
