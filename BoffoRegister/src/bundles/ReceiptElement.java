package bundles;

// Will be a transaction object

import Product.Product;
import database.BoffoDbObject;

// extends BoffoDatabaseObject
public abstract class ReceiptElement extends BoffoDbObject{

    protected String name;
    protected String description;

    protected ReceiptElement(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public abstract double getPrice();
    
    public static double getPriceReceiptElements(PairList<ReceiptElement> elements){
        return 0.0;
    }
    
    public static double getPriceProducts(PairList<Product> products){
        return getPriceReceiptElements(toReceiptElements(products));
    }
    
    public static PairList<ReceiptElement> toReceiptElements(PairList<Product> products){
        return new PairList();
    }

}
