package Mabayahomeexam;

import Mabayahomeexam.api.CreateCampaignController;
import Mabayahomeexam.congifuration.ConfigureModule;
import Mabayahomeexam.service.CampaignService;
import Mabayahomeexam.service.ProductService;
import Mabayahomeexam.service.ServiceCenter;
import Mabayahomeexam.testModules.CreateProductsTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * The main class of the program.
 */
@SpringBootApplication
public class MabayaHomeExamApplication implements ApplicationRunner {

	@Autowired
	private ServiceCenter serviceCenter;

	public static void main(String[] args) {
		SpringApplication.run(MabayaHomeExamApplication.class, args);
	}

	/**
	 * on the starting of the application - configure the application's needed values
	 * such as the daos (with the needed data).
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		ConfigureModule configureModule = new ConfigureModule(serviceCenter);
		configureModule.startConfiguration();
	}
}
