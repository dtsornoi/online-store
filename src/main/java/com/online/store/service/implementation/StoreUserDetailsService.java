package com.online.store.service.implementation;

import com.online.store.entity.StoreUserDetails;
import com.online.store.entity.UserAccount;
import com.online.store.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * implementation of UserDetailsService
 * for getting user from Repository by username
 * and returning CustomUserDetails
 *
 * @author Dmitri Tšornõi
 */
@Service
public class StoreUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public StoreUserDetailsService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByLogin(loginName)
                .orElseThrow(() -> new RuntimeException("User with login " + loginName + " not found"));

        return new StoreUserDetails(userAccount);
    }
}
