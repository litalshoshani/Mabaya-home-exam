package Mabayahomeexam.service;

import Mabayahomeexam.dao.SellerDao;
import Mabayahomeexam.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * This class represents the connection to the SellerDao.
 * The class can access and receive data of a seller from the SellerDao.
 */
@Service
public class SellerService {

    private SellerDao sellerDao;

    /**
     * constructor
     */
    @Autowired
    public SellerService(@Qualifier("sellerDao") SellerDao sellerDao) {
        this.sellerDao = sellerDao;
    }

    /**
     * the method receives a seller id and a category and return a product's UUID the seller sells
     * in the given category. if there is no product the method returns null.
     * @param sellerId
     * @param category
     * @return
     */
    public UUID getSellerProductByCategory(UUID sellerId, String category){
        if(!sellerDao.sellCategory(sellerId, category))
            return null;

        //get the seller's products in the given category
        List<UUID> products = sellerDao.getSellerProductsByCategory(sellerId, category);

        /*
        call getRandomProduct method to check if there are products in the category,
        and if so - return a random product.
         */
        return getRandomProduct(products);
    }

    /**
     * the method receives a seller's id, and return a random product from the
     * seller's products list.
     * @param sellerId
     * @return
     */
    public UUID getSellerProduct(UUID sellerId){
        //get the seller's products
        List<UUID> products = sellerDao.getSellerProducts(sellerId);

        /*
        call getRandomProduct method to check if there are products,
        and if so - return a random product.
         */
        return getRandomProduct(products);
    }

    /**
     * The method returns a random product from the products list.
     * if there is no products, the method returns null.
     * @param products
     * @return
     */
    private UUID getRandomProduct(List<UUID> products){
        //check if there are products.
        if(products.size() == 0)
            return null;

        Random rand = new Random();

        //create a random index within the range of the products list's size
        int randIndex = rand.nextInt(products.size());

        //return the random product.
        return products.get(randIndex);
    }

    /**
     * The method returns the seller's products categories.
     * @param id
     * @return
     */
    public List<String> getSellerProductsCategories(UUID id){
        return sellerDao.sellerProductsCategories(id);
    }

    /**
     * The method adds a new seller.
     * @param seller
     */
    public void addSeller(Seller seller){
        sellerDao.addSeller(seller);
    }

    /**
     * The method adds a product to a given seller.
     * @param seller
     * @param serialNum
     * @param category
     */
    public void addSellerProduct(Seller seller, UUID serialNum, String category){
        sellerDao.addSellerProduct(seller.getId(), serialNum, category);
    }

    /**
     * The method returns a hash map of all the sellers in the dao.
     * @return
     */
    public HashMap<UUID, Seller> getAllSellers(){
        return sellerDao.getAllSellers();
    }
}
