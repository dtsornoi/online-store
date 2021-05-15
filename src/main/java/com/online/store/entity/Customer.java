package com.online.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity class for Customer
 *
 * @author Dmitri Tsornoi
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "author_id")
    private Author author;

    @OneToOne(mappedBy = "user_account_id")
    private UserAccount userAccount;
}
