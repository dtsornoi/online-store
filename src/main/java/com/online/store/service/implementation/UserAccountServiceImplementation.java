package com.online.store.service.implementation;

import com.online.store.entity.Address;
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
        userAccount.setActive(true);
        userAccountRepository.saveAndFlush(userAccount);
    }

    @Override
    public void update(UserAccount userAccount) {
        userAccountRepository.saveAndFlush(userAccount);
    }

    @Override
    public void delete(Long id) {
        UserAccount userAccount = findOne(id);
        userAccount.setActive(false);
        userAccountRepository.saveAndFlush(userAccount);
    }

    @Override
    public void restore(Long id) {
        UserAccount userAccount = findOne(id);
        userAccount.setActive(true);
        userAccountRepository.saveAndFlush(userAccount);
    }

    @Override
    public Boolean existsByLogin(String loginName) {
        return userAccountRepository.existsByLogin(loginName);
    }
}
