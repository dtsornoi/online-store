import { Component, OnInit } from '@angular/core';
import {Products} from "../../model/products.module";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {Category} from "../../model/category.module";
import {CategoryService} from "../../service/category.service";
import {UserAccountService} from "../../service/user-account.service";
import {UserAccount} from "../../model/user-account.module";
import { AbstractControl, FormArray, FormBuilder, FormGroup } from '@angular/forms';
import {TokenStorageService} from '../../service/token-storage.service';
import {timeout} from 'rxjs/operators';

@Component({
  selector: 'app-add-new-product',
  templateUrl: './add-new-product.component.html',
  styleUrls: ['./add-new-product.component.css']
})
export class AddNewProductComponent implements OnInit {

  product: Products = {};
  categoryId: number;
  categories: Category[] = [];
  userId: number;
  userAccounts: UserAccount[] = [];
  imageForm: FormGroup;
  hasErrors: boolean = false;
  message = '';

  constructor(
    private service: ProductService,
    private router: Router,
    private categoryService: CategoryService,
    private userService: UserAccountService,
    private token: TokenStorageService,
    private formBuilder: FormBuilder
  ) {
    this.imageForm = this.formBuilder.group({
      images: this.formBuilder.array([
        this.formBuilder.control(null)
      ])
    })
   }

  addImage(): void {
    (this.imageForm.get('images') as FormArray).push(
      this.formBuilder.control(null)
    );
  } 

  removeImage(index) {
    (this.imageForm.get('images') as FormArray).removeAt(index);
  }

  getImagesFormControls(): AbstractControl[]{
    return(<FormArray> this.imageForm.get('images')).controls
  }
  

  ngOnInit(): void {
    if (this.token.getToken()){
      this.userId = this.token.getUser().userId;
    }

    this.categoryService.getAll().subscribe(
      data => {
        this.categories = data;
      }
    );

    this.userService.getAllUserAccounts().subscribe(
      data => {
        this.userAccounts = data;
      }
    )

  }

  onSubmit(): void {
    this.userService.getUserAccountById(this.token.getUser().id).subscribe(user =>{
      this.product.userAccount = user;
      this.categoryService.get(this.categoryId).subscribe(
        category => {
          this.product.category = category;
          this.product.isActive = true;
          this.service.create(this.product).subscribe(
            data => {
              this.hasErrors = false;
              this.router.navigate(['product']);
            },
            error => {
              this.hasErrors = true;
              console.log(error.error.message);
              this.message = 'Oops! We have encountered an Error!';
            }
          );
        }
      )
    });
  }

  toUpperCase(str: string): string {
    return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
  }

}
