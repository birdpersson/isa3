package com.isa35.isa3.service;

import com.isa35.isa3.dto.UserRequest;
import com.isa35.isa3.model.Authority;
import com.isa35.isa3.model.User;
import com.isa35.isa3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorityService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(UserRequest userRequest) {
        User u = new User();
        u.setUsername(userRequest.getUsername());
        u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        u.setFirstName(userRequest.getFirstname());
        u.setLastName(userRequest.getLastname());
        u.setAddress(userRequest.getAddress());
        u.setCity(userRequest.getCity());
        u.setCountry(userRequest.getCountry());
        u.setPhone(userRequest.getPhone());
        u.setRole(User.Role.USER);
        u.setEnabled(true);

        List<Authority> auth = authService.findByName("ROLE_USER");
        u.setAuthorities(auth);

        return userRepository.save(u);
    }

}
