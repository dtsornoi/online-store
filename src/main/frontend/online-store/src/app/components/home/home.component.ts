import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Products} from '../../model/products.module';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  products: Products[] = [];
  latestProducts: Products[] = [];

  constructor(
    private productService: ProductService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
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
  }

  goToProductDescription(id): void {
    this.router.navigate([`product-description/${id}`]);
  }
}
