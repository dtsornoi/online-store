package com.online.store.service;

import com.online.store.entity.UserAccount;

import java.util.List;

/**
 * Service Interface for UserAccount.class
 *
 * @author Dmitri Tsornoi
 */
public interface UserAccountService {
    List<UserAccount> getAll();

    UserAccount findOne(Long id);

    void save(UserAccount userAccount);

    void update(UserAccount userAccount);

    void delete(Long id);

    void restore(Long id);
}
