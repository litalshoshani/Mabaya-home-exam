package Mabayahomeexam.dao;


import Mabayahomeexam.model.Product;
import Mabayahomeexam.model.Seller;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This class represents the implementation of the seller dao.
 * Contains all sellers, and features of actions that can be done
 * in the dao according to the SellerDao interface.
 */
@Repository("sellerDao")
public class SellerDataAccess implements SellerDao {

    HashMap<UUID, Seller> allSellers;

    /**
     * constructor
     */
    public SellerDataAccess() {
        this.allSellers = new HashMap<UUID, Seller>();
    }

    /**
     * The method adds a seller to the dao.
     * @param seller
     * @return
     */
    @Override
    public int addSeller(Seller seller) {
        allSellers.put(seller.getId(), seller);
        return 1;
    }

    /**
     * The method returns the seller products in a given category.
     * @param id
     * @param category
     * @return
     */
    @Override
    public List<UUID> getSellerProductsByCategory(UUID id, String category) {
        Seller seller = allSellers.get(id);
        return seller.getCategoryProducts(category);
    }

    /**
     * The method returns a list of the seller products' serial numbers.
     * @param id
     * @return
     */
    @Override
    public List<UUID> getSellerProducts(UUID id) {
        Seller seller = allSellers.get(id);
        return seller.getAllSellerProducts();
    }

    /**
     * The method removes a product from the seller.
     * @param sellerId
     * @param productId
     * @return
     */
    @Override
    public int removeSellerProduct(UUID sellerId, UUID productId) {
        return 0;
    }


    /**
     * The method adds a product to the seller.
     * @param sellerId
     * @param serialNum
     * @param category
     * @return
     */
    @Override
    public int addSellerProduct(UUID sellerId, UUID serialNum, String category) {
        Seller seller = allSellers.get(sellerId);
        seller.addProduct(serialNum, category);
        return 1;
    }

    /**
     * The method returns true if the seller has products in the given category.
     * @param id
     * @param category
     * @return
     */
    @Override
    public boolean sellCategory(UUID id, String category){
        //get seller
        Seller seller = allSellers.get(id);
        return seller.sellingCategory(category);
    }

    /**
     * The method returns a list of all the products categories of a seller.
     * @param id
     * @return
     */
    @Override
    public List<String> sellerProductsCategories(UUID id){
        //get seller
        Seller seller = allSellers.get(id);
        return seller.getSellerProductsCategories();
    }

    /**
     * The methos returns a hash map of all the sellers.
     * @return
     */
    @Override
    public HashMap<UUID, Seller> getAllSellers() {
        return allSellers;
    }
}
