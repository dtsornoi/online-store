import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Products} from '../../model/products.module';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  products: Products[] = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
      data => {
        this.products = data;
      }
    );
  }

}
