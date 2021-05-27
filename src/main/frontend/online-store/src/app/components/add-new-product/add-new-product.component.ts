import { Component, OnInit } from '@angular/core';
import {Products} from "../../model/products.module";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {Category} from "../../model/category.module";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-add-new-product',
  templateUrl: './add-new-product.component.html',
  styleUrls: ['./add-new-product.component.css']
})
export class AddNewProductComponent implements OnInit {

  product: Products = {};
  category: Category = {};
  categories: Category[] = [];

  constructor(
    private service: ProductService,
    private router: Router,
    private categoryService: CategoryService
  ) { }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(
      data => {
        this.categories = data;
      }
    );
  }

  onSubmit(): void {
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
