import { Component, OnInit } from '@angular/core';
import { Products } from 'src/app/model/products.module';
import { ProductService } from 'src/app/service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Products[] = [];


  constructor(
    private productService: ProductService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
      data => {
        this.products = data;
      }
    );
  }

  goToProductDescription(id): void {
    this.router.navigate([`product-description/${id}`]);
  }
}
