import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Products} from '../../model/products.module';
import {Router} from '@angular/router';
import {TokenStorageService} from '../../service/token-storage.service';
import {UserAccount} from '../../model/user-account.module';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  products: Products[] = [];
  latestProducts: Products[] = [];
  isLoggedIn: boolean = false;
  currentUser: UserAccount = {};

  constructor(
    private productService: ProductService,
    private router: Router,
    private token: TokenStorageService
  ) { }

  ngOnInit(): void {
    this.productService.getAllActive().subscribe(
      data => {
        this.products = data;
        if (this.products.length >= 3){
          this.latestProducts.push(this.products.pop());
          this.latestProducts.push(this.products.pop());
          this.latestProducts.push(this.products.pop());
        }else if(this.products.length < 3 && this.products.length != 0){
          this.latestProducts.push(this.products.pop());
        }

      }
    );

    if (this.token.getToken()){
      this.isLoggedIn = true;
      this.currentUser = this.token.getUser();
    }
  }

  toUpperCase(str: string): string {
    return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
  }

  goToProductDescription(id): void {
    if (this.isLoggedIn){
      this.router.navigate([`product-description/${id}`]);
    }
  }
}
