package Mabayahomeexam.dao;

import Mabayahomeexam.comparators.CampaignComparator;
import Mabayahomeexam.model.Campaign;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;

/**
 * This class represents the implementation of the campaigns dao.
 * Contains all campaigns - represented by their bid and by their categories,
 * and features of actions that can be done in the dao according to the CampaignDao interface.
 */
public class CampaignDataAccess implements CampaignDao{

    PriorityQueue<Campaign> campaignsByBids;
    HashMap<String, PriorityQueue<Campaign>> categories;

    /**
     * constructor
     */
    public CampaignDataAccess() {
        this.categories = new HashMap<String, PriorityQueue<Campaign>>();
        this.campaignsByBids = new PriorityQueue<>(new CampaignComparator());
    }

    /**
     * The method creates a campaign.
     * The campaign is added to the dao: first to its categories (according to the seller's products),
     * then to the priority queue.
     * The method returns the created campaign.
     *
     * @param name
     * @param bid
     * @param sellerId
     * @param campaignCategories
     * @return
     */
    @Override
    public Campaign addCampign(String name, double bid, UUID sellerId, List<String> campaignCategories) {
        Campaign campaign = new Campaign(name, bid, sellerId);
        addCampaignToCategories(campaign, campaignCategories);
        campaignsByBids.add(campaign);
        return campaign;
    }


    /**
     * The method adds the campaign to the dao by putting the campaign in the categories it promotes.
     * @param campaign
     * @param campaignCategories
     */
    private void addCampaignToCategories(Campaign campaign, List<String> campaignCategories){
        for(String category: campaignCategories){
            if(!categories.containsKey(category)){
                categories.put(category, new PriorityQueue<>(new CampaignComparator()));
            }
            categories.get(category).add(campaign);
        }
    }

    /**
     * the method returns the highest bidder campaign in a given category.
     * @param category
     * @return
     */
    @Override
    public Campaign getCampaignByCategory(String category){
        //the category does not exists
        if(!categories.containsKey(category))
            return null;

        //get the priority queue of the category
        PriorityQueue<Campaign> priorityQueue = categories.get(category);

        //there is no campaign in the given category
        if(priorityQueue.isEmpty()) {
            //remove the category
            categories.remove(category);
            return null;
        }

        //get the campaign with the highest bid of the given category
        Campaign highestCampaign = priorityQueue.peek();
        //check if the campaign is active
        if(highestCampaign.getStatus() == "ACTIVE")
            return highestCampaign;

        return null;
    }

    /**
     * the method returns the highest bidder campaign.
     * @return
     */
    @Override
    public Campaign getHighestBidderCampaign(){
        if (campaignsByBids.isEmpty())
            return null;

        return campaignsByBids.peek();
    }

    /**
     * the method removes a campaign from category.
     */
    @Override
    public void removeCampaignFromCategory(String category, Campaign campaign){
        //the category does not exists
        if(!categories.containsKey(category))
            return;

        //get the priority queue of the category
        PriorityQueue<Campaign> priorityQueue = categories.get(category);

        //there is no campaign in the given category
        if(priorityQueue.isEmpty())
            return;

        //remove the campaign
        priorityQueue.remove(campaign);

        //update the value of the category
        categories.replace(category, priorityQueue);
    }
}
