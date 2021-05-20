package com.online.store.controller;

import com.online.store.entity.Role;
import com.online.store.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for Role.Class
 * URI:<code>/api/user-account</code>
 *
 * @author Mark Salumaa
 */

@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = "*")
public class RoleRestController {

    private final RoleService roleService;

    @Autowired
    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * GET:<code>/</code>
     * @return All roles
     */
    @GetMapping("/")
    public ResponseEntity<List<Role>> getAllRole(){
        List<Role> role = roleService.findAll();
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    /**
     * GET:<code>/id</code>
     * @param id of type Long for searching Role by Id in DB
     * @return Role with specified Id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRolesById(@PathVariable("id") Long id) {
        Role role = roleService.findOne(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    /**
     * POST:<code>/</code>
     * @param role from UI to updated in DB
     * @return HttpStatus 201
     */
    @PostMapping("/")
    public ResponseEntity<HttpStatus> createRole(@RequestBody Role role){
        roleService.save(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * PUT:<code>/</code>
     * @param role from UI to be persisted to DB
     * @return HttpStatus 200
     */
    @PutMapping("/")
    public ResponseEntity<HttpStatus> updateRole(@RequestBody Role role){
        roleService.update(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/delete/id</code>
     * @param id of type Long for searching Role which to delete by id
     * @return HttpStatus 200
     */
    @PostMapping("/delete/")
    public ResponseEntity<HttpStatus> deleteRole(@RequestBody Role role){
        roleService.delete(role.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/restore/id</code>
     * @param id of type Long for searching Role which to restore by ID
     * @return HttpStatus 200
     */
    @PostMapping("/restore/")
    public ResponseEntity<HttpStatus> restoreRole(@RequestBody Role role){
        roleService.restore(role.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
