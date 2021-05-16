package com.online.store.service;

import com.online.store.entity.UserAccount;

import java.util.Optional;

public interface UserAccountService {
    Optional<UserAccount> findOne(Long id);

    UserAccount save(UserAccount userAccount);

}
