import { Byte } from "@angular/compiler/src/util";
import { Address } from "./address.module";
import { Role } from "./role.module";

/**
 * Model for backend UserAccount POJO
 *
 * @author Mark Salumaa
 */

export class UserAccount {
    id?: number;
    login?: string;
    password?: string;
    firstName?: string;
    lastName?: string;
    roles?: Role[];
    avatar?: Byte;
    isActive?: boolean;
    address?: Address;
    active?: boolean;
}
