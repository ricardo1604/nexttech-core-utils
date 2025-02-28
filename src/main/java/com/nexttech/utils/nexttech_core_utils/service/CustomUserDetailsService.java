package com.nexttech.utils.nexttech_core_utils.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nexttech.utils.nexttech_core_utils.repository.UserRepositorio;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepositorio userRepositorio;

    public CustomUserDetailsService(UserRepositorio userRepositorio) {
        this.userRepositorio = userRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepositorio.findByUsuario(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }

}
