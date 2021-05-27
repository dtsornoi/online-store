import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './components/customer/customer.component';
import { ProductComponent } from './components/product/product.component';
import {HomeComponent} from './components/home/home.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';
import {AddNewProductComponent} from "./components/add-new-product/add-new-product.component";
import {RegisterComponent} from "./components/register/register.component";

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'customer', component: CustomerComponent},
  { path: 'product', component: ProductComponent},
  { path: 'update-customer/:id', component: UpdateCustomerComponent},
  { path: 'new-product', component: AddNewProductComponent},
  { path: 'register', component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
