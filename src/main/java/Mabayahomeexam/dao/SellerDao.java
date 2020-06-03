package Mabayahomeexam.dao;

import Mabayahomeexam.model.Product;
import Mabayahomeexam.model.Seller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This interface represents the methods and features of the seller's data access objects.
 */
public interface SellerDao {

    int addSeller(Seller seller);

    List<UUID> getSellerProductsByCategory(UUID id, String category);

    List<UUID> getSellerProducts(UUID id);

    int removeSellerProduct(UUID sellerId, UUID productId);

    int addSellerProduct(UUID sellerId, UUID serialNum, String category);

    boolean sellCategory(UUID id, String category);

    List<String> sellerProductsCategories(UUID id);

    HashMap<UUID, Seller> getAllSellers();
}
