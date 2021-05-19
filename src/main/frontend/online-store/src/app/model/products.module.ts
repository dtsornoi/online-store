import { Author } from "./author.module";
import { Category } from "./category.module";

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
