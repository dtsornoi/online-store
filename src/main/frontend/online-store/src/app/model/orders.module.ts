import { Customer } from "./customer.module";
import { OrderLine } from "./order-line.module";

export class Orders {
    id?: number;
    userName?: string;
    totalCost?: number;
    deliveryAddress?: string;
    dateOfOrder?: Date;
    status?: string;
    isActive?: boolean;
    orderLines?: OrderLine[];
    customer?: Customer;
}
