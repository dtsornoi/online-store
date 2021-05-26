import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAccount } from 'src/app/model/user-account.module';
import {UserAccountService} from "../../service/user-account.service";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customers: UserAccount[] = [];

  constructor(private service: UserAccountService,
    private router: Router) { }


    ngOnInit(): void{
      this.getAllUserAccounts();
    }

 private getAllUserAccounts() {
    this.service.getAllUserAccounts().subscribe(
      data => {
        this.customers = data;
        console.log(data);
      });
  }


  updateCustomer(id: number){
    this.router.navigate(['update-customer', id]);
  }


changeCustomerStatus(id: number, isActive: boolean){
  isActive === true ? this.service.deleteUserAccount(id).subscribe(error => console.log(error)) : this.service.restoreUserAccount(id).subscribe(error => console.log(error));
  window.location.reload();
  }
}
