import { Address } from "./address.module";
import { UserAccount } from "./user-account.module";

/**
 * Model for backend Customer POJO
 * 
 * @author Mark Salumaa 
 */

export class Customer {
    id?: number;
    address?: Address;
    userAccount?: UserAccount;
    isActive?: boolean;
}
