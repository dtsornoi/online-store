import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule} from './app-routing.module';
import { AppComponent } from './app.component';
import { AddNewProductComponent } from './components/add-new-product/add-new-product.component';
import { AddNewCategoryComponent } from './components/add-new-category/add-new-category.component';
import { HomeComponent } from './components/home/home.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CustomerComponent } from './components/customer/customer.component';
import { ProductComponent } from './components/product/product.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { CartComponent } from './components/cart/cart.component';
import { FooterComponent } from './components/footer/footer.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MainNavComponent } from './components/main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule} from '@angular/material/menu';
import {MatCardModule} from "@angular/material/card";
import {MatSelectModule} from '@angular/material/select';
import { ProductDescriptionComponent } from './components/product-description/product-description.component';
import {MatOptionModule} from '@angular/material/core';
import { AdminProductsListComponent } from './components/admin-products-list/admin-products-list.component';
import { MatFormFieldModule} from '@angular/material/form-field';
import { UpdateProductsListComponent } from './components/update-products-list/update-products-list.component';
import { ProfileComponent } from './components/profile/profile.component';
import { OrdersComponent } from './components/orders/orders.component';
import { RecieptComponent } from './components/reciept/reciept.component';
import { NumericDirective } from './numeric.directive';

@NgModule({
  declarations: [
    AppComponent,
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
    MainNavComponent,
    ProductDescriptionComponent,
    AdminProductsListComponent,
    UpdateProductsListComponent,
    ProfileComponent,
    OrdersComponent,
    RecieptComponent,
    NumericDirective
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        NgbModule,
        BrowserAnimationsModule,
        FlexLayoutModule,
        LayoutModule,
        MatToolbarModule,
        MatButtonModule,
        MatSidenavModule,
        MatIconModule,
        MatListModule,
        MatMenuModule,
        MatCardModule,
        MatSelectModule,
        MatOptionModule,
        MatFormFieldModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
