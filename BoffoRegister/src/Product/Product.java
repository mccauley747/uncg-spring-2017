import java.util.List;
import java.util.ArrayList;
import database.BoffoDatbaseAPI;
import database.BoffoDbObject;
import java.util.UUID;

public class product extends BoffoDbObject{
        protected product prod;
        protected String name;
        protected int quantity;
        protected double price;
        protected int UPC;
        protected String SKU;
        protected Rating rat;
        protected UUID uuid;
        
    public class Rating{
        protected Rating rat;
   
        public Rating(){
            this.rat = null;        
}
        public Rating (Rating r){
            this.rat = r;
        }
        public String toString(Rating r){
            this.rat = r;
            return this.rat.toString();
        }
}
    public product(){
        this.uuid = null;
        this.prod = null;
        this.name = "";
        this.quantity = 0;
        this.UPC = 0;
        this.SKU = "";
        this.price = 0.00;
        this.rat = null;
    }
    public product(product prod, String name, int quant, double price, int UPC, String s, Rating r, UUID u){
       this.prod = prod;
       this.name = name;
       this.quantity = quant;
       this.price = price;
       this.UPC = UPC;
       this.SKU = s;
       this.rat = r;
       this.uuid = this.create();
    }
    public product getProduct(){
        return this.prod;
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
    public void create(){
        //return UUID from create() overridden
        //databse needs access type
        
        this.prod.toString() = (Product)
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
} 
