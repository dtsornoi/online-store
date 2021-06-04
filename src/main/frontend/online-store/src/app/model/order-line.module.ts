import { Products } from "./products.module";
import { UserAccount } from "./user-account.module";

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
    userAccount?: UserAccount;
}
