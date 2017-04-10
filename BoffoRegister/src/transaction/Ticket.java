package transaction;

import java.util.ArrayList;
import java.util.List;
import Product.Product;


public class Ticket extends Transaction {

    private List<Product> products;

    public Ticket(List<Product> products) {
        ArrayList<Product> list = new ArrayList<Product>();

    }

    public Product addProduct(int UPC) {
        Product product = new Product(UPC);
        products.add(product);
        return product;
    }
    
     public Product removeProduct(int UPC){

        return null; 
      }

    public Product getProduct(int UPC) {
        for (Product product : products) {
            if (product.getUPC() == UPC) {
                return product;
            }
        }
        return null;
    }
    
      public double getTotalPrice() {
	double totalPrice = 0;
	for (int i=0; i< Product.size(); i++) {
	    Object obj = Product.get(i);
	    Product p = (Product)obj;
	    totalPrice = totalPrice + p.getPrice();
	}
	return totalPrice;
    }

}