package Mabayahomeexam.testModules;

import Mabayahomeexam.model.Product;
import Mabayahomeexam.service.ServiceCenter;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This class is responsible for testing the products addition and using.
 * by parsing a file with the information of the products, the class create and adds
 * all the products to the dao.
 */
public class CreateProductsTest {
    private File productFile;
    private ProductParser parser;
    private ServiceCenter serviceCenter;

    /**
     * constructor
     * @param serviceCenter
     */
    public CreateProductsTest(ServiceCenter serviceCenter) {
        this.productFile  = new File("src/Products");
        this.parser  = new ProductParser();
        this.serviceCenter = serviceCenter;
    }

    /**
     * The method generates the products from the given file,
     * and adds them to the dao (by sending the products to the service center)
     */
    private void createProductsFromFile(){
        List<Product> products = parser.generateProducts(productFile);
        serviceCenter.addProductsToDao(products);
    }

    /**
     * The method returns all added products.
     */
    public HashMap<UUID, Product> testAddingProducts(){
        createProductsFromFile();
        HashMap<UUID, Product> allProducts = serviceCenter.getAllProducts();
        return allProducts;
    }

}
