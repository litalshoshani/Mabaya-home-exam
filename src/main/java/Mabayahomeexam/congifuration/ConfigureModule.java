package Mabayahomeexam.congifuration;

import Mabayahomeexam.service.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class responsible for configurations of the data the program needs.
 * This class is the "brain" of the configurations classes: this class holds
 * and calls the other configuration classes.
 */
@Component
public class ConfigureModule {

    private final ConfigureProducts configureProducts;
    private final ConfigureSellers configureSellers;
    private final ServiceCenter serviceCenter;

    /**
     * constructor
     * @param serviceCenter
     */
    @Autowired
    public ConfigureModule(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
        this.configureProducts = new ConfigureProducts(serviceCenter);
        this.configureSellers = new ConfigureSellers(serviceCenter);
    }

    /**
     * The method generates the needed data.
     */
    public void startConfiguration(){
        configureProducts.createProductsFromFile();
        configureSellers.createSellersFromFile();
    }
}
