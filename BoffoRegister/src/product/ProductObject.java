package product;
import database.BoffoDatbaseAPI;
import database.BoffoDbObject;
//Will extend TicketElement later which inherts from BoffoDbObject.

public class ProductObject extends BoffoDbObject{
   
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
    public ProductObject(){
        this.name = "";
        this.quantity = 0;
        this.price = 0.00;
        this.UPC = 0;
        this.SKU = "";
//        this.rat = null;
        this.uuid = null;
    }
    public ProductObject(String name, int quant, double price, int UPC, String s, String u){
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
    public String getName(){
        return this.name;
    }
    public void setPrice(double p){
        this.price = p;
    }
    public double getPrice(){
        return this.price;
    }
    public void setQuantity(int q){
        this.quantity = q;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void setUPC(int u){
        this.UPC = u;
    }
    public int getUPC(){
        return this.UPC;
    }
    public void setSKU(String s){
        this.SKU = s;
    }
    public String getSKU(){
        return this.SKU;
    }
    public ProductObject getProduct(){
        return new ProductObject(this.name, this.quantity, this.price, this.UPC, this.SKU, this.uuid);
    }
    public static BoffoDbObject createDbObject(){
        return BoffoDbObject.create();
    }
    /*
    cast(Object o) is a method of java.lang.Class<T> class and casts 
    an object to the class specified by the Class object, in this case; product.
    */
    public static ProductObject castAsProduct(BoffoDbObject o){
        try{
            System.out.println("Cast successful.");
            return ProductObject.class.cast(o);
        } catch (ClassCastException e){
            System.out.println("Cast unsuccessful.");
            return null;
        }
    }
    //2nd parameter changed to String for now restricted to only String type.
    //Maybe make a generic tableElement helper class with field and value
    public static ProductObject loadBySKU(String field, String u){
        return ProductObject.castAsProduct(createDbObject().load(field, u));
    }
    public static ProductObject loadByUPC(String field, String u){
        return ProductObject.castAsProduct(createDbObject().load(field, u));
    }
    public static ProductObject loadByName(String field, String n){
       return ProductObject.castAsProduct(createDbObject().load(field, n));
    }
    public static ProductObject loadByQuantity(String field, String q){
       return ProductObject.castAsProduct(createDbObject().load(field, q));
    }
    public static ProductObject loadByRating(String field, String r){
        return ProductObject.castAsProduct(createDbObject().load(field, r));
    }
    public static ProductObject loadByPrice(String field, String p){
        return ProductObject.castAsProduct(createDbObject().load(field, p));
        //where loadByPrice(field, value) is a function looking up from a table
        //cast as Product
    } 
//    public static void main(String[] args) {
//        int num = 333;
//        String numString = String.valueOf(num);
//        ProductObject p = new ProductObject();
//        System.out.println("testing numString: " + numString);
//        System.out.println(ProductObject.loadByName(p.tableName, numString));
//        System.out.println(BoffoDbObject.create().getUuid());
//        System.out.println("--------------------");
//        p.setName("hello");
//        p.setPrice(10.2);
//        p.setQuantity(3);
//        p.setSKU("skuskuskuskusku");
//        p.setUPC(5555);
//        p.setUuid("uuid");
//        ProductObject p2 = new ProductObject("name", 5, 3.33, 7, "SKU", "UUID");
//        System.out.println(p2.getSKU() + p2.getName());
//        
////       p.load("string inside", tableName);
//       // System.out.println("testing castAsProduct() " + Product.castAsProduct(p.load("tableName", numString)));
////        System.out.println("object: " + p.toString());
//    }
} 