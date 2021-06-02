package com.online.store.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * POJO for login request
 *
 * @author Dmitri Tšornõi
 */
@Data
@NoArgsConstructor
public class LoginRequest {

    private String login;

    private String password;
}
