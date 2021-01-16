package com.devsuperior.dslearnbds.service;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.service.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if(null == user){
            log.error("User not found {}", username);
            throw new UsernameNotFoundException("Email not found.");
        }
        log.info("User found: {}", username);
        return user;
    }

    public UserDTO findById(Long id){
        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
        return new UserDTO(entity);
    }


}
