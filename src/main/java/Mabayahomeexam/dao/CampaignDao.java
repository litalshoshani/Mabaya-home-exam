package Mabayahomeexam.dao;

import Mabayahomeexam.model.Campaign;
import Mabayahomeexam.model.Product;

import java.util.List;

public interface CampaignDao {
    int addCampign(Campaign campaign);

    List<String> getCampaignsCategories(Campaign campaign);

    Product getProductByCategory(String category);
}
