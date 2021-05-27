import { Component, OnInit } from '@angular/core';
import {UserAccount} from "../../model/user-account.module";
import {Address} from "../../model/address.module";
import {Role} from "../../model/role.module";
import {RolesService} from "../../service/roles.service";
import {UserAccountService} from "../../service/user-account.service";
import {Router} from "@angular/router";
import {buildLocalizeReplacement} from "@angular/localize/src/tools/src/source_file_utils";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userAccount: UserAccount = {
    address: {}
  };
  roles: Role[] = [];

  constructor(
    private roleService: RolesService,
    private userAccountService: UserAccountService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.roleService.getAllRoles().subscribe(
      data => {
        this.roles = data;
      }
    );
  }

  onSubmit() {
    this.userAccount.roles = this.roles;
    this.userAccountService.saveUserAccount(this.userAccount).subscribe(
      data => {
        this.router.navigate(['']);
      }
    );
  }
}
