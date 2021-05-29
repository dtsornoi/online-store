import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderLine } from 'src/app/model/order-line.module'
import { OrderLineService } from 'src/app/service/order-line.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  order: OrderLine = {};
  orderLines: OrderLine[] = [];
  totalPrice: number;


  constructor(private service: OrderLineService,
    private router: Router) { }

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
        console.log(data);
      });
  }

  quantityPlus (id: number){
    this.service.quantityPlus(id).subscribe(error => console.log(error));
    window.location.reload();
  }

  quantityMinus(id: number){
    this.service.quantityMinus(id).subscribe(error => console.log(error));
    window.location.reload();
  }

  deleteItem(id: number){
      this.service.delete(id).subscribe(error => console.log(error));
      window.location.reload();   
  }

}
