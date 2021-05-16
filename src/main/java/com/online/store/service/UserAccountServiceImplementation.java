package com.online.store.service;

import com.online.store.entity.UserAccount;
import com.online.store.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountServiceImplementation implements UserAccountService{

    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImplementation(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public Optional<UserAccount> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return null;
    }
}
