import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/model/customer.module';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {


  id: number;
  customer: Customer = new Customer();
  constructor( private customerService: CustomerService,
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
      this.customerService.get(this.id).subscribe(data => {
        this.customer = data;
      });
    }

    onSubmit(){
      this.customerService.update(this.customer).subscribe(data => {
          this.goToCustomersList();
      },
      error => console.log(error));
    }
    goToCustomersList(){
      this.router.navigate(['/customer']);
    }

  }



