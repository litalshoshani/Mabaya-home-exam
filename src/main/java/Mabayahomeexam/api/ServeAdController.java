package Mabayahomeexam.api;

import Mabayahomeexam.model.Campaign;
import Mabayahomeexam.model.Product;
import Mabayahomeexam.service.ServiceCenter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class responsible for getting the http get request for receiving a product
 * in a given category.
 */
@RequestMapping("api/ServeAd")
@RestController
public class ServeAdController {

    private final ServiceCenter serviceCenter;

    /**
     * constructor
     */
    @Autowired
    public ServeAdController(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    /**
     * The method returns a product in a given category.
     * If there is none, a product from the highest bidder campaign is returned.
     * the returned json format:
     * {
     *     "title": "",
     *     "price": ,
     *     "category": "",
     *     "productSerialNumber": "",
     *     "sellerID": ""
     * }
     * @param category
     * @return
     */
    @GetMapping
    public Product serveAd(@RequestBody CategoryReader category){
        return serviceCenter.getProductByCategory(category.getCategory());
    }
}
