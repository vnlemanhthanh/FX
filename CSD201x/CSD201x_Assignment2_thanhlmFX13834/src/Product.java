
/**
 * Product class
 */
public class Product implements Comparable<Product> {
    /**
     * bcode    : Product's bar code,
     * title    : Product's title,
     * quantity : Product's quantity,
     * price    : Product's price,
     */
    private String bcode;
    private String title;
    private Integer quantity;
    private double price;

    /**
     * Default constructor
     */
    public Product() {
    }

    /**
     * Constructor method to initialize a product
     * @param bcode    Product's bar code
     * @param title    Product's title
     * @param quantity Product's quantity
     * @param price    Product's price
     */
    public Product(String bcode, String title, Integer quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String bcode) {
        this.bcode = bcode;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Convert this product to String for printing
     */
    @Override
    public String toString() {
        return String.format("%-10s|%-20s|%10d|%10.2f", bcode, title, quantity, price);
    }

    @Override
    public int compareTo(Product o) {
        return this.bcode.compareTo(o.bcode);
    }

    public boolean equals(Product p) {
        return this.compareTo(p) == 0;
    }
}
