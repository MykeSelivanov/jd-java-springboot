package com.training.service;

import com.training.entity.User;
import com.training.enums.UserState;
import com.training.exception.ServiceException;
import com.training.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User readByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    public User readByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @Transactional
    public User createUser(User user) throws ServiceException {
        User foundUserByEmail = readByEmail(user.getEmail());
        User foundUserByUsername = readByUsername(user.getUsername());
        if(foundUserByEmail != null) {
            throw new ServiceException("This user already exists, please change your email");
        }
        if(foundUserByUsername != null) {
            throw new ServiceException("This user already exists, please change your username");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setIsVerified(false);
        return userRepository.save(user);
    }
    @Transactional
    public User verifyUser(User user) {
        user.setIsVerified(true);
        user.setState(UserState.ACTIVE);
        return userRepository.save(user);
    }
    @Transactional
    public void deleteUser(Integer id) throws ServiceException {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ServiceException("This user does not exist");
        }
        user.setIsVerified(false);
        userRepository.save(user);
    }
    @Transactional
    public User resetPassword(User user) throws ServiceException {
        User foundUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (foundUser == null) {
            throw new ServiceException("User with email does not exists: " + user.getEmail());
        }
        foundUser.setState(UserState.ACTIVE);
        foundUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(foundUser);
    }

}
