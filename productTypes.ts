export type Category = 'Electronics' | 'Clothing' | 'Home' | 'Beauty';

export interface Product {
  id: string;
  name: string;
  price: number;
  category: Category;
  tags: string[];
  inStock: boolean;
}

export type CartItem = Product & { quantity: number };