import java.util.List;
import java.util.ArrayList;

<<<<<<< HEAD
public class product extends BoffoDbObject{
        protected product prod;
=======
public class Product{

        protected Product prod;
>>>>>>> refs/remotes/origin/master
        protected String name;
        protected int quantity;
        protected double price;
        protected int UPC;
        protected String SKU;
<<<<<<< HEAD
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
=======
        protected enum rating {E, T, M}
        
    public Product(){
>>>>>>> refs/remotes/origin/master
        this.prod = null;
        this.name = "";
        this.quantity = 0;
        this.price = 0.00;
        this.UPC = 0;
        this.SKU = "";
        this.rating = null;
    }
<<<<<<< HEAD
    public product(product prod, String name, int quant, double price, int UPC, String s, Rating r, UUID u){
=======
    public Product(Product prod, String name, int quant, double price, int UPC, String s, enum e){
>>>>>>> refs/remotes/origin/master
       this.prod = prod;
       this.name = name;
       this.quantity = quant;
       this.price = price;
       this.UPC = UPC;
       this.SKU = s;
       this.rating = e;
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
<<<<<<< HEAD
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
=======
    public void setEnum(enum en){
        switch (en){
            case E:
                this.prod.rating = E;
                break;
            case T:
                this.prod.rating = T;
                break;
            case M:
                this.prod.rating = M;
                break;
        }
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
>>>>>>> refs/remotes/origin/master
