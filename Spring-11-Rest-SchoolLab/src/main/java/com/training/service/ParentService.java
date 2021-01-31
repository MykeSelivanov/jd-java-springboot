package com.training.service;

import com.training.model.Parent;

import java.util.List;

public interface ParentService {

    Parent getParent(Long id);
    List<Parent> getParents();
    List<Parent> deleteParent(Long id);
    Parent updateParent(Long id, Parent parent) throws Exception;
    List<Parent> createParent(Parent parent);

}
