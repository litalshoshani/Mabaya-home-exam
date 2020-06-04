package Mabayahomeexam.testModules;

import Mabayahomeexam.model.Campaign;
import Mabayahomeexam.model.Product;
import Mabayahomeexam.parsers.CampaignParser;
import Mabayahomeexam.service.ServiceCenter;

import java.io.File;
import java.util.UUID;

/**
 * This class is responsible for testing the campaigns addition and using.
 * by parsing a file with the information of the campaigns, the class create and adds
 * all the campaigns to the dao.
 */
public class CreateCampaignTest {
    private File campaignFile;
    private CampaignParser parser;
    private ServiceCenter serviceCenter;

    /**
     * constructor
     * @param serviceCenter
     */
    public CreateCampaignTest(ServiceCenter serviceCenter) {
        this.campaignFile  = new File("src/Campaigns");
        this.serviceCenter = serviceCenter;
        this.parser  = new CampaignParser(serviceCenter);
    }

    /**
     * The method generates the campaigns from the given file,
     * and adds them to the dao (by sending the products to the service center)
     */
    public void createCampaignsFromFile(){
        parser.generateCampaigns(campaignFile);
    }

    /**
     * The method prints the highest bidder campaign features.
     */
    public void testHighBidder(){
        Campaign campaign = serviceCenter.getHighBidder();
        System.out.println("High Bidder Campaign");
        System.out.println(campaign.getName());
        System.out.println(campaign.getCampaignBid());
        System.out.println(campaign.getSellerID());
    }

    /**
     * The method prints the seller id of highest bidder campaign in a given category.
     * @param category
     */
    public void testHighBidderCampaignCategory(String category){
        UUID id = serviceCenter.getCampaignByCategorySeller(category);
        System.out.println(id);
    }

    /**
     * The method prints the highest bidder campaign features of a given category.
     */
    public void testGetProductByCategory(String category){
        Product product = serviceCenter.getProductByCategory(category);
        System.out.println("High Bidder Campaign's Product");
        System.out.println(product.getTitle());
        System.out.println(product.getCategory());
        System.out.println(product.getSellerID());
    }
}
