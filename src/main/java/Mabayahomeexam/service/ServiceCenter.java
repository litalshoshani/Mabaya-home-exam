package Mabayahomeexam.service;


import Mabayahomeexam.model.Campaign;
import Mabayahomeexam.model.Product;

import java.util.List;
import java.util.UUID;

public class ServiceCenter {

    private CampaignService campaignService;
    private SellerService sellerService;
    private ProductService productService;

    public ServiceCenter() {
        this.campaignService = new CampaignService();
        this.sellerService = new SellerService();
        this.productService = new ProductService();
    }

    /**
     * The method creates new campaign
     * @param name
     * @param bid
     * @param sellerId
     */
    public Campaign createCampaign(String name, double bid, UUID sellerId){
        List<String> sellerCategories = sellerService.getSellerProductsCategories(sellerId);
        Campaign campaign = campaignService.addCampaign(name, bid, sellerId, sellerCategories);
        return campaign;
    }

    public Product getProductByCategory(String category){
        //check if there is a campaign in this category, and try to get its seller
        UUID sellerId = campaignService.getHighBidCampaignSellerByCategory(category);

        if(sellerId == null){
            //if there is no campaign, then get the highest bidder campaign's seller instead
        }

        return null;
    }

}
