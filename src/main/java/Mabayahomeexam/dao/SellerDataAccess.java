package Mabayahomeexam.dao;


import Mabayahomeexam.model.Product;
import Mabayahomeexam.model.Seller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This class represents the implementation of the seller dao.
 * Contains all sellers, and features of actions that can be done
 * in the dao according to the SellerDao interface.
 */
public class SellerDataAccess implements SellerDao {

    HashMap<UUID, Seller> allSellers;

    public SellerDataAccess() {
        this.allSellers = new HashMap<UUID, Seller>();
    }

    @Override
    public int addSeller(Seller seller) {
        allSellers.put(seller.getId(), seller);
        return 1;
    }

    @Override
    public List<UUID> getSellerProductsByCategory(UUID id, String category) {
        Seller seller = allSellers.get(id);
        return seller.getCategoryProducts(category);
    }

    @Override
    public List<UUID> getSellerProducts(UUID id) {
        Seller seller = allSellers.get(id);
        return seller.getAllSellerProducts();
    }


    @Override
    public int removeSellerProduct(UUID sellerId, UUID productId) {
        return 0;
    }

    @Override
    public int addSellerProduct(Product p) {
        return 0;
    }


    @Override
    public boolean sellCategory(UUID id, String category){
        //get seller
        Seller seller = allSellers.get(id);
        return seller.sellingCategory(category);
    }

    @Override
    public List<String> sellerProductsCategories(UUID id){
        //get seller
        Seller seller = allSellers.get(id);
        return seller.getSellerProductsCategories();
    }
}
