import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserAccount } from 'src/app/model/user-account.module';
import { UserAccountService } from 'src/app/service/user-account.service';

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {

  id: number;
  isActive: boolean = false;
  customer: UserAccount = new UserAccount();
  constructor( private service: UserAccountService,
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
      this.service.getUserAccountById(this.id).subscribe(data => {
        this.customer = data;
      });
    }


    delete(id: number) {
      if (confirm('Are you sure you want to delete?')) {
        this.service.deleteUserAccount(id).subscribe(data => {
          this.router.navigate(['/customer']);
        });
      }
    }

}
