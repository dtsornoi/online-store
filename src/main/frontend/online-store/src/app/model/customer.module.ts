import { Author } from "./author.module";
import { UserAccount } from "./user-account.module";

/**
 * Model for backend Customer POJO
 * 
 * @author Mark Salumaa 
 */

export class Customer {
    id?: number;
    author?: Author;
    userAccount?: UserAccount;
    isActive?: boolean;
}
