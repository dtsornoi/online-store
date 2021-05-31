import { Component, OnInit } from '@angular/core';
import { Products } from 'src/app/model/products.module';
import { ProductService } from 'src/app/service/product.service';
import {Router} from '@angular/router';
import { Category } from 'src/app/model/category.module';
import { CategoryService } from 'src/app/service/category.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  products: Products[] = [];
  filters: Category[] = [];

  constructor(
    private productService: ProductService,
    private router: Router,
    private categoryService: CategoryService
    ) { }

  ngOnInit(): void {
    this.productService.getAllActive().subscribe(
      data => {
        this.products = data;
      }
    );
    this.categoryService.getAll().subscribe(
      data => {
        this.filters = data;
      }
    );
  }

  goToProductDescription(id): void {
    this.router.navigate([`product-description/${id}`]);
  }

  applyFilter(filter): void {
    filter > 0 ? this.productService.filterByComponentId(filter).subscribe(data => {this.products = data}) : this.productService.getAllActive().subscribe(data => {this.products = data});
    
  }
}
