package Product;

import database.BoffoDatbaseAPI;
import database.BoffoDbObject;

public class Product extends BoffoDbObject{
   
        protected String name;
        protected int quantity;
        protected double price;
        protected int UPC;
        protected String SKU;
//        protected Rating rat;
        protected final String tableName = "Product";
        protected String uuid;
        /* Since a product with a field name and value is part of the object
           maybe add member variables accordingly, but for narrow scope's sake
           keep the variables local for now.
        */
    public Product(){
        this.name = "";
        this.quantity = 0;
        this.price = 0.00;
        this.UPC = 0;
        this.SKU = "";
//        this.rat = null;
        this.uuid = null;
    }
    public Product(String name, int quant, double price, int UPC, String s, String u){
       this.name = name;
       this.quantity = quant;
       this.price = price;
       this.UPC = UPC;
       this.SKU = s;
//       this.rat = r;
       this.uuid = u;
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
    public Product getProduct(){
        return new Product(this.name, this.quantity, this.price, this.UPC, this.SKU, this.uuid);
    }
    public static BoffoDbObject createDbObject(){
        return BoffoDbObject.create();
    }
    /*
    cast(Object o) is a method of java.lang.Class<T> class and casts 
    an object to the class specified by the Class object, in this case; product.
    */
    public static Product castAsProduct(BoffoDbObject o){
        try{
            System.out.println("Cast successful.");
            return Product.class.cast(o);
        } catch (ClassCastException e){
            System.out.println("Cast unsuccessful.");
            return null;
        }
    }
    //2nd parameter changed to String for now restricted to only String type
    public static Product loadBySKU(String field, String u){
        return Product.castAsProduct(createDbObject().load(field, u));
    }
    public static Product loadByUPC(String field, String u){
        return Product.castAsProduct(createDbObject().load(field, u));
    }
    public static Product loadByName(String field, String n){
       return Product.castAsProduct(createDbObject().load(field, n));
    }
    public static Product loadByQuantity(String field, String q){
       return Product.castAsProduct(createDbObject().load(field, q));
    }
    public static Product loadByRating(String field, String r){
        return Product.castAsProduct(createDbObject().load(field, r));
    }
    public static Product loadByPrice(String field, String p){
        return Product.castAsProduct(createDbObject().load(field, p));
        //where loadByPrice(field, value) is a function looking up from a table
        //cast as Product
    } 
    public static void main(String[] args) {
        int num = 333333;
        String numString = String.valueOf(num);
        Product p = new Product();
        System.out.println("testing numString: " + numString);
        System.out.println(Product.loadByName(p.tableName, numString));
        System.out.println(BoffoDbObject.create().getUuid());
        System.out.println("--------------------");
        p.setName("hello");
        p.setPrice(10.2);
        p.setQuantity(3);
        p.setSKU("skuskuskuskusku");
        p.setUPC(5555);
        p.setUuid("uuid");
        System.out.println(p.getProduct());
        
//       p.load("string inside", tableName);
       // System.out.println("testing castAsProduct() " + Product.castAsProduct(p.load("tableName", numString)));
//        System.out.println("object: " + p.toString());
    }
} 