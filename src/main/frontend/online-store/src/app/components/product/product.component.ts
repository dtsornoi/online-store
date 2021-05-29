import { Component, OnInit } from '@angular/core';
import { OrderLine } from 'src/app/model/order-line.module';
import { Products } from 'src/app/model/products.module';
import { OrderLineService } from 'src/app/service/order-line.service';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Products[] = [];
  orderLines: OrderLine = {
    product: {}
  };

  constructor(private productService: ProductService,
    private orderLineService: OrderLineService) { }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
      data => {
        this.products = data;
      }
    );
  }

  addToCart(productId: number){
    this.orderLines.isActive = true;
    this.orderLines.quantityOfProducts = 1;
    this.orderLines.product.id = productId;
    this.orderLineService.create(this.orderLines).subscribe(error => console.log(error));
  }
}
