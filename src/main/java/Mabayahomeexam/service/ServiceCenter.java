package Mabayahomeexam.service;

import Mabayahomeexam.model.Campaign;
import Mabayahomeexam.model.Product;
import Mabayahomeexam.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This class is the services brain.
 * It holds all the other services, and uses them to add objects and features,
 * or to pass and get information from one service to the other.
 */
@Service
public class ServiceCenter {

    private CampaignService campaignService;
    private SellerService sellerService;
    private ProductService productService;

    /**
     * constructor
     */
    @Autowired
    public ServiceCenter(CampaignService campaignService, SellerService sellerService, ProductService productService) {
        this.campaignService = campaignService;
        this.sellerService = sellerService;
        this.productService = productService;
    }

    /**
     * The method creates new campaign
     * @param campaign
     */
    public Campaign addCampaign(Campaign campaign){
        //get the campaign's seller
        UUID sellerId = campaign.getSellerID();
        //get the seller product's categories, in order to know the campaign's promoted categories.
        List<String> sellerCategories = sellerService.getSellerProductsCategories(sellerId);
        campaignService.addCampaign(campaign, sellerCategories);
        return campaign;
    }

    /**
     * The method returns a product from the highest bidder campaign in a given category.
     * if the category does not exists or there is no campaign in the category, the
     * method returns a product from the highest bidder campaign.
     * a "no-product-found" product object is returned of no campaign, category and product found.
     * @param category
     * @return
     */
    public Product getProductByCategory(String category) {
        //check if there is a campaign in this category, and try to get its seller
        UUID sellerId = campaignService.getHighBidCampaignSellerByCategory(category);
        UUID productSerialNumber = null;
        boolean productFound = false;

        //if the seller id is null, then there is no campaign
        if (sellerId == null) {
            //get the highest bidder campaign's seller instead
            sellerId = campaignService.getHighestBidCampaignSeller();
            //get a random product from the seller
            productSerialNumber = sellerService.getSellerProduct(sellerId);
            productFound = true;
        }
        else {
            //there is a campaign in the category, get a product of the seller in the category
            productSerialNumber = sellerService.getSellerProductByCategory(sellerId, category);
            productFound = true;
        }

        Product product = null;
        //there is a product
        if(productFound){
            //get the product by the found serial number, from the product service
            product = productService.getProductBySerialNumber(productSerialNumber);
        }
        else{
            //create a no-product-found object
            sellerId = UUID.fromString("0000");
            productSerialNumber = UUID.fromString("0000");
            product = new Product("no product found", 0, "no category found", sellerId, productSerialNumber);
        }

        return product;
    }

    /**
     * The method adds products to the dao
     * @param products
     */
    public void addProductsToDao(List<Product> products){
        for (Product product: products)
            productService.addProduct(product);
    }

    /**
     * The method adds sellers to the seller dao.
     * The given parameter is a hash map of sellers as keys and their products list of
     * serial numbers as values.
     * The method adds every seller to the dao and adds the products in the list as the seller's
     * products.
     * @param sellers
     */
    public void addSellersToDao(HashMap<Seller, List<UUID>> sellers){
        //iterate over all the sellers
        for (Seller seller : sellers.keySet()) {
            //add every seller to the dao
            sellerService.addSeller(seller);
            //add seller's products
            for(UUID productSerialNumber: sellers.get(seller)) {
                //get the product object by using the product's serial number.
                Product product = getProduct(productSerialNumber);
                //adds the product to the seller.
                sellerService.addSellerProduct(seller, product.getProductSerialNumber(), product.getCategory());
            }
        }
    }

    /**
     * The method returns a product with the given serial number
     * @param serialNum
     * @return
     */
    public Product getProduct(UUID serialNum){
        return productService.getProductBySerialNumber(serialNum);
    }

    /**
     * The method receives a seller and a product serial number,
     * and adds the product with the given serial number to the seller.
     * @param seller
     * @param serialNum
     */
    public void addSellerProductWithGivenSerialNumber(Seller seller, UUID serialNum){
        //get the product with the given serial number
        Product p = getProduct(serialNum);
        //add the product to the given seller.
        sellerService.addSellerProduct(seller, p.getProductSerialNumber(), p.getCategory());
    }

    /**
     * The method returns the highest bidder campaign.
     * @return
     */
    public Campaign getHighBidder(){
        return campaignService.getHighestBidCampaign();
    }

    /**
     * The method returns the highest bidder campaign in a given category.
     * @param category
     * @return
     */
    public UUID getCampaignByCategorySeller(String category){
        return campaignService.getHighBidCampaignSellerByCategory(category);
    }

    /**
     * The method returns a hash map of all the products.
     * @return
     */
    public HashMap<UUID, Product> getAllProducts(){
        return productService.getAllProducts();
    }

    /**
     * The method returns a hash map of all the sellers.
     * @return
     */
    public HashMap<UUID, Seller> getAllSellers(){
        return sellerService.getAllSellers();
    }

}
