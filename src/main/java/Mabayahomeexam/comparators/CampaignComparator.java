package Mabayahomeexam.comparators;


import Mabayahomeexam.model.Campaign;

import java.util.Comparator;

public class CampaignComparator implements Comparator<Campaign> {
    @Override
    public int compare(Campaign o1, Campaign o2) {
        return Double.compare(o1.getCampaignBid(), o2.getCampaignBid());
    }
}
