package com.online.store.controller;

import com.online.store.entity.StoreUserDetails;
import com.online.store.entity.UserAccount;
import com.online.store.payload.request.LoginRequest;
import com.online.store.payload.request.SignUpRequest;
import com.online.store.payload.response.JwtResponse;
import com.online.store.payload.response.MessageResponse;
import com.online.store.security.jwt.JwtUtils;
import com.online.store.service.UserAccountService;
import com.online.store.service.implementation.StoreUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;

    private UserAccountService userAccountService;

    private StoreUserDetailsService storeUserDetailsService;

    private PasswordEncoder encoder;

    private JwtUtils jwtUtils;

    @Autowired
    public AuthController(
            AuthenticationManager authenticationManager,
            UserAccountService userAccountService,
            PasswordEncoder encoder,
            JwtUtils jwtUtils,
            StoreUserDetailsService storeUserDetailsService
    ) {
        this.authenticationManager = authenticationManager;
        this.userAccountService = userAccountService;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
        this.storeUserDetailsService = storeUserDetailsService;
    }

    /**
     * Post: <code>/signin</code>
     * @param loginRequest payload from clientside
     * @return jwtResponse with token and user
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(),
                        loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        StoreUserDetails userDetails = (StoreUserDetails) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        JwtResponse jwtResponse = new JwtResponse(
                jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getFirstName(),
                roles);

        return ResponseEntity.ok(jwtResponse);
    }

    /**
     * Post: <code>/signup</code>
     * @param signupRequest from clientside form
     * @return response message if registration was successful
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signupRequest){

        if (userAccountService.existsByLogin(signupRequest.getLogin())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username already exists."));
        }


        UserAccount user = new UserAccount();
        user.setLogin(signupRequest.getLogin());
        user.setPassword(encoder.encode(signupRequest.getPassword()));
        user.setAddress(signupRequest.getAddress());
        user.setActive(signupRequest.isActive());
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setRoles(signupRequest.getRoles());

        userAccountService.save(user);

        return ResponseEntity.ok(new MessageResponse("user registered successfully"));
    }

}
