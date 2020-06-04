package Mabayahomeexam.parsers;

import Mabayahomeexam.model.Seller;
import Mabayahomeexam.service.ServiceCenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This class is responsible for parsing a file with the information of the sellers
 * and their products.
 */
public class SellerParser {
    private ServiceCenter serviceCenter;

    /**
     * constructor
     * @param serviceCenter
     */
    public SellerParser(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    /**
     * The method receives a file, and parses it:
     * in every line there is a sellerId and all its products serial numbers.
     * the method adds every seller (in every new line) as a key in a hash map,
     * and its products as value.
     * the method returns the hash map.
     *
     * @param file
     * @return
     */
    public HashMap<Seller, List<UUID>> generateSellers(File file){
        HashMap<Seller, List<UUID>> sellers = new HashMap<Seller, List<UUID>>();

        try{
            BufferedReader buff = new BufferedReader(new FileReader(file));
            String str;
            String lineSplit[];
            String attributeSplit[];

            //read the file, line by line. line format: sellerID: ""; products: ""
            while ((str = buff.readLine()) != null){
                //str is the new line. split it by the separator.
                lineSplit = str.split("; ");
                //now in lineSplit[0] there is the seller's id
                attributeSplit = lineSplit[0].split(": ");
                //get the seller id
                UUID sellerID = UUID.fromString(attributeSplit[1]);
                //get all the seller's products
                List<UUID> sellerProduct = parseSellerProduct(lineSplit[1]);
                //create a new seller
                Seller seller = new Seller(sellerID);
                //add the seller as key and its products as value
                sellers.put(seller,sellerProduct);
            }

            buff.close();
        } catch (Exception e) {
            System.out.println("error in file reading");
        }

        //return the hash map
        return sellers;
    }

    /**
     * Create a new seller's products serial numbers list according to the parsed line.
     * the line's format is:
     * productAttributes format: products: ""
     * @param productAttributes
     * @return
     */
    private List<UUID> parseSellerProduct(String productAttributes){
        String splitAttributes[];
        List<UUID> products = new ArrayList<>();
        UUID productSerialNumber = null;
        //split by the separator, so that in splitAttributes[0] is the name of the attribute
        //and in splitAttributes[1] are the products serial numbers
        splitAttributes = productAttributes.split(": ");

        //there can be more than one product in splitAttributes[1]
        String tempProducts[] = splitAttributes[1].split(", ");
        //add all the products to the list
        for(String serialNumStr: tempProducts)
            products.add(UUID.fromString(serialNumStr));
        //return all the products of the seller
        return products;
    }

}
