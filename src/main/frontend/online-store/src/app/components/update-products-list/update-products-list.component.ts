import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from 'src/app/model/products.module';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'update-products-list',
  templateUrl: './update-products-list.component.html',
  styleUrls: ['./update-products-list.component.css']
})
export class UpdateProductsListComponent implements OnInit {

  id: number;
  product: Products = {
    userAccount: {}
  };
  constructor( private service: ProductService,
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
      this.service.get(this.id).subscribe(data => {
        this.product = data;
      });
    }

    onSubmit(){
      this.service.update(this.product).subscribe(data => {
          this.goToProductsList();
      },
      error => console.log(error));
    }

    goToProductsList(){
      this.router.navigate(['/admin-products-list']);
    }


    cancel(){
      if(confirm("Are you sure you want to cancel?")){
        this.router.navigate(['/admin-products-list']);
      }else {
        window.location.reload();
      }
    }

}
