package Mabayahomeexam.dao;

import Mabayahomeexam.model.Campaign;
import Mabayahomeexam.model.Product;

import java.util.List;
import java.util.UUID;

/**
 * This interface represents the methods and features of the campaigns data access objects.
 */
public interface CampaignDao {

    Campaign addCampign(String name, double bid, UUID sellerId, List<String> campaignCategories);

    void removeCampaignFromCategory(String category, Campaign campaign);

    Campaign getHighestBidderCampaign();

    Campaign getCampaignByCategory(String category);

    //List<String> getCampaignsCategories(Campaign campaign);

}