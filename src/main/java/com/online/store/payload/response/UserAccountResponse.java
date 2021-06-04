package com.online.store.payload.response;

import com.online.store.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountResponse {
    private Long id;
    private String login;
    private Collection<Role> roles;
}
