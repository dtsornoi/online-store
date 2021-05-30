import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProductsListComponent } from './update-products-list.component';

describe('UpdateProductsListComponent', () => {
  let component: UpdateProductsListComponent;
  let fixture: ComponentFixture<UpdateProductsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateProductsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateProductsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
