import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute} from '@angular/router';
import {Products} from '../../model/products.module';
import {OrderLineService} from '../../service/order-line.service';
import {OrderLine} from '../../model/order-line.module';

@Component({
  selector: 'app-product-description',
  templateUrl: './product-description.component.html',
  styleUrls: ['./product-description.component.css']
})
export class ProductDescriptionComponent implements OnInit {

  productId: string;
  selectedProduct: Products = {
    userAccount: {},
    category: {}
  };
  orderLines: OrderLine = {
    product: {}
  };

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private orderLineService: OrderLineService
  ) { }

  ngOnInit(): void {
    this.productId = this.route.snapshot.paramMap.get('id');

    this.productService.get(this.productId).subscribe(
      data => {
        this.selectedProduct = data;
      }
    )
  }

  addToCart(productId: number){
    this.orderLines.isActive = true;
    this.orderLines.quantityOfProducts = 1;
    this.orderLines.product.id = productId;
    this.orderLineService.create(this.orderLines).subscribe(error => console.log(error));
  }
}
