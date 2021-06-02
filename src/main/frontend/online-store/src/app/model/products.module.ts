import { Category } from "./category.module";
import {UserAccount} from "./user-account.module";

/**
 * Model for backend Products POJO
 *
 * @author Mark Salumaa
 */

export class Products {
    id?: number;
    title?: string;
    description?: string;
    image?: string;
    price?: number;
    quantity?: number;
    isActive?: boolean;
    category?: Category;
    userAccount?: UserAccount;
    active?: boolean;
    availableQuantity?: number;

}
