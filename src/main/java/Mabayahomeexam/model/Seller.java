package Mabayahomeexam.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class represents the Seller entity.
 * A seller entity contains a unique id, and a list of products (represented by unique id).
 */
public class Seller {
    private final UUID id;
    private List<UUID> products;

    /**
     * constructor
     * @param id
     */
    public Seller(UUID id) {
        this.id = id;
        products = new ArrayList<>();
    }

    /**
     * @return the id of the seller
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the seller's products
     */
    public List<UUID> getProducts() {
        return products;
    }

    /**
     * adds a product to the seller's list of products
     * @param id
     */
    public void addProduct(UUID id) {
        this.products.add(id);
    }


    /**
     * remove the product from the seller list
     * @param id
     */
    public void removeProduct(UUID id){
        products.remove(id);
    }
}
