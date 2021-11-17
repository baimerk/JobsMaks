package com.example.jobs.service.impl;

import com.example.jobs.entities.User;
import com.example.jobs.repository.BaseRepository;
import com.example.jobs.repository.impl.UserRepositoryImpl;
import com.example.jobs.service.BaseService;

import java.util.List;

public class UserServiceImpl implements BaseService<User> {

    private BaseRepository<User> repository;

    public UserServiceImpl() {
        this.repository = new UserRepositoryImpl();
    }

    @Override
    public User findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean save(User entity) {
        return repository.save(entity);
    }
}
