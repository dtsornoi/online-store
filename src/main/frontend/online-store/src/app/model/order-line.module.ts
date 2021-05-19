import { Products } from "./products.module";

export class OrderLine {
    id?: number;
    quantityOfProducts?: number;
    isActive?: boolean;
    product?: Products;
}
