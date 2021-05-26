import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule} from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { AddNewProductComponent } from './components/add-new-product/add-new-product.component';
import { AddNewCategoryComponent } from './components/add-new-category/add-new-category.component';
import { HomeComponent } from './components/home/home.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CustomerComponent } from './components/customer/customer.component';
import { ProductComponent } from './components/product/product.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { CartComponent } from './components/cart/cart.component';
import { FooterComponent } from './components/footer/footer.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';
import { DeleteCustomerComponent } from './components/delete-customer/delete-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    AddNewProductComponent,
    AddNewCategoryComponent,
    HomeComponent,
    CustomerComponent,
    ProductComponent,
    LoginComponent,
    RegisterComponent,
    CartComponent,
    FooterComponent,
    UpdateCustomerComponent,
    DeleteCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
