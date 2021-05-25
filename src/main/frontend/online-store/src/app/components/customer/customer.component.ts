import { Component, OnInit } from '@angular/core';
import { UserAccount } from 'src/app/model/user-account.module';
import {UserAccountService} from "../../service/user-account.service";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customers: UserAccount[] = [];

  constructor(private service: UserAccountService) { }

  ngOnInit(): void {
    this.service.getAllUserAccounts().subscribe(
      data => {
        this.customers = data;
        console.log(data);
      }
    );
  }

}
