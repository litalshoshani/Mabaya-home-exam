package Mabayahomeexam.parsers;

import Mabayahomeexam.model.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class is responsible for parsing a file with the information of the products, their names,
 * price, categories, serial numbers and sellers.
 */
public class ProductParser {

    /**
     * constructor
     */
    public ProductParser() {
    }


    /**
     * The method receives a file, and parses it:
     * in every line there is a product and all its features.
     * the method adds every parsed product (in every new line) to a list of
     * products and returns it.
     * @param file
     * @return
     */
    public List<Product> generateProducts(File file){
        List<Product> products = new ArrayList<>();

        try{
            BufferedReader buff = new BufferedReader(new FileReader(file));
            String str;
            String splitStr[];

            //read the file, line by line
            while ((str = buff.readLine()) != null){
                //str in the new line. split it by the separator.
                splitStr = str.split(", ");
                //now in splitStr are the value of the product. create the product.
                Product parsedProduct = parseProduct(splitStr);
                //add the parsed product
                products.add(parsedProduct);
            }

            buff.close();
        } catch (Exception e) {
            System.out.println("error in file reading");
        }

        //return the list of products
        return products;
    }

    /**
     * Create a new product according to the parsed line.
     * the line's format is:
     * title: "", price:  , category: "", productSerialNumber: "", sellerID: ""
     * @param productFeatures
     * @return
     */
    private Product parseProduct(String productFeatures[]){
        String splitStr[];
        //product features
        String title = "";
        String category = "";
        double price = 0;
        UUID productSerialNumber = null;
        UUID sellerID = null;

        //iterate over the features.
        for (String val: productFeatures){
            splitStr = val.split(": ");
            switch (splitStr[0]){
                case "title":
                    title = splitStr[1];
                    break;
                case "price":
                    price = Double.parseDouble(splitStr[1]);
                    break;
                case "category":
                    category = splitStr[1];
                    break;
                case "productSerialNumber":
                    productSerialNumber = UUID.fromString(splitStr[1]);
                    break;
                case "sellerID":
                    sellerID = UUID.fromString(splitStr[1]);
                    break;
                default:
                    break;
            }
        }
        //create the product by its features.
        Product parsedProduct = new Product(title, price, category, productSerialNumber, sellerID);
        return parsedProduct;
    }
}
