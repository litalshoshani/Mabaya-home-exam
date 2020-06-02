package Mabayahomeexam.service;

import Mabayahomeexam.dao.ProductDao;
import Mabayahomeexam.dao.ProductDataAccess;
import Mabayahomeexam.model.Product;

import java.util.UUID;

/**
 * This class represents the connection to the ProductDao.
 * The class can access and receive data of products from the ProductDao.
 */
public class ProductService {

    private ProductDao productDao;

    /**
     * constructor
     */
    public ProductService() {
        this.productDao = new ProductDataAccess();
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
     * the method adds a new product to the dao.
     * @param title
     * @param price
     * @param category
     * @param productSerialNumber
     * @param sellerID
     * @return
     */
    public int addProduct(String title, double price, String category, UUID productSerialNumber, UUID sellerID){
        productDao.addProduct(title, price, category, productSerialNumber, sellerID);
        return 1;
    }
}
