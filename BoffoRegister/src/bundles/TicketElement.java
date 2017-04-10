package bundles;

// Will be a transaction object

import Product.Product;
import database.BoffoDbObject;

// extends BoffoDatabaseObject
public abstract class TicketElement extends BoffoDbObject{

    protected String name;
    protected String description;

    protected TicketElement(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public abstract double getPrice();
    
    public static double getPriceTicketElements(PairList<TicketElement> elements){
        return 0.0;
    }
    
    public static double getPriceProducts(PairList<Product> products){
        return getPriceTicketElements(toTicketElements(products));
    }
    
    public static PairList<TicketElement> toTicketElements(PairList<Product> products){
        return new PairList();
    }

}
