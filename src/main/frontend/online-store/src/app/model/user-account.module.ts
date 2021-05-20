import { Byte } from "@angular/compiler/src/util";
import { Adress } from "./adress.module";
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
    address?: Adress;
    roles?: Role[];
    avatar?: Byte;
}
