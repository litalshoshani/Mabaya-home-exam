package Mabayahomeexam.congifuration;

import Mabayahomeexam.model.Seller;
import Mabayahomeexam.parsers.SellerParser;
import Mabayahomeexam.service.ServiceCenter;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This class responsible for configuring the sellers.
 */
public class ConfigureSellers {

    private File sellerFile;
    private SellerParser parser;
    private ServiceCenter serviceCenter;


    /**
     * constructor
     * @param serviceCenter
     */
    public ConfigureSellers(ServiceCenter serviceCenter) {
        this.sellerFile  = new File("src/main/java/Mabayahomeexam/Sellers");
        this.serviceCenter = serviceCenter;
        this.parser  = new SellerParser(serviceCenter);
    }

    /**
     * The method generates the sellers from the given file,
     * and adds them to the dao (by sending the sellers to the service center).
     */
    public void createSellersFromFile(){
        HashMap<Seller, List<UUID>> sellers = parser.generateSellers(sellerFile);
        serviceCenter.addSellersToDao(sellers);
    }
}
