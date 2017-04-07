import database.BoffoDbObject;

public class product extends BoffoDbObject{
   
        protected String name;
        protected int quantity;
        protected double price;
        protected int UPC;
        protected String SKU;
        protected Rating rat;
        protected String uuid;
        
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
        this.prod.name = n;
    }
    public void setPrice(double p){
        this.prod.price = p;
    }
    public void setQuantity(int q){
        this.prod.quantity = q;
    }
    public void setUPC(int u){
        this.prod.UPC = u;
    }
    public void setSKU(String s){
        this.prod.SKU = s;
    }
    public String create(){
       return BoffoDbObject.create();
    }
    public static product findBySKU(String s){
        return BoffoDatbaseAPI.findBySKU(s);
    }
    public static product findByUPC(int u){
        return BoffoDatbaseAPI.findByUPC(u);
    }
    public static product findByName(String n){
        return BoffoDatbaseAPI.findByName(n);
    }
    public static product findbyQuantity(int q){
        return BoffoDatbaseAPI.findByQuantity(q);
    }
    public static product findByPrice(double p){
        return BoffoDatbaseAPI.findByPrice(p);
    }
    public static product findByRating(Rating r){
        return BoffoDatbaseAPI.findByRating(r);
    }
    public void loadByPrice(double p){
        this.loadObj('price field', p);
        //where loadObj(field, value) is a function looking up from a table
    } 
    public Product findBySKU(String s){
        //Keep narrowest scope possible for parameter s.
        return null;
    }
    public Product findByUPC(int u){
        //Keep narrowest scope possible for parameter i.
        return null;
    }
    public Product findByName(String n){
        //Keep narrowest scope possible for parameter n.
        return null;
    }
    public List findbyQuantity(int n){
        /*Find the products that have quantity n and return
        a list of those products.*/
        return null;
    }
    public Product findByPrice(double p){
        /*Depending on the variety of products will this method 
        be able to find a specific product. Otherwise, return a list of 
        products that have parameter p.
        */
        return null;
    }
} 