import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderLine } from 'src/app/model/order-line.module'
import { OrderLineService } from 'src/app/service/order-line.service';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  order: OrderLine = {};
  orderLines: OrderLine[] = [];
  totalPrice: number;
  quantity: number[] = [];
  selectedQuantity: number;

  constructor(
    private service: OrderLineService,
    private router: Router,
    private productService: ProductService
  ) { }

  ngOnInit(): void {
    this.getAllOrderLines();

  }

  private getAllOrderLines() {
    this.totalPrice = 0;
    this.service.getAll().subscribe(
      data => {
        this.orderLines = data;
        for(var value of this.orderLines){
          this.totalPrice+= value.product.price * value.quantityOfProducts;
        }
      });
  }

  deleteItem(orderLine: OrderLine){
      orderLine.product.quantity = orderLine.product.availableQuantity;
      this.productService.update(orderLine.product).subscribe();
      this.service.delete(orderLine.id).subscribe(error => console.log(error));
      window.location.reload();
  }

  numberArray(remainingProducts: number, orderLine: OrderLine): number[] {
    let numbers: number[] = [];
    for (let i = 1; i <= remainingProducts; i++){
      numbers[i-1] = i;
    }

    return numbers;
  }

}
