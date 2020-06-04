package Mabayahomeexam.comparators;


import Mabayahomeexam.model.Campaign;

import java.util.Comparator;

/**
 * This class implements the Comparator interface.
 * This class is responsible to compare between two campaigns objects.
 */
public class CampaignComparator implements Comparator<Campaign> {

    /**
     * The method compares the bid values of two campaigns.
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Campaign o1, Campaign o2) {
        if(o1.getCampaignBid() > o2.getCampaignBid())
            return -1;
        if(o1.getCampaignBid() < o2.getCampaignBid())
            return 1;
        return 0;
    }
}
