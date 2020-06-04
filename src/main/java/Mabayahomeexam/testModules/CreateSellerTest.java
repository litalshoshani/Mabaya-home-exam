package Mabayahomeexam.testModules;

import Mabayahomeexam.model.Product;
import Mabayahomeexam.model.Seller;
import Mabayahomeexam.parsers.SellerParser;
import Mabayahomeexam.service.ServiceCenter;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This class is responsible for testing the seller addition and using.
 * by parsing a file with the information of the sellers, the class create and adds
 * all the sellers to the dao.
 */
public class CreateSellerTest {

    private File sellerFile;
    private SellerParser parser;
    private ServiceCenter serviceCenter;

    /**
     * constructor
     * @param serviceCenter
     */
    public CreateSellerTest(ServiceCenter serviceCenter) {
        this.sellerFile  = new File("src/Sellers");
        this.serviceCenter = serviceCenter;
        this.parser  = new SellerParser(serviceCenter);
    }

    /**
     * The method generates the sellers from the given file,
     * and adds them to the dao (by sending the sellers to the service center)
     */
    private void createSellersFromFile(){
        HashMap<Seller, List<UUID>> sellers = parser.generateSellers(sellerFile);
        serviceCenter.addSellersToDao(sellers);
    }

    /**
     * The method tests if the addition of the sellers was a success.
     */
    public void testAddingSellers(){
        createSellersFromFile();
        HashMap<UUID, Seller> allSellers = serviceCenter.getAllSellers();

        checkCategoriesOfSellers(allSellers);

    }

    /**
     * The method tests if the addition of the sellers was a success,
     * by checking if the categories and the id of the sellers are equals
     * to the sellers products.
     * @param allSellers
     */
    public void checkCategoriesOfSellers(HashMap<UUID, Seller> allSellers){
        for(UUID sellerId: allSellers.keySet()){
            Seller seller = allSellers.get(sellerId);
            List<String> categories = seller.getSellerProductsCategories();

            //get seller products
            List<UUID> products = seller.getAllSellerProducts();
            for(UUID serialNum: products){
                Product product = serviceCenter.getProduct(serialNum);
                if(categories.contains(product.getCategory()) || product.getSellerID().equals(sellerId))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }

        }
    }

}
