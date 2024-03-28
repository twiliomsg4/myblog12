package com.myblog.myblog12.security;

import com.myblog.myblog12.entity.Role;
import com.myblog.myblog12.entity.User;
import com.myblog.myblog12.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomerDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(username, username)
                .orElseThrow(() ->
        new UsernameNotFoundException("User not found with username or email:" + username));

     return new org.springframework.security.core.userdetails.User(user.getEmail(),
              user.getPassword(),mapRolesAuthorities(user.getRoles())
     );

    }

    private Collection<? extends GrantedAuthority> mapRolesAuthorities(Set<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
