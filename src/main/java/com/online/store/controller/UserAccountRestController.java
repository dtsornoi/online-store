package com.online.store.controller;

import com.online.store.entity.UserAccount;
import com.online.store.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for UserAccount.Class
 * URI:<code>/api/user-account</code>
 *
 * @author Dmitri Tsornoi
 */
@RestController
@RequestMapping("/api/user-account")
@CrossOrigin(origins = "*")
public class UserAccountRestController {

    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountRestController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    /**
     * GET:<code>/id</code>
     * @param id of type Long for searching UserAccount by Id in DB
     * @return UserAccount with specified Id
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> findUserAccountInDatabaseById(@PathVariable("id") Long id){
        UserAccount userAccount = userAccountService.findOne(id);

        return new ResponseEntity<>(userAccount, HttpStatus.OK);
    }

    /**
     * POST:<code>/</code>
     * @param userAccount from UI to be persisted to DB
     * @return HttpStatus 200
     */
    @PostMapping("/")
    public ResponseEntity<HttpStatus> persistUserAccountToDatabase(@RequestBody UserAccount userAccount){
        userAccountService.save(userAccount);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
