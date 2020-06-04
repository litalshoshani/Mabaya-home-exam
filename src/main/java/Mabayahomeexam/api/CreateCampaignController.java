package Mabayahomeexam.api;

import Mabayahomeexam.model.Campaign;
import Mabayahomeexam.service.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/CreateCampaign")
@RestController
public class CreateCampaignController {
    private final ServiceCenter serviceCenter;

    @Autowired
    public CreateCampaignController(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    @PostMapping
    public Campaign createCampaign(@RequestBody Campaign campaign){
        serviceCenter.addCampaign(campaign);
        return campaign;
    }
}
