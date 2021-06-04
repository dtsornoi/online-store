package com.online.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Class that implements UserDetails interface for usage with Spring Security
 *
 * @author Dmitri Tšornõi
 */
public class StoreUserDetails implements UserDetails {

    private final String username;

    private final Long id;

    private final String firstName;

    @JsonIgnore
    private final String password;

    private final Boolean isActive;

    private final Collection<? extends GrantedAuthority> authorities;


    public StoreUserDetails(UserAccount userAccount) {
        this.id = userAccount.getId();
        this.username = userAccount.getLogin();
        this.firstName = userAccount.getFirstName();
        this.password = userAccount.getPassword();
        this.isActive = userAccount.isActive();
        this.authorities = userAccount.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
