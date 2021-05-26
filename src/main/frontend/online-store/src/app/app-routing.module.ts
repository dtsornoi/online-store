import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './components/customer/customer.component';
import { ProductComponent } from './components/product/product.component';
import {HomeComponent} from './components/home/home.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'customer', component: CustomerComponent},
  { path: 'product', component: ProductComponent},
  { path: 'update-customer/:id', component: UpdateCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
