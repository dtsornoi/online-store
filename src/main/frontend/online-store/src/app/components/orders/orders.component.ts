import { Component, OnInit } from '@angular/core';
import { Orders } from 'src/app/model/orders.module';
import { OrdersService } from 'src/app/service/orders.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  orders: Orders[] = [];
  
  constructor(
    private ordersService: OrdersService
    ){ }

  ngOnInit(): void {
    this.ordersService.getbyUserId(1).subscribe(
      data =>{
        this.orders = data;
      }
    );
  }

}
