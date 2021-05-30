import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Products} from '../../model/products.module';
import {OrderLineService} from '../../service/order-line.service';
import {OrderLine} from '../../model/order-line.module';
import {NgModel} from '@angular/forms';

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
    private orderLineService: OrderLineService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.productId = this.route.snapshot.paramMap.get('id');
    this.productService.get(this.productId).subscribe(
      data => {
        this.selectedProduct = data;
        let i = 1;
        while (i <= this.selectedProduct.quantity){
          this.quantity.push(i);
          i++;
        }
      }
    );
  }

  addToCart(productId: number){
    this.orderLines.isActive = true;
    this.orderLines.quantityOfProducts = this.selectedQuantity;
    let remainingQuantity = this.selectedProduct.quantity - this.selectedQuantity;
    this.selectedProduct.quantity = remainingQuantity;
    this.productService.update(this.selectedProduct).subscribe();
    this.orderLines.product.id = productId;

    this.orderLineService.create(this.orderLines).subscribe(
      data => {
        if(confirm("Do you want to move to cart?")){
          this.router.navigate(['cart']);
        }else {
          window.location.reload();
        }
      }
    );
  }
}