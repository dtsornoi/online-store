import { Component, OnInit } from '@angular/core';
import {Products} from "../../model/products.module";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {Category} from "../../model/category.module";
import {CategoryService} from "../../service/category.service";
import {UserAccountService} from "../../service/user-account.service";
import {UserAccount} from "../../model/user-account.module";
import {FormBuilder, FormGroup } from '@angular/forms';
import {TokenStorageService} from '../../service/token-storage.service';
import { Images } from '../../model/images';
import { ImagesService } from '../../service/images.service';

@Component({
  selector: 'app-add-new-product',
  templateUrl: './add-new-product.component.html',
  styleUrls: ['./add-new-product.component.css']
})
export class AddNewProductComponent implements OnInit {

  image: Images = {};
  product: Products = {
    images: []
  };
  categoryId: number;
  categories: Category[] = [];
  userId: number;
  userAccounts: UserAccount[] = [];
  imageForm: FormGroup;
  hasErrors: boolean = false;
  message = '';

  constructor(
    private imageService: ImagesService,
    private service: ProductService,
    private router: Router,
    private categoryService: CategoryService,
    private userService: UserAccountService,
    private token: TokenStorageService,
    private formBuilder: FormBuilder
  ) {
    this.imageForm = this.formBuilder.group({
      images: this.formBuilder.array([
        this.formBuilder.control(null)
      ])
    })
   }

  ngOnInit(): void {
    if (this.token.getToken()){
      this.userId = this.token.getUser().userId;
    }

    this.categoryService.getAll().subscribe(
      data => {
        this.categories = data;
      }
    );

    this.userService.getAllUserAccounts().subscribe(
      data => {
        this.userAccounts = data;
      }
    )
  }

  onSubmit(): void {
    this.userService.getUserAccountById(this.token.getUser().id).subscribe(user =>{
      this.product.userAccount = user;
      this.categoryService.get(this.categoryId).subscribe(
        category => {
          this.product.category = category;
          this.product.isActive = true;
          this.image.isActive = true;
          this.imageService.create(this.image).subscribe(
            newImage => {
              this.product.images.push(newImage);
              this.product.mainImageId = newImage.imageId;
              this.service.create(this.product).subscribe(
                data => {
                  this.hasErrors = false;
                  this.router.navigate(['product']);
                },
                error => {
                  this.errorMessage('Oops! We have encountered an Error!' ,error);
                }
              );
            }, error => {
              this.errorMessage('Oops! We have encountered an Error!' ,error);
            }
          );
        }, error => {
          this.errorMessage('Oops! We have encountered an Error!' ,error);
        }
      )
    });

  }

  private errorMessage(message, error){
    this.hasErrors = true;
    this.message = message;
    console.log(error.error.message);
  }

  toUpperCase(str: string): string {
    return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
  }

}
