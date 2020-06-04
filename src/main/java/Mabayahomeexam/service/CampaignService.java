package Mabayahomeexam.service;

import Mabayahomeexam.dao.CampaignDao;
import Mabayahomeexam.dao.CampaignDataAccess;
import Mabayahomeexam.model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * This class represents the connection to the CampaignDao.
 * The class can access and receive data of campaigns from the CampaignDao.
 */
@Service
public class CampaignService {

    private CampaignDao campaignDao;

    /**
     * constructor
     */
    @Autowired
    public CampaignService(@Qualifier("campaignDao")CampaignDao campaignDao) {

        //this.campaignDao = new CampaignDataAccess();
        this.campaignDao = campaignDao;

    }

    /**
     * The method adds a campaign to the campaign dao
     * @param campaign
     * @param campaignCategories
     * @return
     */
    public void addCampaign(Campaign campaign, List<String> campaignCategories){
        campaignDao.addCampign(campaign, campaignCategories);
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
