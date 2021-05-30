import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Products} from '../../model/products.module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-products-list',
  templateUrl: './admin-products-list.component.html',
  styleUrls: ['./admin-products-list.component.css']
})
export class AdminProductsListComponent implements OnInit {

  products: Products[] = [];
  newQuantity: number;

  constructor(
    private productService: ProductService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.productService.getAll().subscribe(
      data => {
        this.products = data;
      }
    )

  }

  setActive(id: number) {
    this.productService.restore(id).subscribe(
      data => window.location.reload()

    );
  }

  setInActive(id: number) {
    this.productService.delete(id).subscribe(
      data => window.location.reload()
    );
  }

  changeProductStatus(id: number, isActive: boolean) {
    isActive === true ? this.productService.delete(id).subscribe(error => console.log(error)) : this.productService.restore(id).subscribe(error => console.log(error));
    window.location.reload();
  }

  updateProductList(id: number){
    this.router.navigate(['update-products-list', id]);
  }

}
