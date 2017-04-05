import java.util.List;
import java.util.ArrayList;
import database.BoffoDatbaseAPI;
import database.BoffoDbObject;
import java.util.UUID;

public class Product extends BoffoDbObject{
        protected Product prod;
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
    public Product(){
        this.uuid = null;
        this.prod = null;
        this.name = "";
        this.quantity = 0;
        this.UPC = 0;
        this.SKU = "";
        this.price = 0.00;
        this.rat = null;
    }
    public Product(Product prod, String name, int quant, double price, int UPC, String s, Rating r, UUID u){
       this.prod = prod;
       this.name = name;
       this.quantity = quant;
       this.price = price;
       this.UPC = UPC;
       this.SKU = s;
       this.rat = r;
       this.uuid = this.create();
    }
    public Product getProduct(){
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
        //this.prod = super.create();
    }
    public static Product findBySKU(String s){
        return Database.findBySKU(s);
    }
    public static Product findByUPC(int u){
        return Database.findByUPC(u);
    }
    public static Product findByName(String n){
        return Database.findByName(n);
    }
    public static Product findbyQuantity(int q){
        return Database.findByQuantity(q);
    }
    public static Product findByPrice(double p){
        return Database.findByPrice(p);
    }
    public static Product findByRating(Rating r){
        return Database.findByRating(r);
    }
} 
