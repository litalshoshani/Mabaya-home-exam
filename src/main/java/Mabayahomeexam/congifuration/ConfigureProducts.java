package Mabayahomeexam.congifuration;

import Mabayahomeexam.model.Product;
import Mabayahomeexam.service.ServiceCenter;
import Mabayahomeexam.parsers.ProductParser;

import java.io.File;
import java.util.List;

/**
 * This class responsible for configuring the products.
 */
public class ConfigureProducts {
    private File productFile;
    private ProductParser parser;
    private ServiceCenter serviceCenter;

    /**
     * constructor
     * @param serviceCenter
     */
    public ConfigureProducts(ServiceCenter serviceCenter) {
        this.productFile  = new File("src/main/java/Mabayahomeexam/Products");
        this.parser  = new ProductParser();
        this.serviceCenter = serviceCenter;
    }

    /**
     * The method generates the products from the given file,
     * and adds them to the dao (by sending the products to the service center).
     */
    public void createProductsFromFile(){
        List<Product> products = parser.generateProducts(productFile);
        serviceCenter.addProductsToDao(products);
    }
}
