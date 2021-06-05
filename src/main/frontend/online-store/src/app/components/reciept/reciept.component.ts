import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Orders } from 'src/app/model/orders.module';
import { OrdersService } from 'src/app/service/orders.service';

@Component({
  selector: 'app-reciept',
  templateUrl: './reciept.component.html',
  styleUrls: ['./reciept.component.css']
})
export class RecieptComponent implements OnInit {

  id: number;
  orders: Orders= {
    orderLines:[]    
  };

  constructor(
    private route: ActivatedRoute,
    private ordersService: OrdersService
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.ordersService.get(this.id).subscribe(
      data =>{
        this.orders = data;
      console.log(this.orders);
      }
    );
  }

}
