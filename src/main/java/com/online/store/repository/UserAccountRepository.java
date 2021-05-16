package com.online.store.repository;

import com.online.store.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for UserAccount.class
 *
 * @author Mark Salumaa
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
