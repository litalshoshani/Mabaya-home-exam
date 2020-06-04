package Mabayahomeexam.dao;


import Mabayahomeexam.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

/**
 * This class represents the implementation of the product dao.
 * Contains all products, and features of actions that can be done in the dao
 * according to the ProductDao interface.
 */
@Repository("productDao")
public class ProductDataAccess implements ProductDao {
    HashMap<UUID, Product> allProducts;

    public ProductDataAccess() {
        this.allProducts = new HashMap<UUID, Product>();
    }

    /**
     * the method adds a given product to the dao.
     * @param product
     * @return
     */
    @Override
    public int addProduct(Product product) {
        allProducts.put(product.getProductSerialNumber(), product);
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

    /**
     * The method returns a hash map of all the products.
     * @return
     */
    @Override
    public HashMap<UUID, Product> getAllProducts(){
        return allProducts;
    }
}
