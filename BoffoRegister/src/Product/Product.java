import database.BoffoDatbaseAPI;
import database.BoffoDbObject;

public class product extends BoffoDbObject{
   
        protected String name;
        protected int quantity;
        protected double price;
        protected int UPC;
        protected String SKU;
        protected Rating rat;
        protected String uuid;
        /* Since a product with a field name and value is part of the object
           maybe add member variables accordingly, but for narrow scope's sake
           keep the variables local for now.
        */
    public product(){
        this.name = "";
        this.quantity = 0;
        this.price = 0.00;
        this.UPC = 0;
        this.SKU = "";
        this.rat = null;
        this.uuid = null;
    }
    public product(String name, int quant, double price, int UPC, String s, Rating r, String u){
       this.name = name;
       this.quantity = quant;
       this.price = price;
       this.UPC = UPC;
       this.SKU = s;
       this.rat = r;
       this.uuid = u;
    }
    public product getProduct(){
        return this;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setPrice(double p){
        this.price = p;
    }
    public void setQuantity(int q){
        this.quantity = q;
    }
    public void setUPC(int u){
        this.UPC = u;
    }
    public void setSKU(String s){
        this.SKU = s;
    }
    public String create(){
       return null;
    }
    /*
    cast(Object o) is a method of java.lang.Class<T> class and casts 
    an object to the class specified by the Class object, in this case; product.
    */
    public static product castAsProduct(BoffoDbObject o){
        
        try{
            return product.class.cast(o);
        } catch (ClassCastException e){
            System.out.println("Cast unsuccessful.");
            return null;
        }
    }
    public static product loadBySKU(String field, String u){
        return product.castAsProduct(BoffoDbObject.loadDbObject(field, u));
    }
    public static product loadByUPC(String field, int u){
        return BoffoDbObject.loadObject(field, u);
    }
    public static product loadByName(String n){
        return BoffoDbObject.loadObject(n);
    }
    public static product loadByQuantity(String field, int q){
        return BoffoDbObject.loadObject(field, q);
    }
    public static product loadByRating(String field, Rating r){
        return BoffoDbObject.loadObject(field, r);
    }
    public static product loadByPrice(String field, double p){
        return BoffoDbObject.loadObject(field, p);
        //where loadByPrice(field, value) is a function looking up from a table
        //cast as Product
    } 
} 