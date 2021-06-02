import { Component, OnInit } from '@angular/core';
import { UserAccount } from 'src/app/model/user-account.module';
import { UserAccountService } from 'src/app/service/user-account.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  password: string = '';
  confirmPassword: string = '';
  passwordMissmatch: boolean = false;
  success: boolean = false;

  profile: UserAccount = {
    address: {}
  };

  constructor(
    private userAccountService: UserAccountService
  ) { }

  ngOnInit(): void {
    this.userAccountService.getUserAccountById(1).subscribe(
      data => {
        this.profile = data;
      }
    );
  }

  onSubmit(){
    if (this.password!='') {
    this.password === this.confirmPassword ? this.updateUser() : this.passwordMissMatch();
    } else {
      alert('Input Password!')
    }
  }

  private passwordMissMatch(){
    this.passwordMissmatch = true;
    this.success = false;
    this.password = '';
    this.confirmPassword = '';
    window.scroll({ top: 0, left: 0});
  }

  private  updateUser(){
    this.success = true;
    this.passwordMissmatch = false;
    this.password = '';
    this.confirmPassword = '';
    this.userAccountService.updateUserAccount(this.profile).subscribe(
      data => window.scroll({ top: 0, left: 0}),
      error => console.log(error)
    );
  }

}
