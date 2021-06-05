package com.online.store.payload.request;

import com.online.store.entity.Address;
import com.online.store.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * POJO for registration request
 *
 * @author Dmitri Tšornõi
 */
@Data
@NoArgsConstructor
public class SignUpRequest {

    @Email
    @NotBlank
    private String login;

    @NotBlank
    @Size(min = 4, max = 20)
    private String password;

    private String firstName;

    private String lastName;

    private Address address;

    private List<Role> roles;

    private boolean isActive;
}
