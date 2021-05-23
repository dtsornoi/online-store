import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer.module';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customers: Customer[] = [];

  constructor(private customerService: CustomerService,
    private router: Router) { }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(
      data => {
        this.customers = data;
        console.log(data);
      }
    );
  }

  updateCustomer(id: number){
      this.router.navigate(['update-customer', id]);
  }

}
