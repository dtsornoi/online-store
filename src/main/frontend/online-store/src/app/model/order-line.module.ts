import { Products } from "./products.module";

/**
 * Model for backend OrderLines POJO
 * 
 * @author Mark Salumaa 
 */

export class OrderLine {
    id?: number;
    quantityOfProducts?: number;
    isActive?: boolean;
    product?: Products;
}
