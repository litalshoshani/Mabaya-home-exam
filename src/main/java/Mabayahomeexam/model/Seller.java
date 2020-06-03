package Mabayahomeexam.model;

import java.util.*;

/**
 * This class represents the Seller entity.
 * A seller entity contains a unique id, and a group of products.
 */
public class Seller {
    private final UUID id;
    private HashSet<UUID> productsBySerialNumber;
    private HashMap<String, List<UUID>> productsByCategory;

    /**
     * constructor
     * @param id
     */
    public Seller(UUID id) {
        this.id = id;
        this.productsBySerialNumber = new HashSet<UUID>();
        this.productsByCategory = new HashMap<String, List<UUID>>();
    }

    /**
     * @return the id of the seller
     */
    public UUID getId() {
        return id;
    }

    /**
     * adds a product to the seller's list of products
     * @param serialNumber
     */
    public void addProduct(UUID serialNumber, String category) {
        productsBySerialNumber.add(serialNumber);
        addProductToCategory(serialNumber, category);
    }

    /**
     * The method adds a product to the seller's products.
     * @param serialNumber
     * @param category
     */
    private void addProductToCategory(UUID serialNumber, String category){
        List<UUID> productsInCategory = null;

        //the category exists
        if(productsByCategory.containsKey(category)){
            //get the category products list
            productsInCategory = productsByCategory.get(category);
            //add the product (by its serial number)
            productsInCategory.add(serialNumber);
            //update the category
            productsByCategory.replace(category, productsInCategory);
            return;
        }

        //the category does not exists. create it.
        productsInCategory = new ArrayList<>();
        productsInCategory.add(serialNumber);

        productsByCategory.put(category, productsInCategory);
    }

    /**
     * The method removes a product from the seller's products.
     * @param serialNumber
     * @param category
     */
    public void removeProduct(UUID serialNumber, String category){

        productsBySerialNumber.remove(serialNumber);

        if(productsByCategory.containsKey(category)){
            List<UUID> products = productsByCategory.get(category);
            products.remove(serialNumber);
            //check if the category contains products after deleting. if so - remove category
            if(products.isEmpty())
                productsByCategory.remove(category);
                //there are products in category - update category
            else
                productsByCategory.replace(category,products);
        }
    }

    /**
     * The method returns true if the seller has products in a given category,
     * false otherwise.
     * @param category
     * @return
     */
    public boolean sellingCategory(String category){
        if(productsByCategory.containsKey(category))
            return true;
        return false;
    }

    /**
     * The method returns all the seller's products in a given category.
     * if the category does not exists, the method returns null.
     * @param category
     * @return
     */
    public List<UUID> getCategoryProducts(String category){
        if(!productsByCategory.containsKey(category))
            return null;

        return productsByCategory.get(category);
    }

    /**
     * The method returns all the seller's products.S
     * @return
     */
    public List<UUID> getAllSellerProducts(){
        List<UUID> products = new ArrayList<>();
        for(UUID id: productsBySerialNumber){
            products.add(id);
        }
        return products;
    }

    /**
     * The method returns the seller products categories.
     * @return
     */
    public List<String> getSellerProductsCategories(){
        List<String> categories = new ArrayList<>();
        for(String category : productsByCategory.keySet())
            categories.add(category);

        return categories;
    }
}
