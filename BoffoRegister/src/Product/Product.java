package Product;

//import database.BoffoDatbaseAPI;
import database.BoffoDbObject;

public class Product extends BoffoDbObject{
        
        protected String tableName = "product";
        protected String name;
        protected int quantity;
        protected double price;
        protected int UPC;
        protected String SKU;
//        protected Rating rat;
        protected String table;
        protected String uuid;
        /* Since a product with a field name and value is part of the object
           maybe add member variables accordingly, but for narrow scope's sake
           keep the variables local for now.
        */
    public Product(){
        super();
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
    public Product getProduct(){
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

//    public String create(){
//        return BoffoDbObject.create().toString();
//       //return product.castAsProduct(BoffoDbObject.create()).toString();
//    }
    /*
    cast(Object o) is a method of java.lang.Class<T> class and casts 
    an object to the class specified by the Class object, in this case; product.
    */
    public static Product castAsProduct(BoffoDbObject o){
        
        try{
            return Product.class.cast(o);
        } catch (ClassCastException e){
            System.out.println("Cast unsuccessful.");
            return null;
        }
    }
    public static Product loadBySKU(String field, String u){
        BoffoDbObject db = new BoffoDbObject();
        return Product.castAsProduct(db.load(field, u));
    }
//    public static product loadByUPC(String field, int u){
//        return BoffoDbObject.loadObject(field, u);
//    }
//    public static product loadByName(String n){
//        return BoffoDbObject.loadObject(n);
//    }
//    public static product loadByQuantity(String field, int q){
//        return BoffoDbObject.loadObject(field, q);
//    }
//    public static product loadByRating(String field, Rating r){
//        return BoffoDbObject.loadObject(field, r);
//    }
//    public static product loadByPrice(String field, double p){
//        return BoffoDbObject.loadObject(field, p);
//        //where loadByPrice(field, value) is a function looking up from a table
//        //cast as Product
//    } 
    public static void main(String[] args) {
        Product p = new Product();
        int num = 333333;
        String numString = String.valueOf(num);
        
       p.load("field","value" );
       // System.out.println("testing castAsProduct() " + Product.castAsProduct(p.load("tableName", numString)));
        System.out.println("object: " + p.toString());
    }
} 