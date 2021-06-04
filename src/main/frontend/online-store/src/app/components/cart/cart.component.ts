import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderLine } from 'src/app/model/order-line.module'
import { Orders } from 'src/app/model/orders.module';
import { OrderLineService } from 'src/app/service/order-line.service';
import { OrdersService } from 'src/app/service/orders.service';
import { UserAccountService } from 'src/app/service/user-account.service';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartLines: OrderLine[] = [];
  totalPrice: number;
  quantity: number[] = [];
  selectedQuantity: number;
  counter = 0;
  order: Orders = {
    orderLines: [],  
    userAccount: {
      address: {}
    }
  };

  constructor(
    private router: Router,
    private productService: ProductService,
    private userService: UserAccountService,
    private ordersService: OrdersService,
    private orderLineService: OrderLineService
  ) { }

  ngOnInit(): void {
    this.getAllOrderLines();

  }

  private getAllOrderLines() {
    this.totalPrice = 0;
    this.orderLineService.getActiveUserId(1).subscribe(
      data => {
        this.cartLines = data;
        for(var value of this.cartLines){
          this.totalPrice+= value.product.price * value.quantityOfProducts;
          this.counter++;
        }
      });
  }

  deleteItem(orderLine: OrderLine){
      orderLine.product.quantity = orderLine.product.availableQuantity;
      this.productService.update(orderLine.product).subscribe();
      this.orderLineService.delete(orderLine.id).subscribe(error => console.log(error));
      window.location.reload();
  }

  numberArray(remainingProducts: number, orderLine: OrderLine): number[] {
    let numbers: number[] = [];
    for (let i = 1; i <= remainingProducts; i++){
      numbers[i-1] = i;
    }

    return numbers;
  }

  submitOrder(){
    this.userService.getUserAccountById(1).toPromise().then(
      data => {
        this.order.userAccount = data;
        this.order.dateOfOrder = new Date();
        this.order.deliveryAddress = this.order.userAccount.address.street + ' ' + this.order.userAccount.address.zip + ', ' + this.order.userAccount.address.country;
        this.order.status = 'NEW';
        this.order.totalCost = this.totalPrice;
        this.order.orderLines = this.cartLines;
        this.order.userName = this.order.userAccount.login;
        console.log(this.order);

        this.ordersService.create(this.order).toPromise().then(
          orderServiceData => {
          console.log(orderServiceData);

          this.cartLines.forEach(orderLine => {
            this.orderLineService.delete(orderLine.id).toPromise().then();
          });
          this.router.navigate(['orders']);
        });
    });
  }
}
