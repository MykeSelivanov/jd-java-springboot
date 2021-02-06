package com.training.service;

import com.training.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {

    private UserService userService;

    public SecurityService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User foundUser = loadUser(s);
        if (foundUser == null) throw new UsernameNotFoundException("User not found! - " + s);

        return new org.springframework.security.core.userdetails.User(foundUser.getUsername(), foundUser.getPassword(), listAuthorities(foundUser));
    }

    // User can use email or username to login
    public User loadUser(String value){
        boolean isEmail = value.contains("@");
        return isEmail ? userService.readByEmail(value) : userService.readByUsername(value);
    }

    private List<GrantedAuthority> listAuthorities(User user){
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority(user.getRole().name()));
        return grantedAuthorityList;
    }

}
