package bundles;

import Product.Product;
import java.util.ArrayList;
import java.util.List;

public class Bundle extends ReceiptElement {

    /*  Product needs to have:
        public Product clone()
        public static List<Product> getAllProducts()
        public static List<Product> getAllProducts(boolean enabled)
     */
    private int numberAllowed;
    // Could also be integers so that comparisons could be easier, YYYYMMDD eg.  20171205 < 20171210
    // Date class in Java is depreciated, could make own Date object but using integers may be better.
    private String startDate;
    private String endDate;
    private PairList<Product> products;
    private DiscountType discountType;
    private double discountAmount;

    private Bundle(String name, String description, PairList<Product> products, DiscountType discountType, double discountAmount, String endDate) {
        super(name, description);
        this.discountType = discountType;
        this.discountAmount = discountAmount;
        this.products = products;
        if (discountType == DiscountType.BOGO) {
            this.discountAmount = 0;
        } else {
            this.discountAmount = discountAmount;
        }
        this.startDate = currentDate();
        this.endDate = endDate;
        // Will need to save itself to the database
    }

    public static Bundle generator(String name, String description, PairList<Product> products, DiscountType discountType, double discountAmount, String endDate) {
        return new Bundle(name, description, products, discountType, discountAmount, endDate);
    }

    //<editor-fold desc="Static Methods for Handling Discounts">
    public static List<Bundle> getAllBundles() {
        return new ArrayList();
    }

    public static List<Bundle> getAllBundles(boolean enabled) {
        return new ArrayList();
    }

    public static PairList<ReceiptElement> processBundles(PairList<Product> products) {
        // Recursive method that will return the smallest list of bundles and products.

        return null;
    }

    private static PairList<Bundle> getApplicable(PairList<Product> products) {
        return null;
    }

    //</editor-fold>
    
    public String currentDate(){
        return "";
    }
    
    private boolean withinDate(){
        // return currentDate < endDate;
        return true;
    }
    
    public boolean isActive() {
        return active;
    }

    // Is active and also within the given date.
    public boolean isValid() {
        if (!withinDate()) {
            disable();
            return false;
        }
        return active;
    }
    
    public boolean disable() {
        return false;
    }

    public boolean enable() {
        // Set start date to current date
        return true;
    }
    
    public int getNumberAllowed(){
        return numberAllowed;
    }
    
    public PairList<Product> getProducts(){
        return products.clone();
    }
    
    // Returns price of the bundle
    @Override
    public double getPrice() {
        switch (discountType) {
            case PERCENT:
                return ReceiptElement.getPriceProducts(products) - ReceiptElement.getPriceProducts(products) * discountAmount / 100;
            case DOLLAR:
                return ReceiptElement.getPriceProducts(products) - discountAmount;
            case BOGO:
                return ReceiptElement.getPriceProducts(products) / 2.0;
            default:
                return ReceiptElement.getPriceProducts(products);
        }
    }

    @Override
    public Bundle clone() {
        return new Bundle(name, description, products.clone(), discountType, discountAmount, endDate);
    }

    @Override
    public String toString() {
        return "Bundle:" + super.toString() + " " + discountType.formatString(discountAmount);
    }

}
