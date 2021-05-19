import { Author } from "./author.module";
import { Category } from "./category.module";

/**
 * Model for backend Products POJO
 * 
 * @author Mark Salumaa 
 */

export class Products {
    id?: number;
    title?: string;
    description?: string;
    thumbnail?: string;
    price?: number;
    isActive?: number;
    category?: Category;
    author?: Author;
}
