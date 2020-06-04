package Mabayahomeexam.model;

import java.util.UUID;

/**
 * This class represents the Product entity.
 * A Product entity contains:
 * 1. a unique serial number
 * 2. a title,
 * 3. a price
 * 4. a category
 * 5. a seller id (unique id).
 */
public class Product {
    private String title;
    private double price;
    private String category;
    private final UUID productSerialNumber;
    private UUID sellerID;

    /**
     * default constructor
     * @param title
     * @param price
     * @param category
     * @param productSerialNumber
     * @param sellerID
     */
    public Product(String title, double price, String category, UUID productSerialNumber, UUID sellerID) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.productSerialNumber = productSerialNumber;
        this.sellerID = sellerID;
    }

    /**
     * return the product's title.
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * set the product's title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * return the product's price.
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * set the product's price.
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * return the product's category.
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * set the product's category.
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * return the product seller's id.
     * @return
     */
    public UUID getSellerID() {
        return sellerID;
    }

    /**
     * set the product seller's id.
     * @param sellerID
     */
    public void setSellerID(UUID sellerID) {
        this.sellerID = sellerID;
    }

    /**
     * return the product's serial number
     * @return
     */
    public UUID getProductSerialNumber() {
        return productSerialNumber;
    }

}
