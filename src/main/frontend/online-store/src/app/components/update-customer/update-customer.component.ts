import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserAccount } from 'src/app/model/user-account.module';
import { UserAccountService } from 'src/app/service/user-account.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  id: number;
  customer: UserAccount = {
    address: {}
  };
  constructor( private service: UserAccountService,
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
      this.service.getUserAccountById(this.id).subscribe(data => {
        this.customer = data;
      });
    }

    onSubmit(){
      this.service.updateUserAccount(this.customer).subscribe(data => {
          this.goToCustomersList();
      },
      error => console.log(error));
    }
    goToCustomersList(){
      this.router.navigate(['/customer']);
    }


}
