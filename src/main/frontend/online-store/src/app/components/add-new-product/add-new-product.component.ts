import { Component, OnInit } from '@angular/core';
import {Products} from "../../model/products.module";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {Category} from "../../model/category.module";
import {CategoryService} from "../../service/category.service";
import {UserAccountService} from "../../service/user-account.service";
import {UserAccount} from "../../model/user-account.module";
import {TokenStorageService} from '../../service/token-storage.service';

@Component({
  selector: 'app-add-new-product',
  templateUrl: './add-new-product.component.html',
  styleUrls: ['./add-new-product.component.css']
})
export class AddNewProductComponent implements OnInit {

  product: Products = {
    category: {}
  };
  category: Category = {};
  categories: Category[] = [];
  userAccounts: UserAccount[] = [];
  currentUser: UserAccount = {};
  hasErrors: boolean = false;
  message = '';

  constructor(
    private productService: ProductService,
    private router: Router,
    private categoryService: CategoryService,
    private userService: UserAccountService,
    private token: TokenStorageService
  ) { }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(
      data => {
        this.categories = data;
      },
      error => {
        this.message = error.error.message;
      }
    );

    this.userService.getAllUserAccounts().subscribe(
      data => {
        this.userAccounts = data;
      },
      error => {
        this.message = error.error.message;
      }
    );

    this.currentUser = this.token.getUser();

  }


  onSubmit(): void {
    this.userAccounts.forEach(user => {
      if (user.id === this.currentUser.id){
        this.product.userAccount = user;
      }
    });

    this.product.isActive = true;
    this.product.category = this.category;
    this.productService.create(this.product).subscribe(
      data => {
        this.hasErrors = false;
        this.router.navigate(['product']);
      },
      error => {
        this.message = error.error.message;
        this.hasErrors = true;
      }
    );
  }

  toUpperCase(str: string): string {
    return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
  }
}
