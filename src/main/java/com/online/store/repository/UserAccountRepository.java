package com.online.store.repository;

import com.online.store.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for UserAccount.class
 *
 * @author Mark Salumaa
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
