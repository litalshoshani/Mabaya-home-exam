package Mabayahomeexam.dao;

import Mabayahomeexam.model.Campaign;

import java.util.List;

/**
 * This interface represents the methods and features of the campaigns data access objects.
 */
public interface CampaignDao {

    void addCampign(Campaign campaign, List<String> campaignCategories);

    void removeCampaignFromCategory(String category, Campaign campaign);

    Campaign getHighestBidderCampaign();

    Campaign getCampaignByCategory(String category);

}