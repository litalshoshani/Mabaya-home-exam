package Mabayahomeexam.service;

import Mabayahomeexam.dao.ProductDao;
import Mabayahomeexam.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

/**
 * This class represents the connection to the ProductDao.
 * The class can access and receive data of products from the ProductDao.
 */
@Service
public class ProductService {

    private ProductDao productDao;

    /**
     * constructor
     */
    @Autowired
    public ProductService(@Qualifier("productDao")ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * The method returns the product entity that contains the given unique serial number.
     * @param serialNum
     * @return
     */
    public Product getProductBySerialNumber(UUID serialNum){
        return productDao.getProductBySerialNum(serialNum);
    }

    /**
     * The method returns a product's category.
     * @param serialNum
     * @return
     */
    public String getProductCategory(UUID serialNum){
        return productDao.getProductCategory(serialNum);
    }

    /**
     * The method returns a product's seller.
     * @param serialNum
     * @return
     */
    public UUID getProductSeller(UUID serialNum){
        return productDao.getProductSeller(serialNum);
    }

    /**
     * the method adds a product to the dao.
     * @param product
     * @return
     */
    public int addProduct(Product product){
        productDao.addProduct(product);
        return 1;
    }

    /**
     * The method returns a hash map of all the products.
     * @return
     */
    public HashMap<UUID, Product> getAllProducts(){
        return productDao.getAllProducts();
    }
}
