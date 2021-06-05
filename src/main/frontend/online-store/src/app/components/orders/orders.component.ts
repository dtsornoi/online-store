import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Orders } from 'src/app/model/orders.module';
import { OrdersService } from 'src/app/service/orders.service';
import {TokenStorageService} from '../../service/token-storage.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  orders: Orders[] = [];

  constructor(
    private ordersService: OrdersService,
    private token: TokenStorageService,
    private router: Router
    ){ }

  ngOnInit(): void {
    this.ordersService.getbyUserId(this.token.getUser().id).subscribe(
      data =>{
        this.orders = data;
      }
    );
  }

  showOrder(id: number){
    this.router.navigate(['reciept', id]);
  }

}
