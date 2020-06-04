package Mabayahomeexam.congifuration;

import Mabayahomeexam.service.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class ConfigureModule {

    private final ConfigureProducts configureProducts;
    private final ConfigureSellers configureSellers;
    private final ServiceCenter serviceCenter;

    @Autowired
    public ConfigureModule(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
        this.configureProducts = new ConfigureProducts(serviceCenter);
        this.configureSellers = new ConfigureSellers(serviceCenter);
    }

    public void startConfiguration(){
        configureProducts.createProductsFromFile();
        configureSellers.createSellersFromFile();
    }
}
