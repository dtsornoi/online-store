package com.online.store.service;

import com.online.store.entity.UserAccount;

/**
 * Service Interface for UserAccount.class
 *
 * @author Dmitri Tsornoi
 */
public interface UserAccountService {
    UserAccount findOne(Long id);

    void save(UserAccount userAccount);

}
