import { OrderLine } from "./order-line.module";
import {UserAccount} from "./user-account.module";

/**
 * Model for backend Orders POJO
 *
 * @author Mark Salumaa
 */


export class Orders {
    id?: number;
    userName?: string;
    totalCost?: number;
    deliveryAddress?: string;
    dateOfOrder?: Date;
    status?: string;
    isActive?: boolean;
    orderLines?: OrderLine[];
    userAccount?: UserAccount;
}
