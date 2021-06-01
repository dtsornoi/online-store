import { Component, OnInit } from '@angular/core';
import {Products} from "../../model/products.module";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {Category} from "../../model/category.module";
import {CategoryService} from "../../service/category.service";
import {UserAccountService} from "../../service/user-account.service";
import {UserAccount} from "../../model/user-account.module";
import { AbstractControl, FormArray, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-add-new-product',
  templateUrl: './add-new-product.component.html',
  styleUrls: ['./add-new-product.component.css']
})
export class AddNewProductComponent implements OnInit {

  product: Products = {};
  category: Category = {};
  categories: Category[] = [];
  userId: number;
  userAccounts: UserAccount[] = [];
  imageForm: FormGroup;

  constructor(
    private service: ProductService,
    private router: Router,
    private categoryService: CategoryService,
    private userService: UserAccountService,
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
    this.userAccounts.forEach(user => {
      if (user.id === this.userId){
        this.product.userAccount = user;
      }
    });

    this.product.isActive = true;
    this.product.category = this.category;
    this.service.create(this.product).subscribe(
      data => {
        this.router.navigate(['product']);
      }
    );
  }

  selectedCategory(category: Category) {
    this.category = category;
  }
}
