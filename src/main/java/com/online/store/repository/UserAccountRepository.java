package com.online.store.repository;

import com.online.store.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for UserAccount.class
 *
 * @author Mark Salumaa
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByLogin(String loginName);

    Boolean existsByLogin(String loginName);
}
