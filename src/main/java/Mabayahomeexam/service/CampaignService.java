package Mabayahomeexam.service;

import Mabayahomeexam.dao.CampaignDao;
import Mabayahomeexam.dao.CampaignDataAccess;
import Mabayahomeexam.model.Campaign;

import java.util.List;
import java.util.UUID;

/**
 * This class represents the connection to the CampaignDao.
 * The class can access and receive data of campaigns from the CampaignDao.
 */
public class CampaignService {

    private CampaignDao campaignDao;

    /**
     * constructor
     */
    public CampaignService() {
        this.campaignDao = new CampaignDataAccess();
    }

    /**
     * The method adds a campaign to the campaign dao
     * @param name
     * @param bid
     * @param sellerId
     * @param campaignCategories
     * @return
     */
    public Campaign addCampaign(String name, double bid, UUID sellerId, List<String> campaignCategories){
        return campaignDao.addCampign(name, bid, sellerId, campaignCategories);
    }

    /**
     * The method returns the highest bidder campaign's seller by a given category.
     * if there is no campaign in the category, the method returns null.
     * @param category
     * @return
     */
    public UUID getHighBidCampaignSellerByCategory(String category){
        Campaign campaign = campaignDao.getCampaignByCategory(category);
        if(campaign != null)
            return campaign.getSellerID();
        return null;
    }

    /**
     * The method returns the highest bidder campaign.
     * if there is none - null is returned.
     * @return
     */
    public Campaign getHighestBidCampaign(){
        return campaignDao.getHighestBidderCampaign();
    }

    /**
     * The method returns the seller id of the highest bidder campaign.
     * @return
     */
    public UUID getHighestBidCampaignSeller(){
        Campaign campaign = getHighestBidCampaign();
        if(campaign != null)
            return campaign.getSellerID();
        return null;
    }

    /**
     * The method removes a campaign from a given category.
     * @param category
     * @param campaign
     */
    public void removeCampaignFromCategory(String category, Campaign campaign){
        campaignDao.removeCampaignFromCategory(category, campaign);
    }
}
