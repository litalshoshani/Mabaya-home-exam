package Mabayahomeexam.dao;

import Mabayahomeexam.model.Product;

import java.util.HashMap;
import java.util.UUID;

/**
 * This interface represents the methods and features of the products data access objects.
 */
public interface ProductDao {

    int addProduct(Product product);

    String getProductCategory(UUID serialNum);

    Product getProductBySerialNum(UUID serialNum);

    UUID getProductSeller(UUID serialNum);

    HashMap<UUID, Product> getAllProducts();
}