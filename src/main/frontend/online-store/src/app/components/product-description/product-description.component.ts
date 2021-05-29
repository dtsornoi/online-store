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
  quantity: number[] = [];
  selectedQuantity: number;

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
        for (let number = 1; number <=this.selectedProduct.quantity; number++){
          this.quantity.push(number);
        }
      }
    );

    if (this.selectedQuantity == this.selectedProduct.quantity){
      this.productService.delete(this.productId).subscribe(
        data => window.location.reload()
      );
    }
  }

  addToCart(productId: number){
    this.orderLines.isActive = true;
    this.orderLines.quantityOfProducts = this.selectedQuantity;
    this.orderLines.product.id = productId;
    this.orderLineService.create(this.orderLines).subscribe(error => console.log(error));
  }
}
