package Mabayahomeexam.api;

import Mabayahomeexam.model.Campaign;
import Mabayahomeexam.service.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * This class responsible for getting the http post request for creating campaigns
 */
@RequestMapping("api/CreateCampaign")
@RestController
public class CreateCampaignController {
    private final ServiceCenter serviceCenter;

    /**
     * constructor
     */
    @Autowired
    public CreateCampaignController(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    /**
     * The method creates a campaign with the given features in the http post
     * request (by taking the request body, and put inside of the Campaign entity).
     * The method adds the campaign to the program dao and returns a json
     * representing the campaign.
     * The received json request is in format:
     * {
     * 	"name": "",
     * 	"bid": ,
     * 	"sellerId": ""
     * }
     * and the returned json format:
     * {
     *     "name": "",
     *     "status": "",
     *     "sellerID": "",
     *     "campaignBid":
     * }
     * @param campaign
     * @return
     */
    @PostMapping
    public Campaign createCampaign(@RequestBody Campaign campaign){
        serviceCenter.addCampaign(campaign);
        return campaign;
    }
}
