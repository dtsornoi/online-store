import { Author } from "./author.module";
import { UserAccount } from "./user-account.module";

export class Customer {
    id?: number;
    author?: Author;
    userAccount?: UserAccount;
    isActive?: boolean;
}
