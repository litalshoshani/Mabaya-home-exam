package Mabayahomeexam.api;

import Mabayahomeexam.model.Campaign;
import Mabayahomeexam.model.Product;
import Mabayahomeexam.service.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/ServeAd")
@RestController
public class ServeAdController {

    private final ServiceCenter serviceCenter;

    @Autowired
    public ServeAdController(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    @GetMapping
    public Product serveAd(String category){
        return serviceCenter.getProductByCategory(category);
    }
}
