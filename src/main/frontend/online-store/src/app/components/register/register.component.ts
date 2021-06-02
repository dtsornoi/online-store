import { Component, OnInit } from '@angular/core';
import {UserAccount} from "../../model/user-account.module";
import {Role} from "../../model/role.module";
import {RolesService} from "../../service/roles.service";
import {UserAccountService} from "../../service/user-account.service";
import {Router} from "@angular/router";
import {AuthService} from '../../service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userAccount: UserAccount = {
    password: '',
    roles: [],
    address: {}
  };
  role: Role = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  passwordConfirmation = '';

  constructor(
    private roleService: RolesService,
    private userAccountService: UserAccountService,
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.roleService.getRoleById(1).subscribe(
      data => {
        this.role = data;
      }
    );
  }

  checkIfPasswordsMatch(): boolean {
    if (this.userAccount.password.length == 0){
      return false;
    }
    if (this.userAccount.password != this.passwordConfirmation){
      return  true;
    }if (this.userAccount.password === this.passwordConfirmation){
      return  false;
    }
  }

  onSubmit() {
    console.log(this.userAccount.login)
    this.userAccount.roles.push(this.role);
    this.authService.register(this.userAccount).subscribe(
      data => {
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      error => {
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
