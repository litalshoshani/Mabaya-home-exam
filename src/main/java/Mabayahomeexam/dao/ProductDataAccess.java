package Mabayahomeexam.dao;


import Mabayahomeexam.model.Product;

import java.util.HashMap;
import java.util.UUID;

/**
 * This class represents the implementation of the product dao.
 * Contains all products, and features of actions that can be done in the dao
 * according to the ProductDao interface.
 */
public class ProductDataAccess implements ProductDao {
    HashMap<UUID, Product> allProducts;

    public ProductDataAccess() {
        this.allProducts = new HashMap<UUID, Product>();
    }

    /**
     * the method creates a new product according to the values receives and adds it to the dao.
     * @param title
     * @param price
     * @param category
     * @param productSerialNumber
     * @param sellerID
     * @return
     */
    @Override
    public int addProduct(String title, double price, String category, UUID productSerialNumber, UUID sellerID) {
        Product product = new Product(title, price, category, productSerialNumber, sellerID);
        allProducts.put(productSerialNumber, product);
        return 1;
    }

    /**
     * The method returns a product's category
     * @param serialNum
     * @return
     */
    @Override
    public String getProductCategory(UUID serialNum) {
        Product product = allProducts.get(serialNum);
        return product.getCategory();
    }

    /**
     * The method returns the product with the given serial number
     * @param serialNum
     * @return
     */
    @Override
    public Product getProductBySerialNum(UUID serialNum) {
        return allProducts.get(serialNum);
    }

    /**
     * The method returns the seller of a given product.
     * @param serialNum
     * @return
     */
    @Override
    public UUID getProductSeller(UUID serialNum) {
        Product product = allProducts.get(serialNum);
        return product.getSellerID();
    }
}
