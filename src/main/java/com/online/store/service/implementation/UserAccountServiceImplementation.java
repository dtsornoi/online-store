package com.online.store.service.implementation;

import com.online.store.entity.UserAccount;
import com.online.store.repository.UserAccountRepository;
import com.online.store.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for UserAccount.class
 *
 * @author Dmitri Tsornoi
 */
@Service
public class UserAccountServiceImplementation implements UserAccountService {

    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImplementation(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public List<UserAccount> getAll() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount findOne(Long id) {
        return userAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("UserAccount not found"));
    }

    @Override
    public void save(UserAccount userAccount) {
        userAccountRepository.saveAndFlush(userAccount);
    }

    @Override
    public void update(UserAccount userAccount) {
        userAccountRepository.saveAndFlush(userAccount);
    }

    @Override
    public void delete(UserAccount userAccount) {
        userAccount.setActive(false);
        save(userAccount);
    }

    @Override
    public void restore(UserAccount userAccount) {
        userAccount.setActive(true);
        save(userAccount);
    }
}
