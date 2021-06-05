import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../../service/token-storage.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  isLoggedIn: boolean = false;
  constructor(
    private token: TokenStorageService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (this.token.getToken()){
      this.isLoggedIn = true;
    }
  }

  goToProducts(){
    if (this.isLoggedIn){
      this.router.navigate(['product']);
    }
  }

  goToOrders() {
    if (this.isLoggedIn){
      this.router.navigate(['orders']);
    }
  }

  goToProfile() {
    if (this.isLoggedIn){
      this.router.navigate(['profile']);
    }
  }
}
