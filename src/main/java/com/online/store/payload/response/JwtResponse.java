package com.online.store.payload.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * POJO Response for Jwt token and user
 *
 * @author Dmitri Tšornõi
 */
@Data
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String login;
    private String firstName;
    private Collection<String> roles;

    public JwtResponse(String token, Long id, String login, String firstName, Collection<String> roles) {
        this.token = token;
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.roles = roles;
    }
}
