import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './components/customer/customer.component';
import { ProductComponent } from './components/product/product.component';
import {HomeComponent} from './components/home/home.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';
import {AddNewProductComponent} from "./components/add-new-product/add-new-product.component";
import {RegisterComponent} from "./components/register/register.component";
import { CartComponent } from './components/cart/cart.component';
import {ProductDescriptionComponent} from './components/product-description/product-description.component';
import {AdminProductsListComponent} from './components/admin-products-list/admin-products-list.component';


const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'customer', component: CustomerComponent},
  { path: 'product', component: ProductComponent},
  { path: 'update-customer/:id', component: UpdateCustomerComponent},
  { path: 'new-product', component: AddNewProductComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'cart', component: CartComponent},
  { path: 'product-description/:id', component: ProductDescriptionComponent},
  { path: 'admin-products-list', component: AdminProductsListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
