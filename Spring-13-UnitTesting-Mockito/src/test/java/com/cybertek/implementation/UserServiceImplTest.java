package com.cybertek.implementation;

import com.cybertek.mapper.MapperUtil;
import com.cybertek.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    MapperUtil mapperUtil;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void deleteByUserName() {

        userService.deleteByUserName("mike@gmail.com");

        verify(userRepository).deleteByUserName("mike@gmail.com");
        verify(userRepository, times(2)).deleteByUserName("mike@gmail.com");
        verify(userRepository, atLeastOnce()).deleteByUserName("mike@gmail.com");
        verify(userRepository, atMost(5)).deleteByUserName("mike@gmail.com");

    }
}